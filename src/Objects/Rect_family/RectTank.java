package Objects.Rect_family;

import MainClasses.TankFrame;
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
    public RectTank(int x, int y, TankFrame tf, boolean isAlive, Dir dir, boolean isMoving, Group group) {
        super(x, y, tf, isAlive, dir, isMoving, group);
    }



    @Override
    protected void BoundCheck() {
        if (getPos().getX()<0) setPos(0,getPos().getY());
        if (getPos().getX()>getTf().getWidth()-Width) setPos(getTf().getWidth()-Width,getPos().getY());
        if (getPos().getY()<0) setPos(getPos().getX(),0);
        if (getPos().getY()>getTf().getHeight()-Height) setPos(getPos().getX(),getTf().getHeight()-Height);
    }

    @Override
    public void fire(Firer firer) {

        firer.fire(this,getTf().getFactory());
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

            getTf().getL_enemies().remove(this);
            getTf().getL_explod().add(getTf().getFactory().CreateExplod(this.getPos().getX(), this.getPos().getY(), getTf(), false));
            return;
        }
        this.move();
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(super.getPos().getX(),super.getPos().getY(),Width,Height);
        g.setColor(color);
    }

}
