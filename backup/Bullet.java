package com.balitechy.spacewar.main;

public class Bullet {

    private double x;
    private double y;

    public static final int WIDTH = 11;
    public static final int HEIGHT = 21;

    public Bullet(double x, double y, Game game) {
        this.x = x;
        this.y = y;
    }

    public void tick() {
        y -= 5;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
