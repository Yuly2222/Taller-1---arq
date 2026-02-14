package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class BulletController {
    private final LinkedList<Bullet> bl = new LinkedList<Bullet>();

    public void tick() {
        for (int i = 0; i < bl.size(); i++) {
            if (bl.get(i).getY() < 0) {
                removeBullet(bl.get(i));
            } else {
                bl.get(i).tick();
            }
        }
    }

    /**
     * Rendering is delegated to the current style factory to keep logic decoupled
     * from the chosen visualization.
     */
    public void render(Graphics g, IStyleFactory styleFactory, Game game) {
        for (int i = 0; i < bl.size(); i++) {
            ABulletStyle style = styleFactory.createStyleBullet(bl.get(i), game);
            style.render(g);
        }
    }

    public void addBullet(Bullet bullet) {
        bl.add(bullet);
    }

    public void removeBullet(Bullet bullet) {
        bl.remove(bullet);
    }
}
