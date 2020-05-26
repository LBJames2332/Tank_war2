package Objects.GameObjs;

import Mgr.GameModel;
import Objects.AttributeClasses.Dir;
import Objects.AttributeClasses.Group;
import MainClasses.TankFrame;

public abstract class Bullet extends I_MovingGameObj {

    public Bullet(int x, int y, GameModel gm, boolean isAlive, Dir dir, Group group) {
        super(x, y, gm, isAlive, dir, group);
        //SetImage(dir);
        super.setSPEED(10);
    }
}
