import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TankFrame extends Frame{
    int x =100;
    int y =100;
    public TankFrame(){
        System.out.println(111);
        //constructor
        this.setSize(800,600);
        this.setResizable(false);

        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        System.out.println("动起来");
        TankFrame t = new TankFrame();
    }

    @Override
    public void paint(Graphics g) {
        //随便画
        g.fillRect(x,y,40,40);
        x+=50;
        y+=50;
        System.out.println("paint");
    }
}
