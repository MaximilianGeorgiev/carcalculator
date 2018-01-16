package factories;

import app.ConsoleHandler;
import models.Tyre;

/**
 * Created by sasaas on 15.1.2018 г..
 */
public final class TyreFactory {

    public static String compileTyre(String[] args1, String[] args2){

        boolean isComparison = false;
        StringBuilder output = new StringBuilder();

        if (ConsoleHandler.isInputValid(args1)) {
            if (ConsoleHandler.isInputValid(args2)) {
                isComparison = true;
            }

            Tyre tyre1 = new Tyre(Double.parseDouble(args1[0]),
                    Double.parseDouble(args1[1]), Integer.parseInt(args1[2]));


            if (isComparison) {
                Tyre tyre2 = new Tyre(Double.parseDouble(args2[0]),
                        Double.parseDouble(args2[1]), Integer.parseInt(args2[2]));

                output.append(tyre1.compareTyre(tyre2));

                return output.toString();
            } else {
                double calculatedDiameter = tyre1.getResultDiameter();

                output.append("Diameter is: ");
                output.append(String.valueOf(calculatedDiameter));
                output.append(" \"");

                return output.toString();
            }

        }

        output.append("Invalid input.");
        return output.toString();
    }

}
