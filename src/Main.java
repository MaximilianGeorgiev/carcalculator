import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


/**
 * Created by sasaas on 2.12.2017 г..
 */
public class Main extends Application{
    Stage stage;
    Scene displacementOptionsScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        primaryStage.setTitle("Displacement calculator");

        SceneBuilder.copyStage(stage);

        displacementOptionsScene = SceneBuilder.createDisplacementOptions();

        primaryStage.setScene(displacementOptionsScene);
        primaryStage.show();

    }


    public static void main(String[] args) throws IOException {
        launch(args);
    }

}
