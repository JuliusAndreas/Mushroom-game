package myGame.Scripts;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import myGame.Listeners.MoveListener;

public class Field {

    private final boolean blue = true;
    private final boolean red = false;
    private Player redPlayer = new Player(red,this);
    private Player bluePlayer = new Player(blue,this);
    private int width;
    private JFrame frame;
    private int height;
    private Tile[][] ground;
    private ActionListener[][] moveListeners = new MoveListener[height][width]; 

    public Field(int y, int x) {
        height = x;
        width = y;
        ground = new Tile[x][y];
    }

    public void setAppleField(int x, int y) {
        ground[x][y] = new Apple(frame, this, bluePlayer, redPlayer, new Position(x, y));
        
    }

    public void setStarField(int x, int y) {
        Star star = new Star(frame, this, bluePlayer, redPlayer, new Position(x, y));
        ground[x][y] = star;
        
    }

    public void setWallField(int x, int y) {
        Wall wall = new Wall();
        ground[x][y] = wall;
        wall.setPosition(x, y);
    }

    public void setMushroomField(int x, int y) {
        ground[x][y] = new Mushroom(frame, this, bluePlayer, redPlayer, new Position(x, y));
        
    }

    public void setBlueManField(int x, int y) {
        System.out.println(x+" delavar "+y);
        ground[x][y] = bluePlayer;
        bluePlayer.setPosition(x, y);
        
    }

    public void setRedManField(int x, int y) {
        ground[x][y] = redPlayer;
        redPlayer.setPosition(x, y);
    }

    public Player getRedPlayer() {
        return redPlayer;       
    }
    
    public Player getBluePlayer() {
         return bluePlayer;
    }

    public Tile[][] getField() {
        return ground;
    }

    public int getFieldX() {
        return width;
    }

    public int getFieldY() {
        return height;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
    
}
