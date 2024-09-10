package View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginView {
    private TextField emailField;
    private PasswordField passwordField;

    Button loginButton;
    Button registerButton;

    public LoginView(Stage stage) {
        Label loginLabel = new Label("Iniciar Sessão");
        loginLabel.getStyleClass().add("label");

        // E-mail
        emailField = new TextField();
        emailField.setPromptText("E-mail");
        emailField.getStyleClass().add("text-field");

        // Senha
        passwordField = new PasswordField();
        passwordField.setPromptText("Senha");
        passwordField.getStyleClass().add("password-field");

        // Botão de Login
        loginButton = new Button("Login");
        loginButton.getStyleClass().add("button");

        // Botão de Registro
        Label registerLabel = new Label("Não tem uma conta ?");
        registerLabel.getStyleClass().add("info-label");

        registerButton = new Button("Cadastre-se");
        registerButton.getStyleClass().add("button");

        // Geração da Cena
        VBox layout = new VBox(
            loginLabel, 
            emailField,
            passwordField,
            loginButton,
            registerLabel,
            registerButton
            );
        
        layout.getStyleClass().add("vbox");
        
        Scene scene = new Scene(layout, 1280, 720);
        scene.getStylesheets().add(getClass().getResource("/Style/style.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
    }

    public TextField getEmailField() {
        return emailField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public Button getRegisterButton() {
        return registerButton;
    }
}
