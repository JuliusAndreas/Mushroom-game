package myGame.Scripts;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import myGame.Listeners.OptionListener;

public class GameRunner {

    public GameRunner() {
        int i = 0;
        int j = 0;
        String fieldHeight = JOptionPane.showInputDialog("Enter a number as your field width: ");
        String fieldWidth = JOptionPane.showInputDialog("Enter a number as your field height: ");
        int height = Integer.parseInt(fieldWidth);
        int width = Integer.parseInt(fieldHeight);
        if(height!=width){
            JOptionPane.showMessageDialog(null, "dude you made a mistake! they should be equal!", "error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        String wallsNumber = JOptionPane.showInputDialog("How many walls do you wanna have?");
        int numberOfWalls = Integer.parseInt(wallsNumber);
        String starsNumber = JOptionPane.showInputDialog("How many stars do you wanna have?");
        int numberOfStars = Integer.parseInt(starsNumber);
        String applesNumber = JOptionPane.showInputDialog("How many apples do you wanna have?");
        int numberOfApples = Integer.parseInt(applesNumber);
        String mushroomsNumber = JOptionPane.showInputDialog("How many mushrooms do you wanna have?");
        int numberOfMushrooms = Integer.parseInt(mushroomsNumber);
        JFrame selectionFrame = new JFrame("Choose the position");
        selectionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame chooseFrame = new JFrame("Choose an Option");
        chooseFrame.setLayout(new GridLayout(3, 3));
        chooseFrame.setBounds(100, 100, 300, 300);
        chooseFrame.setResizable(true);
        Field field = new Field(width, height);
        JButton[][] btns = new JButton[width][height];

        OptionListener[][] optionListeners = new OptionListener[width][height];
        for (int counth = 0; counth < width; counth++) {
            for (int countw = 0; countw < height; countw++) {
                optionListeners[counth][countw] = new OptionListener(counth, countw);
                optionListeners[counth][countw].setNumberOfApples(numberOfApples);
                optionListeners[counth][countw].setNumberOfMushrooms(numberOfMushrooms);
                optionListeners[counth][countw].setNumberOfStars(numberOfStars);
                optionListeners[counth][countw].setNumberOfWalls(numberOfWalls);
                optionListeners[counth][countw].setField(field);
                optionListeners[counth][countw].setBtns(btns);
            }
        }
        //chooseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        selectionFrame.setSize(500, 500);
        selectionFrame.setLocation(400, 100);
        selectionFrame.setResizable(true);
        selectionFrame.setLayout(new BorderLayout());
        JPanel panelGo = new JPanel();
        JPanel panelChoose = new JPanel();

        panelChoose.setLayout(new GridLayout(width, height));
        selectionFrame.getContentPane().add(panelGo, BorderLayout.SOUTH);
        selectionFrame.getContentPane().add(panelChoose, BorderLayout.CENTER);
        panelGo.setSize(200, 200);
        JButton goButton = new JButton("GO!!!");
        goButton.setSize(100, 200);

        panelGo.add(goButton);

        for (i = 0; i < width; i++) {
            for (j = 0; j < height; j++) {
                btns[i][j] = new JButton("(" + i + " , " + j + ")");
                btns[i][j].addActionListener(optionListeners[i][j]);
                panelChoose.add(btns[i][j]);
            }
        }

        Game game = new Game(field, field.getBluePlayer(), field.getRedPlayer());
        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectionFrame.setVisible(false);
                game.getGameBoard().setVisible(true);
            }
        });


        selectionFrame.setVisible(true);

        
    }
}