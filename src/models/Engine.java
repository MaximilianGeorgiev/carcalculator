package models;

import app.ConsoleHandler;
import interfaces.Engineable;


/**
 * Created by sasaas on 2.12.2017 г..
 */
public class Engine implements Engineable {

    private float cylBore;
    private float cylStroke;
    private int cylCount;
    private double displacement;

    private double mileage;

    public double getGasMileage() {
        return this.mileage;
    }

    private void setGasMileage(double gasMileage) {
        this.mileage = gasMileage;
    }

    public double getDisplacement() {
        String displacement = String.valueOf(this.displacement);
        return Double.parseDouble(displacement);
    }

    private int getCylCount() {
        return this.cylCount;
    }

    private void setDisplacement(double displacement) {
        this.displacement = displacement;
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

    public Engine(double distance, double gasUsed, boolean isImperial) {
        this.setGasMileage(this.calculateMileage(distance, gasUsed, isImperial));
    }


    @Override
    public double calculateNewDisplacement(float newBore, float newStroke) {
        double value = (Math.PI / 4) * (Math.pow(newBore, 2)) * newStroke * this.getCylCount();

        String newDisplacement = String.valueOf(value);


       /*
          If it has more than 4 characters it will output a brief result: 1500.2 instead of 1500.2222222222
          If it has less than 4 it will not throw out of boundaries exception and will show full result
          If it starts with 0.0 it won't show 0.0 cc but instead will show 0.00159159 cc (will be accurate)
        */

        newDisplacement = (newDisplacement.length() > 4 && !newDisplacement.startsWith("0.0"))
                ? newDisplacement.substring(0, 4) : newDisplacement;


        return Double.parseDouble(newDisplacement);
    }

    @Override
    public double calculateMileage(double distance, double quantity, boolean isImperial) {
        double value = 0;

        // it is calculated different since it's not accurate otherwise
        value = (isImperial) ? distance / quantity : (100 * quantity / distance);

        String mileage = String.valueOf(value);

        // see this.calculateNewDisplacement for reference
        mileage = ((mileage).length() > 4) ? mileage.substring(0, mileage.indexOf(".")) : mileage;

        return Double.parseDouble(mileage);
    }

}
