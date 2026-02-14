package com.balitechy.spacewar.main;

import java.awt.Graphics;

/**
 * Stub implementation: vectorial retro style.
 */
public class VectorialBullet extends ABulletStyle {

    public VectorialBullet(Bullet bullet, Game game) {
        super(bullet, game);
    }

    @Override
    public void render(Graphics g) {
        // TODO: implement primitives-based rendering
        g.drawRect((int) bullet.getX(), (int) bullet.getY(), Bullet.WIDTH, Bullet.HEIGHT);
    }
}
