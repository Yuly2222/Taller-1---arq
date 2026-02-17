package com.balitechy.spacewar.main;

import java.awt.Color;
import java.awt.Graphics;

/**
 * <<<<<<< HEAD
 * Vectorial (retro) visual representation of the Player.
 * Uses geometric primitives (lines, polygons) in white.
 * Creates a classic arcade-style spaceship appearance.
 * =======
 * Vectorial retro style (black background + white outlines).
 * Uses only primitives (polygons/lines/ovals).
 * >>>>>>> 4b512bf1717c6fcb009cd9e9efa3e0f77d391f89
 */
public class VectorialPlayer implements IPlayerStyle {

        private final Player PLAYER     ;

        public VectorialPlayer(Player player) {
                this.PLAYER = player;
        }

        @Override
        public void render(Graphics g) {
                int x = (int) PLAYER.getX();
                int y = (int) PLAYER.getY();

                g.setColor(Color.BLACK);

                // Draw spaceship as a triangle (classic arcade style)
                int[] xPoints = {
                                x + Player.WIDTH / 2, // Top center (nose)
                                x, // Bottom left
                                x + Player.WIDTH // Bottom right
                };
                int[] yPoints = {
                                y, // Top (nose)
                                y + Player.HEIGHT, // Bottom left
                                y + Player.HEIGHT // Bottom right
                };
                g.drawPolygon(xPoints, yPoints, 3);

                // Add detail: draw center line
                g.drawLine(x + Player.WIDTH / 2, y, x + Player.WIDTH / 2, y + Player.HEIGHT);
        }
}