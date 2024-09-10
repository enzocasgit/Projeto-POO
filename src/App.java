// JavaFX Imports
import javafx.application.Application;
import javafx.stage.Stage;

// Local Imports
import View.LoginView;
import Controller.LoginController;
import Repository.Repository;

public class App extends Application {
    private static Repository _repository = new Repository();

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        LoginView view = new LoginView(primaryStage);
        new LoginController(view, _repository);
    }
}
