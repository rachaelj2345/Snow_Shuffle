import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

public class ImageManager {

    private static HashMap<PieceType, BufferedImage> images = new HashMap<>();

    public static void load() {
        try {
            images.put(PieceType.TREE, ImageIO.read(new File("assets/tree.png")));
            images.put(PieceType.LARGE, ImageIO.read(new File("assets/snowball_large.png")));
            images.put(PieceType.SMALL, ImageIO.read(new File("assets/snowball_small.png")));
            images.put(PieceType.HEAD, ImageIO.read(new File("assets/head_blue.png")));
            images.put(PieceType.EMPTY, ImageIO.read(new File("assets/hole.png")));
        } catch (Exception e) {
        e.printStackTrace();
        }
    }

    public static BufferedImage get(PieceType type) {
        return images.get(type);
    }
} 
