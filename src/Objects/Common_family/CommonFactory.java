package Objects.Common_family;

import Factory.I_Factory;
import Mgr.GameModel;
import Objects.AttributeClasses.Dir;
import Objects.AttributeClasses.Group;
import Objects.Common_family.CommonBullet;
import Objects.Common_family.CommonExplod;
import Objects.Common_family.CommonTank;
import Objects.GameObjs.Bullet;
import Objects.GameObjs.Explod;
import Objects.GameObjs.Tank;
import MainClasses.TankFrame;
public class CommonFactory extends I_Factory {
    @Override
    public Tank CreateTank(int x, int y, GameModel gm, boolean isAlive, Dir dir, boolean isMoving, Group group) {
        return new CommonTank(x,y,gm,isAlive,dir,isMoving,group);
    }

    @Override
    public Bullet CreateBullet(int x, int y,GameModel gm, boolean isAlive, Dir dir, Group group) {
        CommonBullet bullet= new CommonBullet(x,y,gm,isAlive,dir,group);
        bullet.SetImage(dir);
        return bullet;
    }

    @Override
    public Explod CreateExplod(int x, int y, GameModel gm, boolean isAlive) {

        return new CommonExplod(x,y,gm,isAlive);
    }
}
