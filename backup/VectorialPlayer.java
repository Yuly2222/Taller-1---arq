package com.balitechy.spacewar.main;

import java.awt.Graphics;

/**
 * Stub implementation: vectorial retro style.
 * (Requested: do not implement style yet; keep compile-ready.)
 */
public class VectorialPlayer extends APlayerStyle {

    public VectorialPlayer(Player player, Game game) {
        super(player, game);
    }

    @Override
    public void render(Graphics g) {
        // TODO: implement primitives-based rendering
        g.drawRect((int) player.getX(), (int) player.getY(), Player.WIDTH, Player.HEIGHT);
    }
}
