
//===========================================
// draws game board and pieces
//===========================================

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BoardPanel extends JPanel {

    private GameBoard board;


    private final int CELL_SIZE = 100;

    public BoardPanel(GameBoard board) {
        // board reference
        this.board = board;
        //loads images
        ImageManager.load();
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
