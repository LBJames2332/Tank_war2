import com.sun.javafx.scene.traversal.Direction;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import jdk.nashorn.internal.ir.IfNode;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TankFrame extends Frame{
    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    private Tank myTank = new Tank(100,400,Dir.DOWN,this,Group.GOOD);
    List<Bullet> l_bullet = new ArrayList<>();
    List<Tank> l_enemies = new ArrayList<>();
    List<Explod> l_explod = new ArrayList<>();
    public TankFrame(){
        //constructor
        this.setSize(WIDTH,HEIGHT);
        this.setResizable(false);

        this.setVisible(true);
        this.addKeyListener(new TankKeyLisener());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        //随便画
        Color color = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("B_Num:"+l_bullet.size(),10,60);
        g.drawString("E_Num:"+l_enemies.size(),10,90);
        g.drawString("Boom_Num:"+l_explod.size(),10,120);
        g.setColor(color);
        myTank.paint(g);
        for (int i = 0; i < l_explod.size(); i++) {
            l_explod.get(i).paint(g);
        }
        for (int i = 0; i < l_enemies.size(); i++) {
            l_enemies.get(i).paint(g);
        }
        for (int i = 0; i < l_bullet.size(); i++) {
            l_bullet.get(i).paint(g);
            //if (!l_bullet.get(i).isLiving())l_bullet.remove(i);
        }
        for (int i = 0; i < l_enemies.size(); i++) {
            for (int j = 0; j < l_bullet.size(); j++) {
                l_enemies.get(i).Boom(l_bullet.get(j));
            }
        }
    }
    class TankKeyLisener extends KeyAdapter{
        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                    break;
                default:
                    break;

            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;

            }
            setMainTankDir();

        }

        public void setMainTankDir(){
            if (!bL&&!bR&&!bU&&!bD) myTank.setMoving(false);
            else {
                myTank.setMoving(true);
                if (bL) myTank.setDir(Dir.LEFT);
                if (bR)  myTank.setDir(Dir.RIGHT);
                if (bU) myTank.setDir(Dir.UP);
                if (bD) myTank.setDir(Dir.DOWN);

            }

        }
        /**
         * 取消闪烁
         */

    }
    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage==null){
            offScreenImage = this.createImage(WIDTH,HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color color = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0,0,WIDTH,HEIGHT);
        gOffScreen.setColor(color);
        paint(gOffScreen);
        g.drawImage(offScreenImage,0,0,null);
    }
}
