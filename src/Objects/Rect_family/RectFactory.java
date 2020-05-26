package Objects.Rect_family;

import Factory.I_Factory;
import MainClasses.TankFrame;
import Mgr.Collider;
import Mgr.GameModel;
import Objects.AttributeClasses.Dir;
import Objects.AttributeClasses.Group;
import Objects.GameObjs.Bullet;
import Objects.GameObjs.Explod;
import Objects.GameObjs.Tank;

public class RectFactory extends I_Factory {


    public RectFactory(Collider tankTankcollider, Collider bulletTankcollider) {
        super(tankTankcollider, bulletTankcollider);
    }

    @Override
    public Tank CreateTank(int x, int y, GameModel gm, boolean isAlive, Dir dir, boolean isMoving, Group group) {
        return new RectTank(x,y ,gm,isAlive,dir,isMoving,group);
    }

    @Override
    public Bullet CreateBullet(int x, int y, GameModel gm, boolean isAlive, Dir dir, Group group) {
        return new RectBullet(x,y ,gm,isAlive,dir,group);
    }

    @Override
    public Explod CreateExplod(int x, int y, GameModel gm, boolean isAlive) {
        return new RectExplod(x,y ,gm,isAlive);
    }
}
