package Objects;


import java.awt.*;
import java.util.Random;

public class Tank extends I_MovingGameObj{

    private boolean isMoving;

    public Tank(int x, int y, TankFrame tf, boolean isAlive, Dir dir, boolean isMoving, Group group) {

        super(x, y, tf, isAlive, dir, group);
        this.isMoving = isMoving;
        super.setSPEED(5);
    }

    public boolean isMoving() {
        return this.isMoving;
    }

    public void setMoving(boolean moving) {
        this.isMoving = moving;
    }

    @Override
    protected void move() {
        if (isMoving()){
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
            if (getGroup()==Group.BAD&&new Random().nextInt(10)>8) {
                this.fire(new TankFirer1());

                setDir(Dir.values()[new Random().nextInt(4)]);
            }
            ;
            BoundCheck();



        }
    }

    @Override
    protected void SetImage(Dir dir) {
        switch (dir){

            case LEFT:
                setImage(ResourceLoader.Tank_Left);
                break;
            case RIGHT:
                setImage(ResourceLoader.Tank_Right);
                break;
            case UP:
                setImage(ResourceLoader.Tank_Up);
                break;
            case DOWN:
                setImage(ResourceLoader.Tank_Down);
                break;
            default:
                break;
        }
    }

    @Override
    public void paint(Graphics g) {
        if (!isAlive())  {

            getTf().l_enemies.remove(this);
            getTf().l_explod.add(new Explod(this.getPos().getX(),this.getPos().getY(),getTf(),false));
            return;
        }
        SetImage(super.getDir());
        this.move();

        g.drawImage(super.getImage(),super.getPos().getX(),super.getPos().getY(),null);
    }

    private void BoundCheck() {
        if (getPos().getX()<0) setPos(0,getPos().getY());
        if (getPos().getX()>getTf().getWidth()-getImage().getWidth()) setPos(getTf().getWidth()-getImage().getWidth(),getPos().getY());
        if (getPos().getY()<0) setPos(getPos().getX(),0);
        if (getPos().getY()>getTf().getHeight()-getImage().getHeight()) setPos(getPos().getX(),getTf().getHeight()-getImage().getHeight());
    }

    public void fire(Firer firer) {
        firer.fire(this);

    }

    public void Boom(Bullet bullet) {
        if (bullet.getGroup().equals(getGroup())) return;
        Rectangle rec_tank = new Rectangle(getPos().getX(),getPos().getY(),getImage().getWidth(),getImage().getHeight());
        Rectangle rec_buillet = new Rectangle(bullet.getPos().getX(),bullet.getPos().getY()
                ,bullet.getImage().getWidth(),bullet.getImage().getHeight());
        if (rec_tank.intersects(rec_buillet)){
            setAlive(false);
            bullet.setAlive(false);
        }

    }

}
