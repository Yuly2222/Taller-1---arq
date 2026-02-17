package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Sprite-based visual representation of a Bullet.
 * Uses image from sprite sheet.
 */
public class SpriteBullet implements IBulletStyle {

    private final Bullet BULLET;
    private final BufferedImage IMAGE;

    public SpriteBullet(Bullet bullet, SpritesImageLoader sprites) {
        this.BULLET = bullet;
        // Extract bullet sprite from sprite sheet
        this.IMAGE = sprites.getImage(35, 52, Bullet.WIDTH, Bullet.HEIGHT);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(IMAGE, (int) BULLET.getX(), (int) BULLET.getY(), null);
    }
}