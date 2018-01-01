package models;

import interfaces.Engineable;

/**
 * Created by sasaas on 2.12.2017 г..
 */
public class Engine implements Engineable {

    private float airFuelMixture; //unused

    private float cylBore;
    private float cylStroke;
    private int cylCount;
    private double displacement;

    private double gasMileage;

    public double getGasMileage() {
        return this.gasMileage;
    }

    public void setGasMileage(double gasMileage) {
        this.gasMileage = gasMileage;
    }

    public double getDisplacement() {
        String displacement = String.valueOf(this.displacement).substring(0, 4);
        return Double.parseDouble(displacement);
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

    public Engine(float cylBore, float cylStroke, int cylCount) {
        this.setCylBore(cylBore);
        this.setCylStroke(cylStroke);
        this.setCylCount(cylCount);
        this.setDisplacement(this.calculateNewDisplacement(cylBore, cylStroke));
    }

//    public Engine(float airFuelMixture, float cylBore, float cylStroke, int cylCount) {
//        this.setAirFuelMixture(airFuelMixture);
//        this.setCylBore(cylBore);
//        this.setCylStroke(cylStroke);
//        this.setCylCount(cylCount);
//        this.setDisplacement(this.calculateNewDisplacement(cylBore, cylStroke));
//    }

    public Engine (double distance, double gasUsed){
        this.setGasMileage(this.calculateMileage(distance,gasUsed));
    }


    @Override
    public double calculateNewDisplacement(float newBore, float newStroke) {
        double value = (Math.PI / 4) * (Math.pow(newBore, 2)) * newStroke * this.getCylCount();

        String newDisplacement = String.valueOf(value).substring(0, 4);

        return Double.parseDouble(newDisplacement);
    }

    @Override
    public double calculateMileage(double distance, double quantity) {
        return distance / quantity;
    }

}
