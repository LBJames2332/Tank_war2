package Objects.GameObjs;

import Objects.AttributeClasses.Position;
import MainClasses.TankFrame;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class I__GameObj {
    private Position pos = new Position();
    private TankFrame tf = null;
    private BufferedImage image;
    private boolean isAlive = true;
    private Rectangle rec;

    public Rectangle getRec() {
        return rec;
    }

    public void setRec() {
        this.rec.x = pos.getX();
        this.rec.y = pos.getY();
        this.rec.height = image.getHeight();
        this.rec.width = image.getWidth();
    }

    public I__GameObj(int x, int y, TankFrame tf, boolean isAlive) {
        this.pos.setX(x);
        this.pos.setY(y);
        this.tf = tf;
        this.isAlive = isAlive;
        rec = new Rectangle(x,y,0,0);
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
