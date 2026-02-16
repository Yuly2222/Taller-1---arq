package com.balitechy.spacewar.main;

public class ColorfulVectorialStyleFactory implements IStyleFactory {

    @Override
    public APlayerStyle createStylePlayer(Player player, Game game) {
        return new ColorfulVectorialPlayer(player, game);
    }

    @Override
    public ABulletStyle createStyleBullet(Bullet bullet, Game game) {
        return new ColorfulVectorialBullet(bullet, game);
    }

    @Override
    public IBackgroundStyle createBackground(Game game) {
        return new ColorfulVectorialBackground();
    }
}
