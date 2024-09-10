package View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegisterAdminView {
    private Stage _stage;

    private TextField _adminIdField;
    private TextField _adminRole;
    private TextField _adminOrganizationField;
    private TextField _adminDegreeField;

    private Button _registerAdminButton;

    public RegisterAdminView(Stage stage)
    {
        _stage = stage;

        Label registerAdminLabel = new Label("Informações do Administrador");
        registerAdminLabel.getStyleClass().add("label");

        // Matricula
        _adminIdField = new TextField();
        _adminIdField.setPromptText("Matricula SIAPE");
        _adminIdField.getStyleClass().add("text-field");
  
        // Ocupação
        _adminRole = new TextField();
        _adminRole.setPromptText("Ocupação");
        _adminRole.getStyleClass().add("text-field");

        // Instituição
        _adminOrganizationField = new TextField();
        _adminOrganizationField.setPromptText("Instituição");
        _adminOrganizationField.getStyleClass().add("text-field");

        // Grau
        _adminDegreeField = new TextField();
        _adminDegreeField.setPromptText("Grau");
        _adminDegreeField.getStyleClass().add("text-field");

        // Botão Cadastro
        _registerAdminButton = new Button("Cadastrar");
        _registerAdminButton.getStyleClass().add("button");

        // Geração da Cena
        VBox layout = new VBox(
            registerAdminLabel,
            _adminIdField,
            _adminRole,
            _adminOrganizationField,
            _adminDegreeField,
            _registerAdminButton
        );
        
        layout.getStyleClass().add("vbox");

        Scene scene = new Scene(layout, 1280, 720);
        scene.getStylesheets().add(getClass().getResource("/Style/style.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("Registering Student ...");
        stage.show();
    }

    public Button getRegisterAdminButton()
    {
        return _registerAdminButton;
    }

    public Stage getStage()
    {
        return _stage;
    }
}
