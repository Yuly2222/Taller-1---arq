package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Random;

/**
 * Vectorial retro background: black space, white stars and a faint grid.
 */
public class VectorialBackground implements IBackgroundStyle {

    private final int[] starX;
    private final int[] starY;

    public VectorialBackground() {
        // Deterministic stars so the background doesn't "sparkle" randomly each frame.
        Random r = new Random(1337);
        int n = 90;
        starX = new int[n];
        starY = new int[n];
        for (int i = 0; i < n; i++) {
            starX[i] = r.nextInt(Game.WIDTH * Game.SCALE);
            starY[i] = r.nextInt(Game.HEIGHT * Game.SCALE);
        }
    }

    @Override
    public void render(Graphics g, Canvas c) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = c.getWidth();
        int h = c.getHeight();

        // Space.
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, w, h);

        // Faint grid (retro terminal vibe).
        g2.setColor(new Color(255, 255, 255, 30));
        int step = 40;
        for (int x = 0; x < w; x += step) g2.drawLine(x, 0, x, h);
        for (int y = 0; y < h; y += step) g2.drawLine(0, y, w, y);

        // Stars.
        g2.setColor(Color.WHITE);
        for (int i = 0; i < starX.length; i++) {
            int sx = starX[i] % w;
            int sy = starY[i] % h;
            g2.fillRect(sx, sy, 2, 2);
        }
    }
}
