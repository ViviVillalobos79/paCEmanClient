package Data;

import Sprites.Player;

public class CrearPill extends Commandos{
    private Integer x;
    private Integer y;

    /**
     * Creates pill
     * @param player who is playing
     * @param x Position in X
     * @param y Position in Y
     */
    public CrearPill(Player player, Integer x, Integer y) {
        super(player);
        this.x = x;
        this.y = y;
    }

    /**
     * Executes the pill commander
     */
    @Override
    public void ejecutar() {
        super.player.getPills().add(x,y);
    }
}
