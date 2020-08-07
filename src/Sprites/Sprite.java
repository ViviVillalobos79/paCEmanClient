package Sprites;

import javax.swing.*;

public class Sprite {

    private Integer x;
    private Integer y;

    private String imagename;
    private ImageIcon image;


    /**
     * Constructor
     *
     * @param x position en X del Sprite
     * @param y position en Y del Sprite
     */
    public Sprite(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Setes image as path define
     */
    private void setearImg() {
        this.image = new ImageIcon(
                "C:\\Users\\Dxnium\\OneDrive - Estudiantes ITCR\\TEC\\Lenguajes\\Tarea Corta 3\\paCEmanClient\\paCEmanClient\\src\\images" + imagename + ".png");
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
        setearImg();
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }
}

