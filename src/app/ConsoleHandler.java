package app;

import models.Engine;

/**
 * Created by sasaas on 2.12.2017 г..
 */
public class ConsoleHandler {


    public static Engine compileEngine(String... args)  {

        float cylBore = Float.parseFloat(args[0]);
        float cylStroke = Float.parseFloat(args[1]);
        int cylCount = Integer.parseInt(args[2]);

        return new Engine(cylBore, cylStroke, cylCount);
    }

    public static float[] compileNewBoreAndStroke(String... args) {

        float newBore = Float.parseFloat(args[0]);
        float newStroke = Float.parseFloat(args[1]);

        return new float[]{newBore, newStroke};
    }

    public static boolean isInputValid(String... args) {
        for (String arg : args) {
            if (arg.equals("") || arg.equals(null)) {
                return false;
            }
        }
        return true;
    }

    public static String createOutputDifference(double oldDisp, double newDisp, double difference){
        double average = (newDisp+oldDisp) / 2;
        double percentDifference = (difference / average ) * 100;

        return String.valueOf(percentDifference).substring(0,4);
    }
}
