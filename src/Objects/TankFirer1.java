package Objects;

public class TankFirer1 implements Firer{

    @Override
    public void fire(Tank tank) {
        switch (tank.getDir()){
            case LEFT:
                Bullet bulletl = new Bullet(tank.getPos().getX(),tank.getPos().getY(),tank.getTf(),true,tank.getDir(),tank.getGroup());
                bulletl.setPos(tank.getPos().getX()-bulletl.getImage().getWidth(),
                    tank.getPos().getY()+(tank.getImage().getHeight()>>1)-(bulletl.getImage().getHeight()>>1));
                tank.getTf().l_bullet.add(bulletl);
                break;
            case RIGHT:
                Bullet bulletr = new Bullet(tank.getPos().getX(),tank.getPos().getY(),tank.getTf(),true,tank.getDir(),tank.getGroup());
                bulletr.setPos(tank.getPos().getX()+tank.getImage().getWidth(),
                    tank.getPos().getY()+(tank.getImage().getHeight()>>1)-(bulletr.getImage().getHeight()>>1));

                tank.getTf().l_bullet.add(bulletr);
                break;
            case UP:
                Bullet bulletu = new Bullet(tank.getPos().getX(),tank.getPos().getY(),tank.getTf(),true,tank.getDir(),tank.getGroup());
                bulletu.setPos(tank.getPos().getX()+(tank.getImage().getWidth()>>1)-(bulletu.getImage().getWidth()>>1),
                    tank.getPos().getY()-bulletu.getImage().getHeight());
                tank.getTf().l_bullet.add(bulletu);
                break;
            case DOWN:
                Bullet bulletd = new Bullet(tank.getPos().getX(),tank.getPos().getY(),tank.getTf(),true,tank.getDir(),tank.getGroup());
                bulletd.setPos(tank.getPos().getX()+(tank.getImage().getWidth()>>1)-(bulletd.getImage().getWidth()>>1),
                    tank.getPos().getY()+tank.getImage().getHeight());

                tank.getTf().l_bullet.add(bulletd);
                break;
            default:
                break;
        }
    }
}