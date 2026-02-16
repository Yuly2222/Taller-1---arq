package com.balitechy.spacewar.main;

import java.awt.Graphics;

/**
 * Stub implementation: colorful vectorial style.
 */
public class ColorfulVectorialPlayer extends APlayerStyle {

    public ColorfulVectorialPlayer(Player player, Game game) {
        super(player, game);
    }

    @Override
    public void render(Graphics g) {
        // TODO: implement primitives-based rendering with colors
        g.drawOval((int) player.getX(), (int) player.getY(), Player.WIDTH, Player.HEIGHT);
    }
}
