package interfaces;

import models.Engine;

/**
 * Created by sasaas on 2.12.2017 г..
 */
public interface Engineable {
    double calculateNewDisplacement(float newBore, float newStroke);
    double calculateInitialDisplacement(float bore, float stroke);
}
