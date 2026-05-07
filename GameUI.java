//===========================================
//main game window
//===========================================

import javax.swing.*;

public class GameUI extends JFrame {

    public GameUI(GameBoard board, GameEngine engine) {

        setTitle("Snow Problem - Task 1");  // sets window title
        setSize(520, 450); //sets size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close window when program closes
        setResizable(false); // set not resizable


        BoardPanel panel = new BoardPanel(board, engine);
        add(panel); // adds game board panel to window

        setVisible(true); // sets wondow visible
    }
} 
