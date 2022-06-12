package myGame.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public abstract class ChooseListener implements ActionListener {
    
    public ImageIcon createIcon(String path){
        URL url = getClass().getResource(path);
        return new ImageIcon(url);
    }


    @Override
    public abstract void actionPerformed(ActionEvent e); 
    
}
