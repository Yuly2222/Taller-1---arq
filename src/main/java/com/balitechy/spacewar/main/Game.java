package com.balitechy.spacewar.main;

import com.balitechy.spacewar.main.Player;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 320;
    public static final int HEIGHT = WIDTH / 12 * 9;
    public static final int SCALE = 2;
    public final String TITLE = "Space War 2D";

    private boolean running = false;
    private Thread thread;
    @SuppressWarnings("unused")
    private final BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

    // ==========================================
    // MODEL (Business Logic)
    // ==========================================
    private Player player;
    private BulletController bullets;

    // ==========================================
    // VIEW (Rendering)
    // ==========================================
    private IStyleFactory styleFactory;
    private View view;

    /**
     * Initializes game components.
     * This is where you configure the visual style by choosing a factory.
     */
    public void init() {
        requestFocus();

        // Add keyboard listener
        addKeyListener(new InputHandler(this));

        // ==========================================
        // INITIALIZE MODEL (Business Logic)
        // ==========================================
        player = new Player(
                (WIDTH * SCALE - Player.WIDTH) / 2.0,
                (double) (HEIGHT * SCALE - 50),
                WIDTH * SCALE,
                HEIGHT * SCALE);
        bullets = new BulletController();

        // ==========================================
        // CONFIGURE VISUAL STYLE
        // Change the factory here to change the entire game's appearance!
        // ==========================================

        // Option 1: Sprite-based style (images/textures)
        styleFactory = new SpriteStyleFactory();
        // Choose style factory (configured via -Dstyle=...).
        styleFactory = StyleFactoryConfig.build();

        // Option 2: Vectorial style (retro monochrome)
        // styleFactory = new VectorialStyleFactory();

        // Option 3: Colorful vectorial style
        // styleFactory = new ColorfulVectorialStyleFactory();

        // ==========================================
        // INITIALIZE VIEW (Rendering Layer)
        // ==========================================
        view = new View(styleFactory, player, bullets);
    }

    /**
     * Handles key press events and updates model accordingly.
     */
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_RIGHT:
                player.setVelX(5);
                break;

            case KeyEvent.VK_LEFT:
                player.setVelX(-5);
                break;

            case KeyEvent.VK_UP:
                player.setVelY(-5);
                break;

            case KeyEvent.VK_DOWN:
                player.setVelY(5);
                break;

            case KeyEvent.VK_SPACE:
                // Player creates bullet, Game adds it to controller
                Bullet bullet = player.createBullet();
                bullets.addBullet(bullet);
                break;
        }
    }

    /**
     * Handles key release events and updates model accordingly.
     */
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_LEFT:
                player.setVelX(0);
                break;

            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
                player.setVelY(0);
                break;
        }
    }

    private synchronized void start() {
        if (running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop() {
        if (!running)
            return;

        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }

    /**
     * Main game loop.
     */
    @Override
    public void run() {
        init();

        long lastTime = System.nanoTime();
        final double numOfTicks = 60.0;
        double ns = 1000000000 / numOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            if (delta >= 1) {
                tick();
                updates++;
                delta--;
            }

            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(updates + " ticks, fps " + frames);
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }

    /**
     * Updates game state (MODEL LOGIC ONLY).
     * View does not participate in business logic.
     */
    public void tick() {
        player.tick();
        bullets.tick();
    }

    /**
     * Renders game graphics (VIEW ONLY).
     * Model does not participate in rendering.
     */
    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        //////////////////////////////////

        view.render(g, this);

        //////////////////////////////////
        g.dispose();
        bs.show();
    }

    /**
     * Application entry point.
     */
    public static void main(String args[]) {
        Game game = new Game();
        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

        JFrame frame = new JFrame(game.TITLE);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        game.start();
    }
}