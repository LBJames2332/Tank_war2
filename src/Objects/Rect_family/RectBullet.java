package Objects.Rect_family;

import MainClasses.TankFrame;
import Objects.AttributeClasses.Dir;
import Objects.AttributeClasses.Group;
import Objects.GameObjs.Bullet;

import java.awt.*;
import java.awt.image.BufferedImage;

public class RectBullet extends Bullet {
    int Width=20;
    int Height=20;

    public RectBullet(int x, int y, TankFrame tf, boolean isAlive, Dir dir, Group group) {
        super(x, y, tf, isAlive, dir, group);
    }
    @Override
    protected void move() {
        switch (getDir()){
            case LEFT:
                getPos().setX(getPos().getX()-getSPEED());
                break;
            case RIGHT:
                getPos().setX(getPos().getX()+getSPEED());
                break;
            case UP:
                getPos().setY(getPos().getY()-getSPEED());
                break;
            case DOWN:
                getPos().setY(getPos().getY()+getSPEED());
                break;
            default:
                break;
        }
    }

    @Override
    public int getWidth() {
        return Width;
    }

    @Override
    public int getHeight() {
        return Height;
    }

    @Override
    public void paint(Graphics g) {
        if (!isAlive()){
            getTf().getL_bullet().remove(this);
            return;
        }
        move();
        Color color = g.getColor();
        g.setColor(Color.WHITE);
        g.fillRect(getPos().getX(),getPos().getY(),Width,Height);
        g.setColor(color);

        if (getPos().getX()<0||getPos().getY()<0||getPos().getX()> TankFrame.getWIDTH()||getPos().getY()> TankFrame.getHEIGHT()){
            setAlive(false);
        }
    }
}
