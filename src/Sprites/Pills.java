package Sprites;

import java.util.ArrayList;

public class Pills {

    private boolean active = false;
    private Integer pillTime = 5000;

    private final ArrayList<Pill> pills = new ArrayList<>();

    /**
     * Add a pill to the group
     * @param x In where the pill is going to be located in X
     * @param y In where the pill is going to be located in Y
     */
    public void add(Integer x, Integer y){
        pills.add(new Pill(x,y));
    }

    /**
     * Remove a pill from the list
     * @param x where the pill is located in X
     * @param y where the pill is located in Y
     */
    public void removePill(Integer x,Integer y) {
        for (int i = 0; i < pills.size(); i++) {
            Pill pill = pills.get(i);
            if (pill.getX() == x && pill.getY() == y) {
                pills.remove(i);
                break;
            }
        }
    }

    /**
     * A pill according to a position
     * @param x where is located in X
     * @param y where is located in Y
     * @return the exact pill
     */
    public Pill getPill(Integer x,Integer y) {
        for (int i = 0; i < pills.size(); i++) {
            Pill pill = pills.get(i);
            if (pill.getX() == x && pill.getY() == y) {
                return pill;
            }
        }
        return null;
    }

    public boolean isActive() {
        return active;
    }

    /**
     * Handles the time
     * @return how much time is missing after configure it
     */
    public Integer pillTimer(){
        pillTime = pillTime - 40;
        if(pillTime <= 0) {
            pillTime = 5000;
            active = false;
            return 0;
        } else {
            return pillTime;
        }
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ArrayList<Pill> getPills() {
        return pills;
    }

    public Integer getPillTime() {
        return pillTime;
    }
}
