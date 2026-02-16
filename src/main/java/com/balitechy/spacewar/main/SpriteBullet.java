package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Sprite-based visual representation of a Bullet.
 * Uses image from sprite sheet.
 */
public class SpriteBullet implements IBulletStyle {

    private final Bullet bullet;
    private final BufferedImage image;

    public SpriteBullet(Bullet bullet, SpritesImageLoader sprites) {
        this.bullet = bullet;
        // Extract bullet sprite from sprite sheet
        this.image = sprites.getImage(35, 52, Bullet.WIDTH, Bullet.HEIGHT);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image, (int) bullet.getX(), (int) bullet.getY(), null);
    }
}