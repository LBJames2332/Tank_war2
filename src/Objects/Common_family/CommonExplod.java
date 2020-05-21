package Objects.Common_family;

import Objects.GameObjs.Explod;
import MainClasses.ResourceLoader;
import MainClasses.TankFrame;

import java.awt.*;

public class CommonExplod extends Explod {
    public CommonExplod(int x, int y, TankFrame tf, boolean isAlive) {
        super(x, y, tf, isAlive);
    }

    @Override
    public void paint(Graphics g) {
        if (!super.isAlive()) g.drawImage(ResourceLoader.getBoom()[this.step++],super.getPos().getX(),super.getPos().getY(),null);
        if (step >= 16) super.getTf().getL_explod().remove(this);
    }
}
