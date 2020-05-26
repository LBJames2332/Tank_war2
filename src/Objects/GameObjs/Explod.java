package Objects.GameObjs;

import MainClasses.TankFrame;
import Mgr.GameModel;

public abstract class Explod extends I__GameObj {
    protected int step = 0;

    public Explod(int x, int y, GameModel gm, boolean isAlive) {
        super(x, y, gm, isAlive);
    }
}
