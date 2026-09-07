public class PatientBST {

    // Node used by the Binary Search Tree
    private class Node {

        Patient patient;
        Node left;
        Node right;

        Node(Patient patient) {
            this.patient = patient;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    // Constructor
    public PatientBST() {
        root = null;
    }

    // =========================
    // INSERT PATIENT
    // =========================
    public void insert(Patient patient) {

        if (patient == null) {
            System.out.println("Patient cannot be null.");
            return;
        }

        root = insertRecursive(root, patient);
    }

    private Node insertRecursive(Node current, Patient patient) {

        // Empty position found
        if (current == null) {
            return new Node(patient);
        }

        // Compare Patient IDs
        if (patient.getPatientId() < current.patient.getPatientId()) {

            current.left = insertRecursive(current.left, patient);

        } else if (patient.getPatientId() > current.patient.getPatientId()) {

            current.right = insertRecursive(current.right, patient);

        } else {

            // Duplicate Patient ID
            System.out.println(
                    "Patient ID " + patient.getPatientId()
                            + " already exists."
            );
        }

        return current;
    }

    // =========================
    // SEARCH PATIENT
    // =========================
    public Patient search(int patientId) {

        Node result = searchRecursive(root, patientId);

        if (result != null) {
            return result.patient;
        }

        return null;
    }

    private Node searchRecursive(Node current, int patientId) {

        // Patient not found
        if (current == null) {
            return null;
        }

        // Patient found
        if (patientId == current.patient.getPatientId()) {
            return current;
        }

        // Search left subtree
        if (patientId < current.patient.getPatientId()) {
            return searchRecursive(current.left, patientId);
        }

        // Search right subtree
        return searchRecursive(current.right, patientId);
    }

    // =========================
    // DELETE PATIENT
    // =========================
    public void delete(int patientId) {

        if (search(patientId) == null) {
            System.out.println(
                    "Patient ID " + patientId + " not found."
            );
            return;
        }

        root = deleteRecursive(root, patientId);

        System.out.println(
                "Patient ID " + patientId + " deleted successfully."
        );
    }

    private Node deleteRecursive(Node current, int patientId) {

        if (current == null) {
            return null;
        }

        // Search left subtree
        if (patientId < current.patient.getPatientId()) {

            current.left = deleteRecursive(current.left, patientId);

        }

        // Search right subtree
        else if (patientId > current.patient.getPatientId()) {

            current.right = deleteRecursive(current.right, patientId);

        }

        // Patient found
        else {

            // Case 1: No child
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: Only right child
            if (current.left == null) {
                return current.right;
            }

            // Case 3: Only left child
            if (current.right == null) {
                return current.left;
            }

            // Case 4: Two children
            Node successor = findMinimum(current.right);

            current.patient = successor.patient;

            current.right = deleteRecursive(
                    current.right,
                    successor.patient.getPatientId()
            );
        }

        return current;
    }

    // Find the smallest node in a subtree
    private Node findMinimum(Node current) {

        Node currentNode = current;

        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }

        return currentNode;
    }

    // =========================
    // IN-ORDER TRAVERSAL
    // =========================
    public void displayInOrder() {

        if (root == null) {
            System.out.println("No patients registered.");
            return;
        }

        System.out.println("\nPatients in ascending Patient ID:");

        inOrderRecursive(root);
    }

    private void inOrderRecursive(Node current) {

        if (current != null) {

            // Left
            inOrderRecursive(current.left);

            // Root
            System.out.println(current.patient);

            // Right
            inOrderRecursive(current.right);
        }
    }
}