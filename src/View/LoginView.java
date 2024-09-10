package View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginView {
    private TextField _emailField;
    private PasswordField _passwordField;

    private Button _loginButton;
    private Button _registerButton;

    public LoginView(Stage stage) {
        Label loginLabel = new Label("Iniciar Sessão");
        loginLabel.getStyleClass().add("label");

        // E-mail
        _emailField = new TextField();
        _emailField.setPromptText("E-mail");
        _emailField.getStyleClass().add("text-field");

        // Senha
        _passwordField = new PasswordField();
        _passwordField.setPromptText("Senha");
        _passwordField.getStyleClass().add("password-field");

        // Botão de Login
        _loginButton = new Button("Login");
        _loginButton.getStyleClass().add("button");

        // Botão de Registro
        Label registerLabel = new Label("Não tem uma conta ?");
        registerLabel.getStyleClass().add("info-label");

        _registerButton = new Button("Cadastre-se");
        _registerButton.getStyleClass().add("button");

        // Geração da Cena
        VBox layout = new VBox(
            loginLabel, 
            _emailField,
            _passwordField,
            _loginButton,
            registerLabel,
            _registerButton
            );
        
        layout.getStyleClass().add("vbox");
        
        Scene scene = new Scene(layout, 1280, 720);
        scene.getStylesheets().add(getClass().getResource("/Style/style.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
    }

    public TextField getEmailField() {
        return _emailField;
    }

    public PasswordField getPasswordField() {
        return _passwordField;
    }

    public Button getLoginButton() {
        return _loginButton;
    }

    public Button getRegisterButton() {
        return _registerButton;
    }
}
