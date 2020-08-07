package Data;

import Sprites.Ghost;
import Sprites.Nivel;
import Sprites.Pacman;

import javax.swing.*;
import java.util.ArrayList;

public class Observerdata {

    public Integer level;

    public Pacman pacman = new Pacman(1,1);

    public ArrayList<Ghost> ghosts = new ArrayList<>();

    public String jugador;
    public Integer puntos;
    public JLabel nombre;
    public JLabel record;

    public JLabel[][] matriz;

    public Nivel nivel;


}
