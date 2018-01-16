package interfaces;

import models.Tyre;

/**
 * Created by sasaas on 14.1.2018 г..
 */
public interface Tyreable {

    double calculateDiameter(double width, double aspectRatio, int rimDiameter);

    String compareTyre(Tyre tyre);

}
