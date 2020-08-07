package Sprites;

public class Nivel {

    private static Integer[][] leveldat;
    private static Integer levelNumber;

    /**
     * Constructor
     * @param levelNumber level in which the player is playing
     */
    public Nivel(Integer levelNumber) {
        Nivel.levelNumber = levelNumber;
        setLevelInfo();
    }


    /**
     * Sets the level array
     */
    private static void setLevelInfo(){
        if(levelNumber == 1){
            leveldat = new Integer[][] {
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                    {2,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,2},
                    {2,1,2,2,1,2,2,2,1,2,1,2,2,2,1,2,2,1,2},
                    {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
                    {2,1,2,1,1,2,1,2,2,2,2,2,1,2,1,2,2,1,2},
                    {2,1,1,1,1,2,1,1,1,2,1,1,1,2,1,1,1,1,2},
                    {2,2,1,2,1,2,2,2,1,2,1,2,2,2,1,2,2,1,2},
                    {2,2,1,1,1,2,2,1,1,1,1,1,1,1,1,2,2,1,2},//8
                    {2,1,2,2,1,2,1,2,0,0,0,2,1,2,1,2,2,1,2},
                    {2,1,2,2,1,1,1,0,0,0,0,0,1,1,1,2,2,1,2},
                    {2,1,2,2,1,2,1,2,0,0,0,2,1,2,1,2,2,1,2},
                    {2,1,1,1,1,2,1,1,1,1,1,1,1,2,1,1,1,1,2},
                    {2,2,2,2,1,2,1,2,2,2,2,2,1,2,1,2,2,2,2},
                    {2,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,2},
                    {2,1,2,2,1,2,2,2,1,2,1,2,2,2,1,2,2,1,2},
                    {2,1,1,2,1,1,1,1,1,1,1,1,1,1,1,2,1,1,2},
                    {2,2,1,2,1,2,1,2,2,2,2,2,1,2,1,2,1,2,2},
                    {2,1,1,1,1,2,1,1,1,2,1,1,1,2,1,1,1,1,2},
                    {2,1,2,2,2,2,2,2,1,2,1,2,2,2,2,2,2,1,2},
                    {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}
            };
        }
        if(levelNumber == 2){
            leveldat = new Integer[][] {
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                    {2,1,1,1,1,1,1,2,2,2,2,1,1,1,1,1,1,1,2},
                    {2,1,2,2,1,2,2,2,2,2,2,2,2,2,1,2,2,1,2},
                    {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
                    {2,1,2,2,1,2,1,2,2,2,2,2,1,2,1,2,2,1,2},
                    {2,1,1,1,1,2,1,1,1,2,1,1,1,2,1,1,1,1,2},
                    {2,2,1,1,1,2,2,2,1,2,1,2,2,2,1,2,2,1,2},
                    {2,2,1,1,1,2,2,1,1,1,1,1,1,1,1,2,2,1,2},
                    {2,1,2,2,1,2,1,2,0,0,0,2,1,2,1,2,2,1,2},
                    {2,1,2,2,1,1,1,0,0,0,0,0,1,1,1,2,2,1,2},
                    {2,1,2,2,1,2,1,2,0,0,0,2,1,1,1,2,2,1,2},
                    {2,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,2},
                    {2,1,2,2,1,2,1,2,2,2,2,2,1,2,1,2,2,2,2},
                    {2,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,2},
                    {2,1,2,2,1,2,2,2,1,2,1,2,2,2,1,2,2,1,2},
                    {2,1,1,2,1,1,1,1,1,1,1,1,1,1,1,2,1,1,2},
                    {2,2,1,2,1,2,1,2,2,2,2,2,1,2,1,2,1,2,2},
                    {2,1,1,1,1,2,1,1,1,2,1,1,1,2,1,1,1,1,2},
                    {2,1,2,2,2,2,2,2,2,2,1,2,2,2,2,2,2,1,2},
                    {2,1,1,1,1,1,1,1,2,2,1,1,1,1,1,1,1,1,2},
                    {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}
            };
        }
        if (levelNumber == 3){
            leveldat = new Integer[][]{
                    {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, //1
                    {2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2}, //2
                    {2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2}, //3
                    {2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2}, //4
                    {2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2}, //5
                    {2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2}, //6
                    {2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2}, //7
                    {2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2}, //8
                    {2, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 2}, //9
                    {2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2}, //10
                    {2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2}, //11
                    {2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2}, //12
                    {2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2}, //13
                    {2, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 0, 0, 0, 0, 0, 2}, //16
                    {2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 0, 0, 0, 0, 0, 0, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2}, //19
                    {2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2}, //20
                    {2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2}, //21
                    {2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2}, //22
                    {2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2}, //23
                    {2, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 2}, //24
                    {2, 2, 2, 1, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 2, 1, 2, 2, 2}, //25
                    {2, 2, 2, 1, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 2, 1, 2, 2, 2}, //26
                    {2, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2}, //27
                    {2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2}, //28
                    {2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2}, //29
                    {2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2}, //30
                    {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}  //31
            };
        }
    }

    public Integer[][] getLeveldat() {
        return leveldat;
    }

    public static void setLeveldat(Integer[][] leveldat) {
        Nivel.leveldat = leveldat;
        setLevelInfo();
    }

    public Integer getLevelNumber() {
        return levelNumber;
    }

    public static void setLevelNumber(Integer levelNumber) {
        Nivel.levelNumber = levelNumber;
    }

    /**
     * Modify de value of a data of the level matrix
     * @param x X position
     * @param y Y position
     * @param value New value
     */
    public void setAInfo(Integer x, Integer y, Integer value){
        leveldat[y][x] = value;
    }




}
