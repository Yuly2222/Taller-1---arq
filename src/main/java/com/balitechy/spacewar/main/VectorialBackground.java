package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * Vectorial (retro) visual representation of the Background.
 * Creates a starfield using simple geometric primitives.
 */
public class VectorialBackground implements IBackgroundStyle {

    private static final int STAR_COUNT = 50;
    private final int[][] STARS;

    public VectorialBackground() {
        // Generate random star positions (only once)
        STARS = new int[STAR_COUNT][2];
        Random rand = new Random(42); // Fixed seed for consistent stars

        for (int i = 0; i < STAR_COUNT; i++) {
            STARS[i][0] = rand.nextInt(640); // x position
            STARS[i][1] = rand.nextInt(480); // y position
        }
    }

    @Override
    public void render(Graphics g, Canvas c) {
        // Black background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, c.getWidth(), c.getHeight());

        // White stars
        g.setColor(Color.WHITE);
        for (int i = 0; i < STAR_COUNT; i++) {
            // Scale stars to canvas size
            int x = (STARS[i][0] * c.getWidth()) / 640;
            int y = (STARS[i][1] * c.getHeight()) / 480;

            // Draw star as small cross
            g.drawLine(x - 1, y, x + 1, y);
            g.drawLine(x, y - 1, x, y + 1);
        }
    }
}
