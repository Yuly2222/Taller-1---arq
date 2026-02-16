package com.balitechy.spacewar.main;

import java.awt.Graphics;

public abstract class APlayerStyle {
    protected final Player player;
    protected final Game game;

    protected APlayerStyle(Player player, Game game) {
        this.player = player;
        this.game = game;
    }

    public void tick() {
        // Default: visualization has no internal tick.
        // Game logic ticks are handled by Player itself.
    }

    public abstract void render(Graphics g);
}
