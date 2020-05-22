package Objects.GameObjs;

import Objects.AttributeClasses.Dir;
import Objects.AttributeClasses.Group;
import MainClasses.TankFrame;

public abstract class Bullet extends I_MovingGameObj {

    public Bullet(int x, int y, TankFrame tf, boolean isAlive, Dir dir, Group group) {
        super(x, y, tf, isAlive, dir, group);
        //SetImage(dir);
        super.setSPEED(10);
    }
}
