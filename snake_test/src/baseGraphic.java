import java.awt.*;

public class baseGraphic {

    int x, y, width, height;
    Color color = Color.BLUE;

    public void drawMe(Graphics g){
        g.fillOval(x, y, width, height);
    }
}
