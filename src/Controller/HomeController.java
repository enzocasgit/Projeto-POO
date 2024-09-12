package Controller;

import Enum.ItemStatusEnum;
import Model.Admin;
import Model.Item;
import Model.Student;
import Model.User;
import Repository.Repository;
import View.HomeView;
import View.LoginView;
import View.Public.AddItemView;
import View.Public.EditItemView;
import View.Public.ReserveItemView;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HomeController {
    private HomeView _view;
    private Repository _repository;
    private boolean isAdmin;

    public HomeController(HomeView view, User user, Repository repository) {
        _view = view;
        _repository = repository;

        if(user instanceof Student) {
            setupStudentView();
        }
        else if (user instanceof Admin) {
            setupAdminView();
        }
        else {
            // Do something (*^*) ! I don't know what haha !
        }

        _view.getLogoffButton().setOnAction(e -> handleLogoff());
    }

    private void setupStudentView()
    {
        isAdmin = false;
        loadItemList();
    }

    private void setupAdminView()
    {
        isAdmin = true;
        _view.getAddItemButton().setOnAction(e -> handleAddItem());

        loadItemList();
    }

    private void loadItemList() {
        for(Item item : _repository.getItemList())
        {
            HBox itemView = _view.generateItemView(item);

            if(isAdmin) {
                HBox actionsButtons = new HBox();
                actionsButtons.getStyleClass().add("hbox-action-button");

                if(item.status == ItemStatusEnum.Requested)
                {
                    Button acceptActionMenuButton = new Button("Aceitar");
                    acceptActionMenuButton.getStyleClass().add("accept-action-button");
                    acceptActionMenuButton.setOnAction(e-> handleAcceptItem(item));

                    Button rejectActionMenuButton = new Button("Rejeitar");
                    rejectActionMenuButton.getStyleClass().add("reject-action-button");
                    rejectActionMenuButton.setOnAction(e-> handleRejectItem(item));
                    
                    actionsButtons.getChildren().add(acceptActionMenuButton);
                    actionsButtons.getChildren().add(rejectActionMenuButton);
                }
                else
                {
                    Button editActionMenuButton = new Button("Editar");
                    editActionMenuButton.getStyleClass().add("edit-action-button");
                    editActionMenuButton.setOnAction(e -> handleEditItem(item));
    
                    Button deleteActionMenuButton = new Button("Deletar");
                    deleteActionMenuButton.getStyleClass().add("delete-action-button");
                    deleteActionMenuButton.setOnAction(e-> handleDeleteItem(item));

                    actionsButtons.getChildren().add(editActionMenuButton);
                    actionsButtons.getChildren().add(deleteActionMenuButton);
                }

                itemView.getChildren().add(actionsButtons);
            } 
            else {
                HBox actionsButtons = new HBox();
                actionsButtons.getStyleClass().add("hbox-action-button");

                if(item.status == ItemStatusEnum.Requested) {
                    Button reserveActionMenuButton = new Button("Cancelar Reserva");
                    reserveActionMenuButton.getStyleClass().add("cancel-reserve-action-button");
                    reserveActionMenuButton.setOnAction(e -> handleCancelReserveItem(item));

                    actionsButtons.getChildren().add(reserveActionMenuButton);
                }
                else if (item.status == ItemStatusEnum.Rejected) {
                    Button reserveActionMenuButton = new Button("Reservar novamente");
                    reserveActionMenuButton.getStyleClass().add("reserve-again-action-button");
                    reserveActionMenuButton.setOnAction(e -> handleReserveAgainItem(item));

                    actionsButtons.getChildren().add(reserveActionMenuButton);
                }
                else if(item.status == ItemStatusEnum.Free) {
                    Button reserveActionMenuButton = new Button("Reservar");
                    reserveActionMenuButton.getStyleClass().add("reserve-action-button");
                    reserveActionMenuButton.setOnAction(e -> handleReserveItem(item));

                    actionsButtons.getChildren().add(reserveActionMenuButton);
                }

                itemView.getChildren().add(actionsButtons);
            }

            _view.getItemListView().getItems().add(itemView);
        }
    }

    private void handleAddItem() {
        Stage stage = new Stage();

        AddItemView view = new AddItemView(stage);

        view.addItemButton.setOnAction(e -> {
            int maxId = 0;

            for(Item item : _repository.getItemList())
            {
                if(item.id > 0)
                {
                    maxId = item.id;
                }
            }

            Item new_item = new Item(
                maxId != 0 ? maxId + 1 : (_repository.getItemList().size() > 0 ? maxId + 1 : maxId),
                view.itemNameField.getText(),
                "",
                view.itemOriginLocation.getText(), 
                "", 
                ItemStatusEnum.Free
            );

            stage.close();

            _repository.addItem(new_item);

            _view.clearItemList();
            loadItemList();
        });
    }

    private void handleEditItem(Item item) {
        Stage stage = new Stage();

        EditItemView view = new EditItemView(stage, item);

        view.editItemButton.setOnAction(e -> {
            item.name = view.itemNameField.getText();
            item.returnDate = view.itemReturnDateField.getText();
            item.originLocation = view.itemOriginLocation.getText();
            item.currentLocation = view.itemCurrentLocation.getText();

            stage.close();

            _repository.editItem(item.id, item);

            _view.clearItemList();
            loadItemList();
        });
    }

    private void handleDeleteItem(Item item) {
        _repository.deleteItem(item.id);

        _view.clearItemList();
        loadItemList();
    }

    private void handleAcceptItem(Item item) {
        item.status = ItemStatusEnum.Reserved;

        _repository.editItem(item.id, item);
        
        _view.clearItemList();
        loadItemList();
    }

    private void handleRejectItem(Item item) {
        item.status = ItemStatusEnum.Rejected;
        item.currentLocation = "";
        item.returnDate = "";

        _repository.editItem(item.id, item);
        
        _view.clearItemList();
        loadItemList();
    }

    private void handleCancelReserveItem(Item item) {
        item.status = ItemStatusEnum.Free;
        item.currentLocation = "";
        item.returnDate = "";

        _repository.editItem(item.id, item);
        
        _view.clearItemList();
        loadItemList();
    }

    private void handleReserveItem(Item item) {
        Stage stage = new Stage();

        ReserveItemView view = new ReserveItemView(stage);

        view.reserveItemButton.setOnAction(e -> {
            item.returnDate = view.itemReturnDateField.getText();
            item.currentLocation = view.itemCurrentLocation.getText();
            item.status = ItemStatusEnum.Requested;

            stage.close();

            _repository.editItem(item.id, item);

            _view.clearItemList();
            loadItemList();
        });
    }

    private void handleReserveAgainItem(Item item) {
        handleReserveItem(item);
    }

    private void handleLogoff() {
        new LoginController(new LoginView(_view.getStage()), _repository);
    }
}
