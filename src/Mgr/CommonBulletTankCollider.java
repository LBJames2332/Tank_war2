package Mgr;

import Objects.Common_family.CommonBullet;
import Objects.Common_family.CommonTank;
import Objects.GameObjs.Bullet;
import Objects.GameObjs.I__GameObj;
import Objects.GameObjs.Tank;

public class CommonBulletTankCollider implements Collider {
    @Override
    public void Colldie(I__GameObj o1, I__GameObj o2) {
        if (o1 instanceof CommonBullet && o2 instanceof CommonTank){
            ((CommonTank) o2).Boom((Bullet) o1);
            return;
        }
        if (o1 instanceof CommonTank &&o2 instanceof CommonBullet){
            ((CommonTank) o1).Boom((Bullet) o2);
            return;
        }
    }
}
