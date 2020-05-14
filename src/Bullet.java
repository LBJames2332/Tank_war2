import java.awt.*;

public class Bullet {
    private Position pos = new Position();
    private static  final int SPEED = 10;
    private Dir dir;
    private boolean isLiving = true;
    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Bullet(int x, int y, Dir dir) {
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

    public boolean isLiving() {
        return isLiving;
    }

    public void setLiving(boolean living) {
        isLiving = living;
    }

    public void paint(Graphics g) {
        if (isLiving){
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
        }
        if (pos.getX()<0||pos.getY()<0||pos.getX()>TankFrame.WIDTH||pos.getY()>TankFrame.HEIGHT){
            isLiving = false;
        }
        g.setColor(Color.orange);
        g.fillOval(pos.getX(),pos.getY(),30,30);
    }
}