package com.balitechy.spacewar.main;

import java.awt.Graphics;

public abstract class ABulletStyle {
    protected final Bullet bullet;
    protected final Game game;

    protected ABulletStyle(Bullet bullet, Game game) {
        this.bullet = bullet;
        this.game = game;
    }

    public void tick() {
        // Default: visualization has no internal tick.
    }

    public abstract void render(Graphics g);
}
