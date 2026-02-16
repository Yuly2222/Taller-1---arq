package com.balitechy.spacewar.main;

import java.io.IOException;

/**
 * Concrete Factory for creating Sprite-based visual styles.
 * Creates a complete family of sprite-based rendering components.
 * 
 * This factory ensures all visual elements use sprites/images
 * for a consistent retro pixel-art look.
 */
public class SpriteStyleFactory implements IStyleFactory {

    private final SpritesImageLoader sprites;

    public SpriteStyleFactory() {
        sprites = new SpritesImageLoader("/sprites.png");
        try {
            sprites.loadImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public IPlayerStyle createPlayerStyle(Player player) {
        return new SpritePlayer(player, sprites);
    }

    @Override
    public IBulletStyle createBulletStyle(Bullet bullet) {
        return new SpriteBullet(bullet, sprites);
    }

    @Override
    public IBackgroundStyle createBackgroundStyle() {
        return new SpriteBackground();
    }
}