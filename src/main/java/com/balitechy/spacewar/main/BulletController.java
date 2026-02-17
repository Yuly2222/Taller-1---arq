package com.balitechy.spacewar.main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BulletController {
    public final LinkedList<Bullet> bl = new LinkedList<Bullet>();

    public void tick() {
        for (int i = 0; i < bl.size(); i++) {
            if (bl.get(i).getY() < 0) {
                removeBullet(bl.get(i));
            } else {
                bl.get(i).tick();
            }
        }
    }

    public List<Bullet> getBullets() {
        return new ArrayList<>(bl);
    }

    /**
     * Rendering is delegated to the current style factory to keep logic decoupled
     * from the chosen visualization.
     */

    public void addBullet(Bullet bullet) {
        bl.add(bullet);
    }

    public void removeBullet(Bullet bullet) {
        bl.remove(bullet);
    }
}
