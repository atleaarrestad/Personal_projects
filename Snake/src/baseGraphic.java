import java.awt.*;

public class baseGraphic {

    int x, y, width, height;
    Color color = Color.BLUE;

    public void drawMe(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public boolean collisionCheck(baseGraphic other){
        Rectangle rectMe = new Rectangle(this.x, this.y, this.width, this.height);
        Rectangle rectOther = new Rectangle(other.x, other.y, other.width, other.height);
        return rectMe.intersects(rectOther);
    }
}
