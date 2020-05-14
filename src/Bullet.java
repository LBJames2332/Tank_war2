import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet {
    private Position pos = new Position();
    private static  final int SPEED = 10;
    private Dir dir;
    private boolean isLiving = true;
    private BufferedImage BULLET_image;

    public BufferedImage getBULLET_image() {
        return BULLET_image;
    }

    public void setBULLET_image(BufferedImage BULLET_image) {
        this.BULLET_image = BULLET_image;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
        SetImage(dir);
    }

    public Bullet(int x, int y, Dir dir) {
        this.pos.setX(x);
        this.pos.setY(y);
        this.dir = dir;
        SetImage(dir);
    }

    private void SetImage(Dir dir) {
        switch (dir){
            case LEFT:
                BULLET_image = ResourceLoader.Bullet_Left;
                break;
            case RIGHT:
                BULLET_image = ResourceLoader.Bullet_Right;
                break;
            case UP:
                BULLET_image = ResourceLoader.Bullet_Up;
                break;
            case DOWN:
                BULLET_image = ResourceLoader.Bullet_Down;
                break;
            default:
                break;
        }
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
                    g.drawImage(BULLET_image,pos.getX(),pos.getY(),null);
                    //g.fillOval(pos.getX(),pos.getY(),30,30);
                    break;
                case RIGHT:
                    pos.setX(pos.getX()+SPEED);
                    g.drawImage(BULLET_image,pos.getX(),pos.getY(),null);
                    break;
                case UP:
                    pos.setY(pos.getY()-SPEED);
                    g.drawImage(BULLET_image,pos.getX(),pos.getY(),null);
                    break;
                case DOWN:
                    pos.setY(pos.getY()+SPEED);
                    g.drawImage(BULLET_image,pos.getX(),pos.getY(),null);
                    break;
                default:
                    break;
            }
        }
        if (pos.getX()<0||pos.getY()<0||pos.getX()>TankFrame.WIDTH||pos.getY()>TankFrame.HEIGHT){
            isLiving = false;
        }
        //g.setColor(Color.orange);

    }
}
