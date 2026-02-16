package com.balitechy.spacewar.main;

/**
 * Central place to configure which concrete visual style is used.
 *
 * Usage:
 *   -Dstyle=sprite
 *   -Dstyle=vectorial-style
 *   -Dstyle=colorful-vectorial-style
 */
public final class StyleFactoryConfig {

    private StyleFactoryConfig() {}

    public static IStyleFactory build() {
        String style = System.getProperty("style", "sprite").trim().toLowerCase();

        switch (style) {
            case "vectorial":
            case "vectorial-style":
                return new VectorialStyleFactory();

            case "colorful":
            case "colorful-vectorial":
            case "colorful-vectorial-style":
                return new ColorfulVectorialStyleFactory();

            case "sprite":
            case "sprite-style":
            default:
                return new SpriteStyleFactory();
        }
    }
}
