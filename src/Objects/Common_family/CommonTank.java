package Objects.Common_family;

import MainClasses.ResourceLoader;
import MainClasses.TankFrame;
import Objects.AttributeClasses.Dir;
import Objects.AttributeClasses.Group;
import Objects.FirerStrategy.Firer;
import Objects.FirerStrategy.TankFirer1;
import Objects.GameObjs.Bullet;
import Objects.GameObjs.Tank;

import java.awt.*;
import java.util.Random;

public class CommonTank extends Tank {
    public CommonTank(int x, int y, TankFrame tf, boolean isAlive, Dir dir, boolean isMoving, Group group) {
        super(x, y, tf, isAlive, dir, isMoving, group);
    }

    @Override
    protected void BoundCheck() {
        if (getPos().getX()<0) setPos(0,getPos().getY());
        if (getPos().getX()>getTf().getWidth()-getImage().getWidth()) setPos(getTf().getWidth()-getImage().getWidth(),getPos().getY());
        if (getPos().getY()<0) setPos(getPos().getX(),0);
        if (getPos().getY()>getTf().getHeight()-getImage().getHeight()) setPos(getPos().getX(),getTf().getHeight()-getImage().getHeight());
    }

    @Override
    public void fire(Firer firer) {

        firer.fire(this);
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
    protected void SetImage(Dir dir) {
        switch (dir){

            case LEFT:
                setImage(ResourceLoader.getTank_Left());
                break;
            case RIGHT:
                setImage(ResourceLoader.getTank_Right());
                break;
            case UP:
                setImage(ResourceLoader.getTank_Up());
                break;
            case DOWN:
                setImage(ResourceLoader.getTank_Down());
                break;
            default:
                break;
        }
    }

    @Override
    public void paint(Graphics g) {
        if (!isAlive())  {

            getTf().getL_enemies().remove(this);
            getTf().getL_explod().add(new CommonExplod(this.getPos().getX(),this.getPos().getY(),getTf(),false));
            return;
        }
        SetImage(super.getDir());
        this.move();

        g.drawImage(super.getImage(),super.getPos().getX(),super.getPos().getY(),null);

    }

}
