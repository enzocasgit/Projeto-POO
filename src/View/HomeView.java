package View;

import Model.Admin;
import Model.Item;
import Model.Student;
import Model.User;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeView {
    private Stage _stage;

    private Button _addItemButton;
    private Button _logoffButton;

    private ListView<HBox> _itemListView = new ListView<>();

    public HomeView(Stage stage, User user) {
        _stage = stage;

        if(user instanceof Student) {
            LoadStudentView((Student) user);
        }
        else if (user instanceof Admin) {
            LoadAdminView((Admin) user);
        }
        else {
            // Do something (*^*) ! I don't know what haha !
        }
    }

    private void LoadStudentView(Student student)
    {
        // Geração da Cena
        VBox layout = new VBox();
        
        layout.getStyleClass().add("vbox");

        Scene scene = new Scene(layout, 1280, 720);
        scene.getStylesheets().add(getClass().getResource("/Style/style.css").toExternalForm());
                
        _stage.setScene(scene);
        _stage.setTitle("Home Student");
        _stage.show();
    }

    private void LoadAdminView(Admin admin)
    {
        Label itemListLabel = new Label("Administração de Bens");
        itemListLabel.getStyleClass().add("label");

        // Adicionando estilo ao ListView
        _itemListView.getStyleClass().add("list-view");

        // Adicionar Item
        _addItemButton = new Button("Adicionar Item");
        _addItemButton.getStyleClass().add("button");

        HBox itemListActionButtonsLayout = new HBox(
            _addItemButton
        );

        // Botão de Sair
        _logoffButton = new Button("Sair");
        _logoffButton.getStyleClass().add("button");

        VBox footer = new VBox(
            _logoffButton
        );

        footer.getStyleClass().add("footer-vbox");

        // Adiciona Header a Lista
        addItemListViewHeader();

        // Geração da Cena
        VBox layout = new VBox(
            itemListLabel,
            itemListActionButtonsLayout,
            _itemListView,
            footer
        );
        
        layout.getStyleClass().add("vbox");

        Scene scene = new Scene(layout, 1280, 720);
        scene.getStylesheets().add(getClass().getResource("/Style/style.css").toExternalForm());

        _stage.setScene(scene);
        _stage.setTitle("Home Admin");
        _stage.show();
    }

    public void clearItemList() {
        _itemListView.getItems().clear(); 

        addItemListViewHeader(); 
    }

    public Button getAddItemButton() { return _addItemButton; }

    public ListView<HBox> getItemListView() { return _itemListView; }

    public Button getLogoffButton() { return _logoffButton; }

    public Stage getStage() { return _stage; }

    private void addItemListViewHeader()
    {
        Label itemIdLabel = new Label("ID");
        itemIdLabel.getStyleClass().add("short-info-label");

        Label itemNameLabel = new Label("Nome");
        itemNameLabel.getStyleClass().add("short-info-label");

        Label itemReturnDateLabel = new Label("Data de Devolução");
        itemReturnDateLabel.getStyleClass().add("short-info-label");

        Label itemOriginLocationLabel = new Label("Local de Origem");
        itemOriginLocationLabel.getStyleClass().add("short-info-label");

        Label itemCurrentLocationLabel = new Label("Local Atual");
        itemCurrentLocationLabel.getStyleClass().add("short-info-label");

        Label itemStatusLabel = new Label("Status");
        itemStatusLabel.getStyleClass().add("short-info-label");

        Label actionButtonsLabel = new Label("Ações");
        actionButtonsLabel.getStyleClass().add("short-info-label");

        HBox itemLayout = new HBox(
            itemIdLabel,
            itemNameLabel,
            itemReturnDateLabel,
            itemOriginLocationLabel,
            itemCurrentLocationLabel,
            itemStatusLabel,
            actionButtonsLabel
        );
        itemLayout.getStyleClass().add("list-header");

        _itemListView.getItems().add(itemLayout);
    }

    public HBox generateItemView(Item item) {
        Label itemIdLabel = new Label(Integer.toString(item.id));
        itemIdLabel.getStyleClass().add("short-info-label");

        Label itemNameLabel = new Label(item.name);
        itemNameLabel.getStyleClass().add("short-info-label");

        Label itemReturnDateLabel = new Label(item.returnDate);
        itemReturnDateLabel.getStyleClass().add("short-info-label");

        Label itemOriginLocationLabel = new Label(item.originLocation);
        itemOriginLocationLabel.getStyleClass().add("short-info-label");

        Label itemCurrentLocationLabel = new Label(item.currentLocation);
        itemCurrentLocationLabel.getStyleClass().add("short-info-label");

        HBox itemLayout = new HBox(
            itemIdLabel,
            itemNameLabel,
            itemReturnDateLabel,
            itemOriginLocationLabel,
            itemCurrentLocationLabel
        );
        itemLayout.getStyleClass().add("hbox-item");
        
        Label itemStatusLabel;

        switch (item.status) {
            case Free:
                itemStatusLabel = new Label("Disponivel");
                itemStatusLabel.getStyleClass().add("free-status-label");

                itemLayout.getChildren().add(itemStatusLabel);
                break;
            case Reserved:
                itemStatusLabel = new Label("Reservado");
                itemStatusLabel.getStyleClass().add("reserved-status-label");

                itemLayout.getChildren().add(itemStatusLabel);
                break;
            case Requested:
                itemStatusLabel = new Label("Solicitado");
                itemStatusLabel.getStyleClass().add("requested-status-label");

                itemLayout.getChildren().add(itemStatusLabel);
                break;
        }

        return itemLayout;
    }
}
