// JavaFX Imports
import javafx.application.Application;
import javafx.stage.Stage;

// Local Imports
import View.LoginView;
import Controller.LoginController;
import Model.Admin;
import Model.Student;
import Repository.Repository;

public class App extends Application {
    private static Repository _repository = new Repository();

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        _repository.addUser(new Student("student", "student", "student")); // Add default student user
        _repository.addUser(new Admin("admin", "admin", "admin")); // Add default admin user

        LoginView view = new LoginView(primaryStage);
        new LoginController(view, _repository);
    }
}
