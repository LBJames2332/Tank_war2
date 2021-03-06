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
    static BufferedImage Bullet_Left;
    static BufferedImage Bullet_Right;
    static BufferedImage Bullet_Up;
    static BufferedImage Bullet_Down;
    static BufferedImage[] Boom = new BufferedImage[16];
    static {


        try {
            Tank_Left = ImageIO.read(ResourceLoader.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            Tank_Right = ImageIO.read(ResourceLoader.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            Tank_Up = ImageIO.read(ResourceLoader.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            Tank_Down = ImageIO.read(ResourceLoader.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
            Bullet_Left = ImageIO.read(ResourceLoader.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            Bullet_Right = ImageIO.read(ResourceLoader.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
            Bullet_Up = ImageIO.read(ResourceLoader.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            Bullet_Down = ImageIO.read(ResourceLoader.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            for (int i = 0; i < Boom.length; i++) {
                Boom[i] = ImageIO.read(ResourceLoader.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
            }
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
