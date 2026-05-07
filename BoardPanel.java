
//===========================================
// draws game board and pieces
//===========================================

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class BoardPanel extends JPanel {

    private GameBoard board;
    private GameEngine engine;


    private final int CELL_SIZE = 100;

    private int selectedX = -1;
    private int selectedY = -1;


    public BoardPanel(GameBoard board, GameEngine engine) {
        // board reference
        this.board = board;
        //engine reference
        this.engine = engine;
        //loads images
        ImageManager.load();

        addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {

                handleClick(e.getX(), e.getY());
            }
            
        });
    } 

//===========================================

    private void handleClick(int mx, int my) {


    // convert mouse pos to board pos
        int x = mx / CELL_SIZE;
        int y = my / CELL_SIZE;

        // ignore clicks outside board
        if (!board.inBounds(x, y)) {
            return;
        }

        //selects a snowball
        if (selectedX == -1) {

            Piece p = board.get(x, y);


            if (p.getType() == PieceType.LARGE ||
                p.getType() == PieceType.SMALL) {

                selectedX = x;
                selectedY = y;
            }

            // redraw selection highlight
            repaint();

            return;
        }

        // calculate click direction
        int dx = x - selectedX;
        int dy = y - selectedY;


        if (Math.abs(dx) > Math.abs(dy)) {

            // horizontal movement
            dy = 0;

            if (dx > 0) {
            dx = 1;
            } else {
            dx = -1;
            }

        } else {

        // vertical movement
            dx = 0;

            if (dy > 0) {
            dy = 1;
            } else {
            dy = -1;
            }
        }

        // move selected snowball
        engine.move(selectedX, selectedY, dx, dy);

        // clear selection
        selectedX = -1;
        selectedY = -1;

        // redraws the board
        repaint();

        //game over screem
        if (engine.isGameOver()) {

            JOptionPane.showMessageDialog(
                this,
                "Game Over!"
            );
        }
    }



//===========================================

    // calls when panel redraws
    @Override
    protected void paintComponent(Graphics g) {
        //clear frame
        super.paintComponent(g);

        Piece[][] grid = board.getGrid();

        for (int y = 0; y < GameBoard.HEIGHT; y++) {
            for (int x = 0; x < GameBoard.WIDTH; x++) {

                // converts board pos to pixel pos
                int px = x * CELL_SIZE;
                int py = y * CELL_SIZE;

//===========================================

                g.setColor(new Color(220, 220, 220));
                g.fillRect(px, py, CELL_SIZE, CELL_SIZE); // light grey square

                g.setColor(Color.BLACK);
                g.drawRect(px, py, CELL_SIZE, CELL_SIZE); // black boarder

//===========================================

                // gets current piece form board
                Piece piece = grid[y][x];

                // gets png image for piece
                if (piece != null) {
                    BufferedImage img = ImageManager.get(piece.getType());

                    if (img != null) {
                        g.drawImage(img, px, py, CELL_SIZE, CELL_SIZE, null);
                    }
                }
            }
        }
    }
} 
