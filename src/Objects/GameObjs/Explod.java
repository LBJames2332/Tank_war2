package Objects.GameObjs;

import MainClasses.TankFrame;

public abstract class Explod extends I__GameObj {
    protected int step = 0;

    public Explod(int x, int y, TankFrame tf, boolean isAlive) {
        super(x, y, tf, isAlive);
    }
}
