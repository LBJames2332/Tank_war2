package Objects.Common_family;

import MainClasses.ResourceLoader;
import MainClasses.TankFrame;
import Mgr.GameModel;
import Objects.AttributeClasses.Dir;
import Objects.AttributeClasses.Group;
import Objects.FirerStrategy.Firer;
import Objects.FirerStrategy.TankFirer1;
import Objects.GameObjs.Bullet;
import Objects.GameObjs.Tank;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CommonTank extends Tank {
    BufferedImage image;

    public CommonTank(int x, int y, GameModel gm, boolean isAlive, Dir dir, boolean isMoving, Group group) {
        super(x, y, gm, isAlive, dir, isMoving, group);
    }



    @Override
    protected void BoundCheck() {
        if (getPos().getX()<0) setPos(0,getPos().getY());
        if (getPos().getX()>getGm().getWidth()-image.getWidth()) setPos(getGm().getWidth()-image.getWidth(),getPos().getY());
        if (getPos().getY()<0) setPos(getPos().getX(),0);
        if (getPos().getY()>getGm().getHeight()-image.getHeight()) setPos(getPos().getX(),getGm().getHeight()-image.getHeight());
    }

    @Override
    public void fire(Firer firer) {

        firer.fire(this,getGm().getFactory());
    }

    @Override
    public void Boom(Bullet bullet) {
        if (bullet.getGroup().equals(getGroup())) return;
        setRec();
        bullet.setRec();
        if (this.getRec().intersects(bullet.getRec())){
            setAlive(false);
            bullet.setAlive(false);
        }
    }

    @Override
    protected void move() {
        if (isMoving()) {
            switch (getDir()) {
                case LEFT:
                    getPos().setX(getPos().getX() - getSPEED());
                    break;
                case RIGHT:
                    getPos().setX(getPos().getX() + getSPEED());
                    break;
                case UP:
                    getPos().setY(getPos().getY() - getSPEED());
                    break;
                case DOWN:
                    getPos().setY(getPos().getY() + getSPEED());
                    break;
                default:
                    break;
            }
            if (getGroup() == Group.BAD && new Random().nextInt(10) > 8) {
                this.fire(new TankFirer1());

                setDir(Dir.values()[new Random().nextInt(4)]);
            }
            ;
            BoundCheck();
        }
    }
    protected void SetImage(Dir dir) {
        switch (dir){

            case LEFT:
                image = ResourceLoader.getTank_Left();
                break;
            case RIGHT:
                image = ResourceLoader.getTank_Right();
                break;
            case UP:
                image = ResourceLoader.getTank_Up();
                break;
            case DOWN:
                image = ResourceLoader.getTank_Down();
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
        if (!isAlive())  {

            getGm().getL_enemies().remove(this);
            getGm().getL_explod().add(new CommonExplod(this.getPos().getX(),this.getPos().getY(),getGm(),false));
            return;
        }
        SetImage(super.getDir());
        this.move();

        g.drawImage(image,super.getPos().getX(),super.getPos().getY(),null);

    }

}
