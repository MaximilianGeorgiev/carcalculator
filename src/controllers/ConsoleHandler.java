package controllers;

import models.Engine;
import models.VehiclePart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sasaas on 2.12.2017 г..
 */
public class ConsoleHandler {
    BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

    public VehiclePart compileVehiclePart() throws IOException {
        System.out.println("Enter engine info: 1. AFR 2. Bore 3. Stroke 4. Cyl count 5. Displacement");
        // will select an option; for now it's hardcoded as engine

        float airFuelMixture = Float.parseFloat(scanner.readLine());
        float cylBore = Float.parseFloat(scanner.readLine());
        float cylStroke = Float.parseFloat(scanner.readLine());
        int cylCount = Integer.parseInt(scanner.readLine());
        double displacement = Double.parseDouble(scanner.readLine());


        return new Engine(airFuelMixture, cylBore, cylStroke, cylCount, displacement);
    }

    public float[] compileNewBoreAndStroke() throws IOException {
        System.out.println("Now enter new bore and/or stroke:");
        float newBore = Float.parseFloat(scanner.readLine());
        float newStroke = Float.parseFloat(scanner.readLine());

        return new float[]{newBore, newStroke};
    }
}
