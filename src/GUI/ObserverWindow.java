package GUI;

import Data.Constants;
import Sprites.Observador;

import javax.swing.*;
import java.awt.*;

public class ObserverWindow extends JFrame {

    public Observador observador;

    public static void main(String[] args){
        EventQueue.invokeLater(()-> {
            JFrame frame = new ObserverWindow();
            frame.setVisible(true);
        });
    }

    public ObserverWindow(){
        initWindow();
    }

    private void initWindow(){
        this.setTitle("PaCEman Observer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(Constants.WIDTH, Constants.HEIGHT);
        this.setLocationRelativeTo(null);
        this.setResizable(true);

        this.observador = new Observador();
        this.add(observador);
    }

    public Observador getObservador() {
        return observador;
    }

    public void setObservador(Observador observador) {
        this.observador = observador;
    }
}
