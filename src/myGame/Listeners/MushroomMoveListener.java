package myGame.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import myGame.Scripts.Field;
import myGame.Scripts.Player;
import myGame.Scripts.Position;
import myGame.Scripts.Tile;
import myGame.Scripts.Wall;

public class MushroomMoveListener implements ActionListener {

    private Field field;
    private final boolean blue = true;
    private final boolean red = false;
    private Player blueplayer;
    private Player redPlayer;
    private int row;
    private int col;
    private static boolean turn;
    //private Tile tile = new Tile();
    private JFrame frame;

    public MushroomMoveListener(JFrame frame, Field field, Player blueplayer, Player redPlayer, int col, int row) {
        this.field = field;
        this.redPlayer = redPlayer;
        this.frame = frame;
        this.blueplayer = blueplayer;
        this.row = row;
        this.col = col;
    }

    public static boolean getTurn() {
        return turn;
    }

    public ImageIcon createIcon(String path) {
        URL url = getClass().getResource(path);
        return new ImageIcon(url);

    }

    public static boolean wallChecker(Field field, Position playerPosition, Position targetPosition) {
        if (playerPosition.getX() == targetPosition.getX()) {
            if (playerPosition.getY() > targetPosition.getY()) {
                for (int i = playerPosition.getY(); i > targetPosition.getY(); i--) {
                    if (field.getField()[playerPosition.getX()][i] instanceof Wall) {
                        return false;
                    }
                }
            }
            if (playerPosition.getY() < targetPosition.getY()) {
                for (int i = playerPosition.getY(); i < targetPosition.getY(); i++) {
                    if (field.getField()[playerPosition.getX()][i] instanceof Wall) {
                        return false;
                    }
                }
            }
        }
        if (playerPosition.getY() == targetPosition.getY()) {
            if (playerPosition.getX() > targetPosition.getX()) {
                for (int i = playerPosition.getX(); i > targetPosition.getX(); i--) {
                    if (field.getField()[i][playerPosition.getY()] instanceof Wall) {
                        return false;
                    }
                }
            }
            if (playerPosition.getX() < targetPosition.getX()) {
                for (int i = playerPosition.getX(); i < targetPosition.getX(); i++) {
                    if (field.getField()[i][playerPosition.getY()] instanceof Wall) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean isValidMove(Field field, Position playerPosition, Position targetPosition, int power) {
        if (playerPosition.getX() == targetPosition.getX() || playerPosition.getY() == targetPosition.getY()) {
            if (wallChecker(field, playerPosition, targetPosition)) {
                if (playerPosition.getX() == targetPosition.getX()) {
                    if (playerPosition.getY() > targetPosition.getY()) {
                        if (playerPosition.getY() - targetPosition.getY() <= power) {
                            return true;
                        }
                    }
                    if (playerPosition.getY() < targetPosition.getY()) {
                        if (targetPosition.getY() - playerPosition.getY() <= power) {
                            return true;
                        }
                    }
                }
                if (playerPosition.getY() == targetPosition.getY()) {
                    if (playerPosition.getX() > targetPosition.getX()) {
                        if (playerPosition.getX() - targetPosition.getX() <= power) {
                            return true;
                        }
                    }
                    if (playerPosition.getX() < targetPosition.getX()) {
                        if (targetPosition.getX() - playerPosition.getX() <= power) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MushroomMoveListener.turn = MoveListener.getTurn();
        if (turn == blue) {
            //System.out.println(field == null);
            //System.out.println(blueplayer == null);
            //System.out.println(redPlayer == null);
            if (isValidMove(field, blueplayer.getPosition(), new Position(row, col), blueplayer.getPower())) {
                //int a1 = blueplayer.getPosition().getX();
                //int a2 = blueplayer.getPosition().getY();
                //System.out.println(field.getField()[blueplayer.getPosition().getX()][blueplayer.getPosition().getY()] instanceof Player);
                //System.out.println(field.getField()[blueplayer.getPosition().getX()][blueplayer.getPosition().getY()] instanceof Tile);
                //System.out.println(field.getField()[a1][a2] instanceof Player);
                //System.out.println(field.getField()[a1][a2] instanceof Tile);
                /**
                 * for (int i = 0; i < 5; i++) { for (int j = 0; j < 5; j++) {
                 * if (e.getSource() == field.getField()[i][j]) {
                 * swapBlue(blueplayer, field, row, col);
                 *
                 * }
                 * }*
                 */
                Tile newTile = new Tile();
                newTile.setPosition(blueplayer.getPosition().getX(), blueplayer.getPosition().getY());
                newTile.setBluePlayer(blueplayer);
                newTile.setRedPlayer(redPlayer);
                newTile.setField(field);
                newTile.setFrame(frame);
                newTile.setActionListener();
                field.getField()[blueplayer.getPosition().getX()][blueplayer.getPosition().getY()].deleteIcon();
                blueplayer.setPosition(row, col);
                //field.setTileField(row, col);

                field.getField()[row][col].setIcon(blueplayer.createIcon("/images/blue man.png"));

                //MoveListener.setTurn(true);
                frame.revalidate();
                frame.repaint();

            }
            //System.out.println(blueplayer.getPosition().getX() + " babr " + blueplayer.getPosition().getY());
            //System.out.println(fi);

            //field.getField()[blueplayer.getPosition().getX()][blueplayer.getPosition().getY()].remove;
            //frame.remove(blueplayer);
            //if(e.getSource()== )
            //field.setTileField(blueplayer.getPosition().getX(), blueplayer.getPosition().getY());
            //field.setBlueManField(row, col);
            //field.getField()[row][col].deleteActionListener();
            //System.out.println(blueplayer.getPosition().getX()+" pole sarat "+blueplayer.getPosition().getY());
            //System.out.println(field.getField()[a1][a2] instanceof Player);
            //field.getField()[blueplayer.getPosition().getX()][blueplayer.getPosition().getY()].setActionListener();
            //ActionListener act = blueplayer.actionListener;
            //blueplayer.deleteActionListener();
            //System.out.println(blueplayer.getPosition().getX()+"player position"+ blueplayer.getPosition().getY());
            //field.setTileField(blueplayer.getPosition().getX(), blueplayer.getPosition().getY());
            //field.setBlueManField(row, col);
            //System.out.println(blueplayer.getPosition().getX() + " new p " + blueplayer.getPosition().getY());
            //System.out.println(blueplayer.getPosition().getX() +" hero"+blueplayer.getPosition().getY());
            //System.out.println(blueplayer == null);
            //5System.out.println(field.getField()[an1][an2] instanceof Player);
            //blueplayer.addActionListener(new InvalidMoveListener());
            //System.out.println(field.getField()[row][col] instanceof Player);
            /**
             * System.out.println(blueplayer.getPosition().getX() +" hero
             * "+blueplayer.getPosition().getY());
             *
             * field.setTileField(blueplayer.getPosition().getX(),
             * blueplayer.getPosition().getY());
             * field.getField()[blueplayer.getPosition().getX()][blueplayer.getPosition().getY()].setIcon(null);
             *
             *
             * //field.getField()[row][col].setIcon(null);
             * //field.getField()[row][col].setIcon(createIcon("/images/blue
             * man.png")); System.out.println(field.getField()[row][col]
             * instanceof Player);*
             */
            //System.out.println(field.getField()[blueplayer.getPosition().getX()][blueplayer.getPosition().getY()] instanceof Player);
            //System.out.println(field.getField()[blueplayer.getPosition().getX()][blueplayer.getPosition().getY()] instanceof Tile);
            //System.out.println(field.getField()[a1][a2] instanceof Player);
            //System.out.println(field.getField()[a1][a2] instanceof Tile);
        } else if (turn == red) {
            if (isValidMove(field, redPlayer.getPosition(), new Position(row, col), redPlayer.getPower())) {
                Tile newTile = new Tile();
                newTile.setPosition(redPlayer.getPosition().getX(), redPlayer.getPosition().getY());
                newTile.setBluePlayer(blueplayer);
                newTile.setRedPlayer(redPlayer);
                newTile.setField(field);
                newTile.setFrame(frame);
                newTile.setActionListener();
                field.getField()[redPlayer.getPosition().getX()][redPlayer.getPosition().getY()].deleteIcon();
                redPlayer.setPosition(row, col);
                //field.setTileField(row, col);

                field.getField()[row][col].setIcon(redPlayer.createIcon("/images/red man.png"));

                turn = blue;
                frame.revalidate();
                frame.repaint();

            }
        }
    }

    public void swapBlue(Player blueplayer, Field field, int row, int col) {
        frame.remove(field.getField()[blueplayer.getPosition().getX()][blueplayer.getPosition().getY()]);
        frame.revalidate();
        frame.repaint();

    }

}
