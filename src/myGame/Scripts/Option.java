package myGame.Scripts;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Option extends JButton {

    public Option(String path) {
        this.setIcon(createIcon(path));
    }
    
    public ImageIcon createIcon(String path) {
        URL url = getClass().getResource(path);
        return new ImageIcon(url);
    }

    
}
