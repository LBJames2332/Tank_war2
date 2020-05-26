package Objects.FirerStrategy;

import Factory.I_Factory;
import Objects.AttributeClasses.Dir;
import Objects.Common_family.CommonBullet;
import Objects.FirerStrategy.Firer;
import Objects.GameObjs.Bullet;
import Objects.GameObjs.Tank;

public class TankFirer1 implements Firer {

    @Override
    public void fire(Tank tank, I_Factory factory) {
        switch (tank.getDir()){
            case LEFT:
                Bullet bulletl = factory.CreateBullet(tank.getPos().getX(),tank.getPos().getY(),tank.getGm(),true,tank.getDir(),tank.getGroup());
                bulletl.setPos(tank.getPos().getX()-bulletl.getWidth(),
                    tank.getPos().getY()+(tank.getHeight()>>1)-(bulletl.getHeight()>>1));
                tank.getGm().getL_bullet().add(bulletl);
                break;
            case RIGHT:
                Bullet bulletr = factory.CreateBullet(tank.getPos().getX(),tank.getPos().getY(),tank.getGm(),true,tank.getDir(),tank.getGroup());
                bulletr.setPos(tank.getPos().getX()+tank.getWidth(),
                    tank.getPos().getY()+(tank.getHeight()>>1)-(bulletr.getHeight()>>1));

                tank.getGm().getL_bullet().add(bulletr);
                break;
            case UP:
                Bullet bulletu = factory.CreateBullet(tank.getPos().getX(),tank.getPos().getY(),tank.getGm(),true,tank.getDir(),tank.getGroup());

                bulletu.setPos(tank.getPos().getX()+(tank.getWidth()>>1)-(bulletu.getWidth()>>1),
                    tank.getPos().getY()-bulletu.getHeight());
                tank.getGm().getL_bullet().add(bulletu);
                break;
            case DOWN:
                Bullet bulletd = factory.CreateBullet(tank.getPos().getX(),tank.getPos().getY(),tank.getGm(),true,tank.getDir(),tank.getGroup());
                bulletd.setPos(tank.getPos().getX()+(tank.getWidth()>>1)-(bulletd.getWidth()>>1),
                    tank.getPos().getY()+tank.getHeight());

                tank.getGm().getL_bullet().add(bulletd);
                break;
            default:
                break;
        }
    }
}