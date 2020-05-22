package Objects.FirerStrategy;

import Objects.AttributeClasses.Dir;
import Objects.Common_family.CommonBullet;
import Objects.FirerStrategy.Firer;
import Objects.GameObjs.Bullet;
import Objects.GameObjs.Tank;

public class TankFirer_4dir implements Firer {
    @Override
    public void fire(Tank tank) {
        int x,y;
        Bullet[] bullets = new Bullet[Dir.values().length];
        for (int i = 0; i < bullets.length; i++) {
            bullets[i] = new CommonBullet(tank.getPos().getX(),tank.getPos().getY(),tank.getTf(),true, Dir.values()[i],tank.getGroup());
        }

        switch (tank.getDir()){
            case LEFT:
                for (Bullet bullet:bullets){
                    bullet.setPos(tank.getPos().getX()-bullet.getWidth(),
                            tank.getPos().getY()+(tank.getHeight()>>1)-(bullet.getHeight()>>1));
                    tank.getTf().getL_bullet().add(bullet);
                }

                break;
            case RIGHT:
                for (Bullet bullet:bullets){
                    bullet.setPos(tank.getPos().getX()+tank.getWidth(),
                            tank.getPos().getY()+(tank.getHeight()>>1)-(bullet.getHeight()>>1));
                    tank.getTf().getL_bullet().add(bullet);
                }


                break;
            case UP:
                for (Bullet bullet:bullets){
                    bullet.setPos(tank.getPos().getX()+(tank.getWidth()>>1)-(bullet.getWidth()>>1),
                            tank.getPos().getY()-bullet.getHeight());
                    tank.getTf().getL_bullet().add(bullet);
                }

                break;
            case DOWN:
                for (Bullet bullet:bullets){
                    bullet.setPos(tank.getPos().getX()+(tank.getWidth()>>1)-(bullet.getWidth()>>1),
                            tank.getPos().getY()+tank.getHeight());
                    tank.getTf().getL_bullet().add(bullet);
                }
                break;
            default:
                break;
        }


    }
}
