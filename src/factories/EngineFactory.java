package factories;

import app.ConsoleHandler;
import models.Engine;

/**
 * Created by sasaas on 18.1.2018 г..
 */
public final class EngineFactory {

    public static String getDisplacementCalculationResult(String[] inputArgs, String[] newInputArgs, boolean isDifference) {
        StringBuilder output = new StringBuilder();
        String newBoreInput = newInputArgs[0];
        String newStrokeInput = newInputArgs[1];

        // check if required info to create an engine is present
        if (ConsoleHandler.isInputValid(inputArgs)) {
            Engine engine = ConsoleHandler.compileEngine(inputArgs);

            // only if the request is to calculate DIFFERENCE then check the other params (newbore, newstroke)
            if (isDifference) {
                if (ConsoleHandler.isInputValid(newInputArgs)) {
                    float[] params = ConsoleHandler.compileNewBoreAndStroke(newBoreInput, newStrokeInput);

                    output.append("New displacement is: ");
                    output.append(engine.calculateNewDisplacement(params[0], params[1]));
                    output.append(" cc\n");
                    output.append("Which is ");

                    double difference = 0;

                    double newDisp = engine.calculateNewDisplacement(params[0], params[1]);
                    double oldDisp = engine.getDisplacement();

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


        return output.toString();
    }

    public static String getMileageCalculationResult(String[] inputArgs, boolean isImperial) {

        StringBuilder output = new StringBuilder();

        String distanceInput = inputArgs[0];
        String gasInput = inputArgs[1];

        if (ConsoleHandler.isInputValid(inputArgs)) {
            double distance = Double.parseDouble(distanceInput);
            double gasUsed = Double.parseDouble(gasInput);

            Engine engine = new Engine(distance, gasUsed);

            output.append("Gas mileage is: ");
            output.append(engine.getGasMileage());

            if (isImperial) {
                output.append(" MPG");
            } else {
                output.append(" L/100 km");
            }
        } else {
            output.append("Invalid input!");
        }

        return output.toString();
    }
}
