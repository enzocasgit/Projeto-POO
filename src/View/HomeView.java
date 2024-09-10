package View;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeView {
    public HomeView(Stage stage)
    {
        // Geração da Cena
        VBox layout = new VBox();
        
        layout.getStyleClass().add("vbox");
        Scene scene = new Scene(layout, 1280, 720);
        scene.getStylesheets().add(getClass().getResource("/Style/style.css").toExternalForm());
        
        stage.setScene(scene);
        stage.setTitle("Home");
        stage.show();
    }
}
