package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


/**
 * Created by sasaas on 2.12.2017 г..
 */
public class Main extends Application {
   private Stage stage;
   private Scene displacementOptionsScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        primaryStage.setTitle("Car calculator");

        SceneBuilder.copyStage(stage);

        displacementOptionsScene = SceneBuilder.createOptions();

        primaryStage.setScene(displacementOptionsScene);
        primaryStage.show();

    }


    public static void main(String[] args) throws IOException {
        launch(args);
    }

}
