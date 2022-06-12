package myGame.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import myGame.Scripts.Field;

public class MushroomChooseListener extends ChooseListener {

    public MushroomChooseListener(Field field, JFrame frame, int row, int col,int mushroomNumber,JButton[][] btns) {
        this.field = field;
        this.frame = frame;
        this.row = row;
        this.col = col;
        this.btns = btns;
        this.mushroomNumber = mushroomNumber;
    }

    private JButton[][] btns;
    private int row;
    private int col;
    private Field field;
    private JFrame frame;
    private int mushroomNumber;
    private static int currentmushrooms;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (currentmushrooms < mushroomNumber) {
            field.setMushroomField(row, col);
            currentmushrooms++;
            btns[row][col].setIcon(this.createIcon("/images/mushroom1.jpg"));
            frame.setVisible(false);
        }
    }

    public void setmushroomNumber(int mushroomNumber) {
        this.mushroomNumber = mushroomNumber;
    }

}
