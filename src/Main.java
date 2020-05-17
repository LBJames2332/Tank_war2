import Objects.Dir;
import Objects.Group;
import Objects.Tank;
import Objects.TankFrame;

public class Main {
    public static void main(String[] args) {
        TankFrame tankFrame = new TankFrame();
        int inialCount = Integer.parseInt((String)PropertyMgr.get("ECountInit"));
        for (int i = 0; i < inialCount; i++) {
            tankFrame.l_enemies.add(new Tank(50+i*60,200,tankFrame,true, Dir.DOWN,true, Group.BAD));
        }
        Thread t = new Thread(()->{
            while (true){
                try {
                    Thread.sleep(10);
                    tankFrame.repaint();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}
