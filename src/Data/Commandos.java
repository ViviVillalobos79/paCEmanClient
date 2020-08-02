package Data;

import Sprites.Player;

public abstract class Commandos {

    protected Player player;

    public Commandos(Player player) {
        this.player = player;
    }

    public abstract void ejecutar();
}
