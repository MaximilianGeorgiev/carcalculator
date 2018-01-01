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

    public static Scene createOptions() {
        Button calculateMileage = new Button("Calculate mileage");
        Button calculateDisplacementDiff = new Button("Calculate disp. difference");

        calculateMileage.setMinWidth(150);
        calculateMileage.setLayoutX(44);
        calculateMileage.setLayoutY(44);
        calculateMileage.setOnAction(e -> stage.setScene(SceneBuilder.createMileageCalculator()));

        calculateDisplacementDiff.setMaxWidth(150);
        calculateDisplacementDiff.setLayoutX(44);
        calculateDisplacementDiff.setLayoutY(114);
        calculateDisplacementDiff.setOnAction(e -> stage.setScene(SceneBuilder.createDisplacementDiffCalculator()));

        Pane layout = new Pane();
        layout.getChildren().add(calculateMileage);
        layout.getChildren().add(calculateDisplacementDiff);

        return new Scene(layout, 233, 200);
    }

    public static Scene createMileageCalculator() {
        Pane mileageCalcPane = new Pane();

        Label distanceLabel = new Label("Distance:");
        Label gasUsedLabel = new Label("Gas used:");

        TextField distanceInput = new TextField();
        TextField gasInput = new TextField();

        CheckBox isImperial = new CheckBox();

        Button backButton = new Button();
        Button calculateButton = new Button();

        distanceLabel.setLayoutY(25);
        distanceInput.setLayoutX(80);
        distanceInput.setLayoutY(25);

        gasUsedLabel.setLayoutY(65);
        gasInput.setLayoutX(80);
        gasInput.setLayoutY(65);

        isImperial.setLayoutX(55);
        isImperial.setLayoutY(105);
        isImperial.setText("Use imperial system");

        StringBuilder output = new StringBuilder();

        calculateButton.setText("Calculate");
        calculateButton.setLayoutX(154);
        calculateButton.setLayoutY(150);
        calculateButton.setOnAction(b -> {
            String[] input = new String[]{distanceInput.getText(), gasInput.getText()};

            if (ConsoleHandler.isInputValid(input)) {
                double distance = Double.parseDouble(distanceInput.getText());
                double gasUsed = Double.parseDouble(gasInput.getText());

                Engine engine = new Engine(distance, gasUsed);

                output.append("Gas mileage is: ");
                output.append(engine.getGasMileage());

                if (isImperial.isSelected()) {
                    output.append(" MPG");
                } else {
                    output.append(" L/100 km");
                }
            } else {
                output.append("Invalid input!");
            }

            Label text = new Label(String.valueOf(output));
            text.setLayoutX(15);
            text.setLayoutY(200);
            mileageCalcPane.getChildren().add(text);

        });


        // dublicate
        backButton.setText("Back");
        backButton.setLayoutX(22);
        backButton.setLayoutY(150);
        backButton.setOnAction(b -> stage.setScene(SceneBuilder.createOptions()));

        mileageCalcPane.getChildren().add(distanceLabel);
        mileageCalcPane.getChildren().add(gasUsedLabel);
        mileageCalcPane.getChildren().add(distanceInput);
        mileageCalcPane.getChildren().add(gasInput);
        mileageCalcPane.getChildren().add(isImperial);
        mileageCalcPane.getChildren().add(backButton);
        mileageCalcPane.getChildren().add(calculateButton);


        return new Scene(mileageCalcPane, 233, 255);
    }

    public static Scene createDisplacementDiffCalculator() {

        Pane displacementCalcPane = new Pane();

        Label boreLabel = new Label("Bore:");
        Label strokeLabel = new Label("Stroke:");
        Label cylinderCountLabel = new Label("Cylinder count:");
        Label newBoreLabel = new Label("New bore:");
        Label newStrokeLabel = new Label("New stroke:");

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
        backButton.setOnAction(b -> stage.setScene(SceneBuilder.createOptions()));

        isDifference.setText("Calculate displacement difference");
        isDifference.setLayoutX(16);
        isDifference.setLayoutY(222);


        boreLabel.setLayoutY(25);
        boreInput.setLayoutY(20);
        boreInput.setLayoutX(91);

        strokeLabel.setLayoutY(65);
        strokeInput.setLayoutY(60);
        strokeInput.setLayoutX(91);

        cylinderCountLabel.setLayoutY(105);
        cylinderCountInput.setLayoutY(100);
        cylinderCountInput.setLayoutX(91);


        newBoreLabel.setLayoutY(145);
        newBoreInput.setLayoutY(140);
        newBoreInput.setLayoutX(91);

        newStrokeLabel.setLayoutY(185);
        newStrokeInput.setLayoutY(180);
        newStrokeInput.setLayoutX(91);


        displacementCalcPane.getChildren().add(boreLabel);
        displacementCalcPane.getChildren().add(strokeLabel);
        displacementCalcPane.getChildren().add(cylinderCountLabel);
        displacementCalcPane.getChildren().add(newBoreLabel);
        displacementCalcPane.getChildren().add(newStrokeLabel);

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

