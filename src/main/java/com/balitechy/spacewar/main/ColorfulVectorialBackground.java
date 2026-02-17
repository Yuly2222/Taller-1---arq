package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * Colorful Vectorial visual representation of the Background.
 * Creates a colorful starfield using geometric primitives.
 */
public class ColorfulVectorialBackground implements IBackgroundStyle {

    private static final int STAR_COUNT = 60;
    private final int[][] STARTS;
    private final Color[] START_COLORS;

    public ColorfulVectorialBackground() {
        // Generate random star positions and colors (only once)
        STARTS = new int[STAR_COUNT][2];
        START_COLORS = new Color[STAR_COUNT];
        Random rand = new Random(42); // Fixed seed for consistency

        Color[] possibleColors = {
                Color.WHITE, Color.CYAN, Color.YELLOW,
                Color.MAGENTA, new Color(255, 200, 255),
                new Color(200, 255, 255)
        };

        for (int i = 0; i < STAR_COUNT; i++) {
            STARTS[i][0] = rand.nextInt(640); // x position
            STARTS[i][1] = rand.nextInt(480); // y position
            START_COLORS[i] = possibleColors[rand.nextInt(possibleColors.length)];
        }
    }

    @Override
    public void render(Graphics g, Canvas c) {
        // Dark blue gradient background
        g.setColor(new Color(10, 10, 40));
        g.fillRect(0, 0, c.getWidth(), c.getHeight());

        // Add gradient effect
        g.setColor(new Color(20, 10, 60, 100));
        g.fillRect(0, c.getHeight() / 2, c.getWidth(), c.getHeight() / 2);

        // Colorful stars
        for (int i = 0; i < STAR_COUNT; i++) {
            // Scale stars to canvas size
            int x = (STARTS[i][0] * c.getWidth()) / 640;
            int y = (STARTS[i][1] * c.getHeight()) / 480;

            g.setColor(START_COLORS[i]);

            // Draw stars with different sizes for depth
            if (i % 3 == 0) {
                // Bigger, brighter stars
                g.fillOval(x - 1, y - 1, 3, 3);
            } else {
                // Smaller stars
                g.drawLine(x - 1, y, x + 1, y);
                g.drawLine(x, y - 1, x, y + 1);
            }
        }
    }
}