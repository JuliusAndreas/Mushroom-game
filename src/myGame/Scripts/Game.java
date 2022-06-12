package myGame.Scripts;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game {

    public Game(Field field, Player bluePlayer, Player redPlayer) {
        this.field = field;
        field.setFrame(gameBoard);
        this.bluePlayer = bluePlayer;
        this.redPlayer = redPlayer;
        for (int county = 0; county < field.getFieldY(); county++) {
            for (int countx = 0; countx < field.getFieldX(); countx++) {
                Tile tile = new Tile();
                tile.setPosition(county, countx);
                tile.setBluePlayer(bluePlayer);
                tile.setRedPlayer(redPlayer);
                tile.setFrame(gameBoard);
                tile.setField(field);
                tile.setActionListener();
                //System.out.println(county+"joojoo"+countx);
                field.getField()[county][countx] = tile;
            }
        }

    }

    private Field field;
    private final boolean red = false;
    private final boolean blue = true;
    private boolean turn = true;
    private final Player bluePlayer;
    private final Player redPlayer;
    private int wallsNumber;
    private int applesNumber;
    private int starsNumber;
    private int mushroomsNumber;
    private JFrame gameBoard = new JFrame("The Game");
    private Tile[][] board;
    private Wall[] walls = new Wall[wallsNumber];

    public void setWallsNumber(int wallsNumber) {
        this.wallsNumber = wallsNumber;
    }

    public void setApplesNumber(int applesNumber) {
        this.applesNumber = applesNumber;
    }

    public void setStarsNumber(int starsNumber) {
        this.starsNumber = starsNumber;
    }

    public void setMushroomsNumber(int mushroomsNumber) {
        this.mushroomsNumber = mushroomsNumber;
    }

    public Player getBluePlayer() {
        return bluePlayer;
    }

    public Player getRedPlayer() {
        return redPlayer;
    }

    public Field getField() {
        return field;
    }

    public JFrame getGameBoard() {
        JPanel statusPanel = new JPanel();
        JPanel gamePanel = new JPanel();
        JLabel blueScoreLabel = new JLabel("Blue Score: " + bluePlayer.getScore());
        JLabel redScoreLabel = new JLabel("Red Score: " + redPlayer.getScore());
        JLabel bluePowerLabel = new JLabel("Blue Power: " + bluePlayer.getPower());
        JLabel redPowerLabel = new JLabel("Red Power: " + redPlayer.getPower());
        gamePanel.setLayout(new GridLayout(field.getFieldX(), field.getFieldY()));
        gameBoard.setResizable(true);
        statusPanel.setLayout(new GridLayout());
        gameBoard.setLayout(new BorderLayout());
        gameBoard.getContentPane().add(gamePanel, BorderLayout.CENTER);
        gameBoard.getContentPane().add(statusPanel, BorderLayout.NORTH);
        gameBoard.setBounds(400, 100, 650, 650);
        gameBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        redPowerLabel.setLocation(40, 100);
        redScoreLabel.setLocation(30, 100);
        bluePowerLabel.setLocation(40, 50);
        blueScoreLabel.setLocation(30, 50);
        redPlayer.setPowerLabel(redPowerLabel);
        redPlayer.setScoreLabel(redScoreLabel);
        bluePlayer.setScoreLabel(blueScoreLabel);
        bluePlayer.setPowerLabel(bluePowerLabel);
        statusPanel.add(redPowerLabel);
        statusPanel.add(blueScoreLabel);
        statusPanel.add(bluePowerLabel);
        statusPanel.add(redScoreLabel);
        for (int i = 0; i < field.getFieldY(); i++) {
            for (int j = 0; j < field.getFieldX(); j++) {
                gamePanel.add(field.getField()[i][j]);
            }
        }
        return gameBoard;
    }

}
