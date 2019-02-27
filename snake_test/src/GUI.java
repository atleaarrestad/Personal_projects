import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


class GUI extends JPanel implements KeyListener, ActionListener {

    public JFrame frame;
    public snake snake = new snake(32,32);
    public Timer gameTick;

    GUI(){
        frame = new JFrame("tittel");
        frame.setSize(1024,1024);
        frame.setVisible(true);
        frame.add(this);
        frame.addKeyListener(this);
        gameTick = new Timer(350, this);
        gameTick.start();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        //Do this every game tick(200ms)

        if (e.getSource() == gameTick){
            switch (snake.direction){
                case UP: snake.y -= snake.speed;
                    break;
                case DOWN: snake.y += snake.speed;
                    break;
                case RIGHT: snake.x += snake.speed;
                    break;
                case LEFT: snake.x -= snake.speed;
                    break;
            }
        }
        snake.drawMe(this.getGraphics());
        System.out.println("Snake x: " + snake.x + " y: " + snake.y + " Dir: " + snake.direction);

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