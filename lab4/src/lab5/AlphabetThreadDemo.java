package lab5;

import java.util.Random;

class RandomAlphabetPrinter extends Thread {
    private volatile boolean running = true;

    @Override
    public void run() {
        Random random = new Random();

        try {
            for (int i = 0; i < 26; i++) { // Loop to print 26 alphabets
                char randomChar = (char) ('A' + random.nextInt(26)); // Generate a random character from A-Z
                System.out.print(randomChar + " ");

                // Sleep for a random time between 100ms and 500ms
                int sleepTime = random.nextInt(400);
                Thread.sleep(sleepTime);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }

    public void stopThread() {
        running = false;
    }
}

public class AlphabetThreadDemo {
    public static void main(String[] args) {
        RandomAlphabetPrinter printer = new RandomAlphabetPrinter();
        
        System.out.println("Starting thread to print random alphabets...");
        printer.start();

        try {
            // Let the thread run for a while before stopping (optional demonstration)
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread Interrupted! ");
    }
}
