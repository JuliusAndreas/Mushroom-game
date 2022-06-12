package myGame.Listeners;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import myGame.Scripts.Field;

public class WallChooseListener extends ChooseListener {

    private JButton[][] btns;
    private int row;
    private int col;
    private Field field;
    private JFrame frame;
    private int wallsNumber;
    private static int currentWalls;
    private int rowcopy;
    private int colcopy;
    
    public WallChooseListener(Field field, JFrame frame, int row, int col, int wallsNumber, JButton[][] btns) {
        this.field = field;
        this.frame = frame;
        this.rowcopy = row;
        this.colcopy = col;
        this.btns = btns;
        this.wallsNumber = wallsNumber;
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        row = rowcopy;
        col = colcopy;
        if (currentWalls < wallsNumber) {
            field.setWallField(row, col);
            currentWalls++;
            btns[this.row][this.col].setIcon(this.createIcon("/images/wall.png"));
            frame.setVisible(false);
        }
    }

    public void setWallsNumber(int wallsNumber) {
        this.wallsNumber = wallsNumber;
    }
}
