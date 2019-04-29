import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client extends Application {
    public void start(Stage stage) {
        Scene scene = new Scene(new GUI(), 400, 200);

        stage.setTitle("ZombieDice");
        stage.setScene(scene);
        stage.show();
    }
}