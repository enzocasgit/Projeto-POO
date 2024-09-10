package Controller;

// Java Imports
import java.util.*;

// Local Imports
import Repository.Repository;
import View.HomeView;
import View.LoginView;
import View.RegisterView;
import Model.User;

public class LoginController {
    private LoginView _view;
    private Repository _repository;

    public LoginController(LoginView view, Repository repository) {
        _view = view;
        _repository = repository;

        view.getLoginButton().setOnAction(e -> handleLogin());
        view.getRegisterButton().setOnAction(e -> handleRegister());
    }

    private void handleLogin() {
        String email = _view.getEmailField().getText();
        String password = _view.getPasswordField().getText();

        List<User> userList = _repository.getUserList();
        
        for(User user : userList)
        {
            if(user.email.equals(email) && user.password.equals(password))
            {
                new HomeView(_view.getStage());
            }
        }
    }

    private void handleRegister() {
        RegisterView registerView = new RegisterView(_view.getStage());
        new RegisterController(registerView, _repository);
    }
}
