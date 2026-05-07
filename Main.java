public class Main {

    public static void main(String[] args) {

        GameBoard board = new GameBoard();

        LevelLoader.load(board, Level1.getLayout());

        new GameUI(board);
    }
} 
