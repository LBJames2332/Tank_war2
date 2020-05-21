package Factory;

import Objects.AttributeClasses.Dir;
import Objects.AttributeClasses.Group;
import Objects.Common_family.CommonBullet;
import Objects.Common_family.CommonExplod;
import Objects.Common_family.CommonTank;
import Objects.GameObjs.Bullet;
import Objects.GameObjs.Explod;
import Objects.GameObjs.Tank;
import MainClasses.TankFrame;
public class CommonFactory extends I_Factory{
    @Override
    public Tank CreateTank(int x, int y, TankFrame tf, boolean isAlive, Dir dir, boolean isMoving, Group group) {
        return new CommonTank(x,y,tf,isAlive,dir,isMoving,group);
    }

    @Override
    public Bullet CreateBullet(int x, int y, TankFrame tf, boolean isAlive, Dir dir, Group group) {
        return new CommonBullet(x,y,tf,isAlive,dir,group);
    }

    @Override
    public Explod CreateExplod(int x, int y, TankFrame tf, boolean isAlive) {
        return new CommonExplod(x,y,tf,isAlive);
    }
}
