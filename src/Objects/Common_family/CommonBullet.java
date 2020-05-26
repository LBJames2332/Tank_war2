package Objects.Common_family;

import java.awt.*;
import java.awt.image.BufferedImage;

import MainClasses.TankFrame;
import Mgr.GameModel;
import Objects.AttributeClasses.Dir;
import Objects.AttributeClasses.Group;
import Objects.GameObjs.Bullet;
import MainClasses.ResourceLoader;
public class CommonBullet extends Bullet {
    BufferedImage image;

    public CommonBullet(int x, int y, GameModel gm, boolean isAlive, Dir dir, Group group) {
        super(x, y, gm, isAlive, dir, group);
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
    protected void SetImage(Dir dir) {
        switch (dir){
            case LEFT:
                image = ResourceLoader.getBullet_Left();
                break;
            case RIGHT:
                image = ResourceLoader.getBullet_Right();
                break;
            case UP:
                image = ResourceLoader.getBullet_Up();
                break;
            case DOWN:
                image = ResourceLoader.getBullet_Down();
                break;
            default:
                break;
        }
    }

    @Override
    public int getWidth() {
        return image.getWidth();
    }

    @Override
    public int getHeight() {
        return image.getHeight();
    }

    @Override
    public void paint(Graphics g) {
        if (!isAlive()){
            getGm().getL_bullet().remove(this);
            return;
        }
        move();
        g.drawImage(image,getPos().getX(),getPos().getY(),null);


        if (getPos().getX()<0||getPos().getY()<0||getPos().getX()> TankFrame.getWIDTH()||getPos().getY()> TankFrame.getHEIGHT()){
            setAlive(false);
        }
    }
}
