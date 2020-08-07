package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelMenu extends JFrame{

    JLabel fondoMenu;
    ImageIcon imagenFondoMenu;

    private JButton btnJugar;
    private JButton btnSalir;
    private JButton btnObservar;


    public PanelMenu(){
        initFrame();
        initComponents();
    }

    private void initFrame(){

        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Integer height = pantalla.height;
        Integer width = pantalla.width;
        this.setSize(width/2, height/2);

        this.setTitle("PaCEman");
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cuando se le da a la X se cierre


    }

    private void Reproducirsonido(){


    }



    private void initComponents() {

        fondoMenu = new JLabel();
        fondoMenu.setBounds(0, 0, this.getWidth(), this.getHeight());
        imagenFondoMenu = new ImageIcon("C:\\Users\\Dxnium\\OneDrive - Estudiantes ITCR\\TEC\\Lenguajes\\Tarea Corta 3\\paCEmanClient\\paCEmanClient\\src\\images\\menu.gif");
        imagenFondoMenu = new ImageIcon(imagenFondoMenu.getImage().getScaledInstance(this.getWidth(),
                this.getHeight(), Image.SCALE_DEFAULT));
        fondoMenu.setIcon(imagenFondoMenu);
        fondoMenu.setVisible(true);
        this.add(fondoMenu,0);

        btnJugar = new JButton();
        btnJugar.setText("JUGAR");
        btnJugar.setBounds(this.getWidth()/2 -250, this.getHeight()/2 +50 , 80,40);
        btnJugar.setBackground(Color.YELLOW);
        btnJugar.setVisible(true);
        this.add(btnJugar,0);

        btnSalir = new JButton();
        btnSalir.setText("SALIR");
        btnSalir.setBounds(this.getWidth()/2-50 , this.getHeight()/2 +50, 80,40);
        btnSalir.setBackground(Color.YELLOW);
        btnSalir.setVisible(true);
        this.add(btnSalir,0);

        btnObservar = new JButton();
        btnObservar.setText("Observar");
        btnObservar.setBounds(this.getWidth()/2 +100 , this.getHeight()/2 +50, 100,40);
        btnObservar.setBackground(Color.YELLOW);
        btnObservar.setVisible(true);
        this.add(btnObservar,0);

        btnJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnJugarpressed(e);
            }
        });
        btnObservar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnObservadorpressed(e);
            }
        });

    }


    private void btnJugarpressed(ActionEvent e) {
        (new PlayerWindow()).setVisible(true);
        this.setVisible(false);
    }

    private void btnObservadorpressed(ActionEvent e) {
       // (new Observador()).setVisible(true);
        this.setVisible(false);
    }

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PanelMenu().setVisible(true);
            }
        });

    }
}
