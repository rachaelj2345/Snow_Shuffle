//===========================================

public class Main {

    public static void main(String[] args) {


        // creates game board object
        GameBoard board = new GameBoard();

        //load level 1
        LevelLoader.load(board, Level1.getLayout());

        GameEngine engine = new GameEngine(board);


        //create and output game window
        new GameUI(board, engine);
    }
} 
