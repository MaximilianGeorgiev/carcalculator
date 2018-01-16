package enums;

/**
 * Created by sasaas on 12.1.2018 г..
 */

public enum Coordinates {
    MILEAGEBUTTON(44, 44, 150),
    DISPBUTTON(44, 114, 150),
    TYREBUTTON(44, 184, 150),
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
    NEWSTROKE(91, 180),
    RESULT2(15, 310),
    TYREWIDTH(100,25),
    TYREASPECT(100, 65),
    RIMDIAMETER(100, 105),
    TYREWIDTH2(100, 165),
    TYREASPECT2(100, 205),
    RIMDIAMETER2(100, 245),
    BACKBUTTON3(35, 288),
    CALCBUTTON3(170, 288),
    RESULT3(44, 333);


    public int WIDTH;
    public int HEIGHT;
    public int BOUNDARYWIDTH;

    Coordinates(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
    }

    Coordinates(int width, int height, int boundaryWidth) {
        this.BOUNDARYWIDTH = boundaryWidth;
        this.WIDTH = width;
        this.HEIGHT = height;
    }

}

