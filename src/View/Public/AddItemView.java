package View.Public;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddItemView {
    public TextField itemNameField;
    public TextField itemOriginLocation;

    public Button addItemButton;

    public AddItemView(Stage stage)
    {
        Label addItemLabel = new Label("Cadastrar Item");
        addItemLabel.getStyleClass().add("label");

        // Nome do Item
        itemNameField = new TextField();
        itemNameField.setPromptText("Nome do Item");
        itemNameField.getStyleClass().add("text-field");

        // Local de Origem
        itemOriginLocation = new TextField();
        itemOriginLocation.setPromptText("Local de Origem");
        itemOriginLocation.getStyleClass().add("password-field");

        // Botão de adicionar
        addItemButton = new Button("Adicionar");
        addItemButton.getStyleClass().add("button");

        // Geração da Cena
        VBox layout = new VBox(
            addItemLabel,
            itemNameField,
            itemOriginLocation,
            addItemButton
        );
        
        layout.getStyleClass().add("vbox");

        Scene scene = new Scene(layout, 1280, 720);
        scene.getStylesheets().add(getClass().getResource("/Style/style.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("Add Item");
        stage.show();
    }
}

