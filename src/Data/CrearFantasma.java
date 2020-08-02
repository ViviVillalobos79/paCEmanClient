package Data;

import Sprites.Ghost;
import Sprites.Player;

public class CrearFantasma extends Commandos{

    Integer ghostColor;
    String name;

    public CrearFantasma(Player player, Integer ghostColor, String name) {
        super(player);
        this.ghostColor = ghostColor;
        this.name = name;
    }

    @Override
    public void ejecutar() {
        super.player.getGhosts().add(new Ghost(super.player.getNivel().getLevelNumber(), ghostColor, name));
    }
}
