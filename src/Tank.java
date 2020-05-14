import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;
import jdk.nashorn.internal.ir.ThrowNode;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tank {
    private Position pos = new Position();
    private static  final int SPEED = 5;
    private Dir dir;
    private boolean isMoving;
    private TankFrame tf = null;
    private BufferedImage TANK_image;
    public BufferedImage getTANK_image() {
        return TANK_image;
    }

    public void setTANK_image(BufferedImage TANK_image) {
        this.TANK_image = TANK_image;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Tank(int x, int y, Dir dir,TankFrame tf,BufferedImage TANK_image) {
        this.pos.setX(x);
        this.pos.setY(y);
        this.dir = dir;
        this.tf = tf;
        this.TANK_image = TANK_image;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(int x,int y) {
        this.pos.setX(x);
        this.pos.setY(y);

    }

    public void paint(Graphics g) {

        this.move();
        //g.setColor(Color.WHITE);
        g.drawImage(this.TANK_image,pos.getX(),pos.getY(),null);
        ////g.fillRect(pos.getX(),pos.getY(),40,40);
    }

    private void move() {
        if (isMoving){
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
    }

    public void fire() {
        tf.l_bullet.add(new Bullet(pos.getX(),pos.getY(),dir));

    }
}
