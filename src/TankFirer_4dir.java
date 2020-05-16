class TankFirer_4dir implements Firer {
    @Override
    public void fire(Tank tank) {
        int x,y;
        Bullet[] bullets = new Bullet[Dir.values().length];
        for (int i = 0; i < bullets.length; i++) {
            bullets[i] = new Bullet(tank.getPos().getX(),tank.getPos().getY(), Dir.values()[i],tank.getTf(),tank.getGroup());
        }

        switch (tank.getDir()){
            case LEFT:
                for (Bullet bullet:bullets){
                    bullet.setPos(tank.getPos().getX()-bullet.getBULLET_image().getWidth(),
                            tank.getPos().getY()+(tank.getTANK_image().getHeight()>>1)-(bullet.getBULLET_image().getHeight()>>1));
                    tank.getTf().l_bullet.add(bullet);
                }

                break;
            case RIGHT:
                for (Bullet bullet:bullets){
                    bullet.setPos(tank.getPos().getX()+tank.getTANK_image().getWidth(),
                            tank.getPos().getY()+(tank.getTANK_image().getHeight()>>1)-(bullet.getBULLET_image().getHeight()>>1));
                    tank.getTf().l_bullet.add(bullet);
                }


                break;
            case UP:
                for (Bullet bullet:bullets){
                    bullet.setPos(tank.getPos().getX()+(tank.getTANK_image().getWidth()>>1)-(bullet.getBULLET_image().getWidth()>>1),
                            tank.getPos().getY()-bullet.getBULLET_image().getHeight());
                    tank.getTf().l_bullet.add(bullet);
                }

                break;
            case DOWN:
                for (Bullet bullet:bullets){
                    bullet.setPos(tank.getPos().getX()+(tank.getTANK_image().getWidth()>>1)-(bullet.getBULLET_image().getWidth()>>1),
                            tank.getPos().getY()+tank.getTANK_image().getHeight());
                    tank.getTf().l_bullet.add(bullet);
                }
                break;
            default:
                break;
        }


    }
}
