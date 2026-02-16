package com.balitechy.spacewar.main;

/**
 * Player entity - Pure model class with NO dependencies on View or Game.
 * Contains only business logic: position, velocity, movement bounds.
 */
public class Player {

    private double x;
    private double y;

    private double velX;
    private double velY;

    public static final int WIDTH = 56;
    public static final int HEIGHT = 28;

    private int maxWidth;
    private int maxHeight;

    public Player(double x, double y, int maxWidth, int maxHeight) {
        this.x = x;
        this.y = y;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }

    /**
     * Creates a bullet at the player's current position.
     * The caller is responsible for adding it to the game.
     */
    public Bullet createBullet() {
        return new Bullet(x + (WIDTH / 2.0) - 5, y - 18);
    }

    /**
     * Updates player position based on velocity and enforces bounds.
     */
    public void tick() {
        x += velX;
        y += velY;

        // Keep player inside the arena bounds.
        if (x <= 0)
            x = 0;
        if (x >= maxWidth - WIDTH)
            x = maxWidth - WIDTH;
        if (y <= 0)
            y = 0;
        if (y >= maxHeight - HEIGHT)
            y = maxHeight - HEIGHT;
    }
}