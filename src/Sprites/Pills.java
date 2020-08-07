package Sprites;

import java.util.ArrayList;

public class Pills {

    private boolean active = false;
    private Integer pillTime = 5000;

    private final ArrayList<Pill> pills = new ArrayList<>();

    public void add(Integer x, Integer y){
        pills.add(new Pill(x,y));
    }
    public void removePill(Integer x,Integer y) {
        for (int i = 0; i < pills.size(); i++) {
            Pill pill = pills.get(i);
            if (pill.getX() == x && pill.getY() == y) {
                pills.remove(i);
                break;
            }
        }
    }

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
}
