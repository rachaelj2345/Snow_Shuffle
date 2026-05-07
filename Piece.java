

public class Piece {

    // stores piece type
    private PieceType type;


    public Piece(PieceType type){

        // sets piece type
        this.type = type;
    }

    // returns piece type
    public PieceType getType(){
        return type;
    }
}