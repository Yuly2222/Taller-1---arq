package com.balitechy.spacewar.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;

/**
 * Colorful vectorial style: same geometry as vectorial, but with neon-ish colors.
 */
public class ColorfulVectorialPlayer extends APlayerStyle {

    public ColorfulVectorialPlayer(Player player, Game game) {
        super(player, game);
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int x = (int) player.getX();
        int y = (int) player.getY();
        int w = Player.WIDTH;
        int h = Player.HEIGHT;

        Polygon body = new Polygon(
                new int[]{x + w / 2, x + w - 6, x + w - 16, x + 16, x + 6},
                new int[]{y + 2, y + h / 2, y + h - 3, y + h - 3, y + h / 2},
                5
        );

        // Fill + outline.
        g2.setColor(new Color(0, 220, 255, 180));
        g2.fillPolygon(body);
        g2.setColor(new Color(255, 0, 200));
        g2.drawPolygon(body);

        // Cockpit.
        int cx = x + w / 2 - 6;
        int cy = y + h / 2 - 6;
        g2.setColor(new Color(255, 255, 255, 200));
        g2.fillOval(cx, cy, 12, 12);
        g2.setColor(new Color(0, 0, 0, 180));
        g2.drawOval(cx, cy, 12, 12);

        // Thruster flame.
        g2.setColor(new Color(255, 170, 0, 200));
        g2.drawLine(x + 10, y + h / 2, x - 4, y + h / 2);
        g2.setColor(new Color(255, 60, 0, 180));
        g2.drawLine(x + 14, y + h / 2 - 5, x, y + h / 2 - 5);
        g2.drawLine(x + 14, y + h / 2 + 5, x, y + h / 2 + 5);
    }
}
