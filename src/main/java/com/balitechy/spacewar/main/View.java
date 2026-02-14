package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Graphics;

public class View {

    private final Game game;
    private final Player player;
    private final BulletController bullets;

    private final IStyleFactory styleFactory;
    private final APlayerStyle playerStyle;
    private final IBackgroundStyle backgroundStyle;

    public View(Game game, IStyleFactory styleFactory, Player player, BulletController bullets) {
        this.game = game;
        this.styleFactory = styleFactory;
        this.player = player;
        this.bullets = bullets;

        this.playerStyle = styleFactory.createStylePlayer(player, game);
        this.backgroundStyle = styleFactory.createBackground(game);
    }

    public void tick() {
        player.tick();
        bullets.tick();
        playerStyle.tick();
        // bullet styles are created on demand in render
    }

    public void render(Graphics g, Canvas c) {
        backgroundStyle.render(g, c);
        playerStyle.render(g);
        bullets.render(g, styleFactory, game);
    }
}
