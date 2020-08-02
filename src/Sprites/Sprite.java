package Sprites;

import javax.swing.*;

public class Sprite {

    public static Integer x;
    public static Integer y;

    public static String imagename;
    public static ImageIcon image;


    /**
     * Constructor
     *
     * @param x position en X del Sprite
     * @param y position en Y del Sprite
     */
    public Sprite(Integer x, Integer y) {
        Sprite.x = x;
        Sprite.y = y;
    }

    /**
     * Setes image as path define
     */
    private static void setearImg() {
        image = new ImageIcon(
                "src\\images\\" + imagename + ".png");
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        Sprite.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        Sprite.y = y;
    }

    public static String getImagename() {
        return imagename;
    }

    public static void setImagename(String imagename) {
        Sprite.imagename = imagename;
        setearImg();
    }

    public ImageIcon getImage() {
        return image;
    }

    public static void setImage(ImageIcon image) {
        Sprite.image = image;
    }
}

