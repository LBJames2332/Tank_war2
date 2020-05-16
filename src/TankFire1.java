class TankFirer1 implements Firer{

    @Override
    public void fire(Tank tank) {
        switch (tank.getDir()){
            case LEFT:
                Bullet bulletl = new Bullet(tank.getPos().getX(),tank.getPos().getY(),tank.getDir(),tank.getTf(),tank.getGroup());
                bulletl.setPos(tank.getPos().getX()-bulletl.getBULLET_image().getWidth(),
                    tank.getPos().getY()+(tank.getTANK_image().getHeight()>>1)-(bulletl.getBULLET_image().getHeight()>>1));
                tank.getTf().l_bullet.add(bulletl);
                break;
            case RIGHT:
                Bullet bulletr = new Bullet(tank.getPos().getX(),tank.getPos().getY(),tank.getDir(),tank.getTf(),tank.getGroup());
                bulletr.setPos(tank.getPos().getX()+tank.getTANK_image().getWidth(),
                    tank.getPos().getY()+(tank.getTANK_image().getHeight()>>1)-(bulletr.getBULLET_image().getHeight()>>1));

                tank.getTf().l_bullet.add(bulletr);
                break;
            case UP:
                Bullet bulletu = new Bullet(tank.getPos().getX(),tank.getPos().getY(),tank.getDir(),tank.getTf(),tank.getGroup());
                bulletu.setPos(tank.getPos().getX()+(tank.getTANK_image().getWidth()>>1)-(bulletu.getBULLET_image().getWidth()>>1),
                    tank.getPos().getY()-bulletu.getBULLET_image().getHeight());
                tank.getTf().l_bullet.add(bulletu);
                break;
            case DOWN:
                Bullet bulletd = new Bullet(tank.getPos().getX(),tank.getPos().getY(),tank.getDir(),tank.getTf(),tank.getGroup());
                bulletd.setPos(tank.getPos().getX()+(tank.getTANK_image().getWidth()>>1)-(bulletd.getBULLET_image().getWidth()>>1),
                    tank.getPos().getY()+tank.getTANK_image().getHeight());

                tank.getTf().l_bullet.add(bulletd);
                break;
            default:
                break;
        }
    }
}