package Objects.FirerStrategy;

import Factory.I_Factory;
import Objects.AttributeClasses.Dir;
import Objects.Common_family.CommonBullet;
import Objects.FirerStrategy.Firer;
import Objects.GameObjs.Bullet;
import Objects.GameObjs.Tank;

public class TankFirer_4dir implements Firer {
    @Override
    public void fire(Tank tank, I_Factory factory) {
        int x,y;
        Bullet[] bullets = new Bullet[Dir.values().length];
        for (int i = 0; i < bullets.length; i++) {
            bullets[i] = factory.CreateBullet(tank.getPos().getX(),tank.getPos().getY(),tank.getGm(),true, Dir.values()[i],tank.getGroup());
        }

        switch (tank.getDir()){
            case LEFT:
                for (Bullet bullet:bullets){
                    bullet.setPos(tank.getPos().getX()-bullet.getWidth(),
                            tank.getPos().getY()+(tank.getHeight()>>1)-(bullet.getHeight()>>1));
                    tank.getGm().getL_obj().add(bullet);
                }

                break;
            case RIGHT:
                for (Bullet bullet:bullets){
                    bullet.setPos(tank.getPos().getX()+tank.getWidth(),
                            tank.getPos().getY()+(tank.getHeight()>>1)-(bullet.getHeight()>>1));
                    tank.getGm().getL_obj().add(bullet);
                }


                break;
            case UP:
                for (Bullet bullet:bullets){
                    bullet.setPos(tank.getPos().getX()+(tank.getWidth()>>1)-(bullet.getWidth()>>1),
                            tank.getPos().getY()-bullet.getHeight());
                    tank.getGm().getL_obj().add(bullet);
                }

                break;
            case DOWN:
                for (Bullet bullet:bullets){
                    bullet.setPos(tank.getPos().getX()+(tank.getWidth()>>1)-(bullet.getWidth()>>1),
                            tank.getPos().getY()+tank.getHeight());
                    tank.getGm().getL_obj().add(bullet);
                }
                break;
            default:
                break;
        }


    }
}
