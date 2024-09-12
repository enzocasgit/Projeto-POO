package View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegisterStudentView {
    private Stage _stage;
    
    private TextField _studentIdNumberField;
    private TextField _studentDegreeField;
    private TextField _studentOrganizationField;

    private Button _registerStudentButton;

    public RegisterStudentView(Stage stage)
    {
        _stage = stage;

        Label registerStudentLabel = new Label("Informações do Aluno");
        registerStudentLabel.getStyleClass().add("label");

        // Matricula
        _studentIdNumberField = new TextField();
        _studentIdNumberField.setPromptText("Matricula");
        _studentIdNumberField.getStyleClass().add("text-field");

        // Curso
        _studentDegreeField = new TextField();
        _studentDegreeField.setPromptText("Curso");
        _studentDegreeField.getStyleClass().add("text-field");

        // Instituição
        _studentOrganizationField = new TextField();
        _studentOrganizationField.setPromptText("Instituição");
        _studentOrganizationField.getStyleClass().add("text-field");

        // Botão Cadastro
        _registerStudentButton = new Button("Cadastrar");
        _registerStudentButton.getStyleClass().add("button");

        // Geração da Cena
        VBox layout = new VBox(
            registerStudentLabel,
            _studentIdNumberField,
            _studentDegreeField,
            _studentOrganizationField,
            _registerStudentButton
        );
        
        layout.getStyleClass().add("vbox");

        Scene scene = new Scene(layout, 1280, 720);
        scene.getStylesheets().add(getClass().getResource("/Style/style.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("Registering Student ...");
        stage.show();
    }

    public TextField getIdNumberField() { return _studentIdNumberField; }

    public TextField getDegreeField() { return _studentDegreeField; }

    public TextField getOrganizationField() { return _studentOrganizationField; }

    public Button getRegisterStudentButton()
    {
        return _registerStudentButton;
    }

    public Stage getStage()
    {
        return _stage;
    }
}
