package org.example.objects;

public class Division {
    private double a;
    private double b;

    public Division(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getDivision() {
        return a / b;
    }
}
