package myGame.Scripts;

import javax.swing.JFrame;
import myGame.Listeners.MoveListener;

public class Mushroom extends Tile {

    public Mushroom(JFrame frame, Field field, Player bluePlayer, Player redPlayer, Position position) {
        this.field = field;
        this.frame = frame;
        this.bluePlayer = bluePlayer;
        this.redPlayer = redPlayer;
        this.position = position;
        this.setIcon(super.createIcon("/images/mushroom1.jpg"));
        addActionListener(new MoveListener(frame, field, bluePlayer, redPlayer, this.getPosition().getY(), this.getPosition().getX(), true));
    }

    private MoveListener actListener;

    @Override
    public void deleteActionListener() {
        this.removeActionListener(actListener);
    }

    @Override
    public void setActionListener() {
        actListener = new MoveListener(frame, field, bluePlayer, redPlayer, this.getPosition().getY(), this.getPosition().getX(),true);
        this.addActionListener(actListener);
    }
}
