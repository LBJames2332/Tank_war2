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
    private Tank myTank;
    private I_Factory factory;
    public I_Factory getFactory() {
        return factory;
    }

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
            this.l_obj.add(factory.CreateTank(50 + i * 60, 200, this, true, Dir.DOWN, true, Group.BAD));
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
        myTank.paint(g);
        for (int i = 0; i < l_obj.size(); i++) {
            l_obj.get(i).paint(g);
        }
        for (int i = 0; i < l_obj.size(); i++) {
            for (int j = i+1; j < l_obj.size();j++) {
                factory.getBulletTankcollider().Colldie(l_obj.get(i),l_obj.get(j));
                factory.getTankTankcollider().Colldie(l_obj.get(i),l_obj.get(j));
            }
        }

    }
}
