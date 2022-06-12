package myGame.Scripts;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import myGame.Listeners.MoveListener;

public class Player extends Tile {

    public Player(boolean color,Field field) {
        if (color) {
            this.setIcon(super.createIcon("/images/blue man.png"));
            this.color = "Blue";
            addActionListener(new MoveListener(frame,field, this, redPlayer, this.getPosition().getY(), this.getPosition().getX(),false));
        } else {
            this.setIcon(super.createIcon("/images/red man.png"));
            addActionListener(new MoveListener(frame,field, bluePlayer, this, this.getPosition().getY(), this.getPosition().getX(),false));
            this.color = "Red";
        }
    }

    private int power = 1;
    private int score;
    private JLabel powerLabel;
    private JLabel scoreLabel;
    private String color;

    public void giveIcon() {
        this.setIcon(createIcon("/images/blue man.png"));
    }

    /**
     * @return
     */
    public int getScore() {
        return score;
    }

    /**
     *
     * @return
     */
    public int getPower() {
        return power;
    }

    public void increaseScore() {
        score++;
        scoreLabel.setText(this.color + " Score: " + score);
    }

    public void decreasePower() {
        power--;
        powerLabel.setText(this.color + " Power :" + power);
    }

    public void increasePower() {
        power++;
        powerLabel.setText(this.color + " Power: " + power);
    }

    public ImageIcon setTheBlueManIcon() {
        return super.createIcon("/images/blue man.png");
    }

    /**
     * @return the actionListener
     */
    public ActionListener getActionListener() {
        return actionListener;
    }

    /**
     * @param actionListener the actionListener to set
     */
    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    public void setPosition(int row, int col) {
        this.position.setX(row);
        this.position.setY(col);
    }

    /**
     * @return the statusLabel
     */
    public JLabel getPowerLabel() {
        return powerLabel;
    }

    /**
     * @param statusLabel the statusLabel to set
     */
    public void setPowerLabel(JLabel powerLabel) {
        this.powerLabel = powerLabel;
    }

    /**
     * @return the scoreLabel
     */
    public JLabel getScoreLabel() {
        return scoreLabel;
    }

    /**
     * @param scoreLabel the scoreLabel to set
     */
    public void setScoreLabel(JLabel scoreLabel) {
        this.scoreLabel = scoreLabel;
    }
}
