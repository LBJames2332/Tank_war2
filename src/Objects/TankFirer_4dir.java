package Objects;

class TankFirer_4dir implements Firer {
    @Override
    public void fire(Tank tank) {
        int x,y;
        Bullet[] bullets = new Bullet[Dir.values().length];
        for (int i = 0; i < bullets.length; i++) {
            bullets[i] = new Bullet(tank.getPos().getX(),tank.getPos().getY(),tank.getTf(),true, Dir.values()[i],tank.getGroup());
        }

        switch (tank.getDir()){
            case LEFT:
                for (Bullet bullet:bullets){
                    bullet.setPos(tank.getPos().getX()-bullet.getImage().getWidth(),
                            tank.getPos().getY()+(tank.getImage().getHeight()>>1)-(bullet.getImage().getHeight()>>1));
                    tank.getTf().l_bullet.add(bullet);
                }

                break;
            case RIGHT:
                for (Bullet bullet:bullets){
                    bullet.setPos(tank.getPos().getX()+tank.getImage().getWidth(),
                            tank.getPos().getY()+(tank.getImage().getHeight()>>1)-(bullet.getImage().getHeight()>>1));
                    tank.getTf().l_bullet.add(bullet);
                }


                break;
            case UP:
                for (Bullet bullet:bullets){
                    bullet.setPos(tank.getPos().getX()+(tank.getImage().getWidth()>>1)-(bullet.getImage().getWidth()>>1),
                            tank.getPos().getY()-bullet.getImage().getHeight());
                    tank.getTf().l_bullet.add(bullet);
                }

                break;
            case DOWN:
                for (Bullet bullet:bullets){
                    bullet.setPos(tank.getPos().getX()+(tank.getImage().getWidth()>>1)-(bullet.getImage().getWidth()>>1),
                            tank.getPos().getY()+tank.getImage().getHeight());
                    tank.getTf().l_bullet.add(bullet);
                }
                break;
            default:
                break;
        }


    }
}