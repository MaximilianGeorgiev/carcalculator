import javafx.scene.control.TextField;
import models.Engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sasaas on 2.12.2017 г..
 */
public class ConsoleHandler {

    public static Engine compileVehiclePart(String... args) throws IOException {
        float airFuelMixture = 14.7f;  // AFR is hardcoded
        float cylBore = Float.parseFloat(args[0]);
        float cylStroke = Float.parseFloat(args[1]);
        int cylCount = Integer.parseInt(args[2]);

        return new Engine(airFuelMixture, cylBore, cylStroke, cylCount);
    }

    public static float[] compileNewBoreAndStroke(String... args) {

        float newBore = Float.parseFloat(args[0]);
        float newStroke = Float.parseFloat(args[1]);


        return new float[]{newBore, newStroke};
    }

    public static boolean isInputValid(String... args){
        for (String arg : args) {
            if (arg.equals("") || arg.equals(null)){
                return false;
            }
        }
        return true;
    }
}
