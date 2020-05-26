package Objects.Rect_family;

import MainClasses.TankFrame;
import Mgr.GameModel;
import Objects.AttributeClasses.Dir;
import Objects.AttributeClasses.Group;
import Objects.Common_family.CommonExplod;
import Objects.FirerStrategy.Firer;
import Objects.FirerStrategy.TankFirer1;
import Objects.GameObjs.Bullet;
import Objects.GameObjs.Tank;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class RectTank extends Tank {
    int Width=50;
    int Height=50;
    public RectTank(int x, int y, GameModel gm, boolean isAlive, Dir dir, boolean isMoving, Group group) {
        super(x, y, gm, isAlive, dir, isMoving, group);
    }



    @Override
    protected void BoundCheck() {
        if (getPos().getX()<0) setPos(0,getPos().getY());
        if (getPos().getX()>getGm().getWidth()-Width) setPos(getGm().getWidth()-Width,getPos().getY());
        if (getPos().getY()<0) setPos(getPos().getX(),0);
        if (getPos().getY()>getGm().getHeight()-Height) setPos(getPos().getX(),getGm().getHeight()-Height);
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

    @Override
    public int getWidth() {
        return Width;
    }

    @Override
    public int getHeight() {
        return Height;
    }

    @Override
    public void paint(Graphics g) {
        if (!isAlive())  {

            getGm().getL_obj().remove(this);
            getGm().getL_obj().add(getGm().getFactory().CreateExplod(this.getPos().getX(), this.getPos().getY(), getGm(), false));
            return;
        }
        this.move();
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(super.getPos().getX(),super.getPos().getY(),Width,Height);
        g.setColor(color);
    }

}
