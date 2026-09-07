

public class TreatmentStack {

    private TreatmentRecord[] stack;
    private int top;

    public TreatmentStack(int capacity) {

        stack = new TreatmentRecord[capacity];

        top = -1;
    }

    // Push
    public void push(TreatmentRecord record) {

        if (top == stack.length - 1) {

            System.out.println("Treatment stack is full.");
            return;
        }

        top++;

        stack[top] = record;

        System.out.println("Treatment record added successfully.");
    }

    // Pop
    public TreatmentRecord pop() {

        if (isEmpty()) {

            System.out.println("Treatment stack is empty.");
            return null;
        }

        TreatmentRecord record = stack[top];

        stack[top] = null;

        top--;

        System.out.println("Most recent treatment removed.");

        return record;
    }

    // Display
    public void displayStack() {

        if (isEmpty()) {

            System.out.println("Treatment stack is empty.");
            return;
        }

        System.out.println("\n===== TREATMENT HISTORY =====");

        for (int i = top; i >= 0; i--) {

            System.out.println(stack[i]);
        }

        System.out.println("=============================\n");
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

