package app;

import enums.Coordinates;
import factories.EngineFactory;
import factories.TyreFactory;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SceneBuilder {
    private static Stage stage;

    // keep track of initial stage (main menu)
    protected static void copyStage(Stage stage1) {
        stage = stage1;
    }

    // main menu
    protected static Scene createOptions() {
        Button calculateMileageButton = new Button("Calculate mileage");
        Button calculateDisplacementDiffButton = new Button("Calculate disp. difference");
        Button calculateTyreDifferenceButton = new Button("Calculate tyre diameter");
        Button showAboutButton = new Button("About");

        calculateMileageButton.setMinWidth(Coordinates.MILEAGEBUTTON.BOUNDARYWIDTH);
        calculateMileageButton.setLayoutX(Coordinates.MILEAGEBUTTON.WIDTH);
        calculateMileageButton.setLayoutY(Coordinates.MILEAGEBUTTON.HEIGHT);
        calculateMileageButton.setOnAction(e -> stage.setScene(createMileageCalculator()));

        calculateDisplacementDiffButton.setMinWidth(Coordinates.DISPBUTTON.BOUNDARYWIDTH);
        calculateDisplacementDiffButton.setLayoutX(Coordinates.DISPBUTTON.WIDTH);
        calculateDisplacementDiffButton.setLayoutY(Coordinates.DISPBUTTON.HEIGHT);
        calculateDisplacementDiffButton.setOnAction(e -> stage.setScene(createDisplacementDiffCalculator()));

        calculateTyreDifferenceButton.setMinWidth(Coordinates.TYREBUTTON.BOUNDARYWIDTH);
        calculateTyreDifferenceButton.setLayoutX(Coordinates.TYREBUTTON.WIDTH);
        calculateTyreDifferenceButton.setLayoutY(Coordinates.TYREBUTTON.HEIGHT);
        calculateTyreDifferenceButton.setOnAction(e -> stage.setScene(createTyreCalculator()));

        showAboutButton.setMinWidth(Coordinates.ABOUTBUTTON.BOUNDARYWIDTH);
        showAboutButton.setLayoutX(Coordinates.ABOUTBUTTON.WIDTH);
        showAboutButton.setLayoutY(Coordinates.ABOUTBUTTON.HEIGHT);
        showAboutButton.setOnAction(e -> stage.setScene(createAboutMenu()));

        Pane layout = new Pane();
        layout.getChildren().add(calculateMileageButton);
        layout.getChildren().add(calculateDisplacementDiffButton);
        layout.getChildren().add(calculateTyreDifferenceButton);
        layout.getChildren().add(showAboutButton);

        return new Scene(layout, Coordinates.OPTIONSPANE.WIDTH, Coordinates.OPTIONSPANE.HEIGHT);
    }

    private static Scene createAboutMenu() {
        Pane aboutMenuPane = new Pane();

        TextArea info = new TextArea();
        info.setText("This project was written by scratch and is intended to practise " +
                "good OOP principles and overall project structure. " +
                "Features a calculator that can calculate engine displacement " +
                "and engine displacement difference if bore and stroke measurements are affected." +
                "A gas mileage calculator is also available. Tyre diamater and difference in diameters can also be calculated. ");
        info.setMaxSize(Coordinates.INFOTEXTAREA.WIDTH, Coordinates.INFOTEXTAREA.HEIGHT);
        info.setFont(new Font(18));
        info.setWrapText(true);


        Button backButton = new Button("Back");
        backButton.setLayoutX(Coordinates.BACKBUTTON4.WIDTH);
        backButton.setLayoutY(Coordinates.BACKBUTTON4.HEIGHT);
        backButton.setOnAction(b -> stage.setScene(createOptions()));

        Image explanationImage = new Image("/views/explanation.png");
        ImageView view = new ImageView(explanationImage);
        view.setLayoutY(Coordinates.IMAGE.HEIGHT);
        view.setFitHeight(Coordinates.IMAGE.WIDTH);
        view.setFitWidth(Coordinates.IMAGE.WIDTH);


        aboutMenuPane.getChildren().add(info);
        aboutMenuPane.getChildren().add(backButton);
        aboutMenuPane.getChildren().add(view);


        return new Scene(aboutMenuPane,Coordinates.ABOUTPANE.WIDTH, Coordinates.ABOUTPANE.HEIGHT);
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

            tyreCalculatorPane.getChildren().remove(text); // prevent adding dublicate children exception

            text.setText(TyreFactory.getCalculationResult(input, input2));
            tyreCalculatorPane.getChildren().add(text);
        });


        tyreCalculatorPane.getChildren().add(tyreWidth);
        tyreCalculatorPane.getChildren().add(tyreAspectRatio);
        tyreCalculatorPane.getChildren().add(rimDiameter);
        tyreCalculatorPane.getChildren().add(tyreWidthInput);
        tyreCalculatorPane.getChildren().add(tyreAspectInput);
        tyreCalculatorPane.getChildren().add(rimDiameterInput);
        tyreCalculatorPane.getChildren().add(tyreWidth2);
        tyreCalculatorPane.getChildren().add(tyreAspectRatio2);
        tyreCalculatorPane.getChildren().add(rimDiameter2);
        tyreCalculatorPane.getChildren().add(tyreWidthInput2);
        tyreCalculatorPane.getChildren().add(tyreAspectInput2);
        tyreCalculatorPane.getChildren().add(rimDiameterInput2);
        tyreCalculatorPane.getChildren().add(backButton);
        tyreCalculatorPane.getChildren().add(calculateButton);


        return new Scene(tyreCalculatorPane, Coordinates.TYREPANE.WIDTH, Coordinates.TYREPANE.HEIGHT);
    }

    private static Scene createMileageCalculator() {

        Pane mileageCalcPane = new Pane();

        Label distanceLabel = new Label("Distance:");
        Label fuelUsedLabel = new Label("Fuel used:");

        TextField distanceInput = new TextField();
        TextField gasInput = new TextField();

        CheckBox isImperial = new CheckBox();

        Button backButton = new Button();
        Button calculateButton = new Button();

        distanceLabel.setLayoutY(Coordinates.DISTANCE.HEIGHT);
        distanceInput.setLayoutX(Coordinates.DISTANCE.WIDTH);
        distanceInput.setLayoutY(Coordinates.DISTANCE.HEIGHT);

        fuelUsedLabel.setLayoutY(Coordinates.GASUSED.HEIGHT);
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

            mileageCalcPane.getChildren().remove(text); // prevent adding dublicate children exception

            text.setText(EngineFactory.getMileageCalculationResult(input, isImperial.isSelected()));
            mileageCalcPane.getChildren().add(text);
        });


        // dublicate
        backButton.setText("Back");
        backButton.setLayoutX(Coordinates.BACKBUTTON1.WIDTH);
        backButton.setLayoutY(Coordinates.BACKBUTTON1.HEIGHT);
        backButton.setOnAction(b -> stage.setScene(SceneBuilder.createOptions()));

        mileageCalcPane.getChildren().add(distanceLabel);
        mileageCalcPane.getChildren().add(fuelUsedLabel);
        mileageCalcPane.getChildren().add(distanceInput);
        mileageCalcPane.getChildren().add(gasInput);
        mileageCalcPane.getChildren().add(isImperial);
        mileageCalcPane.getChildren().add(backButton);
        mileageCalcPane.getChildren().add(calculateButton);


        return new Scene(mileageCalcPane, Coordinates.MILEAGEPANE.WIDTH, Coordinates.MILEAGEPANE.HEIGHT);
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

        calculateButton.setOnAction(b -> {
                    String[] inputArgs = new String[]{boreInput.getText(), strokeInput.getText(),
                            cylinderCountInput.getText()};

                    String[] newInputArgs = new String[]{newBoreInput.getText(), newStrokeInput.getText()};

                    displacementCalcPane.getChildren().remove(text); // prevent dublicate children exception

                    text.setText(EngineFactory.getDisplacementCalculationResult(inputArgs, newInputArgs, isDifference.isSelected()));
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

        return new Scene(displacementCalcPane, Coordinates.DISPPANE.WIDTH, Coordinates.DISPPANE.HEIGHT);
    }
}

