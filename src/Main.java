import controllers.ConsoleHandler;
import models.VehiclePart;

import java.io.IOException;

/**
 * Created by sasaas on 2.12.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ConsoleHandler controller = new ConsoleHandler();
        VehiclePart part = controller.compileVehiclePart();

        float[] newParameters = controller.compileNewBoreAndStroke();
        System.out.println(part.calculateNewDisplacement(newParameters[0], newParameters[1]));

    }
}
