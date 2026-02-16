package com.balitechy.spacewar.main;

/**
 * Concrete Factory for creating Colorful Vectorial visual styles.
 * Creates a complete family of colorful vector-based rendering components.
 * 
 * This factory ensures all visual elements use geometric primitives
 * with vibrant colors for a modern, eye-catching appearance.
 */
public class ColorfulVectorialStyleFactory implements IStyleFactory {

    @Override
    public IPlayerStyle createPlayerStyle(Player player) {
        return new ColorfulVectorialPlayer(player);
    }

    @Override
    public IBulletStyle createBulletStyle(Bullet bullet) {
        return new ColorfulVectorialBullet(bullet);
    }

    @Override
    public IBackgroundStyle createBackgroundStyle() {
        return new ColorfulVectorialBackground();
    }
}