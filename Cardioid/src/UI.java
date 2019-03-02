import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UI extends JPanel implements ActionListener {

    private int factor = 3;
    private JFrame window;
    private int numberOfPoints = 1;
    private int width = 1024;
    private int height = 1024;
    private int radius = 450;
    private ArrayList<Integer> coordX = new ArrayList<>();
    private ArrayList<Integer> coordY = new ArrayList<>();
    private int startX = width/2;
    private int startY = height/2;
    private int pointWidth = 2;
    private int pointHeight = 2;
    private Timer tick;
    private int delay = 100;




    UI(){
        window = new JFrame("Cardioid");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(width, height);
        window.add(this);
        tick = new Timer(delay, this);
        tick.start();
        window.setVisible(true);
        calculatePoints();
    }



    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        //Draw Points
        for(int i = 0;i < numberOfPoints; i++){
            g.drawOval(coordX.get(i) - pointWidth/2, coordY.get(i) - pointHeight/2, pointWidth,pointHeight);
        }

        //Paint lines
        for (int i = 0; i < numberOfPoints; i++){
            int x;
            int multipleInt;
            double multiple = Math.floor((((factor*i)/(double)numberOfPoints)));
            multipleInt = (int) multiple;
            x = (factor*i) - (multipleInt * numberOfPoints);

            g.drawLine(coordX.get(i), coordY.get(i), coordX.get(x), coordY.get(x));
        }

        //Draw info
        g.setFont(g.getFont().deriveFont(18.0f));
        g.drawString("Factor: " + factor, 20, 20);
        g.drawString("Number of points: " + numberOfPoints, 20, 40);

        //Repaint
        repaint();
    }

    public void calculatePoints(){
        coordX.clear();
        coordY.clear();
        for (int i = 0; i < numberOfPoints; i++){
            coordX.add((int) Math.round(Math.cos((2*Math.PI/numberOfPoints)*i) * radius) + startX);
            coordY.add((int) Math.round(Math.sin((2*Math.PI/numberOfPoints)*i) * radius) + startY);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        numberOfPoints += 1;
        calculatePoints();
    }
}