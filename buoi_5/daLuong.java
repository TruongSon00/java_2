package buoi_5;

public class daLuong {
    public static void main(String[] args) {
        Thread threadCurrent = new Thread();
        System.out.println("Thread Main ---> " + threadCurrent.getName() + threadCurrent.getState());

        Thread t1 = new Thread(new myRunable());
        // myRunable.setPriority(1);
        System.out.println("T 2 priority: " + t1.getPriority());
        System.out.println("T 2 demon? : " + t1.isDaemon());
        t1.start();
        // try {
        // t1.join();
        // } catch (InterruptedException e) {

        // e.printStackTrace();
        // }

        // -------------
        myThread t0 = new myThread(t1);
        System.out.println("T 1 priority: " + t0.getPriority());
        t0.start();
        // try {
        // t0.join();
        // } catch (InterruptedException e) {

        // e.printStackTrace();
        // }

        System.out.println("End Main");

    }
}
