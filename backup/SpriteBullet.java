package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SpriteBullet extends ABulletStyle {

    private final BufferedImage image;

    public SpriteBullet(Bullet bullet, Game game) {
        super(bullet, game);
        this.image = game.getSprites().getImage(35, 52, Bullet.WIDTH, Bullet.HEIGHT);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image, (int) bullet.getX(), (int) bullet.getY(), null);
    }
}
