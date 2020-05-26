package Objects.GameObjs;


import MainClasses.TankFrame;
import Mgr.GameModel;
import Objects.AttributeClasses.Dir;
import Objects.AttributeClasses.Group;
import Objects.FirerStrategy.Firer;

public abstract class Tank extends I_MovingGameObj {

    private boolean isMoving;

    public Tank(int x, int y, GameModel gm, boolean isAlive, Dir dir, boolean isMoving, Group group) {

        super(x, y, gm, isAlive, dir, group);
        this.isMoving = isMoving;
        super.setSPEED(5);
    }

    public boolean isMoving() {
        return this.isMoving;
    }

    public void setMoving(boolean moving) {
        this.isMoving = moving;
    }

    protected abstract void BoundCheck();

    public abstract void fire(Firer firer);

    public abstract void Boom(Bullet bullet);

}