package Controller;

import Model.Admin;
import Model.Item;
import Model.Student;
import Model.User;
import Repository.Repository;
import View.HomeView;
import View.LoginView;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class HomeController {
    private HomeView _view;
    private Repository _repository;

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

    }

    private void setupAdminView()
    {
        _view.getAddItemButton().setOnAction(e -> handleAddItem());

        for(Item item : _repository.getItemList())
        {
            HBox itemView = _view.generateItemView(item);

            Button editActionMenuButton = new Button("Editar");
            editActionMenuButton.getStyleClass().add("edit-action-button");
            editActionMenuButton.setOnAction(null);

            Button deleteActionMenuButton = new Button("Deletar");
            deleteActionMenuButton.getStyleClass().add("delete-action-button");
            deleteActionMenuButton.setOnAction(null);

            HBox actionsButtons = new HBox(
                editActionMenuButton,
                deleteActionMenuButton
            );
            actionsButtons.getStyleClass().add("hbox-action-button");

            itemView.getChildren().add(actionsButtons);

            _view.getItemListView().getItems().add(itemView);
        }
    }

    private void handleAddItem() {

    }

    private void handleLogoff() {
        new LoginController(new LoginView(_view.getStage()), _repository);
    }
}
