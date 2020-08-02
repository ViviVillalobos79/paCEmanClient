package Sprites;

import javax.swing.*;
import java.awt.*;

public class Pacman extends Sprite{

    private final Integer PAC_ANIM_DELAY = 2;
    private final Integer PACMAN_ANIM_COUNT = 4;
    private final Integer PACMAN_SPEED = 6;

    private Integer pacAnimCount = PAC_ANIM_DELAY;
    private Integer pacAnimDir = 1;
    private Integer pacmanAnimPos = 0;

    private Integer[] dx, dy;

    private Integer abajo;
    private Integer arriba;
    private Integer izquierda;
    private Integer derecha;

    private ImageIcon pacman1, pacman2up, pacman2left, pacman2right, pacman2down;
    private ImageIcon pacman3up, pacman3down, pacman3left, pacman3right;
    private ImageIcon pacman4up, pacman4down, pacman4left, pacman4right;


    /**
     * Constructor
     *
     * @param x position en X del Sprite
     * @param y position en Y del Sprite
     */
    public Pacman(Integer x, Integer y) {
        super(x, y);
        loadImages();
    }

    /**
     * Loads Images for the animation
     */
    private void loadImages() {
        pacman1 = new ImageIcon("src\\images\\pacman.png");
        pacman2up = new ImageIcon("src\\images\\up1.gif");
        pacman3up = new ImageIcon("src\\images\\up2.gif");
        pacman4up = new ImageIcon("src\\images\\up3.gif");
        pacman2down = new ImageIcon("src\\images\\down1.gif");
        pacman3down = new ImageIcon("src\\images\\down2.gif");
        pacman4down = new ImageIcon("src\\images\\down3.gif");
        pacman2left = new ImageIcon("src\\images\\left1.gif");
        pacman3left = new ImageIcon("src\\images\\left2.gif");
        pacman4left = new ImageIcon("src\\images\\left3.gif");
        pacman2right = new ImageIcon("src\\images\\right1.gif");
        pacman3right = new ImageIcon("src\\images\\right2.gif");
        pacman4right = new ImageIcon("src\\images\\right3.gif");
    }

    /**
     * Says which image is suppose to be drawn
     * @return Image Icon for the corresponding direction
     */
    public ImageIcon getImageAnim(){
        if (arriba == 1){
            return pacman2up;
        }
        if (abajo == 1){
            return pacman2down;
        }
        if (derecha == 1){
            return pacman2right;
        }
        if (izquierda == 1){
            return pacman2left;
        }
        else {
            return pacman2right;
        }
    }

    public Integer getAbajo() {
        return abajo;
    }

    public void setAbajo(Integer abajo) {
        this.abajo = abajo;
    }

    public Integer getArriba() {
        return arriba;
    }

    public void setArriba(Integer arriba) {
        this.arriba = arriba;
    }

    public Integer getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Integer izquierda) {
        this.izquierda = izquierda;
    }

    public Integer getDerecha() {
        return derecha;
    }

    public void setDerecha(Integer derecha) {
        this.derecha = derecha;
    }
}
