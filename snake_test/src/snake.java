import java.awt.*;
import java.util.ArrayList;

public class snake extends baseGraphic {

    public dir direction = dir.UP;
    public ArrayList<snakeBody> body = new ArrayList<>();
    public int speed;

    snake(int width, int height, int speed){
        this.x = 512;
        this.y = 512;
        this.width = width;
        this.height = height;
        this.color = Color.GREEN;
        this.speed = speed;
    }

    public boolean checkSnakeOutsideBounds(int windowWidth, int windowHeight){
        if (this.x < 0 || this.x + this.width >= windowWidth){return true;}
        if (this.y < 0 || this.y >= windowHeight - this.height - 32){return true;}
        return false;
    }

    public void killSnake(){
        body.clear();
        this.x = 512;
        this.y = 512;
    }

    public void addSnakeLength(){
        this.body.add(new snakeBody(0,0, width, height ));
    }

    public void moveSnakeBody(){

        int bodySize = body.size();
        if (bodySize > 1){

            for (int i = bodySize; i > 1; i--){
                body.get(i - 1).x = body.get(i - 2).x;
                body.get(i - 1).y = body.get(i - 2).y;
            }
        }

        if (body.size() > 0){
            body.get(0).x = x;
            body.get(0).y = y;
        }

        moveSnakeHead();
    }

    public void moveSnakeHead(){
        switch (direction){
            case UP: y -= speed;
                break;
            case DOWN: y += speed;
                break;
            case RIGHT: x += speed;
                break;
            case LEFT: x -= speed;
                break;
        }
    }

}
