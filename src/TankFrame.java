import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TankFrame extends Frame{
    public TankFrame(){
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
        TankFrame t = new TankFrame();
    }

    @Override
    public void paint(Graphics g) {
        //随便画
        g.fillRect(200,100,40,40);
        System.out.println("paint");
    }
}
