package myGame.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import myGame.Scripts.Apple;
import myGame.Scripts.Field;

public class AppleChooseListener extends ChooseListener{

    public AppleChooseListener(Field field,JFrame frame,int row,int col,int applesNumber,JButton[][] btns){
        this.field = field;
        this.frame = frame;
        this.row = row;
        this.col = col;
        this.btns = btns;
        this.applesNumber = applesNumber;
    }
    
    private JButton[][] btns;
    private int row;
    private int col;
    private Field field;
    private JFrame frame;
    private int applesNumber;
    private static int currentApples;
  
    @Override
    public void actionPerformed(ActionEvent e) {
        if(currentApples<applesNumber){
            field.setAppleField(row, col);
            currentApples++;
            btns[row][col].setIcon(this.createIcon("/images/apple.jpg"));
            frame.setVisible(false);
        }
    }
    
    public void setApplesNumber(int applesNumber) {
        this.applesNumber = applesNumber;
    }
    
}
