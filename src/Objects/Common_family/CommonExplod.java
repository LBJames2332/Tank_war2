package Objects.Common_family;

import Mgr.GameModel;
import Objects.GameObjs.Explod;
import MainClasses.ResourceLoader;

import java.awt.*;

public class CommonExplod extends Explod {
    @Override
    public int getWidth() {
        return ResourceLoader.getBoom()[0].getWidth();
    }

    @Override
    public int getHeight() {
        return ResourceLoader.getBoom()[0].getHeight();
    }

    public CommonExplod(int x, int y, GameModel gm, boolean isAlive) {
        super(x, y, gm, isAlive);
    }

    @Override
    public void paint(Graphics g) {
        if (!super.isAlive()) g.drawImage(ResourceLoader.getBoom()[this.step++],super.getPos().getX(),super.getPos().getY(),null);
        if (step >= 16) super.getGm().getL_obj().remove(this);
    }
}
