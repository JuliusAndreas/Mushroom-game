package myGame.Scripts;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class Wall extends Tile {

    public Wall() {
        this.setIcon(super.createIcon("/images/wall.png"));
        addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "WHY Do you wanna go to a wall???", "Error", JOptionPane.ERROR_MESSAGE);
        });
    }

}