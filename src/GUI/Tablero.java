package GUI;

import juego.Fantasmas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tablero {

    private static int px;
    private static int py;

    private static int reqdx, reqdy;

    private static boolean ingame;
    private static boolean start;
    private static final Font smallFont = new Font("Helvetica", Font.BOLD, 20);

    private static  JLabel _pacMan;
    private final ImageIcon[] _pacman = {
            new ImageIcon("C:\\Users\\Dxnium\\OneDrive - Estudiantes ITCR\\TEC\\Lenguajes\\Tarea Corta 3\\paCEmanClient\\paCEmanClient\\src\\images\\PACMAN-SPRITE-1.png"),
            new ImageIcon("C:\\Users\\Dxnium\\OneDrive - Estudiantes ITCR\\TEC\\Lenguajes\\Tarea Corta 3\\paCEmanClient\\paCEmanClient\\src\\images\\PACMAN-SPRITE-2.png"),
            new ImageIcon("C:\\Users\\Dxnium\\OneDrive - Estudiantes ITCR\\TEC\\Lenguajes\\Tarea Corta 3\\paCEmanClient\\paCEmanClient\\src\\images\\PACMAN-SPRITE-3.png"),
            new ImageIcon("C:\\Users\\Dxnium\\OneDrive - Estudiantes ITCR\\TEC\\Lenguajes\\Tarea Corta 3\\paCEmanClient\\paCEmanClient\\src\\images\\PACMAN-SPRITE-4.png"),
    };

    private Image ghost;
    private Image pacman1, pacman2up, pacman2left, pacman2right, pacman2down;
    private Image pacman3up, pacman3down, pacman3left, pacman3right;
    private Image pacman4up, pacman4down, pacman4left, pacman4right;

    private static String jugador;
    private static JPanel paneljuego;
    private static JLabel fondoJuego;
    private static ImageIcon imagenFondoJuego;

    private static JLabel[][] matriz;
    private static int puntos;
    private static JLabel nombre;
    private static JLabel record;
    public static int[][] mat;
    private static int level;
    private static int abajo;
    private static int arriba;
    private static int izquierda;
    private static int derecha;
    private static Timer timer;

    private static JFrame ventana;
    private static JPanel menu;
    private static int[][] aux = {
            {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}, //1
            {2,1,1,1,1,1,1,1,1,1,1,1,2,2,1,1,1,1,1,1,1,1,1,1,1,2}, //2
            {2,1,2,2,2,2,1,2,2,2,2,1,2,2,1,2,2,2,2,1,2,2,2,2,1,2}, //3
            {2,1,2,2,2,2,1,2,2,2,2,1,2,2,1,2,2,2,2,1,2,2,2,2,1,2}, //4
            {2,1,2,2,2,2,1,2,2,2,2,1,2,2,1,2,2,2,2,1,2,2,2,2,1,2}, //5
            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}, //6
            {2,1,2,2,2,2,1,2,2,1,2,2,2,2,2,2,1,2,2,1,2,2,2,2,1,2}, //7
            {2,1,2,2,2,2,1,2,2,1,2,2,2,2,2,2,1,2,2,1,2,2,2,2,1,2}, //8
            {2,1,1,1,1,1,1,2,2,1,1,1,2,2,1,1,1,2,2,1,1,1,1,1,1,2}, //9
            {2,2,2,2,2,2,1,2,2,2,2,1,2,2,1,2,2,2,2,1,2,2,2,2,2,2}, //10
            {2,2,2,2,2,2,1,2,2,2,2,1,2,2,1,2,2,2,2,1,2,2,2,2,2,2}, //11
            {2,2,2,2,2,2,1,2,2,1,1,1,1,1,1,1,1,2,2,1,2,2,2,2,2,2}, //12
            {2,2,2,2,2,2,1,2,2,1,1,1,1,1,1,1,1,2,2,1,2,2,2,2,2,2}, //13
            {0,0,0,0,0,0,1,1,1,1,2,2,2,2,2,2,1,1,1,1,0,0,0,0,0,0}, //16
            {2,2,2,2,2,2,1,2,2,1,0,0,0,0,0,0,1,2,2,1,2,2,2,2,2,2}, //19
            {2,2,2,2,2,2,1,2,2,1,2,2,2,2,2,2,1,2,2,1,2,2,2,2,2,2}, //20
            {2,1,1,1,1,1,1,1,1,1,1,1,2,2,1,1,1,1,1,1,1,1,1,1,1,2}, //21
            {2,1,2,2,2,2,1,2,2,2,2,1,2,2,1,2,2,2,2,1,2,2,2,2,1,2}, //22
            {2,1,2,2,2,2,1,2,2,2,2,1,2,2,1,2,2,2,2,1,2,2,2,2,1,2}, //23
            {2,1,1,1,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,1,1,1,2}, //24
            {2,2,2,1,2,2,1,1,1,1,2,2,2,2,2,2,2,1,2,1,2,2,1,2,2,2}, //25
            {2,2,2,1,2,2,1,1,1,1,2,2,2,2,2,2,2,1,2,1,2,2,1,2,2,2}, //26
            {2,1,1,1,1,1,1,2,2,1,1,1,1,2,2,1,1,1,2,1,1,1,1,1,1,2}, //27
            {2,1,2,2,2,2,2,2,2,2,2,2,1,2,2,1,2,2,2,2,2,2,2,2,1,2}, //28
            {2,1,2,2,2,2,2,2,2,2,2,2,1,2,2,1,2,2,2,2,2,2,2,2,1,2}, //29
            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}, //30
            {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}  //31
    };

    Fantasmas Blinky;
    Fantasmas Pinky;
    Fantasmas Inky;
    Fantasmas Clyde;


    public Tablero(){
    }

    public void jugar(JFrame ventanas, JPanel menus){

        ventana = ventanas;
        menu = menus;

        loadImages();
        initVariables();

        //drawMaze();
        pintarMatriz();
        mover();

    }

    public static int[][] nivel(){
        int[][] aux = new int[0][];
        if(level == 1){
            aux = new int[][] {
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                    {2,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,2},
                    {2,1,2,2,1,2,2,2,1,2,1,2,2,2,1,2,2,1,2},
                    {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
                    {2,1,2,1,1,2,1,2,2,2,2,2,1,2,1,2,2,1,2},
                    {2,1,1,1,1,2,1,1,1,2,1,1,1,2,1,1,1,1,2},
                    {2,2,1,2,1,2,2,2,1,2,1,2,2,2,1,2,1,2,2},
                    {2,2,1,1,2,1,2,1,1,1,1,1,1,1,2,1,2,1,2},
                    {2,1,2,2,1,2,1,2,2,2,2,2,1,2,1,2,2,1,2},
                    {2,1,2,2,1,1,1,2,0,0,0,2,1,1,1,2,2,1,2},
                    {2,1,2,2,1,2,1,2,2,2,2,2,1,2,1,2,2,1,2},
                    {2,1,1,1,1,2,1,1,1,1,1,1,1,2,1,1,1,1,2},
                    {2,2,2,2,1,2,1,2,2,2,2,2,1,2,1,2,2,2,2},
                    {2,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,2},
                    {2,1,2,2,1,2,2,2,1,2,1,2,2,2,1,2,2,1,2},
                    {2,1,1,2,1,1,1,1,1,1,1,1,1,1,1,2,1,1,2},
                    {2,2,1,2,1,2,1,2,2,2,2,2,1,2,1,2,1,2,2},
                    {2,1,1,1,1,2,1,1,1,2,1,1,1,2,1,1,1,1,2},
                    {2,1,2,2,2,2,2,2,1,2,1,2,2,2,2,2,2,1,2},
                    {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}
            };
        }
        if(level == 2){
            aux = new int[][] {
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                    {2,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,2},
                    {2,1,2,2,1,2,2,2,1,2,1,2,2,2,1,2,2,1,2},
                    {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
                    {2,1,2,2,1,2,1,2,2,2,2,2,1,2,1,2,2,1,2},
                    {2,1,1,1,1,2,1,1,1,2,1,1,1,2,1,1,1,1,2},
                    {2,2,1,1,1,2,2,2,1,2,1,2,2,2,1,2,1,2,2},
                    {2,2,1,1,1,2,2,1,1,1,1,1,1,1,2,1,2,1,2},
                    {2,1,2,2,1,2,1,2,2,2,2,2,1,2,1,2,2,1,2},
                    {2,1,2,2,1,1,1,2,0,0,0,2,1,1,1,2,2,1,2},
                    {2,1,2,2,1,2,1,2,2,1,1,2,1,1,1,2,2,1,2},
                    {2,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,2},
                    {2,2,2,2,1,2,1,2,2,2,2,2,1,2,1,2,2,2,2},
                    {2,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,2},
                    {2,1,2,2,1,2,2,2,1,2,1,2,2,2,1,2,2,1,2},
                    {2,1,1,2,1,1,1,1,1,1,1,1,1,1,1,2,1,1,2},
                    {2,2,1,2,1,2,1,2,2,2,2,2,1,2,1,2,1,2,2},
                    {2,1,1,1,1,2,1,1,1,2,1,1,1,2,1,1,1,1,2},
                    {2,1,2,2,2,2,2,2,1,2,1,2,2,2,2,2,2,1,2},
                    {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}
            };
        }
        if (level == 3){
            aux = new int[][]{
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
                    {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0}, //16
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
        }
        
        return aux;
    }

    private static void initVariables() {
        paneljuego = new JPanel();
        paneljuego.setLayout(null);
        paneljuego.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
        paneljuego.setVisible(true);

        paneljuego.setBackground(Color.BLACK);

        ventana.add(paneljuego);
        level = 3;
        mat = new int[26][31];
        matriz = new JLabel[31][26];
        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < 26; j++) {
                matriz[i][j] = new JLabel();
            }
        }
        level = 2;
        mat = nivel();
        px = 1;
        py = 1;
        mat[py][px] = 3;
        abajo = 0;
        arriba = 0;
        derecha = 0;
        izquierda = 0;
        ingame = true;
        start = true;
        reqdx = 0;
        reqdy = 0;
        puntos = 0;
        nombre = new JLabel("JUGADOR: "+ jugador);
        nombre.setBounds(700,20,200,30);
        nombre.setFont(smallFont);
        nombre.setForeground(Color.white);
        nombre.setVisible(true);
        paneljuego.add(nombre,0);

        record = new JLabel("Puntos: "+ puntos);
        record.setBounds(700,60,200,30);
        record.setFont(smallFont);
        record.setForeground(Color.white);
        record.setVisible(true);
        paneljuego.add(record,0);

    }

    private void loadImages() {

        ghost = new ImageIcon(getClass().getResource("C:\\Users\\Dxnium\\OneDrive - Estudiantes ITCR\\TEC\\Lenguajes\\Tarea Corta 3\\paCEmanClient\\paCEmanClient\\src\\images\\ghost.gif")).getImage();
        pacman1 = new ImageIcon(getClass().getResource("C:\\Users\\Dxnium\\OneDrive - Estudiantes ITCR\\TEC\\Lenguajes\\Tarea Corta 3\\paCEmanClient\\paCEmanClient\\src\\images\\pacman.gif")).getImage();
        pacman2up = new ImageIcon(getClass().getResource("C:\\Users\\Dxnium\\OneDrive - Estudiantes ITCR\\TEC\\Lenguajes\\Tarea Corta 3\\paCEmanClient\\paCEmanClient\\src\\images\\up1.gif")).getImage();
        pacman3up = new ImageIcon(getClass().getResource("C:\\Users\\Dxnium\\OneDrive - Estudiantes ITCR\\TEC\\Lenguajes\\Tarea Corta 3\\paCEmanClient\\paCEmanClient\\src\\images\\up2.gif")).getImage();
        pacman4up = new ImageIcon(getClass().getResource("C:\\Users\\Dxnium\\OneDrive - Estudiantes ITCR\\TEC\\Lenguajes\\Tarea Corta 3\\paCEmanClient\\paCEmanClient\\src\\images\\up3.gif")).getImage();
        pacman2down = new ImageIcon(getClass().getResource("C:\\Users\\Dxnium\\OneDrive - Estudiantes ITCR\\TEC\\Lenguajes\\Tarea Corta 3\\paCEmanClient\\paCEmanClient\\src\\images\\down1.gif")).getImage();
        pacman3down = new ImageIcon(getClass().getResource("C:\\Users\\Dxnium\\OneDrive - Estudiantes ITCR\\TEC\\Lenguajes\\Tarea Corta 3\\paCEmanClient\\paCEmanClient\\src\\images\\down2.gif")).getImage();
        pacman4down = new ImageIcon(getClass().getResource("C:\\Users\\Dxnium\\OneDrive - Estudiantes ITCR\\TEC\\Lenguajes\\Tarea Corta 3\\paCEmanClient\\paCEmanClient\\src\\images\\down3.gif")).getImage();
        pacman2left = new ImageIcon(getClass().getResource("C:\\Users\\Dxnium\\OneDrive - Estudiantes ITCR\\TEC\\Lenguajes\\Tarea Corta 3\\paCEmanClient\\paCEmanClient\\src\\images\\left1.gif")).getImage();
        pacman3left = new ImageIcon(getClass().getResource("C:\\Users\\Dxnium\\OneDrive - Estudiantes ITCR\\TEC\\Lenguajes\\Tarea Corta 3\\paCEmanClient\\paCEmanClient\\src\\images\\left2.gif")).getImage();
        pacman4left = new ImageIcon(getClass().getResource("C:\\Users\\Dxnium\\OneDrive - Estudiantes ITCR\\TEC\\Lenguajes\\Tarea Corta 3\\paCEmanClient\\paCEmanClient\\src\\images\\left3.gif")).getImage();
        pacman2right = new ImageIcon(getClass().getResource("C:\\Users\\Dxnium\\OneDrive - Estudiantes ITCR\\TEC\\Lenguajes\\Tarea Corta 3\\paCEmanClient\\paCEmanClient\\src\\images\\right1.gif")).getImage();
        pacman3right = new ImageIcon(getClass().getResource("C:\\Users\\Dxnium\\OneDrive - Estudiantes ITCR\\TEC\\Lenguajes\\Tarea Corta 3\\paCEmanClient\\paCEmanClient\\src\\images\\right2.gif")).getImage();
        pacman4right = new ImageIcon(getClass().getResource("C:\\Users\\Dxnium\\OneDrive - Estudiantes ITCR\\TEC\\Lenguajes\\Tarea Corta 3\\paCEmanClient\\paCEmanClient\\src\\images\\right3.gif")).getImage();
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public void pintarMatriz() {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                matriz[i][j].setIcon(new ImageIcon(
                        "\\src\\images\\"+mat[i][j]+".png"));

                matriz[i][j].setBounds(10+(j*25),10+(i*25),25,25);
                matriz[i][j].setVisible(true);
                paneljuego.add(matriz[i][j],0);
            }
        }
    }




    public void mover(){

        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(arriba == 1 && (mat[py-1][px] == 1 || mat[py-1][px] == 0)){
                    if(mat[py-1][px] == 1 ){
                        puntos = puntos + 5;
                        record.setText("Puntos: "+ puntos);
                    }
                    mat[py][px] = 0;
                    py = py-1;
                    mat[py][px] = 3;
                    pintarMatriz();

                }
                if(abajo == 1 && (mat[py+1][px] == 1 || mat[py+1][px] == 0)){
                    if(mat[py+1][px] == 1 ){
                        puntos = puntos+ 5;
                        record.setText("Puntos: "+ puntos);
                    }
                    mat[py][px] = 0;
                    py = py+1;
                    mat[py][px] = 3;
                    pintarMatriz();
                }
                if(derecha == 1 && (mat[py][px+1] == 1 || mat[py][px+1] == 0)){
                    if(mat[py][px+1] == 1 ){
                        puntos = puntos+ 5;
                        record.setText("Puntos: "+ puntos);
                    }
                    mat[py][px] = 0;
                    px = px+1;
                    mat[py][px] = 3;
                    pintarMatriz();
                }
                if(izquierda == 1 && (mat[py][px-1] == 1 || mat[py][px-1] == 0)){
                    if(mat[py][px-1] == 1 ){
                        puntos = puntos+ 5;
                        record.setText("Puntos: "+ puntos);
                    }
                    mat[py][px] = 0;
                    px = px-1;
                    mat[py][px] = 3;
                    pintarMatriz();
                }
                int enc = 0;
                for (int i = 0; i < mat.length && enc == 0; i++) {
                    for (int j = 0; j < mat[i].length && enc == 0; j++) {
                        if(mat[i][j] == 1){
                            enc = 1;
                        }
                    }
                }
                if(enc == 0){
                    JOptionPane.showMessageDialog(ventana, "GANASTE!!!!");
                    paneljuego.setVisible(false);
                    menu.setVisible(true);
                    timer.stop();
                }
            }
        });

        timer.start();

        ventana.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_UP) {
                    if (mat[py-1][px] == 1 || mat[py-1][px] == 0) {
                        arriba = 1;
                        abajo = 0;
                        derecha = 0;
                        izquierda = 0;
                    }
                }

                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    if (mat[py+1][px] == 1 || mat[py+1][px] == 0) {
                        arriba = 0;
                        abajo = 1;
                        derecha = 0;
                        izquierda = 0;
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    if (mat[py][px-1] == 1 || mat[py][px-1] == 0) {
                        arriba = 0;
                        abajo = 0;
                        derecha = 0;
                        izquierda = 1;
                    }
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    if (mat[py][px+1] == 1 || mat[py][px+1] == 0) {

                        arriba = 0;
                        abajo = 0;
                        derecha = 1;
                        izquierda = 0;
                    }
                }


            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }



}
