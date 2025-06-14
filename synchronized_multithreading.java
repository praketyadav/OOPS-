class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getValue() {
        return count;
    }
}

class Worker extends Thread {
    private Counter counter;

    public Worker(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Worker t1 = new Worker(counter);
        Worker t2 = new Worker(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        System.out.println("Final counter value: " + counter.getValue());
    }
}
