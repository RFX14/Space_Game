public class Application {
    public static void main(String[] args) {
        boolean run = true;
        Thread t1 = new Thread(new Menu());
        
        t1.start();

        while(run) {
            if(Menu.getClose()) {
                run = false;
                Menu.frame.dispose();
            }
        }
        new Game().run();
    }
}