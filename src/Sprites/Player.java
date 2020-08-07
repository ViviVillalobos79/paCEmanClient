package Sprites;

import Data.Constants;
import GUI.ObserverWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Player extends JPanel implements ActionListener{

    private static final Font smallFont = new Font("Helvetica", Font.BOLD, 20);

    public static Nivel nivel;
    private static Pacman pacman;

    private static Integer levelNum;

    private static JLabel[][] matriz;

    public static Integer[][] matAux;

    private final ArrayList<Ghost> ghosts = new ArrayList<>();

    private Manage fruits;
    private Pills pills;

    public String jugador;
    public Integer puntos;
    public Integer pastTiempo;
    public Integer lifes;
    public JLabel nombre;
    public JLabel record;
    public JLabel pasTiempo;
    public JLabel vida;

    ObserverWindow observerWindow;

    private static Timer timer;

    /**
     * Constructor
     * Makes that everything starts
     */
    public Player() {
        initVariables();
        drawMaze();
        drawScore();
        configurePanel();
        mover();
    }

    public static void setTimer(Timer timer) {
        Player.timer = timer;
    }

    /**
     * Initiate all needes variables for the game
     */
    private void initVariables() {
        this.setLayout(null);
        this.setBounds(0, 0, Constants.WIDTH, Constants.HEIGHT);
        this.setVisible(true);

        this.setBackground(Color.BLACK);

        fruits = new Manage();
        pills = new Pills();

        levelNum = Constants.levelNum;

        nivel = new Nivel(levelNum);

        pacman = new Pacman(1,1);
        pacman.setAbajo(0);
        pacman.setArriba(0);
        pacman.setDerecha(0);
        pacman.setIzquierda(0);

        matriz = new JLabel[31][26];

        matAux = Constants.getMat1(levelNum);
        for (Integer i = 0; i < 31; i++) {
            for (Integer j = 0; j < 26; j++) {
                matriz[i][j] = new JLabel();
            }
        }
        jugador = "Vivi";
        puntos = 0;
        pastTiempo = 0;
        lifes = 3;
        //observerWindow = new ObserverWindow();
        //observerWindow.setVisible(true);
        //updateObserver();
    }

    /**
     * Prepares everything for a new level
     */
    private void newLevel(){

        Constants.levelNum = levelNum + 1;
        if(Constants.levelNum <= 3){
            this.removeAll();
            initVariables();
            ghosts.clear();
        }
    }

    private void reset(){
        Integer[][] mat = nivel.getLeveldat();
        mat[pacman.getY()][pacman.getX()] = 0;
        pacman.resetPos();
        for(Ghost ghost: ghosts){
            mat[ghost.getY()][ghost.getX()] = 0;
            ghost.resetPos();
        }
        drawMaze();
    }

    /**
     * Draw the visual maze
     */
    public void drawMaze() {
        Integer[][] mat = nivel.getLeveldat();
        for (Integer i = 0; i < mat.length; i++) {
            for (Integer j = 0; j < mat[i].length; j++) {
                if(mat[i][j] == 1 || mat[i][j] == 0 || mat[i][j] == 2) {
                    matriz[i][j].setIcon(new ImageIcon(
                            "C:\\Users\\Dxnium\\OneDrive - Estudiantes ITCR\\TEC\\Lenguajes\\Tarea Corta 3\\paCEmanClient\\paCEmanClient\\src\\images\\" + mat[i][j] + ".png"));
                    matriz[i][j].setBounds(10 + (j * 25), 10 + (i * 25), 25, 25);
                    matriz[i][j].setVisible(true);
                    this.add(matriz[i][j], 0);
                }
            }
        }
        drawPacMan();
        drawFruits();
        drawPills();
        drawGhost();

        //updateObserver();
    }

    /**
     * Draw Pacman according to the direction is taking
     */
    public void drawPacMan(){
        Integer pacX = pacman.getX();
        Integer pacY = pacman.getY();

        nivel.setAInfo(pacX,pacY,3);

        matriz[pacY][pacX].setIcon(pacman.getImageAnim());
        matriz[pacY][pacX].setBounds(10 + (pacX * 25), 10 + (pacY * 25), 25, 25);
        matriz[pacY][pacX].setVisible(true);
        this.add(matriz[pacY][pacX], 0);
    }

    /**
     * Draw ghost according to the position
     */
    public void drawGhost(){
        for (Ghost ghost: ghosts){
            Integer fanx = ghost.getX();
            Integer fany = ghost.getY();

            nivel.setAInfo(fanx,fany,58);
            matriz[fany][fanx].setIcon(ghost.getImageGhost());
            matriz[fany][fanx].setBounds(10 + (fanx * 25), 10 + (fany * 25), 25, 25);
            matriz[fany][fanx].setVisible(true);
            this.add(matriz[fany][fanx],0);
        }
    }

    /**
     * Draw the fruits according to the position
     */
    public void drawFruits(){
        ArrayList<Sprite> sprites = fruits.getSprites();
        for (Sprite sprite : sprites) {
            Integer fx = sprite.getX();
            Integer fy = sprite.getY();

            nivel.setAInfo(fx, fy, 50);
            matriz[fy][fx].setIcon(sprite.getImage());
            matriz[fy][fx].setBounds(10 + (fx * 25), 10 + (fy * 25), 25, 25);
            matriz[fy][fx].setVisible(true);
            this.add(matriz[fy][fx], 0);
        }
    }

    /**
     * Draw pills in the correct position
     */
    public void drawPills(){
        ArrayList<Pill> pills1 = pills.getPills();
        for(Pill pill: pills1){
            Integer px = pill.getX();
            Integer py = pill.getY();
            Integer size = pill.getSize();

            nivel.setAInfo(px, py, 5);
            matriz[py][px].setIcon(new ImageIcon(
                    "C:\\Users\\Dxnium\\OneDrive - Estudiantes ITCR\\TEC\\Lenguajes\\Tarea Corta 3\\paCEmanClient\\paCEmanClient\\src\\images\\50.png"));
            matriz[py][px].setBounds(10 + (px * 25), 10 + (py * 25), 25, 25);
            matriz[py][px].setVisible(true);
            this.add(matriz[py][px], 0);
        }
    }

    /**
     * Draw player's name and score
     */
    public void drawScore(){
        nombre = new JLabel("JUGADOR: "+ jugador);
        nombre.setBounds(700,20,200,30);
        nombre.setFont(smallFont);
        nombre.setForeground(Color.white);
        nombre.setVisible(true);
        this.add(nombre,0);

        record = new JLabel("Puntos: "+ puntos);
        record.setBounds(700,60,200,30);
        record.setFont(smallFont);
        record.setForeground(Color.white);
        record.setVisible(true);
        this.add(record,0);

        pasTiempo = new JLabel("Tiempo pastilla: "+ pastTiempo);
        pasTiempo.setBounds(700,100,200,30);
        pasTiempo.setFont(smallFont);
        pasTiempo.setForeground(Color.white);
        pasTiempo.setVisible(true);
        this.add(pasTiempo,0);

        vida = new JLabel("Vidas: "+ lifes);
        vida.setBounds(700,140,200,30);
        vida.setFont(smallFont);
        vida.setForeground(Color.white);
        vida.setVisible(true);
        this.add(vida,0);

    }

    /**
     * Sets up the Timer
     */
    private void configurePanel() {
        Timer timer = new Timer(40, this);
        timer.start();

        this.setFocusable(true);
        this.setBackground(Color.black);
    }

    /**
     * Sets up the KeyListener
     */
    public void mover() {

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                Integer key = e.getKeyCode();
                Integer[][] mat = nivel.getLeveldat();
                Integer py = pacman.getY();
                Integer px = pacman.getX();
                switch (key) {
                    case KeyEvent.VK_RIGHT:
                        if (mat[py][px + 1] !=2) {
                            pacman.setArriba(0);
                            pacman.setAbajo(0);
                            pacman.setDerecha(1);
                            pacman.setIzquierda(0);
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        if (mat[py][px - 1] != 2) {
                            pacman.setArriba(0);
                            pacman.setAbajo(0);
                            pacman.setDerecha(0);
                            pacman.setIzquierda(1);
                        }
                        break;
                    case KeyEvent.VK_UP:
                        if (mat[py - 1][px] != 2) {
                            pacman.setArriba(1);
                            pacman.setAbajo(0);
                            pacman.setDerecha(0);
                            pacman.setIzquierda(0);
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if (mat[py + 1][px] != 2) {
                            pacman.setArriba(0);
                            pacman.setAbajo(1);
                            pacman.setDerecha(0);
                            pacman.setIzquierda(0);
                        }
                }
            }
        });

    }

    /**
     * Decide if pacman can move to an exact point
     * @param mat matrix level
     */
    public void movePacman(Integer[][] mat){
        Integer py = pacman.getY();
        Integer px = pacman.getX();
        if(pacman.getArriba() == 1 && mat[py-1][px] !=2){
            if(mat[py-1][px] == 1 ){
                puntos = puntos + 5;
                record.setText("Puntos: "+ puntos);
            }
            if(mat[py-1][px] == 50){
                Fruit fruit = (Fruit) fruits.get(px,py-1);
                puntos = puntos + fruit.getPoints();
                record.setText("Puntos: "+ puntos);
                fruits.remove(px,py-1);
            }
            if(mat[py-1][px] == 5){
                puntos = puntos + 150;
                record.setText("Puntos: "+ puntos);
                pills.removePill(px,py-1);
                pills.setActive(true);
                System.out.println(pills.isActive());
                for(Ghost ghost: ghosts){
                    ghost.setComible(true);
                }
            }
            if(mat[py-1][px] == 58){
                System.out.println("va a haber un fantasma");
                Ghost ghost = null;
                for(Ghost ghost1: ghosts){
                    if(ghost1.getX() == px && ghost1.getY() == (py-1)){
                        ghost = ghost1;
                        break;
                    }
                                    }
                assert ghost != null;
                System.out.println("comible " + ghost.getComible());
                if(ghost.getComible()){
                    puntos = puntos + 200;
                    record.setText("Puntos: "+ puntos);
                    ghosts.remove(ghost);
                }
                else {
                    die();
                }
            }
            nivel.setAInfo(px,py,0);
            matAux[py][px] = 0;
            pacman.setY(py-1);
            drawMaze();
        }
        if(pacman.getAbajo() == 1 && mat[py+1][px] !=2){
            if(mat[py+1][px] == 1 ){
                puntos = puntos+ 5;
                record.setText("Puntos: "+ puntos);
            }
            if(mat[py+1][px] == 50){
                Fruit fruit = (Fruit) fruits.get(px,py+1);
                puntos = puntos + fruit.getPoints();
                record.setText("Puntos: "+ puntos);
                fruits.remove(px,py+1);
            }
            if(mat[py+1][px] == 5){
                puntos = puntos + 150;
                record.setText("Puntos: "+ puntos);
                pills.removePill(px,py+1);
                pills.setActive(true);
                System.out.println(pills.isActive());
                for(Ghost ghost: ghosts){
                    ghost.setComible(true);
                }
            }
            if(mat[py+1][px] == 58) {
                Ghost ghost = null;
                for (Ghost ghost1 : ghosts) {
                    if (ghost1.getX() == px && ghost1.getY() == (py + 1)) {
                        ghost = ghost1;
                        break;
                    }
                }
                assert ghost != null;
                if (ghost.getComible()) {
                    puntos = puntos + 200;
                    record.setText("Puntos: " + puntos);
                    ghosts.remove(ghost);
                } else {
                    die();
                }
            }
                nivel.setAInfo(px, py, 0);
                matAux[py][px] = 0;
                pacman.setY(py + 1);
                drawMaze();

        }
        if(pacman.getDerecha() == 1 && mat[py][px+1]!= 2){
            if(mat[py][px+1] == 1 ){
                puntos = puntos+ 5;
                record.setText("Puntos: "+ puntos);
            }
            if(mat[py][px+1] == 50){
                Fruit fruit = (Fruit) fruits.get(px+1,py);
                puntos = puntos + fruit.getPoints();
                record.setText("Puntos: "+ puntos);
                fruits.remove(px+1,py);
            }
            if(mat[py][px+1] == 5){
                puntos = puntos + 150;
                record.setText("Puntos: "+ puntos);
                pills.removePill(px+1,py);
                pills.setActive(true);
                System.out.println(pills.isActive());
                for(Ghost ghost: ghosts){
                    ghost.setComible(true);
                }
            }
            if(mat[py][px+1] == 58) {
                Ghost ghost = null;
                for (Ghost ghost1 : ghosts) {
                    if (ghost1.getX() == (px+1) && ghost1.getY() == py) {
                        ghost = ghost1;
                        break;
                    }
                }
                assert ghost != null;
                if (ghost.getComible()) {
                    puntos = puntos + 200;
                    record.setText("Puntos: " + puntos);
                    ghosts.remove(ghost);
                } else {
                    die();
                }
            }

            nivel.setAInfo(px,py,0);
            matAux[py][px] = 0;
            pacman.setX(px+1);
            drawMaze();
        }
        if(pacman.getIzquierda() == 1 && mat[py][px-1] != 2){
            if(mat[py][px-1] == 1 ){
                puntos = puntos+ 5;
                record.setText("Puntos: "+ puntos);
            }
            if(mat[py][px-1] == 50){
                Fruit fruit = (Fruit) fruits.get(px-1,py);
                puntos = puntos + fruit.getPoints();
                record.setText("Puntos: "+ puntos);
                fruits.remove(px-1,py);
            }
            if(mat[py][px-1] == 5){
                puntos = puntos + 150;
                record.setText("Puntos: "+ puntos);
                pills.removePill(px-1,py);
                pills.setActive(true);
                System.out.println(pills.isActive());
                for(Ghost ghost: ghosts){
                    ghost.setComible(true);
                }
            }
            if(mat[py][px-1]  == 58) {
                Ghost ghost = null;
                for (Ghost ghost1 : ghosts) {
                    if (ghost1.getX() == (px-1) && ghost1.getY() == py) {
                        ghost = ghost1;
                        break;
                    }
                }
                assert ghost != null;
                if (ghost.getComible()) {
                    puntos = puntos + 200;
                    record.setText("Puntos: " + puntos);
                    ghosts.remove(ghost);
                } else {
                    die();
                }
            }
            nivel.setAInfo(px,py,0);
            matAux[py][px] = 0;
            pacman.setX(px-1);
            drawMaze();
        }
    }

    /**
     * Moves each ghost
     * @param mat matrix level
     */
    public void moveGhosts(Integer[][] mat){
        for (Ghost ghost: ghosts) {
            ghost.mover();
        }
    }

    /**
     * Changes pacman position
     * @param e Event that is done
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Integer[][] mat = nivel.getLeveldat();
        movePacman(mat);
        moveGhosts(mat);
        pastTiempo = pills.getPillTime();
        pasTiempo.setText("Tiempo pastilla: "+ pastTiempo);
        if(pills.isActive()){

            if(pills.pillTimer() == 0){

                for(Ghost ghost: ghosts){
                    ghost.setComible(false);
                }
            }

        }

        Integer enc = 0;
        for (Integer i = 0; i < mat.length && enc == 0; i++) {
            for (Integer j = 0; j < mat[i].length && enc == 0; j++) {
                if(mat[i][j] == 1){
                    enc = 1;
                }
            }
        }
        if(enc == 0){
            win();
            if(levelNum == 3) {
                System.exit(0);
                timer.stop();

            }
        }
        if(ghosts.size()>0) {
            if (!ghosts.get(0).getComible()) {
                if (mat[pacman.getY()][pacman.getX() + 1] == 58 || mat[pacman.getY()][pacman.getX() - 1] == 58 ||
                        mat[pacman.getY() - 1][pacman.getX()] == 58 || mat[pacman.getY() + 1][pacman.getX()] == 58) {

                    die();
                    if(lifes == 0) {
                        System.exit(0);
                        timer.stop();

                    }
                }
            }
        }

        drawMaze();
    }

    /**
     * Tells you that ypu win
     */
    private void win() {
        JOptionPane.showMessageDialog(this, "GANASTE!!!!");
        if(levelNum <3){
            newLevel();
        }
        else {
            this.setVisible(false);
            System.exit(0);
        }
    }

    /**
     * Tells you when you die
     */
    private void die() {

        if(lifes > 0){
            lifes = lifes - 1;
            vida.setText("Vidas: "+ lifes);
        }
        if(lifes == 0){
            JOptionPane.showMessageDialog(this, "PERDISTE!!!!");
            this.setVisible(false);
        }
        if(lifes > 0){
            reset();
        }


    }

    public Nivel getNivel() {
        return nivel;
    }

   /* public Pacman getPacman() {
        return pacman;
    }
    */

    public ArrayList<Ghost> getGhosts() {
        return ghosts;
    }

   /* public void updateObserver(){
        Observerdata observerdata = new Observerdata();

        observerdata.nivel = this.getNivel();
        observerdata.level = nivel.getLevelNumber();
        observerdata.pacman = this.getPacman();
        observerdata.ghosts = this.ghosts;
        observerdata.jugador = this.jugador;
        observerdata.puntos = this.puntos;
        observerdata.nombre = this.nombre;
        observerdata.record = this.record;
        observerdata.matriz = this.matriz;

        observerWindow.observador.update(observerdata);

    }

    */

    public Manage getFruits() {
        return fruits;
    }

    /*
    public void setFruits(Manage fruits) {
        this.fruits = fruits;
    }
     */

    public Pills getPills() {
        return pills;
    }

    /*
    public void setPills(Pills pills) {
        this.pills = pills;
    }
    */

}