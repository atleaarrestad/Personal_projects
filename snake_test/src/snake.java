public class snake extends baseGraphic {

    public dir direction = dir.UP;
    public int speed = 32;

    snake(int width, int height){
        this.x = 512;
        this.y = 512;
        this.width = width;
        this.height = height;
    }
}
