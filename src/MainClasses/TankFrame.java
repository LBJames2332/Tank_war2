package MainClasses;

import Mgr.GameModel;
import Objects.Common_family.CommonFactory;
import Factory.I_Factory;
import Objects.AttributeClasses.Dir;
import Objects.AttributeClasses.Group;
import Objects.FirerStrategy.TankFirer_4dir;
import Objects.GameObjs.Bullet;
import Objects.GameObjs.Explod;
import Objects.GameObjs.Tank;
import Objects.Rect_family.RectFactory;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame{
    static final int WIDTH = 800;
    static final int HEIGHT = 600;


    private GameModel gameModel = new GameModel(WIDTH,HEIGHT);




    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }



    public TankFrame() {

        //constructor
        this.setSize(WIDTH, HEIGHT);
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
        this.gameModel.paint(g);
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
                    gameModel.getMyTank().fire(new TankFirer_4dir());
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
            if (!bL&&!bR&&!bU&&!bD) gameModel.getMyTank().setMoving(false);
            else {
                gameModel.getMyTank().setMoving(true);
                if (bL) gameModel.getMyTank().setDir(Dir.LEFT);
                if (bR)  gameModel.getMyTank().setDir(Dir.RIGHT);
                if (bU) gameModel.getMyTank().setDir(Dir.UP);
                if (bD) gameModel.getMyTank().setDir(Dir.DOWN);

            }

        }


    }
    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        /**
         * 取消闪烁
         */
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
