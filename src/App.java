// JavaFX Imports
import javafx.application.Application;
import javafx.stage.Stage;

// Local Imports
import View.LoginView;
import Controller.LoginController;
import Enum.ItemStatusEnum;
import Model.Admin;
import Model.Item;
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

        _repository.addItem(new Item(0, "teste", "12/09/2024", "Pipinete", "Pipilandia", ItemStatusEnum.Free));
        _repository.addItem(new Item(1, "teste", "12/09/2024", "Pipinete", "Pipilandia", ItemStatusEnum.Reserved));

        LoginView view = new LoginView(primaryStage);
        new LoginController(view, _repository);
    }
}
