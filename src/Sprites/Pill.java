package Sprites;

public class Pill extends Sprite{

    private final Integer size = 25;

    /**
     * Constructor
     *
     * @param x position en X del Sprite
     * @param y position en Y del Sprite
     */
    public Pill(Integer x, Integer y) {
        super(x, y);
    }

    /**
     * How big is
     * @return size of
     */
    public Integer getSize() {
        return size;
    }
}
