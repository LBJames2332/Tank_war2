package Factory;

import MainClasses.TankFrame;
import Objects.AttributeClasses.Dir;
import Objects.AttributeClasses.Group;
import Objects.GameObjs.Bullet;
import Objects.GameObjs.Explod;
import Objects.GameObjs.Tank;

public abstract class I_Factory {
    public abstract Tank CreateTank(int x, int y, TankFrame tf, boolean isAlive, Dir dir, boolean isMoving, Group group);
    public abstract Bullet CreateBullet(int x, int y, TankFrame tf, boolean isAlive, Dir dir, Group group);
    public abstract Explod CreateExplod(int x, int y, TankFrame tf, boolean isAlive);
}
