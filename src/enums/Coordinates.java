package enums;

/**
 * Created by sasaas on 12.1.2018 г..
 */

public enum Coordinates {
    MILEAGEBUTTON(44, 44, 150),
    DISPBUTTON(44, 114, 150),
    DISTANCE(80, 25),
    GASUSED(80, 65),
    ISIMPERIAL(55, 105),
    CALCBUTTON1(154, 150),
    RESULT1(15, 200),
    BACKBUTTON1(22, 150),
    CALCBUTTON2(154, 257),
    BACKBUTTON2(22, 257),
    ISDIFFERENCE(16, 220),
    BORE(91, 20),
    STROKE(91, 60),
    CYLCOUNT (91, 100),
    NEWBORE(91, 140),
    NEWSTROKE(91, 180);


    public int WIDTH;
    public int HEIGHT;
    public int boundaryWidth;

    Coordinates(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
    }

    Coordinates(int width, int height, int boundaryWidth) {
        this.boundaryWidth = boundaryWidth;
        this.WIDTH = width;
        this.HEIGHT = height;
    }

}

