package com.balitechy.spacewar.main;

import java.awt.Color;
import java.awt.Graphics;

public class VectorialBullet implements IBulletStyle {

    private final Bullet bullet;

    public VectorialBullet(Bullet bullet) {
        this.bullet = bullet;
    }

    @Override
    public void render(Graphics g) {
        int x = (int) bullet.getX();
        int y = (int) bullet.getY();

        g.setColor(Color.BLACK);

        // Draw bullet as a small vertical line (laser beam style)
        g.drawLine(x + Bullet.WIDTH / 2, y, x + Bullet.WIDTH / 2, y + Bullet.HEIGHT);

        // Add glow effect with small rectangle
        g.drawRect(x + Bullet.WIDTH / 2 - 1, y, 2, Bullet.HEIGHT);
    }
}