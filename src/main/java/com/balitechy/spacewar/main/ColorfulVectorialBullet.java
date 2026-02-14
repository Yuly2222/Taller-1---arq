package com.balitechy.spacewar.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * Colorful vectorial bullet: neon plasma pellet.
 */
public class ColorfulVectorialBullet extends ABulletStyle {

    public ColorfulVectorialBullet(Bullet bullet, Game game) {
        super(bullet, game);
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int x = (int) bullet.getX();
        int y = (int) bullet.getY();
        int w = Bullet.WIDTH;
        int h = Bullet.HEIGHT;

        g2.setColor(new Color(140, 255, 0, 220));
        g2.fillOval(x, y, w, h);
        g2.setColor(new Color(255, 255, 255, 220));
        g2.drawOval(x, y, w, h);

        // Little glow core.
        g2.setColor(new Color(255, 255, 255, 140));
        g2.fillOval(x + 2, y + 2, Math.max(0, w - 4), Math.max(0, h - 4));
    }
}
