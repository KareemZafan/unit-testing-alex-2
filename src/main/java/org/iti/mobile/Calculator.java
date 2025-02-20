package org.iti.mobile;

public class Calculator {


    public double add(double a, double b) {

        return a + b;
    }

    public double sub(double a, double b) {

        return a - b;
    }

    public double mul(double a, double b) {

        return a * b;
    }

    public double div(double a, double b) {
        if (b == 0) throw new IllegalArgumentException("Dividing by zero");
        return a / b;
    }

    public double getSquareRoot(double a) {

        return Math.sqrt(a);
    }

    public double abs(double a) {
        return Math.abs(a);
    }


}
