//===========================================
// movement logic for pieces
//===========================================

public class GameEngine {

    private GameBoard board;
    private boolean gameOver = false;

    public GameEngine(GameBoard board) {
        this.board = board;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void move(int x, int y, int dx, int dy) {

        if (gameOver) return;

        // get selected piece
        Piece piece = board.get(x, y);

        // piece exists
        if (piece == null) {
            return;
        }

        // only snowballs move
        if (!(piece.getType() == PieceType.LARGE ||
            piece.getType() == PieceType.SMALL)) {
            return;
        }

        // current movement position
        int cx = x;
        int cy = y;

        // continues until obstacle
        while (true) {
            int nx = cx + dx;
            int ny = cy + dy;

        
            // fell off board 
        if (!board.inBounds(nx, ny)) {
            board.set(cx, cy, new Piece(PieceType.EMPTY));
            gameOver = true;
            return;
        }

        // stop if hits something
        if (board.get(nx, ny).getType() != PieceType.EMPTY) {
            break;
        }

        cx = nx;
        cy = ny;
        }

        // clears old position
        board.set(x, y, new Piece(PieceType.EMPTY));
        board.set(cx, cy, piece);
    }
} 

