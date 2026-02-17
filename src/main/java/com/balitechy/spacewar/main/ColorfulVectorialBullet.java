package com.balitechy.spacewar.main;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Colorful vectorial bullet: neon plasma pellet.
 */
public class ColorfulVectorialBullet implements IBulletStyle {

    private final Bullet BULLET;

    public ColorfulVectorialBullet(Bullet bullet) {
        this.BULLET = bullet;
    }

    @Override
    public void render(Graphics g) {
        int x = (int) BULLET.getX();
        int y = (int) BULLET.getY();

        // Draw bullet core in bright yellow
        g.setColor(Color.YELLOW);
        g.fillOval(x + Bullet.WIDTH / 2 - 2, y, 4, Bullet.HEIGHT);

        // Add outer glow in orange
        g.setColor(Color.ORANGE);
        g.drawOval(x + Bullet.WIDTH / 2 - 3, y - 1, 6, Bullet.HEIGHT + 2);

        // Add inner highlight in white
        g.setColor(Color.WHITE);
        g.fillOval(x + Bullet.WIDTH / 2 - 1, y + 2, 2, Bullet.HEIGHT / 3);
    }
}