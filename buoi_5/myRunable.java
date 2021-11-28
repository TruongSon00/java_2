package buoi_5;

public class myRunable implements Runnable {

    @Override
    public void run() {
        System.out.println("Begin thread 2");
        for (int i = 0; i < 100; i++) {
            System.out.println("Thread: " + i);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
        System.out.println("End thread 2");
    }

}
