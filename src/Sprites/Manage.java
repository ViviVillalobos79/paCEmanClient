package Sprites;

import java.util.ArrayList;

public class Manage {

    private ArrayList<Sprite> sprites = new ArrayList<>();

    /**
     * Add a sprite to the list
     * @param sprite which that is going to add
     */
    public void add(Sprite sprite){
        sprites.add(sprite);
    }

    /**
     * How many sprites there are
     * @return length of the list
     */
    public Integer len(){
        return sprites.size();
    }

    /**
     * Gets a sprite according to where is located and erase it
     * @param x Position X
     * @param y Position Y
     */
    public void remove(Integer x, Integer y){
        for (int i = 0; i < sprites.size(); i++) {
            Sprite sprite = sprites.get(i);
            if (sprite.getX() == x && sprite.getY() == y) {
                sprites.remove(i);
                break;
            }
        }
    }

    /**
     * Returns a specific sprite according to a position
     * @param x Position in X
     * @param y Position in y
     * @return sprite in the position wanted
     */
    public Sprite get(Integer x, Integer y){
        for(Sprite sprite : sprites){
            if (sprite.getX() == x && sprite.getY() == y) {
                return sprite;
            }
        }
        return null;
    }

    public ArrayList<Sprite> getSprites() {
        return sprites;
    }

    public void setSprites(ArrayList<Sprite> sprites) {
        this.sprites = sprites;
    }
}
