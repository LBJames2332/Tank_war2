public class Main {
    public static void main(String[] args) {
        TankFrame tankFrame = new TankFrame();
        for (int i = 0; i < 5; i++) {
            tankFrame.l_enemies.add(new Tank(50+i*60,200,Dir.DOWN,tankFrame,Group.BAD));
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
