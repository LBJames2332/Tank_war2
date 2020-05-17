package Objects;

import Objects.Position;
import Objects.ResourceLoader;
import Objects.TankFrame;

import java.awt.*;

public class Explod extends I__GameObj{
    int step = 0;

    public Explod(int x, int y, TankFrame tf, boolean isAlive) {
        super(x, y, tf, isAlive);
    }


    public Position getPos() {
        return super.getPos();
    }

    public void setPos(int x,int y) {
        super.setPos(x,y);
    }

    @Override
    public void paint(Graphics g) {
        if (!super.isAlive()) g.drawImage(ResourceLoader.Boom[this.step++],super.getPos().getX(),super.getPos().getY(),null);
        if (step >= 16) super.getTf().l_explod.remove(this);
    }
}
