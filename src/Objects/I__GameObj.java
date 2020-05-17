package Objects;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public abstract class I__GameObj {
    private Position pos = new Position();
    private TankFrame tf = null;
    private BufferedImage image;
    private boolean isAlive = true;

    public I__GameObj(int x,int y, TankFrame tf, boolean isAlive) {
        this.pos.setX(x);
        this.pos.setY(y);
        this.tf = tf;
        this.isAlive = isAlive;
    }

    public TankFrame getTf() {
        return tf;
    }

    public void setTf(TankFrame tf) {
        this.tf = tf;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(int x,int y) {
        this.pos.setX(x);
        this.pos.setY(y);

    }

    public abstract void paint(Graphics g);


}
