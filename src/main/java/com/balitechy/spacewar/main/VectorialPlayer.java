package com.balitechy.spacewar.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;

/**
 * Vectorial retro style (black background + white outlines).
 * Uses only primitives (polygons/lines/ovals).
 */
public class VectorialPlayer extends APlayerStyle {

    public VectorialPlayer(Player player, Game game) {
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

        // Simple retro ship: a triangle nose + small tail fins.
        Polygon body = new Polygon(
                new int[]{x + w / 2, x + w - 6, x + w - 16, x + 16, x + 6},
                new int[]{y + 2, y + h / 2, y + h - 3, y + h - 3, y + h / 2},
                5
        );

        g2.setColor(Color.WHITE);
        g2.drawPolygon(body);

        // Cockpit ring.
        int cx = x + w / 2 - 6;
        int cy = y + h / 2 - 6;
        g2.drawOval(cx, cy, 12, 12);

        // Thruster lines.
        g2.drawLine(x + 10, y + h / 2, x + 0, y + h / 2);
        g2.drawLine(x + 14, y + h / 2 - 5, x + 2, y + h / 2 - 5);
        g2.drawLine(x + 14, y + h / 2 + 5, x + 2, y + h / 2 + 5);
    }
}
