package Mgr;

import Objects.Common_family.CommonBullet;
import Objects.Common_family.CommonTank;
import Objects.GameObjs.I__GameObj;

public class CommonTankTankCollider implements Collider {
    @Override
    public void Colldie(I__GameObj o1, I__GameObj o2) {
        if (o1 instanceof CommonTank && o2 instanceof CommonTank){
            o1.setRec();
            o2.setRec();

            if (o1.getRec().intersects(o2.getRec())){
                ((CommonTank) o1).setMoving(false);
                ((CommonTank) o2).setMoving(false);
            }
        }
    }
}
