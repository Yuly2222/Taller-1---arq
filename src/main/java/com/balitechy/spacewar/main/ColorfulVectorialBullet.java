package com.balitechy.spacewar.main;

import java.awt.Graphics;

/**
 * Stub implementation: colorful vectorial style.
 */
public class ColorfulVectorialBullet extends ABulletStyle {

    public ColorfulVectorialBullet(Bullet bullet, Game game) {
        super(bullet, game);
    }

    @Override
    public void render(Graphics g) {
        // TODO: implement primitives-based rendering with colors
        g.drawOval((int) bullet.getX(), (int) bullet.getY(), Bullet.WIDTH, Bullet.HEIGHT);
    }
}
