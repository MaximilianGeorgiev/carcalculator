package models;

import interfaces.Engineable;

/**
 * Created by sasaas on 2.12.2017 г..
 */
public class Engine extends VehiclePart implements Engineable {

    public Engine(float airFuelMixture, float cylBore, float cylStroke, int cylCount, double displacement){
        this.setAirFuelMixture(airFuelMixture);
        this.setCylBore(cylBore);
        this.setCylStroke(cylStroke);
        this.setCylCount(cylCount);
        this.setDisplacement(displacement);
    }

    public Engine(){

    }

    private float airFuelMixture; //unused
    private float cylBore;
    private float cylStroke;

    private int cylCount;
    private double displacement;

    public double getDisplacement() {
        return this.displacement;
    }


    public float getAirFuelMixture() {
        return this.airFuelMixture;
    }

    public float getCylBore() {
        return this.cylBore;
    }

    public float getCylStroke() {
        return this.cylStroke;
    }

    public int getCylCount() {
        return this.cylCount;
    }

    private void setDisplacement(double displacement) {
        this.displacement = displacement;
    }
    private void setAirFuelMixture(float airFuelMixture) {
        this.airFuelMixture = airFuelMixture;
    }

    private void setCylBore(float cylBore) {
        this.cylBore = cylBore;
    }

    private void setCylStroke(float cylStroke) {
        this.cylStroke = cylStroke;
    }

    private void setCylCount(int cylCount) {
        this.cylCount = cylCount;
    }


    @Override
    public double calculateNewDisplacement(float newBore, float newStroke) {
        double newDisplacement = (Math.PI / 4) * (Math.pow(newBore,2)) * newStroke * this.getCylCount();

        return newDisplacement;
    }
}
