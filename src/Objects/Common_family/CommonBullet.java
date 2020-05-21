package Objects.Common_family;

import java.awt.*;

import MainClasses.TankFrame;
import Objects.AttributeClasses.Dir;
import Objects.AttributeClasses.Group;
import Objects.GameObjs.Bullet;
import MainClasses.ResourceLoader;
public class CommonBullet extends Bullet {


    public CommonBullet(int x, int y, TankFrame tf, boolean isAlive, Dir dir, Group group) {
        super(x, y, tf, isAlive, dir, group);
    }
    @Override
    protected void move() {
        switch (getDir()){
            case LEFT:
                getPos().setX(getPos().getX()-getSPEED());
                break;
            case RIGHT:
                getPos().setX(getPos().getX()+getSPEED());
                break;
            case UP:
                getPos().setY(getPos().getY()-getSPEED());
                break;
            case DOWN:
                getPos().setY(getPos().getY()+getSPEED());
                break;
            default:
                break;
        }
    }

    @Override
    protected void SetImage(Dir dir) {
        switch (dir){
            case LEFT:
                setImage(ResourceLoader.getBullet_Left());
                break;
            case RIGHT:
                setImage(ResourceLoader.getBullet_Right());
                break;
            case UP:
                setImage(ResourceLoader.getBullet_Up());
                break;
            case DOWN:
                setImage(ResourceLoader.getBullet_Down());
                break;
            default:
                break;
        }
    }

    @Override
    public void paint(Graphics g) {
        if (!isAlive()){
            getTf().getL_bullet().remove(this);
            return;
        }
        move();
        switch (getDir()){
            case LEFT:
                g.drawImage(getImage(),getPos().getX(),getPos().getY(),null);
                break;
            case RIGHT:
                g.drawImage(getImage(),getPos().getX(),getPos().getY(),null);
                break;
            case UP:
                g.drawImage(getImage(),getPos().getX(),getPos().getY(),null);
                break;
            case DOWN:
                g.drawImage(getImage(),getPos().getX(),getPos().getY(),null);
                break;
            default:
                break;
        }

        if (getPos().getX()<0||getPos().getY()<0||getPos().getX()> TankFrame.getWIDTH()||getPos().getY()> TankFrame.getHEIGHT()){
            setAlive(false);
        }
    }
}
