import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Engine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sasaas on 2.12.2017 г..
 */
public class Main extends Application{
    Stage stage;
    Scene displacementOptionsScene;
    Scene displacementCalculateDifferenceScene;


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

    private static void calculate() throws IOException {


    }
}
