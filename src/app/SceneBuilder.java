package app;

import enums.Coordinates;
import factories.TyreFactory;
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
public class SceneBuilder {
    private static Stage stage;

    // keep track of initial stage (main menu)
    protected static void copyStage(Stage stage1) {
        stage = stage1;
    }

    protected static Scene createOptions() {
        Button calculateMileage = new Button("Calculate mileage");
        Button calculateDisplacementDiff = new Button("Calculate disp. difference");
        Button calculateTyreDifference = new Button("Calculate tyre diameter");

        calculateMileage.setMinWidth(Coordinates.MILEAGEBUTTON.BOUNDARYWIDTH);
        calculateMileage.setLayoutX(Coordinates.MILEAGEBUTTON.WIDTH);
        calculateMileage.setLayoutY(Coordinates.MILEAGEBUTTON.HEIGHT);
        calculateMileage.setOnAction(e -> stage.setScene(createMileageCalculator()));

        calculateDisplacementDiff.setMaxWidth(Coordinates.DISPBUTTON.BOUNDARYWIDTH);
        calculateDisplacementDiff.setLayoutX(Coordinates.DISPBUTTON.WIDTH);
        calculateDisplacementDiff.setLayoutY(Coordinates.DISPBUTTON.HEIGHT);
        calculateDisplacementDiff.setOnAction(e -> stage.setScene(createDisplacementDiffCalculator()));

        calculateTyreDifference.setMaxWidth(Coordinates.TYREBUTTON.BOUNDARYWIDTH);
        calculateTyreDifference.setLayoutX(Coordinates.TYREBUTTON.WIDTH);
        calculateTyreDifference.setLayoutY(Coordinates.TYREBUTTON.HEIGHT);
        calculateTyreDifference.setOnAction(e -> stage.setScene(createTyreCalculator()));

        Pane layout = new Pane();
        layout.getChildren().add(calculateMileage);
        layout.getChildren().add(calculateDisplacementDiff);
        layout.getChildren().add(calculateTyreDifference);

        return new Scene(layout, 233, 300);
    }

    private static Scene createTyreCalculator() {
        Pane tyreCalculatorPane = new Pane();

        Label tyreWidth = new Label("Tyre width:");
        Label tyreAspectRatio = new Label("Tyre aspect ratio:");
        Label rimDiameter = new Label("Rim diameter:");

        TextField tyreWidthInput = new TextField();
        TextField tyreAspectInput = new TextField();
        TextField rimDiameterInput = new TextField();

        Label tyreWidth2 = new Label("Tyre width:");
        Label tyreAspectRatio2 = new Label("Tyre aspect ratio:");
        Label rimDiameter2 = new Label("Rim diameter:");

        TextField tyreWidthInput2 = new TextField();
        TextField tyreAspectInput2 = new TextField();
        TextField rimDiameterInput2 = new TextField();

        Button backButton = new Button("Back");
        Button calculateButton = new Button("Calculate");


        tyreWidth.setLayoutY(Coordinates.TYREWIDTH.HEIGHT);
        tyreWidth2.setLayoutY(Coordinates.TYREWIDTH2.HEIGHT);
        tyreWidthInput.setLayoutX(Coordinates.TYREWIDTH.WIDTH);
        tyreWidthInput.setLayoutY(Coordinates.TYREWIDTH.HEIGHT);
        tyreWidthInput2.setLayoutX(Coordinates.TYREWIDTH2.WIDTH);
        tyreWidthInput2.setLayoutY(Coordinates.TYREWIDTH2.HEIGHT);

        tyreAspectRatio.setLayoutY(Coordinates.TYREASPECT.HEIGHT);
        tyreAspectRatio2.setLayoutY(Coordinates.TYREASPECT2.HEIGHT);
        tyreAspectInput.setLayoutX(Coordinates.TYREASPECT.WIDTH);
        tyreAspectInput.setLayoutY(Coordinates.TYREASPECT.HEIGHT);
        tyreAspectInput2.setLayoutX(Coordinates.TYREASPECT2.WIDTH);
        tyreAspectInput2.setLayoutY(Coordinates.TYREASPECT2.HEIGHT);

        rimDiameter.setLayoutY(Coordinates.RIMDIAMETER.HEIGHT);
        rimDiameter2.setLayoutY(Coordinates.RIMDIAMETER2.HEIGHT);
        rimDiameterInput.setLayoutX(Coordinates.RIMDIAMETER.WIDTH);
        rimDiameterInput.setLayoutY(Coordinates.RIMDIAMETER.HEIGHT);
        rimDiameterInput2.setLayoutX(Coordinates.RIMDIAMETER2.WIDTH);
        rimDiameterInput2.setLayoutY(Coordinates.RIMDIAMETER2.HEIGHT);

        backButton.setLayoutX(Coordinates.BACKBUTTON3.WIDTH);
        backButton.setLayoutY(Coordinates.BACKBUTTON3.HEIGHT);
        backButton.setOnAction(b -> stage.setScene(createOptions()));

        Label text = new Label();
        text.setLayoutX(Coordinates.RESULT3.WIDTH);
        text.setLayoutY(Coordinates.RESULT3.HEIGHT);

        calculateButton.setLayoutX(Coordinates.CALCBUTTON3.WIDTH);
        calculateButton.setLayoutY(Coordinates.CALCBUTTON3.HEIGHT);
        calculateButton.setOnAction(c -> {
            String[] input = new String[]{
                    tyreWidthInput.getText(), tyreAspectInput.getText(), rimDiameterInput.getText()};

            String[] input2 = new String[]{
                    tyreWidthInput2.getText(), tyreAspectInput2.getText(), rimDiameterInput2.getText()};

            tyreCalculatorPane.getChildren().remove(text);

           text.setText(TyreFactory.compileTyre(input, input2));


            tyreCalculatorPane.getChildren().add(text);
        });


        tyreCalculatorPane.getChildren().add(tyreWidth);
        tyreCalculatorPane.getChildren().add(tyreWidth2);
        tyreCalculatorPane.getChildren().add(tyreAspectRatio);
        tyreCalculatorPane.getChildren().add(tyreAspectRatio2);
        tyreCalculatorPane.getChildren().add(rimDiameter);
        tyreCalculatorPane.getChildren().add(rimDiameter2);
        tyreCalculatorPane.getChildren().add(tyreWidthInput);
        tyreCalculatorPane.getChildren().add(tyreWidthInput2);
        tyreCalculatorPane.getChildren().add(tyreAspectInput);
        tyreCalculatorPane.getChildren().add(tyreAspectInput2);
        tyreCalculatorPane.getChildren().add(rimDiameterInput);
        tyreCalculatorPane.getChildren().add(rimDiameterInput2);
        tyreCalculatorPane.getChildren().add(backButton);
        tyreCalculatorPane.getChildren().add(calculateButton);


        return new Scene(tyreCalculatorPane, 280, 388);
    }


    private static Scene createMileageCalculator() {

        Pane mileageCalcPane = new Pane();

        Label distanceLabel = new Label("Distance:");
        Label gasUsedLabel = new Label("Gas used:");

        TextField distanceInput = new TextField();
        TextField gasInput = new TextField();

        CheckBox isImperial = new CheckBox();

        Button backButton = new Button();
        Button calculateButton = new Button();

        distanceLabel.setLayoutY(Coordinates.DISTANCE.HEIGHT);
        distanceInput.setLayoutX(Coordinates.DISTANCE.WIDTH);
        distanceInput.setLayoutY(Coordinates.DISTANCE.HEIGHT);

        gasUsedLabel.setLayoutY(Coordinates.GASUSED.HEIGHT);
        gasInput.setLayoutX(Coordinates.GASUSED.WIDTH);
        gasInput.setLayoutY(Coordinates.GASUSED.HEIGHT);

        isImperial.setLayoutX(Coordinates.ISIMPERIAL.WIDTH);
        isImperial.setLayoutY(Coordinates.ISIMPERIAL.HEIGHT);
        isImperial.setText("Use imperial system");

        Label text = new Label();
        text.setLayoutX(Coordinates.RESULT1.WIDTH);
        text.setLayoutY(Coordinates.RESULT1.HEIGHT);

        calculateButton.setText("Calculate");
        calculateButton.setLayoutX(Coordinates.CALCBUTTON1.WIDTH);
        calculateButton.setLayoutY(Coordinates.CALCBUTTON1.HEIGHT);
        calculateButton.setOnAction(b -> {
            String[] input = new String[]{distanceInput.getText(), gasInput.getText()};

            StringBuilder output = new StringBuilder();
            mileageCalcPane.getChildren().remove(text); // prevent adding dublicate children exception

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

            text.setText(String.valueOf(output));
            mileageCalcPane.getChildren().add(text);
        });


        // dublicate
        backButton.setText("Back");
        backButton.setLayoutX(Coordinates.BACKBUTTON1.WIDTH);
        backButton.setLayoutY(Coordinates.BACKBUTTON1.HEIGHT);
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

    private static Scene createDisplacementDiffCalculator() {

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

        Label text = new Label();
        text.setLayoutX(Coordinates.RESULT2.WIDTH);
        text.setLayoutY(Coordinates.RESULT2.HEIGHT);

        //needs refactoring
        calculateButton.setOnAction(b -> {
                    String[] inputArgs = new String[]{boreInput.getText(), strokeInput.getText(),
                            cylinderCountInput.getText()};

                    String[] newInputArgs = new String[]{newBoreInput.getText(), newStrokeInput.getText()};

                    StringBuilder output = new StringBuilder();
                    displacementCalcPane.getChildren().remove(text);

                    // check if required info to create an engine is present
                    if (ConsoleHandler.isInputValid(inputArgs)) {
                        Engine engine = ConsoleHandler.compileEngine(inputArgs);

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

                    text.setText(String.valueOf(output));
                    displacementCalcPane.getChildren().add(text);
                }
        );

        calculateButton.setText("Calculate");
        calculateButton.setLayoutX(Coordinates.CALCBUTTON2.WIDTH);
        calculateButton.setLayoutY(Coordinates.CALCBUTTON2.HEIGHT);

        backButton.setText("Back");
        backButton.setLayoutX(Coordinates.BACKBUTTON2.WIDTH);
        backButton.setLayoutY(Coordinates.BACKBUTTON2.HEIGHT);
        backButton.setOnAction(b -> stage.setScene(SceneBuilder.createOptions()));

        isDifference.setText("Calculate displacement difference");
        isDifference.setLayoutX(Coordinates.ISDIFFERENCE.WIDTH);
        isDifference.setLayoutY(Coordinates.ISDIFFERENCE.HEIGHT);


        boreInput.setLayoutX(Coordinates.BORE.WIDTH);
        boreLabel.setLayoutY(Coordinates.BORE.HEIGHT);
        boreInput.setLayoutY(Coordinates.BORE.HEIGHT);

        strokeInput.setLayoutX(Coordinates.STROKE.WIDTH);
        strokeLabel.setLayoutY(Coordinates.STROKE.HEIGHT);
        strokeInput.setLayoutY(Coordinates.STROKE.HEIGHT);

        cylinderCountInput.setLayoutX(Coordinates.CYLCOUNT.WIDTH);
        cylinderCountLabel.setLayoutY(Coordinates.CYLCOUNT.HEIGHT);
        cylinderCountInput.setLayoutY(Coordinates.CYLCOUNT.HEIGHT);


        newBoreInput.setLayoutX(Coordinates.NEWBORE.WIDTH);
        newBoreLabel.setLayoutY(Coordinates.NEWBORE.HEIGHT);
        newBoreInput.setLayoutY(Coordinates.NEWBORE.HEIGHT);

        newStrokeInput.setLayoutX(Coordinates.NEWSTROKE.WIDTH);
        newStrokeLabel.setLayoutY(Coordinates.NEWSTROKE.HEIGHT);
        newStrokeInput.setLayoutY(Coordinates.NEWSTROKE.HEIGHT);


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
