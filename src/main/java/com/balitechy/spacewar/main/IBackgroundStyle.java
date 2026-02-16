package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Graphics;

public interface IBackgroundStyle {

    /**
     * 
     * @param g Graphics context for drawing
     * @param c Canvas to get dimensions
     */
    public void render(Graphics g, Canvas c);
}