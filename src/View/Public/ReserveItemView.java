package View.Public;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ReserveItemView {
    public TextField itemReturnDateField;
    public TextField itemCurrentLocation;

    public Button reserveItemButton;

    public ReserveItemView(Stage stage)
    {
        Label reserveItemLabel = new Label("Reservar Item");
        reserveItemLabel.getStyleClass().add("label");

        // Nome do Item
        itemReturnDateField = new TextField();
        itemReturnDateField.setPromptText("Data de Devolução");
        itemReturnDateField.getStyleClass().add("text-field");

        // Local de Origem
        itemCurrentLocation = new TextField();
        itemCurrentLocation.setPromptText("Local Atual");
        itemCurrentLocation.getStyleClass().add("password-field");

        // Botão de adicionar
        reserveItemButton = new Button("Reservar");
        reserveItemButton.getStyleClass().add("button");

        // Geração da Cena
        VBox layout = new VBox(
            reserveItemLabel,
            itemReturnDateField,
            itemCurrentLocation,
            reserveItemButton
        );
        
        layout.getStyleClass().add("vbox");

        Scene scene = new Scene(layout, 1280, 720);
        scene.getStylesheets().add(getClass().getResource("/Style/style.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("Add Item");
        stage.show();
    }
}
