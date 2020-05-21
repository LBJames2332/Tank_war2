package Factory;

import MainClasses.TankFrame;
import Objects.AttributeClasses.Dir;
import Objects.AttributeClasses.Group;
import Objects.GameObjs.Bullet;
import Objects.GameObjs.Explod;
import Objects.GameObjs.Tank;

public class RectFactory extends I_Factory{


    @Override
    public Tank CreateTank(int x, int y, TankFrame tf, boolean isAlive, Dir dir, boolean isMoving, Group group) {
        return null;
    }

    @Override
    public Bullet CreateBullet(int x, int y, TankFrame tf, boolean isAlive, Dir dir, Group group) {
        return null;
    }

    @Override
    public Explod CreateExplod(int x, int y, TankFrame tf, boolean isAlive) {
        return null;
    }
}
