package FakeServer;

import Data.Commandos;
import Data.CrearFantasma;
import Data.CrearFruta;
import Sprites.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class FakePlayerServer extends JFrame {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JButton ejecutarButton;
    private JComboBox nombreFantasma;
    private JLabel jlabel1;
    private JButton crearFrutaButton;
    private JSpinner fruitPunt;


    private Player player;

    public FakePlayerServer(Player player) {
        this.setSize(300,300);
        this.player = player;

        initVariables();

        ejecutarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Commandos crearGhost = new CrearFantasma(player, getGhostColor(getGhostName()), getGhostName());
                crearGhost.ejecutar();

            }
        });

        crearFrutaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Commandos crearFruta = new CrearFruta(player,getFruitPoints());
                crearFruta.ejecutar();
            }
        });
    }

    public void initVariables(){
        setContentPane(panel1);
        fruitPunt.setModel(new SpinnerNumberModel(10000,100,null,100));
    }

    private String getGhostName() {
        String name = Objects.requireNonNull(nombreFantasma.getSelectedItem()).toString();
        return name;
    }

    private Integer getGhostColor(String name){
        if(name.equals("Clyde")){
            return 1;
        }
        if(name.equals("Blinky")){
            return 2;
        }
        if(name.equals("Pinky")){
            return 3;
        }
        else {
            return 4;
        }
    }

    private Integer getFruitPoints(){
        return (Integer)fruitPunt.getValue();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}
