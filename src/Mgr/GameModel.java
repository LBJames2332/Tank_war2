package Mgr;

import Factory.I_Factory;
import MainClasses.PropertyMgr;
import Objects.AttributeClasses.Dir;
import Objects.AttributeClasses.Group;
import Objects.GameObjs.Bullet;
import Objects.GameObjs.Explod;
import Objects.GameObjs.I__GameObj;
import Objects.GameObjs.Tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
    //facede+
    private int Width;
    private int Height;
    private List<I__GameObj> l_obj = new ArrayList<>();
//    private List<Bullet> l_bullet = new ArrayList<>();
//    private List<Tank> l_enemies = new ArrayList<>();
//    private List<Explod> l_explod = new ArrayList<>();
    private Tank myTank;
    private I_Factory factory;
    public I_Factory getFactory() {
        return factory;
    }
//    public List<Bullet> getL_bullet() {
//        return l_bullet;
//    }
//
//    public List<Tank> getL_enemies() {
//        return l_enemies;
//    }
//
//    public List<Explod> getL_explod() {
//        return l_explod;
//    }

    public List<I__GameObj> getL_obj() {
        return l_obj;
    }

    public GameModel(int width, int height) {
        String style_factory = (String) PropertyMgr.get("Factory");
        try {
            factory = (I_Factory) Class.forName(style_factory).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        myTank = factory.CreateTank(100, 400, this, true, Dir.DOWN, true, Group.GOOD);
        int inialCount = Integer.parseInt((String) PropertyMgr.get("ECountInit"));
        for (int i = 0; i < inialCount; i++) {
            this.l_obj.add(factory.CreateTank(50 + i * 60, 200, this, true, Dir.DOWN, false, Group.BAD));
        }
        this.Width = width;
        this.Height = height;
    }

    public int getWidth() {
        return Width;
    }

    public int getHeight() {
        return Height;
    }

    public Tank getMyTank() {
        return myTank;
    }

    public void paint(Graphics g) {
        //随便画
        Color color = g.getColor();
//        g.setColor(Color.WHITE);
//        g.drawString("B_Num:"+l_bullet.size(),10,60);
//        g.drawString("E_Num:"+l_enemies.size(),10,90);
//        g.drawString("Boom_Num:"+l_explod.size(),10,120);
//        g.setColor(color);
        System.out.println(l_obj.size());
        myTank.paint(g);
        for (int i = 0; i < l_obj.size(); i++) {
            l_obj.get(i).paint(g);
        }
//        for (int i = 0; i < l_enemies.size(); i++) {
//            l_enemies.get(i).paint(g);
//        }
//        for (int i = 0; i < l_bullet.size(); i++) {
//            l_bullet.get(i).paint(g);
//            //if (!l_bullet.get(i).isLiving())l_bullet.remove(i);
//        }
        for (int i = 0; i < l_obj.size(); i++) {
            for (int j = i+1; i < l_obj.size(); i++) {
                factory.getBulletTankcollider().Colldie(l_obj.get(i),l_obj.get(j));
                factory.getTankTankcollider().Colldie(l_obj.get(i),l_obj.get(j));
            }
        }

    }
}
