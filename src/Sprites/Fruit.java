package Sprites;

import javax.swing.*;
import java.util.Random;

public class Fruit extends Sprite {

    private Integer points;
    private ImageIcon image;
    private Random random = new Random();


    /**
     * Constructor
     *
     * @param x position en X del Sprite
     * @param y position en Y del Sprite
     */
    public Fruit(Integer x, Integer y) {
        super(x, y);
    }

    /**
     * Constructor
     * @param points value if eaten
     */
    public Fruit(Integer points){
        super(2,2);
        setPos();
        this.points = points;
        loadimage();
    }

    /**
     * Loads the fruit image
     */
    private void loadimage() {
        image = new ImageIcon("src\\images\\fruit.png");
    }

    public Integer getPoints() {
        return points;
    }

    /**
     * Sets a random position for the Fruit
     */
    public void setPos(){
        Integer[][] mat = Player.nivel.getLeveldat();
        while (true){
            Integer x = random.nextInt(mat[0].length);
            Integer y = random.nextInt(mat.length);
            if(mat[y][x] == 1 || mat[y][x] == 0){
                this.setX(x);
                this.setY(y);
                break;
            }
        }
    }

    @Override
    public ImageIcon getImage() {
        return image;
    }
}
