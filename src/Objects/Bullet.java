package Objects;

import java.awt.*;

public class Bullet extends I_MovingGameObj{

    public Bullet(int x, int y, TankFrame tf, boolean isAlive, Dir dir, Group group) {
        super(x, y, tf, isAlive, dir, group);
        SetImage(dir);
        super.setSPEED(10);
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
    protected void SetImage(Dir dir) {
        switch (dir){
            case LEFT:
                setImage(ResourceLoader.Bullet_Left);
                break;
            case RIGHT:
                setImage(ResourceLoader.Bullet_Right);
                break;
            case UP:
                setImage(ResourceLoader.Bullet_Up);
                break;
            case DOWN:
                setImage(ResourceLoader.Bullet_Down);
                break;
            default:
                break;
        }
    }

    @Override
    public void paint(Graphics g) {
        if (!isAlive()){
            getTf().l_bullet.remove(this);
            return;
        }
        move();
        switch (getDir()){
            case LEFT:
                g.drawImage(getImage(),getPos().getX(),getPos().getY(),null);
                break;
            case RIGHT:
                g.drawImage(getImage(),getPos().getX(),getPos().getY(),null);
                break;
            case UP:
                g.drawImage(getImage(),getPos().getX(),getPos().getY(),null);
                break;
            case DOWN:
                g.drawImage(getImage(),getPos().getX(),getPos().getY(),null);
                break;
            default:
                break;
        }

        if (getPos().getX()<0||getPos().getY()<0||getPos().getX()>TankFrame.WIDTH||getPos().getY()>TankFrame.HEIGHT){
            setAlive(false);
        }

    }
}
