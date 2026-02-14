package com.balitechy.spacewar.main;

public class SpriteStyleFactory implements IStyleFactory {

    @Override
    public APlayerStyle createStylePlayer(Player player, Game game) {
        return new SpritePlayer(player, game);
    }

    @Override
    public ABulletStyle createStyleBullet(Bullet bullet, Game game) {
        return new SpriteBullet(bullet, game);
    }

    @Override
    public IBackgroundStyle createBackground(Game game) {
        return new SpriteBackground(game);
    }
}
