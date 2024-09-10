package Controller;

// Java Imports
import java.util.*;

// Local Imports
import Repository.Repository;
import View.LoginView;
import Model.User;

public class LoginController {
    private LoginView _view;
    private Repository _repository;

    public LoginController(LoginView view, Repository repository) {
        _view = view;
        _repository = repository;

        _repository.addUser(new User("root", "root"));

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
                System.out.println("Ok");
            }
        }
    }

    private void handleRegister() {

    }
}
