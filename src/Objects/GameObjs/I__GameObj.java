package Objects.GameObjs;

import Mgr.GameModel;
import Objects.AttributeClasses.Position;

import java.awt.*;

public abstract class I__GameObj {


    private Position pos = new Position();
    private GameModel gm = null;
    //private BufferedImage image;
    private boolean isAlive = true;
    private Rectangle rec;

    public Rectangle getRec() {
        return rec;
    }

    public void setRec() {
        this.rec.x = pos.getX();
        this.rec.y = pos.getY();
        this.rec.height = getHeight();
        this.rec.width = getWidth();
    }

    public abstract int getWidth();

    public abstract int getHeight();

    public I__GameObj(int x, int y, GameModel gm, boolean isAlive) {
        this.pos.setX(x);
        this.pos.setY(y);
        this.gm = gm;
        this.isAlive = isAlive;
        rec = new Rectangle(x,y,0,0);
    }

    public GameModel getGm() {
        return gm;
    }

    public void setGm(GameModel gm) {
        this.gm = gm;
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
