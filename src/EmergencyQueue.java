public class EmergencyQueue {

    private Patient[] queue;
    private int front;
    private int rear;
    private int size;

    public EmergencyQueue(int capacity) {

        queue = new Patient[capacity];

        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue
    public void enqueue(Patient patient) {

        if (size == queue.length) {
            System.out.println("Emergency queue is full.");
            return;
        }

        rear = (rear + 1) % queue.length;

        queue[rear] = patient;

        size++;

        System.out.println(
                "Patient " + patient.getPatientId() +
                " added to emergency queue."
        );
    }

    // Dequeue
    public Patient dequeue() {

        if (isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return null;
        }

        Patient patient = queue[front];

        queue[front] = null;

        front = (front + 1) % queue.length;

        size--;

        System.out.println(
                "Patient " + patient.getPatientId() +
                " removed from emergency queue."
        );

        return patient;
    }

    // Display queue
    public void displayQueue() {

        if (isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return;
        }

        System.out.println("\n===== EMERGENCY WAITING QUEUE =====");

        int index = front;

        for (int i = 0; i < size; i++) {

            System.out.println(queue[index]);

            index = (index + 1) % queue.length;
        }

        System.out.println("===================================\n");
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
