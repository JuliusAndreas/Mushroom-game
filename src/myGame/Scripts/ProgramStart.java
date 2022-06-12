package myGame.Scripts;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class ProgramStart {
    
    public ProgramStart() throws IOException{
        JLabel lblBackGroundImage = new JLabel();
        JFrame mainMenu = new JFrame("Clash of Warriors");
        mainMenu.setLayout(new BorderLayout());
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout());
        lblBackGroundImage.setLayout(null);
        lblBackGroundImage.setIcon(new ImageIcon("F:\\Education\\University\\Programming\\advanced programming - Java\\skytemple.jpg"));
        mainMenu.setBounds(350, 100, 650, 400);
        lblBackGroundImage.setBounds(50, 50, 800, 150);
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.setResizable(true);
        menuPanel.add(lblBackGroundImage);
        mainMenu.getContentPane().add(menuPanel);
        JButton startButton = new JButton("Start 1v1 Game");
        JButton exitButton = new JButton("Exit Game");
        startButton.setBounds(235, 155, 140, 60);
        exitButton.setBounds(235, 240, 140, 60);
        lblBackGroundImage.add(startButton);
        lblBackGroundImage.add(exitButton);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenu.dispose();
                JOptionPane.showMessageDialog(null, "Hi, there are some rules to play:\nYou Can not go to the place where your player was first spawned, just go ahead\nYou think it is funny to pick only one Player? no it is not. So Dont do it.\nYou should choose your field in the way it becomes square.\n ENJOY :) ", "Welcome", JOptionPane.INFORMATION_MESSAGE);
                new GameRunner();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        music();
        mainMenu.setVisible(true);
        
    
    }
    
    public static void music() throws IOException 
    {       
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;

        ContinuousAudioDataStream loop = null;

        try
        {
            InputStream test = new FileInputStream("F:\\Education\\University\\Programming\\advanced programming - Java\\mortal.wav");
            BGM = new AudioStream(test);
            AudioPlayer.player.start(BGM);
            //MD = BGM.getData();
            //loop = new ContinuousAudioDataStream(MD);

        }
        catch(FileNotFoundException e){
            System.out.print(e.toString());
        }
        MGP.start(loop);
    }
    
}
