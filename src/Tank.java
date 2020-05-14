import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;
import javafx.geometry.Pos;
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
    private boolean isAlive = true;

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void Boom(Bullet bullet) {
        Rectangle rec_tank = new Rectangle(pos.getX(),pos.getY(),TANK_image.getWidth(),TANK_image.getHeight());
        Rectangle rec_buillet = new Rectangle(bullet.getPos().getX(),bullet.getPos().getY()
                ,bullet.getBULLET_image().getWidth(),bullet.getBULLET_image().getHeight());
        if (rec_tank.intersects(rec_buillet)){
            this.isAlive = false;
            bullet.setLiving(false);
        }

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
        SetImage(dir);
    }

    public Tank(int x, int y, Dir dir,TankFrame tf) {
        this.pos.setX(x);
        this.pos.setY(y);
        this.dir = dir;
        this.tf = tf;
        SetImage(dir);
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(int x,int y) {
        this.pos.setX(x);
        this.pos.setY(y);

    }

    public void paint(Graphics g) {
        if (!isAlive)  return;
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
    private void SetImage(Dir dir) {
        switch (dir){
            case LEFT:
                TANK_image = ResourceLoader.Tank_Left;
                break;
            case RIGHT:
                TANK_image = ResourceLoader.Tank_Right;
                break;
            case UP:
                TANK_image = ResourceLoader.Tank_Up;
                break;
            case DOWN:
                TANK_image = ResourceLoader.Tank_Down;
                break;
            default:
                break;
        }
    }
    public void fire() {
        switch (dir){
            case LEFT:
                Bullet bulletl = new Bullet(pos.getX(),pos.getY(),dir);
                bulletl.setPos(pos.getX()-bulletl.getBULLET_image().getWidth(),
                        pos.getY()+(TANK_image.getHeight()>>1)-(bulletl.getBULLET_image().getHeight()>>1));
                tf.l_bullet.add(bulletl);
                break;
            case RIGHT:
                Bullet bulletr = new Bullet(pos.getX(),pos.getY(),dir);
                bulletr.setPos(pos.getX()+TANK_image.getWidth(),
                        pos.getY()+(TANK_image.getHeight()>>1)-(bulletr.getBULLET_image().getHeight()>>1));

                tf.l_bullet.add(bulletr);
                break;
            case UP:
                Bullet bulletu = new Bullet(pos.getX(),pos.getY(),dir);
                bulletu.setPos(pos.getX()+(TANK_image.getWidth()>>1)-(bulletu.getBULLET_image().getWidth()>>1),
                        pos.getY()-bulletu.getBULLET_image().getHeight());
                tf.l_bullet.add(bulletu);
                break;
            case DOWN:
                Bullet bulletd = new Bullet(pos.getX(),pos.getY(),dir);
                bulletd.setPos(pos.getX()+(TANK_image.getWidth()>>1)-(bulletd.getBULLET_image().getWidth()>>1),
                        pos.getY()+TANK_image.getHeight());

                tf.l_bullet.add(bulletd);
                break;
            default:
                break;
        }
        //tf.l_bullet.add(new Bullet(pos.getX(),pos.getY(),dir));

    }
}
