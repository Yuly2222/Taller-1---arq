package com.balitechy.spacewar.main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Utility class for loading and extracting sprites from sprite sheets.
 */
public class SpritesImageLoader {

	private final String PATH;
	private BufferedImage image;

	public SpritesImageLoader(String path) {
		this.PATH = path;
	}

	/**
	 * Loads the sprite sheet image from resources.
	 */
	public BufferedImage loadImage() throws IOException {
		image = ImageIO.read(getClass().getResource(PATH));
		return image;
	}

	/**
	 * Extracts a sub-image (sprite) from the loaded sprite sheet.
	 * 
	 * @param left   X coordinate in the sprite sheet
	 * @param top    Y coordinate in the sprite sheet
	 * @param width  Width of the sprite
	 * @param height Height of the sprite
	 * @return The extracted sprite
	 */
	public BufferedImage getImage(int left, int top, int width, int height) {
		return image.getSubimage(left, top, width, height);
	}
}