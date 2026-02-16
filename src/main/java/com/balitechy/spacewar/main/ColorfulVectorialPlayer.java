package com.balitechy.spacewar.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;

/**
 * <<<<<<< HEAD
 * Colorful Vectorial visual representation of the Player.
 * Uses geometric primitives with vibrant colors.
 * =======
 * Colorful vectorial style: same geometry as vectorial, but with neon-ish
 * colors.
 * >>>>>>> 4b512bf1717c6fcb009cd9e9efa3e0f77d391f89
 */
public class ColorfulVectorialPlayer implements IPlayerStyle {

        private final Player player;

        public ColorfulVectorialPlayer(Player player) {
                this.player = player;
        }

        @Override
        public void render(Graphics g) {
                int x = (int) player.getX();
                int y = (int) player.getY();

                // Draw spaceship body in cyan
                g.setColor(Color.CYAN);
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
                g.fillPolygon(xPoints, yPoints, 3);

                // Draw outline in blue
                g.setColor(Color.BLUE);
                g.drawPolygon(xPoints, yPoints, 3);

                // Add detail: draw engine exhaust in orange/red
                g.setColor(Color.ORANGE);
                g.fillOval(x + 5, y + Player.HEIGHT - 3, 8, 6);
                g.fillOval(x + Player.WIDTH - 13, y + Player.HEIGHT - 3, 8, 6);
        }
}