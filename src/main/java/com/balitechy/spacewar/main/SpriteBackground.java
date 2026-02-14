package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteBackground implements IBackgroundStyle {

    private BufferedImage background;

    public SpriteBackground(Game game) {
        try {
            SpritesImageLoader bg = new SpritesImageLoader("/bg.png");
            this.background = bg.loadImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void render(Graphics g, Canvas c) {
        if(background != null) {
            g.drawImage(background, 0, 0, c.getWidth(), c.getHeight(), null);
        }
    }
}
