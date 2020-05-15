import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;
import javafx.geometry.Pos;
import jdk.nashorn.internal.ir.ThrowNode;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Explod {
    private Position pos = new Position();
    private static  final int SPEED = 1;
    //private TankFrame tf = null;
    int step = 0;

    boolean isAlive = true;

    public Explod(int x, int y) {
        this.pos.setX(x);
        this.pos.setY(y);

    }

    public Position getPos() {
        return pos;
    }

    public void setPos(int x,int y) {
        this.pos.setX(x);
        this.pos.setY(y);

    }

    public void paint(Graphics g) {
        //if (!isAlive)
        g.drawImage(ResourceLoader.Boom[this.step++],this.pos.getX(),this.pos.getY(),null);
        if (step >= 16) step = 0;
    }
}
