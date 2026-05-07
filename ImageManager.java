
//===========================================
// load and stores pngs for game
//===========================================


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

//===========================================

public class ImageManager {

    // HashMap stores images with piece type as key
    private static HashMap<PieceType, BufferedImage> images = new HashMap<>();

    // load images form assets
    public static void load() {
        try {
            images.put(PieceType.TREE, ImageIO.read(new File("assets/tree.png")));
            images.put(PieceType.LARGE, ImageIO.read(new File("assets/snowball_large.png")));
            images.put(PieceType.SMALL, ImageIO.read(new File("assets/snowball_small.png")));
            images.put(PieceType.HEAD, ImageIO.read(new File("assets/head_blue.png")));
            images.put(PieceType.EMPTY, ImageIO.read(new File("assets/hole.png")));
            images.put(PieceType.STACK, ImageIO.read(new File("assets/snowman_stack.png")));
            images.put(PieceType.SNOWMAN, ImageIO.read(new File("assets/snowman_blue.png")));
        } catch (Exception e) {

        // error message
        e.printStackTrace();
        }
    }

    // returns the image for piece type
    public static BufferedImage get(PieceType type) {
        return images.get(type);
    }
} 
