package View.Public;

import Model.Item;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditItemView {
    public TextField itemNameField;
    public TextField itemReturnDateField;
    public TextField itemOriginLocation;
    public TextField itemCurrentLocation;

    public Button editItemButton;

    public EditItemView(Stage stage, Item item) {
        Label editItemLabel = new Label("Editar Item");
        editItemLabel.getStyleClass().add("label");

        // Nome do Item
        itemNameField = new TextField();
        itemNameField.setPromptText(item.name);
        itemNameField.getStyleClass().add("text-field");

        // Data da Devolução
        itemReturnDateField = new TextField();
        itemReturnDateField.setPromptText(item.returnDate);
        itemReturnDateField.getStyleClass().add("text-field");

        // Local de Origem
        itemOriginLocation = new TextField();
        itemOriginLocation.setPromptText(item.originLocation);
        itemOriginLocation.getStyleClass().add("password-field");
        
        // Local Atual
        itemCurrentLocation = new TextField();
        itemCurrentLocation.setPromptText(item.currentLocation);
        itemCurrentLocation.getStyleClass().add("password-field");

        // Botão de adicionar
        editItemButton = new Button("Editar");
        editItemButton.getStyleClass().add("button");

        // Geração da Cena
        VBox layout = new VBox(
            editItemLabel,
            itemNameField,
            itemReturnDateField,
            itemOriginLocation,
            itemCurrentLocation,
            editItemButton
        );
        
        layout.getStyleClass().add("vbox");

        Scene scene = new Scene(layout, 1280, 720);
        scene.getStylesheets().add(getClass().getResource("/Style/style.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("Edit Item");
        stage.show();
    }
}
