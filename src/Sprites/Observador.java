package Sprites;

import Data.Constants;
import Data.Observerdata;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Observador extends JPanel {

    private static final Font smallFont = new Font("Helvetica", Font.BOLD, 20);

    private Integer levelNum;
    private Nivel nivel;
    private Pacman pacman;
    private ArrayList<Ghost> ghosts = new ArrayList<>();

    private String jugador;
    private Integer puntos;
    private JLabel nombre;
    private JLabel record;

    private JLabel[][] matriz;

    public Observador(){
        initVariables();
        drawMaze();
    }

    private void initVariables() {
        this.setLayout(null);
        this.setBounds(0, 0, Constants.WIDTH, Constants.HEIGHT);
        this.setVisible(true);

        this.setBackground(Color.BLACK);

        this.levelNum = 3;

        this.nivel = new Nivel(levelNum);

        this.pacman = new Pacman(1,1);
        this.pacman.setAbajo(0);
        this.pacman.setArriba(0);
        this.pacman.setDerecha(0);
        this.pacman.setIzquierda(0);

        this.matriz = new JLabel[31][26];

        for (Integer i = 0; i < 31; i++) {
            for (Integer j = 0; j < 26; j++) {
                this.matriz[i][j] = new JLabel();
            }
        }
        this.jugador = "Vivi";
        this.puntos = 0;

    }

    public void update(Observerdata observerdataupdate){
        nivel = observerdataupdate.nivel;
        levelNum = observerdataupdate.level;
        pacman = observerdataupdate.pacman;
        ghosts = observerdataupdate.ghosts;
        jugador = observerdataupdate.jugador;
        puntos = observerdataupdate.puntos;
        nombre = observerdataupdate.nombre;
        record = observerdataupdate.record;
        matriz = observerdataupdate.matriz;
        drawMaze();
    }


    /**
     * Draw the visual maze
     */
    public void drawMaze() {
        Integer[][] mat = nivel.getLeveldat();
        for (Integer i = 0; i < mat.length; i++) {
            for (Integer j = 0; j < mat[i].length; j++) {
                matriz[i][j].setIcon(new ImageIcon(
                        "C:\\Users\\Dxnium\\OneDrive - Estudiantes ITCR\\TEC\\Lenguajes\\Tarea Corta 3\\paCEmanClient\\paCEmanClient\\src\\images\\" + mat[i][j] + ".png"));
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

}
