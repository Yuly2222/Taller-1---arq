package com.balitechy.spacewar.main;

public interface IStyleFactory {
    /**
     * Creates a visual style for rendering a player.
     * 
     * @param player The player entity to be rendered
     * @return A player style implementation
     */
    IPlayerStyle createPlayerStyle(Player player);

    /**
     * Creates a visual style for rendering a bullet.
     * 
     * @param bullet The bullet entity to be rendered
     * @return A bullet style implementation
     */
    IBulletStyle createBulletStyle(Bullet bullet);

    /**
     * Creates a visual style for rendering the background.
     * 
     * @return A background style implementation
     */
    IBackgroundStyle createBackgroundStyle();
}
