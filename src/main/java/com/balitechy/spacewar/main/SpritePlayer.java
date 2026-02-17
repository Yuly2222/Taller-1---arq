package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SpritePlayer implements IPlayerStyle {

    private final Player PLAYER;
    private final BufferedImage IMAGE;

    public SpritePlayer(Player player, SpritesImageLoader sprites) {
        this.PLAYER = player;
        // Extract player sprite from sprite sheet
        this.IMAGE = sprites.getImage(219, 304, Player.WIDTH, Player.HEIGHT);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(IMAGE, (int) PLAYER.getX(), (int) PLAYER.getY(), null);
    }
}