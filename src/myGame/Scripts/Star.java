package myGame.Scripts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import myGame.Listeners.MoveListener;
import myGame.Listeners.OptionListener;
import myGame.Listeners.StarChooseListener;

public class Star extends Tile {

    public Star(JFrame frame,Field field, Player bluePlayer, Player redPlayer, Position position) {
        this.field = field;
        this.frame = frame;
        this.bluePlayer = bluePlayer;
        this.redPlayer = redPlayer;
        this.position = position;
        this.setIcon(super.createIcon("/images/star.png"));
        //System.out.println(field == null);
        addActionListener(new MoveListener(frame,field, bluePlayer, redPlayer, this.getPosition().getY(), this.getPosition().getX(),false));
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MoveListener.getTurn() == blue) {
                    bluePlayer.increaseScore();
                    StarChooseListener.reduceStars();
                } else if (MoveListener.getTurn() == red) {
                    redPlayer.increaseScore();
                    StarChooseListener.reduceStars();
                }
            }
        });
    }
    private ActionListener actListener = new MoveListener(frame, field, bluePlayer, redPlayer, this.getPosition().getY(), this.getPosition().getX(),false);
    //private ActionListener actListener = new MoveListener(frame,field, bluePlayer, redPlayer, this.getPosition().getY(), this.getPosition().getX());
        /**public Star(Field field, Player bluePlayer, Player redPlayer, Position position) {
        this.field = field;
        this.bluePlayer = bluePlayer;
        this.redPlayer = redPlayer;
        this.position = position;
        this.setIcon(super.createIcon("/images/star.png"));
        //System.out.println(field == null);
        addActionListener(new MoveListener(frame,field, bluePlayer, redPlayer, this.getPosition().getY(), this.getPosition().getX()));
        /**addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MoveListener.getTurn() == blue) {
                    bluePlayer.increaseScore();
                } else if (MoveListener.getTurn() == red) {
                    redPlayer.increaseScore();
                }
            }
        });**/
    

    
    /**
     * @return the redPlayer
     */
    public Player getRedPlayer() {
        return redPlayer;
    }

    /**
     * @param redPlayer the redPlayer to set
     */
    @Override
    public void setRedPlayer(Player redPlayer) {
        this.setRedPlayer(redPlayer);
    }

    /**
     * @return the bluePlayer
     */
    public Player getBluePlayer() {
        return bluePlayer;
    }

    /**
     * @param bluePlayer the bluePlayer to set
     */
    @Override
    public void setBluePlayer(Player bluePlayer) {
        this.setBluePlayer(bluePlayer);
    }

    /**
     * @param field the field to set
     */
    @Override
    public void setField(Field field) {
        this.field = field;

    }

}
