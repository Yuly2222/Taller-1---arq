package com.balitechy.spacewar.main;

/**
 * Concrete Factory for creating Vectorial (retro) visual styles.
 * Creates a complete family of vector-based rendering components.
 * 
 * This factory ensures all visual elements use geometric primitives
 * in white for a classic arcade/retro monochrome look.
 */
public class VectorialStyleFactory implements IStyleFactory {

    @Override
    public IPlayerStyle createPlayerStyle(Player player) {
        return new VectorialPlayer(player);
    }

    @Override
    public IBulletStyle createBulletStyle(Bullet bullet) {
        return new VectorialBullet(bullet);
    }

    @Override
    public IBackgroundStyle createBackgroundStyle() {
        return new VectorialBackground();
    }
}