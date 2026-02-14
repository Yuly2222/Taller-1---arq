package com.balitechy.spacewar.main;

public class VectorialStyleFactory implements IStyleFactory {

    @Override
    public APlayerStyle createStylePlayer(Player player, Game game) {
        return new VectorialPlayer(player, game);
    }

    @Override
    public ABulletStyle createStyleBullet(Bullet bullet, Game game) {
        return new VectorialBullet(bullet, game);
    }

    @Override
    public IBackgroundStyle createBackground(Game game) {
        return new VectorialBackground();
    }
}
