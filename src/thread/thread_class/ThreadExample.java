package thread_class;

public class ThreadExample extends Thread {
    
    @Override
    public void run() {
        int i = 1;
        while(i <= 100) {
            System.out.println(i + " " + this.getName());
            i++;
        }
    }


    public static void main(String[] args) {

        ThreadExample thread1 = new ThreadExample();
        thread1.setName("My first thread");
        thread1.start();

        ThreadExample thread2 = new ThreadExample();
        thread2.setName("My second thread");
        thread2.start();

    }
}
