public class VisitLinkedList {

    private VisitNode head;

    // Add a visit
    public void addVisit(Visit visit) {

        VisitNode newNode = new VisitNode(visit);

        if (head == null) {

            head = newNode;
            return;
        }

        VisitNode current = head;

        while (current.next != null) {

            current = current.next;
        }

        current.next = newNode;
    }

    // Remove a visit
    public boolean removeVisit(int visitId) {

        if (head == null) {

            return false;
        }

        if (head.visit.getVisitId() == visitId) {

            head = head.next;

            return true;
        }

        VisitNode current = head;

        while (current.next != null) {

            if (current.next.visit.getVisitId() == visitId) {

                current.next = current.next.next;

                return true;
            }

            current = current.next;
        }

        return false;
    }

    // Search visit
    public Visit searchVisit(int visitId) {

        VisitNode current = head;

        while (current != null) {

            if (current.visit.getVisitId() == visitId) {

                return current.visit;
            }

            current = current.next;
        }

        return null;
    }

    // Display visits
    public void displayVisits() {

        if (head == null) {

            System.out.println("No visit history found.");

            return;
        }

        System.out.println("\n===== PATIENT VISIT HISTORY =====");

        VisitNode current = head;

        while (current != null) {

            System.out.println(current.visit);

            current = current.next;
        }

        System.out.println("=================================\n");
    }
}

