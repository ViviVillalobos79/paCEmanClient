package Sprites;

import javax.swing.*;

public class Ghost extends Sprite{

    private String name;
    private Integer ghostColor;
    private Integer levelNum;

    private ImageIcon ghost_blue, ghost_orange, ghost_red, ghost_pink;


    /**
     * Constructor
     *
     * @param x position en X del Sprite
     * @param y position en Y del Sprite
     */
    public Ghost(Integer x, Integer y) {
        super(x, y);
        loadImages();
    }

    /**
     * Another constructor
     * @param levelNum to be use for the path that they follow
     * @param ghostColor color of the ghost
     * @param name name of ghost
     */
    public Ghost(Integer levelNum, Integer ghostColor, String name){
        super(2,1);
        loadImages();
        this.ghostColor = ghostColor;
        this.levelNum = levelNum;
        this.name = name;
        setInitPosition();

    }

    /**
     * Sets the first position for default for each ghost
     */
    public void setInitPosition(){
        if(name.equals("Clyde")){
            this.setX(11);
        }
        else if(name.equals("Blinky")){
            this.setX(12);
        }
        else if(name.equals("Pinky")){
            this.setX(13);
        }
        else if(name.equals("Inky")) {
            this.setX(14);
        }
        else {
            this.setX(17);
        }
        this.setY(14);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Is going to handle the movement
     */
    public void mover(){
        
    }

    /**
     * Loads images for each ghost
     */
    private void loadImages() {
        ghost_blue = new ImageIcon("src\\images\\ghost_blue.png");
        ghost_orange = new ImageIcon("src\\images\\ghost_orange.png");
        ghost_pink = new ImageIcon("src\\images\\ghost_pink.png");
        ghost_red = new ImageIcon("src\\images\\ghost_red.png");

    }

    /**
     * Get image depending of the ghost
     * @return ImageIcon in regards of the ghost name
     */
    public ImageIcon getImageGhost(){
        if(name.equals("Clyde")){
            return ghost_orange;
        }
        if(name.equals("Blinky")){
            return ghost_red;
        }
        if(name.equals("Pinky")){
            return ghost_pink;
        }
        return ghost_blue;
    }

}
