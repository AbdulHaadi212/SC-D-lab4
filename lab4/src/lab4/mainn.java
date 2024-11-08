package lab4;

class RollNumberTable extends Thread {
    private String rollNumber;

    public RollNumberTable(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    @Override
    public void run() {
        System.out.println("Table for Roll Number: " + rollNumber);
        for (int i = 1; i <= 10; i++) {
            System.out.println(rollNumber + " x " + i + " = " + rollNumber + "-" + i);
            try {
                Thread.sleep(100); // Slight delay to simulate concurrent execution
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }
}

class DateOfBirthTable extends Thread {
    private String dateOfBirth;

    public DateOfBirthTable(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public void run() {
        System.out.println("Table for Date of Birth: " + dateOfBirth);
        for (int i = 1; i <= 10; i++) {
            System.out.println(dateOfBirth + " x " + i + " = " + dateOfBirth + "-" + i);
            try {
                Thread.sleep(100); // Slight delay to simulate concurrent execution
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }
}

public class mainn {
    public static void main(String[] args) {
        RollNumberTable rollNumberThread = new RollNumberTable("2019-SE-092");
        DateOfBirthTable dobThread = new DateOfBirthTable("05-April");

        rollNumberThread.start();
        dobThread.start();
    }
}

