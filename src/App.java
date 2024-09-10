// JavaFX Imports
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

// Local Imports
import View.LoginView;
import Controller.LoginController;


public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        LoginView view = new LoginView(primaryStage);
        new LoginController(view);
    }
}
