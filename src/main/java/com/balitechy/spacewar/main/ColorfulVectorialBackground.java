package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Random;

/**
 * Colorful vectorial background: deep space + colorful stars + neon grid.
 */
public class ColorfulVectorialBackground implements IBackgroundStyle {

    private final int[] starX;
    private final int[] starY;
    private final Color[] starC;

    public ColorfulVectorialBackground() {
        Random r = new Random(2026);
        int n = 110;
        starX = new int[n];
        starY = new int[n];
        starC = new Color[n];
        for (int i = 0; i < n; i++) {
            starX[i] = r.nextInt(Game.WIDTH * Game.SCALE);
            starY[i] = r.nextInt(Game.HEIGHT * Game.SCALE);
            // A small palette of neon-ish star colors.
            int pick = r.nextInt(5);
            switch (pick) {
    case 0:
        starC[i] = new Color(255, 80, 190, 220);
        break;
    case 1:
        starC[i] = new Color(0, 220, 255, 220);
        break;
    case 2:
        starC[i] = new Color(170, 255, 0, 220);
        break;
    case 3:
        starC[i] = new Color(255, 210, 0, 220);
        break;
    default:
        starC[i] = new Color(255, 255, 255, 210);
        break;
            }
        }

    }

    @Override
    public void render(Graphics g, Canvas c) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = c.getWidth();
        int h = c.getHeight();

        // Space base.
        g2.setColor(new Color(5, 0, 20));
        g2.fillRect(0, 0, w, h);

        // Neon grid.
        g2.setColor(new Color(0, 220, 255, 40));
        int step = 40;
        for (int x = 0; x < w; x += step) g2.drawLine(x, 0, x, h);
        g2.setColor(new Color(255, 80, 190, 30));
        for (int y = 0; y < h; y += step) g2.drawLine(0, y, w, y);

        // Stars.
        for (int i = 0; i < starX.length; i++) {
            int sx = starX[i] % w;
            int sy = starY[i] % h;
            g2.setColor(starC[i]);
            g2.fillOval(sx, sy, 3, 3);
        }
    }
}
