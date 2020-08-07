package Sprites;

import Data.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Player extends JPanel implements ActionListener{

    private static final Font smallFont = new Font("Helvetica", Font.BOLD, 20);

    static Nivel nivel;
    private static Pacman pacman;

    private static Integer levelNum;

    private static JLabel[][] matriz;

    public static Integer[][] matAux;

    private final ArrayList<Ghost> ghosts = new ArrayList<>();

    private static String jugador;
    private static Integer puntos;
    private static JLabel nombre;
    private static JLabel record;

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

        levelNum = 3;

        nivel = new Nivel(levelNum);

        pacman = new Pacman(1,1);
        pacman.setAbajo(0);
        pacman.setArriba(0);
        pacman.setDerecha(0);
        pacman.setIzquierda(0);

        matriz = new JLabel[31][26];

        matAux = new Integer[][]{
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, //1
                {2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2}, //2
                {2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2}, //3
                {2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2}, //4
                {2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2}, //5
                {2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2}, //6
                {2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2}, //7
                {2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2}, //8
                {2, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 2}, //9
                {2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2}, //10
                {2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2}, //11
                {2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2}, //12
                {2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2}, //13
                {2, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 0, 0, 0, 0, 0, 2}, //16
                {2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 0, 0, 0, 0, 0, 0, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2}, //19
                {2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2}, //20
                {2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2}, //21
                {2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2}, //22
                {2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2}, //23
                {2, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 2}, //24
                {2, 2, 2, 1, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 2, 1, 2, 2, 2}, //25
                {2, 2, 2, 1, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 2, 1, 2, 2, 2}, //26
                {2, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2}, //27
                {2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2}, //28
                {2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2}, //29
                {2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2}, //30
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}  //31
        };
        for (Integer i = 0; i < 31; i++) {
            for (Integer j = 0; j < 26; j++) {
                matriz[i][j] = new JLabel();
            }
        }
        jugador = "Vivi";
        puntos = 0;

    }

    /**
     * Draw the visual maze
     */
    public void drawMaze() {
        Integer[][] mat = nivel.getLeveldat();
        for (Integer i = 0; i < mat.length; i++) {
            for (Integer j = 0; j < mat[i].length; j++) {
                matriz[i][j].setIcon(new ImageIcon(
                        "src\\images\\" + mat[i][j] + ".png"));
                matriz[i][j].setBounds(10 + (j * 25), 10 + (i * 25), 25, 25);
                matriz[i][j].setVisible(true);
                this.add(matriz[i][j], 0);
            }
        }
        drawPacMan();
        drawGhost();
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
                        if (mat[py][px + 1] == 1 || mat[py][px + 1] == 0) {
                            pacman.setArriba(0);
                            pacman.setAbajo(0);
                            pacman.setDerecha(1);
                            pacman.setIzquierda(0);
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        if (mat[py][px - 1] == 1 || mat[py][px - 1] == 0) {
                            pacman.setArriba(0);
                            pacman.setAbajo(0);
                            pacman.setDerecha(0);
                            pacman.setIzquierda(1);
                        }
                        break;
                    case KeyEvent.VK_UP:
                        if (mat[py - 1][px] == 1 || mat[py - 1][px] == 0) {
                            pacman.setArriba(1);
                            pacman.setAbajo(0);
                            pacman.setDerecha(0);
                            pacman.setIzquierda(0);
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if (mat[py + 1][px] == 1 || mat[py + 1][px] == 0) {
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
        if(pacman.getArriba() == 1 && (mat[py-1][px] == 1 || mat[py-1][px] == 0)){
            if(mat[py-1][px] == 1 ){
                puntos = puntos + 5;
                record.setText("Puntos: "+ puntos);
            }
            nivel.setAInfo(px,py,0);
            matAux[py][px] = 0;
            pacman.setY(py-1);
            drawMaze();
        }
        if(pacman.getAbajo() == 1 && (mat[py+1][px] == 1 || mat[py+1][px] == 0)){
            if(mat[py+1][px] == 1 ){
                puntos = puntos+ 5;
                record.setText("Puntos: "+ puntos);
            }
            nivel.setAInfo(px,py,0);
            matAux[py][px] = 0;
            pacman.setY(py+1);
            drawMaze();
        }
        if(pacman.getDerecha() == 1 && (mat[py][px+1] == 1 || mat[py][px+1] == 0)){
            if(mat[py][px+1] == 1 ){
                puntos = puntos+ 5;
                record.setText("Puntos: "+ puntos);
            }

            nivel.setAInfo(px,py,0);
            matAux[py][px] = 0;
            pacman.setX(px+1);
            drawMaze();
        }
        if(pacman.getIzquierda() == 1 && (mat[py][px-1] == 1 || mat[py][px-1] == 0)){
            if(mat[py][px-1] == 1 ){
                puntos = puntos+ 5;
                record.setText("Puntos: "+ puntos);
            }
            nivel.setAInfo(px,py,0);
            matAux[py][px] = 0;
            pacman.setX(px-1);
            drawMaze();
        }
    }

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
            timer.stop();
        }
        drawMaze();
    }

    /**
     * Tells you that ypu win
     */
    private void win() {
        JOptionPane.showMessageDialog(this, "GANASTE!!!!");
        this.setVisible(false);
    }

    public Nivel getNivel() {
        return nivel;
    }

    public Pacman getPacman() {
        return pacman;
    }

    public ArrayList<Ghost> getGhosts() {
        return ghosts;
    }
}