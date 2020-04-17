import java.awt.*;
import java.awt.event.*;

public class TankFrame extends Frame{
    int x =100;
    int y =100;
    public TankFrame(){
        //constructor
        this.setSize(800,600);
        this.setResizable(false);

        this.setVisible(true);
        this.addKeyListener(new TankFrameLisener());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    public static void main(String[] args) {
        TankFrame t = new TankFrame();
        while (true){
            try {
                Thread.sleep(2000);
                t.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void paint(Graphics g) {
        //随便画
        g.fillRect(x,y,40,40);

    }
    class TankFrameLisener extends KeyAdapter{
        //键盘监听
        @Override
        public void keyPressed(KeyEvent e) {

            x+=1;
            //repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //System.out.println("key released");
        }
    }
}
