import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Engine;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by sasaas on 10.12.2017 г..
 */
public final class SceneBuilder{
    private static Stage stage;

    public static void copyStage(Stage stage1){
        stage = stage1;
    }

    public static Scene createDisplacementOptions() {
        Button calculateDisplacement = new Button("Calculate displacement");
        Button calculateDisplacementDiff = new Button("Calculate disp. difference");

        calculateDisplacement.setMinWidth(150);
        calculateDisplacement.setLayoutX(44);
        calculateDisplacement.setLayoutY(44);

        calculateDisplacementDiff.setMaxWidth(150);
        calculateDisplacementDiff.setLayoutX(44);
        calculateDisplacementDiff.setLayoutY(114);
        calculateDisplacementDiff.setOnAction(e -> stage.setScene(SceneBuilder.createDisplacementDiffCalculator()));

        Pane layout = new Pane();
        layout.getChildren().add(calculateDisplacement);
        layout.getChildren().add(calculateDisplacementDiff);

        return new Scene(layout, 233, 200);
    }

    public static Scene createDisplacementDiffCalculator(){
        Pane displacementCalcPane = new Pane();

        Label bore = new Label("Bore:");
        Label stroke = new Label("Stroke:");
        Label cylinderCount = new Label ("Cylinder count:");
        Label displacement = new Label ("Current displ.:");
        Label newBore = new Label("New bore:");
        Label newStroke = new Label("New stroke:");

        TextField boreInput = new TextField();
        TextField strokeInput = new TextField();
        TextField cylinderCountInput = new TextField();
        TextField displacementInput = new TextField();
        TextField newBoreInput = new TextField();
        TextField newStrokeInput = new TextField();


        Button calculateButton = new Button();
        calculateButton.setText("Calculate");
        calculateButton.setLayoutX(154);
        calculateButton.setLayoutY(271);

        //fix this code
        calculateButton.setOnAction(b -> {
            try {
                Engine engine =
                ConsoleHandler.compileVehiclePart(boreInput.getText(), strokeInput.getText(), cylinderCountInput.getText(),
                        displacementInput.getText());

               float[] params = ConsoleHandler.compileNewBoreAndStroke(newBoreInput.getText(), newStrokeInput.getText());

                StringBuilder sb = new StringBuilder();
                sb.append("New displacement is: ");
                sb.append(Math.round(engine.calculateNewDisplacement(params[0], params[1])));
                sb.append(" cc");

                Label text = new Label(String.valueOf(sb));
                text.setLayoutX(15);
                text.setLayoutY(310);
                displacementCalcPane.getChildren().add(text);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Button backButton = new Button();
        backButton.setText("Back");
        backButton.setLayoutX(22);
        backButton.setLayoutY(271);
        backButton.setOnAction(b -> stage.setScene(SceneBuilder.createDisplacementOptions()));


        bore.setLayoutY(25);
        boreInput.setLayoutY(20);
        boreInput.setLayoutX(91);

        stroke.setLayoutY(65);
        strokeInput.setLayoutY(60);
        strokeInput.setLayoutX(91);

        cylinderCount.setLayoutY(105);
        cylinderCountInput.setLayoutY(100);
        cylinderCountInput.setLayoutX(91);

        displacement.setLayoutY(145);
        displacementInput.setLayoutY(140);
        displacementInput.setLayoutX(91);

        newBore.setLayoutY(185);
        newBoreInput.setLayoutY(180);
        newBoreInput.setLayoutX(91);

        newStroke.setLayoutY(225);
        newStrokeInput.setLayoutY(220);
        newStrokeInput.setLayoutX(91);


        displacementCalcPane.getChildren().add(bore);
        displacementCalcPane.getChildren().add(stroke);
        displacementCalcPane.getChildren().add(cylinderCount);
        displacementCalcPane.getChildren().add(displacement);
        displacementCalcPane.getChildren().add(newBore);
        displacementCalcPane.getChildren().add(newStroke);

        displacementCalcPane.getChildren().add(boreInput);
        displacementCalcPane.getChildren().add(strokeInput);
        displacementCalcPane.getChildren().add(cylinderCountInput);
        displacementCalcPane.getChildren().add(displacementInput);
        displacementCalcPane.getChildren().add(newBoreInput);
        displacementCalcPane.getChildren().add(newStrokeInput);

        displacementCalcPane.getChildren().add(calculateButton);
        displacementCalcPane.getChildren().add(backButton);

        return new Scene(displacementCalcPane, 255, 355);
    } }

