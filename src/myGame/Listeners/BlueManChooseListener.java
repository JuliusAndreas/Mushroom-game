package myGame.Listeners;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import myGame.Scripts.Field;

public class BlueManChooseListener extends ChooseListener {

    public BlueManChooseListener(Field field, JFrame frame, int row, int col,JButton[][] btns) {
        this.field = field;
        this.frame = frame;
        this.row = row;
        this.btns = btns;
        this.col = col;
    }

    private JButton[][] btns;
    private static final int LIMIT = 1;
    private int row;
    private int col;
    private Field field;
    private JFrame frame;
    private static int currentBlueMans;
    private final boolean blue = true;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (currentBlueMans < LIMIT) {
            field.setBlueManField(row, col);
            currentBlueMans++;
            btns[row][col].setIcon(this.createIcon("/images/blue man.png"));
            frame.setVisible(false);
        }
        else {
            JOptionPane.showMessageDialog(null, "NO WAY MAN. Already have this", "LIMIT REACHED", JOptionPane.ERROR_MESSAGE);
        }
    }
}
