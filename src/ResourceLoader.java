import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceLoader {
    static BufferedImage Tank_Left;
    static BufferedImage Tank_Right;
    static BufferedImage Tank_Up;
    static BufferedImage Tank_Down;
    static {


        try {
            Tank_Left = ImageIO.read(ResourceLoader.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            Tank_Right = ImageIO.read(ResourceLoader.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            Tank_Up = ImageIO.read(ResourceLoader.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            Tank_Down = ImageIO.read(ResourceLoader.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //loadImage(Tank_Left,"images/tankL.gif");
    }
//    static void loadImage(Image image, String sourcePath){
//        try {
//            image = ImageIO.read(ResourceLoader.class.getClassLoader().getResourceAsStream(sourcePath));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
