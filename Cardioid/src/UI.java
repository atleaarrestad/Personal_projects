import javax.swing.*;
import java.awt.*;

public class UI extends JFrame {
    private int width;
    private int height;
    private JFrame window;

    UI(int width, int height){
        window = new JFrame("Cardioid");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(width, height);
        window.setVisible(true);
    }

    public void testmethod(){
        Graphics g = new window.getGraphics();
    }

}