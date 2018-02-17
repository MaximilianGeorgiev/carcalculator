package models;

import interfaces.Tyreable;

/**
 * Created by sasaas on 14.1.2018 г..
 */
public class Tyre implements Tyreable {
    private double width;
    private double aspectRatio;
    private double resultDiameter;
    private int rimDiameter;


    private void setWidth(double width) {
        this.width = width;
    }

    private void setAspectRatio(double aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    private void setRimDiameter(int rimDiameter) {
        this.rimDiameter = rimDiameter;
    }

    public double getResultDiameter() {
        String rimOutterDiameterString = String.valueOf(resultDiameter).substring(0, 2);
        return Double.parseDouble(rimOutterDiameterString);
    }


    public Tyre(double width, double aspectRatio, int rimDiameter) {
        this.setWidth(width);
        this.setAspectRatio(aspectRatio);
        this.setRimDiameter(rimDiameter);
        this.resultDiameter = this.calculateDiameter(width, aspectRatio, rimDiameter);
    }

    @Override
    public double calculateDiameter(double width, double aspectRatio, int rimDiameter) {
        double sectionWidth = width / 25.4;
        double sectionHeight = sectionWidth * (aspectRatio / 100);

        return sectionHeight * 2 + rimDiameter;
    }


    @Override
    public String compareTyre(Tyre tyre) {
        double firstTyreDiameter = this.getResultDiameter();
        double secondTyreDiameter = tyre.getResultDiameter();

        StringBuilder output = new StringBuilder();

        // no comparison
        if (firstTyreDiameter == secondTyreDiameter) {
            output.append("Diameter is: ");
            output.append(String.valueOf(firstTyreDiameter));
            output.append(" \nwhich is the same as before.");

            return output.toString();
        }

        output.append("New diameter is: ");
        output.append(String.valueOf(secondTyreDiameter));
        output.append("\"\n");
        output.append("Which is: ");

        if (firstTyreDiameter > secondTyreDiameter) {
            output.append(String.valueOf(firstTyreDiameter - secondTyreDiameter));
            output.append("\" smaller.");
        } else if (secondTyreDiameter > firstTyreDiameter) {
            output.append(String.valueOf(secondTyreDiameter - firstTyreDiameter));
            output.append("\" bigger.");
        }

        return output.toString();
    }
}
