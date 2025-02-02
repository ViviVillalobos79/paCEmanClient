package Sprites;

import javax.swing.*;
import java.util.Random;

public class Ghost extends Sprite{

    private String name;
    private Integer ghostColor;
    private Integer levelNum;
    private Timer timer;

    private Boolean comible = false;

    public Integer speed;

    Integer direccion;
    Integer mx;
    Integer my;

    Player player;



    public Random random = new Random();

    private ImageIcon ghost_blue, ghost_orange, ghost_red, ghost_pink, ghost_die;



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
            if(levelNum == 3) {
                this.setX(11);
            }
            else {
                this.setX(8);
            }
        }
        else if(name.equals("Blinky")){
            if(levelNum == 3) {
                this.setX(9);
            }
        }
        else if(name.equals("Pinky")){
            if (levelNum == 3) {
                this.setX(10);
            }
        }
        else if(name.equals("Inky")) {
            if(levelNum == 3) {
                this.setX(11);
            }
        }
        else {
            if(levelNum == 3) {
                this.setX(12);
            }
        }
        if(levelNum==3) {
            this.setY(14);
        }
        else {
            this.setY(10);
        }
    }

    /**
     * Resets to the first pos
     */
    public void resetPos(){
        setInitPosition();
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
            //move
            if(mat[fany-1][fanx] == 0 || mat[fany-1][fanx] == 1 || mat[fany-1][fanx] == 50 || mat[fany-1][fanx] == 5) {
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
            //move
            if(mat[fany+1][fanx] == 0 || mat[fany+1][fanx] == 1 || mat[fany+1][fanx] == 50|| mat[fany+1][fanx] == 5) {
                Player.nivel.setAInfo(fanx,fany,Player.matAux[fany][fanx]);
                setY(fany + 1);
            }
            //walls
            else if(mat[fany+1][fanx] == 58 || mat[fany+1][fanx] == 2 ){
                direccion = random.nextInt(4);
            }

        }

        //right
        if(direccion == 2) {
            //move
            if (mat[fany][fanx+1] == 0 || mat[fany][fanx+1] == 1 || mat[fany][fanx+1] == 50 || mat[fany][fanx+1] == 5) {
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
            //move
            if(mat[fany][fanx-1] == 0 || mat[fany][fanx-1] == 1 || mat[fany][fanx-1] == 50 || mat[fany][fanx-1] == 5) {
                Player.nivel.setAInfo(fanx,fany,Player.matAux[fany][fanx]);
                setX(fanx - 1);
            }
            //walls
            else if(mat[fany][fanx-1] == 58 || mat[fany][fanx-1] == 2){
                direccion = random.nextInt(4);
            }
        }


    }

    public void mover2(){

    }

    /**
     * Loads images for each ghost
     */
    private void loadImages() {
        ghost_blue = new ImageIcon("C:\\Users\\Dxnium\\OneDrive - Estudiantes ITCR\\TEC\\Lenguajes\\Tarea Corta 3\\paCEmanClient\\paCEmanClient\\src\\images\\ghost_blue.png");
        ghost_orange = new ImageIcon("C:\\Users\\Dxnium\\OneDrive - Estudiantes ITCR\\TEC\\Lenguajes\\Tarea Corta 3\\paCEmanClient\\paCEmanClient\\src\\images\\ghost_orange.png");
        ghost_pink = new ImageIcon("C:\\Users\\Dxnium\\OneDrive - Estudiantes ITCR\\TEC\\Lenguajes\\Tarea Corta 3\\paCEmanClient\\paCEmanClient\\src\\images\\ghost_pink.png");
        ghost_red = new ImageIcon("C:\\Users\\Dxnium\\OneDrive - Estudiantes ITCR\\TEC\\Lenguajes\\Tarea Corta 3\\paCEmanClient\\paCEmanClient\\src\\images\\ghost_red.png");
        ghost_die = new ImageIcon("C:\\Users\\Dxnium\\OneDrive - Estudiantes ITCR\\TEC\\Lenguajes\\Tarea Corta 3\\paCEmanClient\\paCEmanClient\\src\\images\\dieghost.png");

    }

    /**
     * Get image depending of the ghost
     * @return ImageIcon in regards of the ghost name
     */
    public ImageIcon getImageGhost(){
        if(comible){
            return ghost_die;
        }
        else if(name.equals("Clyde")){
            return ghost_orange;
        }
        else if(name.equals("Blinky")){
            return ghost_red;
        }
        else if(name.equals("Pinky")){
            return ghost_pink;
        }
        return ghost_blue;
    }

    public void setComible(Boolean comible) {
        this.comible = comible;
    }

    public Boolean getComible() {
        return comible;
    }
}
