package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SpritePlayer implements IPlayerStyle {

    private final Player player;
    private final BufferedImage image;

    public SpritePlayer(Player player, SpritesImageLoader sprites) {
        this.player = player;
        // Extract player sprite from sprite sheet
        this.image = sprites.getImage(219, 304, Player.WIDTH, Player.HEIGHT);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image, (int) player.getX(), (int) player.getY(), null);
    }
}