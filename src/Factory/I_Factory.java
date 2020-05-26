package Factory;

import MainClasses.TankFrame;
import Mgr.Collider;
import Mgr.GameModel;
import Objects.AttributeClasses.Dir;
import Objects.AttributeClasses.Group;
import Objects.GameObjs.Bullet;
import Objects.GameObjs.Explod;
import Objects.GameObjs.Tank;

public abstract class I_Factory {
    protected Collider TankTankcollider;
    protected Collider BulletTankcollider;

    public Collider getTankTankcollider() {
        return TankTankcollider;
    }

    public Collider getBulletTankcollider() {
        return BulletTankcollider;
    }

    public I_Factory(Collider tankTankcollider, Collider bulletTankcollider) {
        TankTankcollider = tankTankcollider;
        BulletTankcollider = bulletTankcollider;
    }

    public abstract Tank CreateTank(int x, int y, GameModel gm, boolean isAlive, Dir dir, boolean isMoving, Group group);
    public abstract Bullet CreateBullet(int x, int y, GameModel gm, boolean isAlive, Dir dir, Group group);
    public abstract Explod CreateExplod(int x, int y, GameModel gm, boolean isAlive);
}
