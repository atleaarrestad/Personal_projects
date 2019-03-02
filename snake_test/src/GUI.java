import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


class GUI extends JPanel implements KeyListener, ActionListener {

    public JFrame frame;
    public int tileSize = 64;
    public snake snake = new snake(tileSize, tileSize, tileSize);
    public apple apple = new apple(tileSize,tileSize);
    public Timer gameTick;
    public Timer appleTimer;
    public int gameTickDelay = 100;
    public int appleTimerDelay = 5000;
    public int window_width = 1024 -16;
    public int window_height = 1024 -28;
    public boolean gamePaused = true;
    public boolean dead = false;

    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenuItem menuFileRestart;


    GUI(){

        frame = new JFrame("tittel");
        frame.setSize(window_width,window_height);
        frame.add(this);
        frame.addKeyListener(this);
        gameTick = new Timer(gameTickDelay, this);
        appleTimer = new Timer(appleTimerDelay, this);
        appleTimer.start();
        gameTick.start();

        //Menu
        menuBar = new JMenuBar();
        menuFile = new JMenu("Game");
        menuFileRestart = new JMenuItem("Start/restart");
        menuFileRestart.addActionListener(this);
        menuFile.add(menuFileRestart);
        menuBar.add(menuFile);
        frame.setJMenuBar(menuBar);

        frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Draw grid
        for (int i = 0; i < window_height / tileSize; i++){
            g.drawLine(0, i*tileSize, window_width, i*tileSize);
            g.drawLine(i*tileSize, 0, i*tileSize, window_height);
        }

        //Draw score
        String text = "Score: " + Integer.toString(apple.score);
        int scoreWidth = g.getFontMetrics().stringWidth(text);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 32));
        g.drawString(text, window_width/2 - (scoreWidth), 28);

        //Draw snake/apple
        for (int i = 0; i < snake.body.size(); i++){
            snake.body.get(i).drawMe(g);
        }
        snake.drawMe(g);

        //Draw apple
        apple.drawMe(g);

        //Draw you died
        if (dead){
            g.setFont(new Font("TimesRoman", Font.PLAIN, 200));
            g.setColor(Color.RED);
            g.drawString("You Died", (window_width/2) - 420, window_height/2 - 32);
        }

        //repaint
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == menuFileRestart) {
            dead = false;
            gamePaused = false;
            appleTimer.restart();
            apple.score = 0;
            snake.killSnake();
        }

        if (!gamePaused) {
            if (e.getSource() == gameTick) {

                //Eat apple
                if (snake.collisionCheck(apple)) {
                    apple.eatApple();
                    apple.randomizeLocation(window_width, window_height, tileSize);
                    appleTimer.restart();
                    snake.addSnakeLength();
                }

                //Movement
                snake.moveSnakeBody();

                //Outside bounds
                if (snake.checkSnakeOutsideBounds(window_width, window_height)) {
                    gamePaused = true;
                    dead = true;
                }
            }

            //Move apple
            if (e.getSource() == appleTimer) {
                apple.randomizeLocation(window_width, window_height, tileSize);
            }
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key){
            case KeyEvent.VK_LEFT: snake.direction = dir.LEFT;
                break;
            case KeyEvent.VK_RIGHT: snake.direction = dir.RIGHT;
                break;
            case KeyEvent.VK_UP: snake.direction = dir.UP;
                break;
            case KeyEvent.VK_DOWN: snake.direction = dir.DOWN;
                break;
        }

    }
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
}