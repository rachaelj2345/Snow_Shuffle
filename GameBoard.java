//===========================================
// Setting up the board
//===========================================

public class GameBoard {

    public static final int WIDTH = 5;
    public static final int HEIGHT = 4;

    private Piece[][] grid = new Piece[HEIGHT][WIDTH];

//===========================================
//Set 5 x 4 grid all empty

    public GameBoard(){
        for (int y = 0; y < HEIGHT; y++){
            for(int x = 0; x < WIDTH; x++){
                grid[y][x] = new Piece(PieceType.EMPTY);

            }
        }
    }

//===========================================
// Return piece at position

    public Piece get(int x,int y){
        return grid[y][x];
    }

//===========================================
// Set piece at position

    public void set(int x, int y, Piece piece){
        grid[y][x] = piece;
    }

//===========================================
// 
    public Piece[][] getGrid(){
        return grid;
    }
}