package Objects.GameObjs;


import Objects.AttributeClasses.Dir;
import Objects.AttributeClasses.Group;
import MainClasses.TankFrame;

public abstract class I_MovingGameObj extends I__GameObj{
    private int SPEED;
    private Dir dir;
    private Group group;

    public Group getGroup() {
        return group;
    }

    public I_MovingGameObj(int x, int y, TankFrame tf, boolean isAlive, Dir dir, Group group) {

        super(x, y, tf, isAlive);
        this.dir = dir;
        this.group = group;
    }

    public int getSPEED() {
        return SPEED;
    }

    public void setSPEED(int SPEED) {
        this.SPEED = SPEED;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    protected abstract void move();
}
