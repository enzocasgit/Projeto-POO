package Controller;

import View.LoginView;

public class LoginController {
    private LoginView view;

    public LoginController(LoginView view) {
        this.view = view;

        view.getLoginButton().setOnAction(e -> handleLogin());
        view.getRegisterButton().setOnAction(e -> handleRegister());
    }

    private void handleLogin() {
        String email = view.getEmailField().getText();
        String password = view.getPasswordField().getText();

        System.out.println("E-Mail: " + email);
        System.out.println("Password: " + password);
    }

    private void handleRegister() {
        System.out.println("Registro !");
    }
}
