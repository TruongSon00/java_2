package buoi_5;

public class myThread extends Thread {
    Thread oThread;

    public myThread(Thread oThread) {
        this.oThread = oThread;
    }

    @Override
    public void run() {
        // if (oThread != null)
        // try {
        // oThread.join();
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        System.out.println("Begin thread 1");
        for (int i = -100; i < 0; i++) {
            System.out.println("Thread: " + i);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("End thread 1");

    }

}
