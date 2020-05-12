public class Main {
    public static void main(String[] args) {
        TankFrame tankFrame = new TankFrame();
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
