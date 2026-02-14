package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SpritePlayer extends APlayerStyle {

    private final BufferedImage image;

    public SpritePlayer(Player player, Game game) {
        super(player, game);
        // Keep original sprite coordinates.
        this.image = game.getSprites().getImage(0, 0, Player.WIDTH, Player.HEIGHT);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image, (int) player.getX(), (int) player.getY(), null);
    }
}
