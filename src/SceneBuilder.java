import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Engine;


/**
 * Created by sasaas on 10.12.2017 г..
 */
public final class SceneBuilder {
    private static Stage stage;


    // keep track of initial stage (main menu)
    public static void copyStage(Stage stage1) {
        stage = stage1;
    }

    public static Scene createDisplacementOptions() {
        Button calculateDisplacement = new Button("UNUSED");
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

    public static Scene createDisplacementDiffCalculator() {

        Pane displacementCalcPane = new Pane();

        Label bore = new Label("Bore:");
        Label stroke = new Label("Stroke:");
        Label cylinderCount = new Label("Cylinder count:");
        Label newBore = new Label("New bore:");
        Label newStroke = new Label("New stroke:");

        TextField boreInput = new TextField();
        TextField strokeInput = new TextField();
        TextField cylinderCountInput = new TextField();
        TextField newBoreInput = new TextField();
        TextField newStrokeInput = new TextField();

        CheckBox isDifference = new CheckBox();

        Button backButton = new Button();
        Button calculateButton = new Button();


        //needs refactoring
        calculateButton.setOnAction(b -> {
                    String[] inputArgs = new String[]{boreInput.getText(), strokeInput.getText(),
                            cylinderCountInput.getText()};

                    String[] newInputArgs = new String[]{newBoreInput.getText(), newStrokeInput.getText()};

                    StringBuilder output = new StringBuilder();

                    // check if required info to create an engine is present
                    if (ConsoleHandler.isInputValid(inputArgs)) {
                        Engine engine = ConsoleHandler.compileVehiclePart(inputArgs);

                        // only if the request is to calculate DIFFERENCE then check the other params (newbore, newstroke)
                        if (isDifference.isSelected()) {
                            if (ConsoleHandler.isInputValid(newInputArgs)) {
                                float[] params = ConsoleHandler.compileNewBoreAndStroke(newBoreInput.getText(), newStrokeInput.getText());


                                output.append("New displacement is: ");
                                output.append(engine.calculateNewDisplacement(params[0], params[1]));
                                output.append(" cc\n");
                                output.append("Which is ");

                                double difference = 0;
                                double percentDifference = 0;

                                double newDisp = engine.calculateNewDisplacement(params[0], params[1]);
                                double oldDisp = engine.getDisplacement();

                                // EXTRACT COMMAND
                                if (newDisp > oldDisp) {
                                    difference = newDisp - oldDisp;
                                    output.append(difference);
                                    output.append(" cc and ");

                                    output.append(ConsoleHandler.createOutputDifference(oldDisp, newDisp, difference));
                                    output.append(" % bigger.");
                                } else if (newDisp < oldDisp) {
                                    difference = oldDisp - newDisp;
                                    output.append(difference);
                                    output.append(" cc and ");

                                    output.append(ConsoleHandler.createOutputDifference(oldDisp, newDisp, difference));
                                    output.append(" % smaller.");
                                } else {
                                    output.append("same as initial.");
                                }
                            } else {
                                output.append("Invalid input!");
                            }
                        } else {
                            output.append("Displacement is: ");
                            output.append(engine.getDisplacement());
                            output.append(" cc");
                        }
                    } else {
                        output.append("Invalid input!");
                    }

                    Label text = new Label(String.valueOf(output));
                    text.setLayoutX(15);
                    text.setLayoutY(310);

                    displacementCalcPane.getChildren().add(text);
                }
        );

        calculateButton.setText("Calculate");
        calculateButton.setLayoutX(154);
        calculateButton.setLayoutY(257);

        backButton.setText("Back");
        backButton.setLayoutX(22);
        backButton.setLayoutY(257);
        backButton.setOnAction(b -> stage.setScene(SceneBuilder.createDisplacementOptions()));

        isDifference.setText("Calculate displacement difference");
        isDifference.setLayoutX(16);
        isDifference.setLayoutY(222);


        bore.setLayoutY(25);
        boreInput.setLayoutY(20);
        boreInput.setLayoutX(91);

        stroke.setLayoutY(65);
        strokeInput.setLayoutY(60);
        strokeInput.setLayoutX(91);

        cylinderCount.setLayoutY(105);
        cylinderCountInput.setLayoutY(100);
        cylinderCountInput.setLayoutX(91);


        newBore.setLayoutY(145);
        newBoreInput.setLayoutY(140);
        newBoreInput.setLayoutX(91);

        newStroke.setLayoutY(185);
        newStrokeInput.setLayoutY(180);
        newStrokeInput.setLayoutX(91);


        displacementCalcPane.getChildren().add(bore);
        displacementCalcPane.getChildren().add(stroke);
        displacementCalcPane.getChildren().add(cylinderCount);
        displacementCalcPane.getChildren().add(newBore);
        displacementCalcPane.getChildren().add(newStroke);

        displacementCalcPane.getChildren().add(boreInput);
        displacementCalcPane.getChildren().add(strokeInput);
        displacementCalcPane.getChildren().add(cylinderCountInput);
        displacementCalcPane.getChildren().add(newBoreInput);
        displacementCalcPane.getChildren().add(newStrokeInput);

        displacementCalcPane.getChildren().add(calculateButton);
        displacementCalcPane.getChildren().add(backButton);
        displacementCalcPane.getChildren().add(isDifference);

        return new Scene(displacementCalcPane, 255, 355);
    }
}

