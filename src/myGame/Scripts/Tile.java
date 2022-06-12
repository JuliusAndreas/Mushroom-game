package myGame.Scripts;

import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import myGame.Listeners.MoveListener;

public class Tile extends JButton {
    
    protected final boolean blue = true;
    protected final boolean red = false;
    protected Player redPlayer;
    protected JFrame frame;
    protected Player bluePlayer;
    protected ActionListener actListener;
    protected Field field;
    protected Position position = new Position();
    
    public ImageIcon createIcon(String path) {
        URL url = getClass().getResource(path);
        return new ImageIcon(url);
    }
    
    public void removeIcon(){
        this.setIcon(null);
    }
    
    public void setPosition(int x, int y) {
        //System.out.println(x + " wolf " + y);
        position.setX(x);
        position.setY(y);
    }

    public Position getPosition() {
        return position;
    }

    /**
     * @return the field
     */
    public Field getField() {
        return field;
    }

    /**
     * @param field the field to set
     */
    public void setField(Field field) {
        this.field = field;
    }

    public void deleteActionListener() {
        this.removeActionListener(actListener);
    }

    public void setActionListener() {
        setActListener(new MoveListener(frame, field, bluePlayer, redPlayer, this.getPosition().getY(), this.getPosition().getX(),false));
        this.addActionListener(actListener);
    }

    /**
     * @param redPlayer the redPlayer to set
     */
    public void setRedPlayer(Player redPlayer) {
        this.redPlayer = redPlayer;
    }
    
    public void deleteIcon(){
        this.setIcon(null);
    }

    /**
     * @param bluePlayer the bluePlayer to set
     */
    public void setBluePlayer(Player bluePlayer) {
        this.bluePlayer = bluePlayer;
    }

    /**
     * @return the actListener
     */
    public ActionListener getActListener() {
        return actListener;
    }

    /**
     * @param actListener the actListener to set
     */
    public void setActListener(MoveListener actListener) {
        this.actListener = actListener;
    }

    /**
     * @param frame the frame to set
     */
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
}
