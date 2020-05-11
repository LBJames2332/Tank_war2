import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

import java.awt.*;

public class Tank {
    private Position pos = new Position();
    private static  final int SPEED = 10;
    private Dir dir;

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Tank(int x, int y, Dir dir) {
        this.pos.setX(x);
        this.pos.setY(y);
        this.dir = dir;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(int x,int y) {
        this.pos.setX(x);
        this.pos.setY(y);

    }

    public void paint(Graphics g) {

        switch (dir){
            case LEFT:
                pos.setX(pos.getX()-SPEED);
                break;
            case RIGHT:
                pos.setX(pos.getX()+SPEED);
                break;
            case UP:
                pos.setY(pos.getY()-SPEED);
                break;
            case DOWN:
                pos.setY(pos.getY()+SPEED);
                break;
            default:
                break;
        }
        g.fillRect(pos.getX(),pos.getY(),40,40);
    }
    class Position{
        int x;
        int y;


        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}