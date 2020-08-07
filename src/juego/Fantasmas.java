package juego;

import GUI.Tablero;

public class Fantasmas {

    int fanx;
    int fany;

    public Fantasmas(int x, int y){
        fanx = x;
        fany = y;
        Tablero.mat[fany][fanx] = 7;
    }

    public void movimiento(){

    }


}
