package myGame.Scripts;

public class Position {
    public Position(int x,int y){
        this.x = x;
        this.y = y;
    }
    public Position(){}
    
    private int x = 0;
    private int y = 0;

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        System.out.println(" pol "+x);
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
}
