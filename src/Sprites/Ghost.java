package Sprites;

import javax.swing.*;
import java.util.Random;

public class Ghost extends Sprite{

    private String name;
    private Integer ghostColor;
    private Integer levelNum;
    private Timer timer;

    Integer direccion;
    Integer mx;
    Integer my;

    Player player;



    public Random random = new Random();

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
    public Ghost(Integer levelNum, Integer ghostColor, String name,Player player){
        super(2,1);
        this.player = player;

        loadImages();
        this.ghostColor = ghostColor;
        this.levelNum = levelNum;
        this.name = name;
        setInitPosition();
        direccion = random.nextInt(4);

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
        Integer[][] mat = Player.nivel.getLeveldat();
        Integer fanx = getX();
        Integer fany = getY();

        if(direccion == 0){
            System.out.println("aqui direccion " + direccion);
            //move
            if(mat[fany-1][fanx] == 0 || mat[fany-1][fanx] == 1) {
                Player.nivel.setAInfo(fanx,fany,Player.matAux[fany][fanx]);
                setY(fany - 1);
            }
            //walls
            else if(mat[fany-1][fanx] == 58 || mat[fany-1][fanx] == 2){
                direccion = random.nextInt(4);
            }
        }

        //down
        if(direccion == 1){
            System.out.println("aqui direccion " + direccion);
            //move
            if(mat[fany+1][fanx] == 0 || mat[fany+1][fanx] == 1) {
                Player.nivel.setAInfo(fanx,fany,Player.matAux[fany][fanx]);
                setY(fany + 1);
            }
            //walls
            else if(mat[fany+1][fanx] == 58 || mat[fany+1][fanx] == 2){
                direccion = random.nextInt(4);
            }

        }

        //right
        if(direccion == 2) {
            System.out.println("aqui direccion " + direccion);
            //move
            if (mat[fany][fanx + 1] == 0 || mat[fany][fanx + 1] == 1) {
                Player.nivel.setAInfo(fanx,fany,Player.matAux[fany][fanx]);
                setX(fanx + 1);
            }
            //walls
            else if (mat[fany][fanx + 1] == 58 || mat[fany][fanx + 1] == 2) {
                direccion = random.nextInt(4);
            }

        }

        //left
        if(direccion == 3){
            System.out.println("aqui direccion " + direccion);
            //move
            if(mat[fany][fanx-1] == 0 || mat[fany][fanx-1] == 1) {
                Player.nivel.setAInfo(fanx,fany,Player.matAux[fany][fanx]);
                setX(fanx - 1);
            }
            //walls
            else if(mat[fany][fanx-1] == 58 || mat[fany][fanx-1] == 2){
                direccion = random.nextInt(4);
            }

        }
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
