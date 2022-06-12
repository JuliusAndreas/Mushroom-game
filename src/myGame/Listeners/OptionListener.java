package myGame.Listeners;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import myGame.Scripts.Field;
import myGame.Scripts.Option;

public class OptionListener implements ActionListener {

    private JFrame frame = new JFrame("Choose what you want");
    private int row;
    private int col;
    private Field field;
    private Option starOption = new Option("/images/star.png");
    private Option wallOption = new Option("/images/wall.png");
    private Option redManOption = new Option("/images/red man.png");
    private Option appleOption = new Option("/images/apple.jpg");
    private Option blueManOption = new Option("/images/blue man.png");
    private Option mushroomOption = new Option("/images/mushroom1.jpg");
    private JButton[][] btns;
    private int numberOfStars;
    private int numberOfWalls;
    private int numberOfApples;
    private int numberOfMushrooms;
    //private int limit;

    public OptionListener(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setBounds(100, 100, 300, 300);
        frame.setLayout(new GridLayout(3,3));
        starOption.addActionListener(new StarChooseListener(field, frame, row, col, numberOfStars, btns));
        wallOption.addActionListener(new WallChooseListener(field, frame, row, col, numberOfWalls, btns));
        redManOption.addActionListener(new RedManChooseListener(field, frame, row, col, btns));
        appleOption.addActionListener(new AppleChooseListener(field, frame, row, col, numberOfApples, btns));
        blueManOption.addActionListener(new BlueManChooseListener(field, frame, row, col, btns));
        mushroomOption.addActionListener(new MushroomChooseListener(field, frame, row, col, numberOfMushrooms, btns));
        frame.add(appleOption);
        frame.add(blueManOption);
        frame.add(redManOption);
        frame.add(mushroomOption);
        frame.add(wallOption);
        frame.add(starOption);
        frame.setVisible(true);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int aRow) {
        row = aRow;
    }

    public int getCol() {
        return col;
    }
    
    
    /**
     * @param aCol the col to set
     */
    public void setCol(int aCol) {
        col = aCol;
    }

    /**
     * @param field the field to set
     */
    public void setField(Field field) {
        this.field = field;
    }

    /**
     * @param btns the btns to set
     */
    public void setBtns(JButton[][] btns) {
        this.btns = btns;
    }

    /**
     * @param numberOfStars the numberOfStars to set
     */
    public void setNumberOfStars(int numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    /**
     * @param numberOfWalls the numberOfWalls to set
     */
    public void setNumberOfWalls(int numberOfWalls) {
        this.numberOfWalls = numberOfWalls;
    }

    public void setNumberOfApples(int numberOfApples) {
        this.numberOfApples = numberOfApples;
    }

    public void setNumberOfMushrooms(int numberOfMushrooms) {
        this.numberOfMushrooms = numberOfMushrooms;
    }

}
