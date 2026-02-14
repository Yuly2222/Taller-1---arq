package com.balitechy.spacewar.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * Vectorial retro bullet (white capsule).
 */
public class VectorialBullet extends ABulletStyle {

    public VectorialBullet(Bullet bullet, Game game) {
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

        g2.setColor(Color.WHITE);
        // Capsule-like: rounded rect outline + a small fill core.
        g2.drawRoundRect(x, y, w, h, 6, 6);
        g2.fillRoundRect(x + 1, y + 1, Math.max(0, w - 2), Math.max(0, h - 2), 6, 6);
    }
}
