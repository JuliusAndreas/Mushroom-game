package myGame.Scripts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import myGame.Listeners.MoveListener;

public class Apple extends Tile {

    public Apple(JFrame frame, Field field, Player bluePlayer, Player redPlayer, Position position) {
        this.field = field;
        this.frame = frame;
        this.bluePlayer = bluePlayer;
        this.redPlayer = redPlayer;
        this.position = position;
        this.setIcon(super.createIcon("/images/apple.jpg"));
        actListener = new MoveListener(frame, field, bluePlayer, redPlayer, this.getPosition().getY(), this.getPosition().getX(),false);
        powerListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MoveListener.getTurn() == blue) {
                    bluePlayer.increasePower();
                } else if (MoveListener.getTurn() == red) {
                    redPlayer.increasePower();
                }
            }
        };
        addActionListener(actListener);
        addActionListener(powerListener);
    }

    private MoveListener actListener;
    private ActionListener powerListener;

    @Override
    public void deleteActionListener() {
        this.removeActionListener(powerListener);
        this.removeActionListener(actListener);
    }

    @Override
    public void setActionListener() {
        actListener = new MoveListener(frame, field, bluePlayer, redPlayer, this.getPosition().getY(), this.getPosition().getX(),false);
        powerListener = (ActionEvent e) -> {
            if (MoveListener.getTurn() == blue) {
                bluePlayer.decreasePower();
            } else if (MoveListener.getTurn() == red) {
                redPlayer.decreasePower();
            }
        };
        this.addActionListener(powerListener);
        this.addActionListener(actListener);
    }
}
