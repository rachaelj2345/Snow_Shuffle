import javax.swing.*;

public class GameUI extends JFrame {

    public GameUI(GameBoard board) {

        setTitle("Snow Problem - Task 1");
        setSize(520, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        BoardPanel panel = new BoardPanel(board);
        add(panel);

        setVisible(true);
    }
} 
