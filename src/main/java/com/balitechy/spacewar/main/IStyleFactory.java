package com.balitechy.spacewar.main;

public interface IStyleFactory {
    APlayerStyle createStylePlayer(Player player, Game game);
    ABulletStyle createStyleBullet(Bullet bullet, Game game);
    IBackgroundStyle createBackground(Game game);
}
