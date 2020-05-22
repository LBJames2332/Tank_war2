package Objects.Rect_family;

import MainClasses.TankFrame;
import Objects.GameObjs.Explod;

import java.awt.*;

public class RectExplod extends Explod {
    int Width=5;
    int Height=5;
    @Override
    public int getWidth() {
        return Width;
    }

    @Override
    public int getHeight() {
        return Height;
    }

    public RectExplod(int x, int y, TankFrame tf, boolean isAlive) {
        super(x, y, tf, isAlive);
    }

    @Override
    public void paint(Graphics g) {
        if (!super.isAlive()) {
            Color color = g.getColor();
            g.setColor(Color.CYAN);
            g.fillRect(super.getPos().getX(),super.getPos().getY(),step*Width,(step++)*Height);
            g.setColor(color);
        }
        if (step >= 16) super.getTf().getL_explod().remove(this);
    }
}
