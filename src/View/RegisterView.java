package View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegisterView {
    private Stage _stage;

    private TextField _fullnameField;
    private TextField _emailField;
    private PasswordField _passwordField;

    private Button _registerStudentButton;
    private Button _registerAdminButton;
    private Button _backToLoginButton;

    public RegisterView(Stage stage)
    {
        _stage = stage;

        Label registerLabel = new Label("Cadastrar Usuário");
        registerLabel.getStyleClass().add("label");

        // E-mail
        _fullnameField = new TextField();
        _fullnameField.setPromptText("Nome Completo");
        _fullnameField.getStyleClass().add("text-field");

        // E-mail
        _emailField = new TextField();
        _emailField.setPromptText("E-mail");
        _emailField.getStyleClass().add("text-field");

        // Senha
        _passwordField = new PasswordField();
        _passwordField.setPromptText("Senha");
        _passwordField.getStyleClass().add("password-field");
        
        // Senha Repetida
        PasswordField repeatPasswordField = new PasswordField();
        repeatPasswordField.setPromptText("Senha");
        repeatPasswordField.getStyleClass().add("password-field");

        // Botões de Cadastro
        Label registerButtonLabel = new Label("Cadastrar Como");
        registerButtonLabel.getStyleClass().add("short-info-label");

        _registerStudentButton = new Button("Aluno");
        _registerStudentButton.getStyleClass().add("button");

        _registerAdminButton = new Button("Administrador");
        _registerAdminButton.getStyleClass().add("button");

        HBox layoutBotoes = new HBox(
            _registerStudentButton,
            _registerAdminButton
        );

        layoutBotoes.getStyleClass().add("hbox");

        // Botão de Voltar para o Login
        Label backToLoginLabel = new Label("Já tem uma conta ?");
        backToLoginLabel.getStyleClass().add("info-label");

        _backToLoginButton = new Button("Entrar");
        _backToLoginButton.getStyleClass().add("button");

        VBox footer = new VBox(
            backToLoginLabel,
            _backToLoginButton
        );

        footer.getStyleClass().add("footer-vbox");

        // Geração da Cena
        VBox layout = new VBox(
            registerLabel,
            _fullnameField,
            _emailField,
            _passwordField,
            repeatPasswordField,
            registerButtonLabel,
            layoutBotoes,
            footer
        );
        
        layout.getStyleClass().add("vbox");

        Scene scene = new Scene(layout, 1280, 720);
        scene.getStylesheets().add(getClass().getResource("/Style/style.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("Register");
        stage.show();
    }

    public TextField getFullnameField() { return _fullnameField; }

    public TextField getEmailField() { return _emailField; }

    public PasswordField getPasswordField() { return _passwordField; }

    public Button getRegisterStudentButton() {
        return _registerStudentButton;
    }

    public Button getRegisterAdminButton() {
        return _registerAdminButton;
    }

    public Button getBackToLoginButton () {
        return _backToLoginButton;
    }

    public Stage getStage()
    {
        return _stage;
    }
}
