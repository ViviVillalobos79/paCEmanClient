package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Juego {

    //atributos

    JFrame ventana;
    int width = 900;
    int height = 750;

    private final Font smallFont = new Font("Helvetica", Font.BOLD, 26);

    JPanel presentacion;
    JButton iniciar;
    JLabel fondoPresentacion;
    ImageIcon imagenFondoPres;

    JPanel menu;
    JButton botones[];
    JLabel fondoMenu;
    ImageIcon imagenFondoMenu;

    public Juego(){
        ventana = new JFrame("PaCEman");
        ventana.setSize(width,height);
        ventana.setLayout(null);
        ventana.setLocationRelativeTo(null); //pone la pantalla en el centro
        ventana.setResizable(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cuando se le da a la X se cierre

        presentacion = new JPanel();
        presentacion.setLayout(null);
        presentacion.setBounds(0,0,ventana.getWidth(), ventana.getHeight());
        presentacion.setVisible(true);

        iniciar = new JButton("INICIAR");
        iniciar.setFont(smallFont);
        iniciar.setBounds(presentacion.getWidth()-450,presentacion.getHeight()/2 -50,200,100);
        iniciar.setVisible(true);
        iniciar.setBackground(Color.YELLOW);
        presentacion.add(iniciar,0);

        fondoPresentacion = new JLabel();
        fondoPresentacion.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
        imagenFondoPres = new ImageIcon("C:\\Users\\User\\IdeaProjects\\untitled2\\src\\images\\FondoPresentacion.jpg");
        imagenFondoPres = new ImageIcon(imagenFondoPres.getImage().getScaledInstance(ventana.getWidth(),
                ventana.getHeight(), Image.SCALE_DEFAULT));
        fondoPresentacion.setIcon(imagenFondoPres);
        fondoPresentacion.setVisible(true);
        presentacion.add(fondoPresentacion,0);

        //menu
        botones = new JButton[5];
        for (int i = 0; i<botones.length; i++){
            botones[i] = new JButton();
        }

        iniciar.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                menu();
                eventoMenu();
            }
        });


        ventana.add(presentacion);


        ventana.setVisible(true);

    }

    public void menu(){
        presentacion.setVisible(false);
        menu = new JPanel();
        menu.setLayout(null);
        menu.setBounds(0,0,ventana.getWidth(), ventana.getHeight());
        menu.setVisible(true);

        fondoMenu = new JLabel();
        fondoMenu.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
        imagenFondoMenu = new ImageIcon("C:\\Users\\User\\IdeaProjects\\untitled2\\src\\images\\menu.gif");
        imagenFondoMenu = new ImageIcon(imagenFondoMenu.getImage().getScaledInstance(ventana.getWidth(),
                ventana.getHeight(), Image.SCALE_DEFAULT));
        fondoMenu.setIcon(imagenFondoMenu);
        fondoMenu.setVisible(true);
        menu.add(fondoMenu,0);

        botones[0].setText("JUGAR");
        botones[1].setText("Crear");
        botones[2].setText("Records");
        botones[3].setText("Cargar");
        botones[4].setText("SALIR");


        for (int i = 0; i<botones.length; i++){
            botones[i].setBounds(ventana.getWidth()/botones.length * i, ventana.getHeight()/2 +100, 100,40);
            botones[i].setBackground(Color.WHITE);
            botones[i].setVisible(true);
            menu.add(botones[i], 0);
        }

        ventana.add(menu);

    }

    public void eventoMenu(){

        //jugar
        botones[0].addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){

                String jugador = JOptionPane.showInputDialog(ventana, "Nombre del jugador", "Escribe aqui");
                while (jugador == null || jugador.compareTo("Escribe aqui") == 0 || jugador.compareTo("") == 0){
                    jugador = JOptionPane.showInputDialog(ventana, "Debes ingresar un usuario", "Escribe aqui");
                }

                ventana.setVisible(false);
                PlayerWindow playerWindow = new PlayerWindow();
                playerWindow.setVisible(true);
                //Tablero tablero = new Tablero();
                //tablero.setJugador(jugador);
                //tablero.jugar(ventana, menu);

            }
        });

        //crear tablero
        botones[1].addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
            }
        });

        //Record
        botones[2].addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
            }
        });

        //cargar tablero
        botones[3].addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
            }
        });

        //salir
        botones[4].addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                System.exit(0);
            }
        });

    }

}
