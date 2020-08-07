package Data;

import Sprites.Fruit;
import Sprites.Player;

public class CrearFruta extends Commandos{

    private Fruit fruit;

    /**
     * Creates a Fruit
     * @param player sets the player who is playing
     * @param points value if it is eaten
     */
    public CrearFruta(Player player, Integer points) {
        super(player);
        fruit = new Fruit(points);
    }

    /**
     * Executes the command
     */
    @Override
    public void ejecutar() {
        super.player.getFruits().add(fruit);
    }
}
