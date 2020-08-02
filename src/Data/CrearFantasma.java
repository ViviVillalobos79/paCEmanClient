package Data;

import Sprites.Ghost;
import Sprites.Player;

public class CrearFantasma extends Commandos{

    Integer ghostColor;
    String name;

    /**
     * Constructor
     * @param player Actual person playing
     * @param ghostColor color of the ghost to create
     * @param name Name of the ghost to create
     */
    public CrearFantasma(Player player, Integer ghostColor, String name) {
        super(player);
        this.ghostColor = ghostColor;
        this.name = name;
    }

    /**
     * Gets the command and executed
     */
    @Override
    public void ejecutar() {
        super.player.getGhosts().add(new Ghost(super.player.getNivel().getLevelNumber(), ghostColor, name));
    }
}
