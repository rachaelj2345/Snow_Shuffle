import java.util.List;


public class LevelLoader {

    public static void load(GameBoard board, List<String> layout) {

        for (int y = 0; y < layout.size(); y++) {
            String row = layout.get(y);

            for (int x = 0; x < row.length(); x++) {

                char c = row.charAt(x);

                switch (c) {
                    case 'T':
                        board.set(x, y, new Piece(PieceType.TREE));
                        break;
                    case 'L':
                        board.set(x, y, new Piece(PieceType.LARGE));
                        break;
                    case 'S':
                        board.set(x, y, new Piece(PieceType.SMALL));
                        break;
                    case 'H':
                        board.set(x, y, new Piece(PieceType.HEAD));
                        break;
                    default:
                        board.set(x, y, new Piece(PieceType.EMPTY));
                }
            }
        }
    }
} 

