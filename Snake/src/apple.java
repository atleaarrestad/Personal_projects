import java.awt.*;
import java.util.Random;

public class apple extends baseGraphic {

    public int score;
    apple(int width, int height) {
        this.x = 256;
        this.y = 256;
        this.width = width;
        this.height = height;
        this.color = Color.red;
        score = 0;
    }

    public void randomizeLocation(int windowWidth, int windowHeight, int tileSize){
        Random random = new Random();
        int randomX = random.nextInt(windowHeight/tileSize);
        int randomY = random.nextInt(windowHeight/tileSize);
        this.x = randomX * tileSize;
        this.y = randomY * tileSize;
    }

    public void eatApple(){
        this.score += 1;
    }

    public void resetScore(){
        this.score = 0;
    }

}
