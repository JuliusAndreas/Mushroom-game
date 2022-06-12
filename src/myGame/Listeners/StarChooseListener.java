package myGame.Listeners;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import myGame.Scripts.Field;

public class StarChooseListener extends ChooseListener {

    public StarChooseListener(Field field, JFrame frame, int row, int col, int starsNumber, JButton[][] btns) {
        this.field = field;
        this.frame = frame;
        this.row = row;
        this.col = col;
        this.btns = btns;
        this.starsNumber = starsNumber;
    }

    private JButton[][] btns;
    private int row;
    private int col;
    private Field field;
    private JFrame frame;
    private int starsNumber;
    private static int currentStars;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (getCurrentStars() < starsNumber) {
            field.setStarField(row, col);
            //System.out.println(field == null);
            currentStars++;
            btns[row][col].setIcon(this.createIcon("/images/star.png"));
            frame.setVisible(false);
        }
    }

    public void setStarsNumber(int starsNumber) {
        this.starsNumber = starsNumber;
    }

    public static void reduceStars() {
        currentStars--;
    }

    /**
     * @return the currentStars
     */
    public static int getCurrentStars() {
        return currentStars;
    }
}
