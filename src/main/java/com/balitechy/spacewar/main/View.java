package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Graphics;

/**
 * View layer - Handles ONLY rendering.
 * Completely decoupled from concrete style implementations.
 * Uses only interfaces (IStyleFactory, IPlayerStyle, IBulletStyle,
 * IBackgroundStyle).
 * 
 * Key Design Principles:
 * - View does NOT execute business logic (no tick() calls on model)
 * - View only knows about interfaces, never concrete classes
 * - View is purely a rendering layer
 */
public class View {

    private final Player player;
    private final BulletController bullets;

    private final IStyleFactory styleFactory;
    private final IBackgroundStyle backgroundStyle;

    /**
     * Creates a View with a specific style factory.
     * The factory determines the visual appearance of all game elements.
     */
    public View(IStyleFactory styleFactory, Player player, BulletController bullets) {
        this.styleFactory = styleFactory;
        this.player = player;
        this.bullets = bullets;

        // Create background style once (it doesn't change per frame)
        this.backgroundStyle = styleFactory.createBackgroundStyle();
    }

    /**
     * Renders all game elements using the configured style factory.
     * Each element is rendered using its corresponding style interface.
     * 
     * @param g Graphics context for drawing
     * @param c Canvas to get dimensions
     */
    public void render(Graphics g, Canvas c) {
        // 1. Render background
        backgroundStyle.render(g, c);

        // 2. Render player
        IPlayerStyle playerStyle = styleFactory.createPlayerStyle(player);
        playerStyle.render(g);

        // 3. Render all bullets
        for (Bullet bullet : bullets.getBullets()) {
            IBulletStyle bulletStyle = styleFactory.createBulletStyle(bullet);
            bulletStyle.render(g);
        }
    }
}