import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HospitalMain {

    private static Scanner scanner = new Scanner(System.in);

    // Required Data Structures
    private static PatientBST patientBST = new PatientBST();
    private static EmergencyQueue emergencyQueue = new EmergencyQueue(100);
    private static TreatmentStack treatmentStack = new TreatmentStack(100);

    // Each patient has their own visit history
    private static Map<Integer, VisitLinkedList> visitHistories = new HashMap<>();

    public static void main(String[] args) {

        int choice;

        System.out.println("==============================================");
        System.out.println(" MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM");
        System.out.println("==============================================");

        do {

            displayMenu();

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    registerPatient();
                    break;

                case 2:
                    searchPatient();
                    break;

                case 3:
                    deletePatient();
                    break;

                case 4:
                    displayAllPatients();
                    break;

                case 5:
                    enqueuePatient();
                    break;

                case 6:
                    dequeuePatient();
                    break;

                case 7:
                    displayEmergencyQueue();
                    break;

                case 8:
                    addTreatment();
                    break;

                case 9:
                    popTreatment();
                    break;

                case 10:
                    displayTreatmentHistory();
                    break;

                case 11:
                    addVisit();
                    break;

                case 12:
                    removeVisit();
                    break;

                case 13:
                    searchVisit();
                    break;

                case 14:
                    displayVisitHistory();
                    break;

                case 0:
                    System.out.println("\nThank you for using the system.");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }

    // ==========================================
    // MAIN MENU
    // ==========================================

    private static void displayMenu() {

        System.out.println("\n============== MAIN MENU ==============");

        System.out.println("1. Register New Patient");
        System.out.println("2. Search Patient");
        System.out.println("3. Delete Patient");
        System.out.println("4. Display All Patients");

        System.out.println("\n----- Emergency Queue -----");
        System.out.println("5. Add Patient to Emergency Queue");
        System.out.println("6. Treat Next Emergency Patient");
        System.out.println("7. Display Waiting Patients");

        System.out.println("\n----- Treatment Stack -----");
        System.out.println("8. Complete Treatment / Push");
        System.out.println("9. Remove Latest Treatment / Pop");
        System.out.println("10. Display Treatment History");

        System.out.println("\n----- Patient Visit History -----");
        System.out.println("11. Add Patient Visit");
        System.out.println("12. Remove Patient Visit");
        System.out.println("13. Search Patient Visit");
        System.out.println("14. Display Patient Visit History");

        System.out.println("\n0. Exit");

        System.out.println("========================================");
    }

    // ==========================================
    // 1. REGISTER PATIENT - BST INSERT
    // ==========================================

    private static void registerPatient() {

        System.out.println("\n===== REGISTER NEW PATIENT =====");

        int patientId = readInt("Enter Patient ID: ");

        // Check duplicate ID
        if (patientBST.search(patientId) != null) {

            System.out.println("Patient ID already exists.");

            return;
        }

        String name = readString("Enter Patient Name: ");

        int age = readInt("Enter Age: ");

        String contact = readString("Enter Contact Number: ");

        String condition = readString("Enter Medical Condition: ");

        Patient patient = new Patient(
                patientId,
                name,
                age,
                contact,
                condition
        );

        patientBST.insert(patient);

        // Create an empty visit history for the patient
        visitHistories.put(
                patientId,
                new VisitLinkedList()
        );

        System.out.println("Patient registered successfully.");
    }

    // ==========================================
    // 2. SEARCH PATIENT - BST SEARCH
    // ==========================================

    private static void searchPatient() {

        System.out.println("\n===== SEARCH PATIENT =====");

        int patientId = readInt("Enter Patient ID: ");

        Patient patient = patientBST.search(patientId);

        if (patient == null) {

            System.out.println("Patient not found.");

        } else {

            System.out.println("\nPatient found:");
            System.out.println(patient);
        }
    }

    // ==========================================
    // 3. DELETE PATIENT - BST DELETE
    // ==========================================

    private static void deletePatient() {

        System.out.println("\n===== DELETE PATIENT =====");

        int patientId = readInt("Enter Patient ID: ");

        if (patientBST.search(patientId) == null) {

            System.out.println("Patient not found.");

            return;
        }

        patientBST.delete(patientId);

        // Remove patient's visit history
        visitHistories.remove(patientId);
    }

    // ==========================================
    // 4. DISPLAY PATIENTS - BST INORDER
    // ==========================================

    private static void displayAllPatients() {

        System.out.println("\n===== ALL PATIENTS =====");

        patientBST.displayInOrder();
    }

    // ==========================================
    // 5. ENQUEUE PATIENT
    // ==========================================

    private static void enqueuePatient() {

        System.out.println("\n===== ADD TO EMERGENCY QUEUE =====");

        int patientId = readInt("Enter Patient ID: ");

        Patient patient = patientBST.search(patientId);

        if (patient == null) {

            System.out.println(
                    "Patient not found. Register the patient first."
            );

            return;
        }

        emergencyQueue.enqueue(patient);
    }

    // ==========================================
    // 6. DEQUEUE PATIENT
    // ==========================================

    private static void dequeuePatient() {

        System.out.println("\n===== TREAT NEXT EMERGENCY PATIENT =====");

        Patient patient = emergencyQueue.dequeue();

        if (patient != null) {

            System.out.println(
                    "Now treating: " +
                    patient.getPatientName()
            );

            System.out.println(
                    "Patient ID: " +
                    patient.getPatientId()
            );
        }
    }

    // ==========================================
    // 7. DISPLAY QUEUE
    // ==========================================

    private static void displayEmergencyQueue() {

        emergencyQueue.displayQueue();
    }

    // ==========================================
    // 8. PUSH TREATMENT
    // ==========================================

    private static void addTreatment() {

        System.out.println("\n===== COMPLETE TREATMENT =====");

        int patientId = readInt("Enter Patient ID: ");

        Patient patient = patientBST.search(patientId);

        if (patient == null) {

            System.out.println("Patient not found.");

            return;
        }

        String doctorName =
                readString("Enter Doctor Name: ");

        String treatment =
                readString("Enter Treatment: ");

        String date =
                readString("Enter Treatment Date: ");

        TreatmentRecord record =
                new TreatmentRecord(
                        patient.getPatientId(),
                        patient.getPatientName(),
                        doctorName,
                        treatment,
                        date
                );

        treatmentStack.push(record);
    }

    // ==========================================
    // 9. POP TREATMENT
    // ==========================================

    private static void popTreatment() {

        System.out.println("\n===== REMOVE LATEST TREATMENT =====");

        TreatmentRecord record = treatmentStack.pop();

        if (record != null) {

            System.out.println("Removed record:");
            System.out.println(record);
        }
    }

    // ==========================================
    // 10. DISPLAY STACK
    // ==========================================

    private static void displayTreatmentHistory() {

        treatmentStack.displayStack();
    }

    // ==========================================
    // 11. ADD VISIT - LINKED LIST
    // ==========================================

    private static void addVisit() {

        System.out.println("\n===== ADD PATIENT VISIT =====");

        int patientId = readInt("Enter Patient ID: ");

        Patient patient = patientBST.search(patientId);

        if (patient == null) {

            System.out.println("Patient not found.");

            return;
        }

        int visitId = readInt("Enter Visit ID: ");

        String date =
                readString("Enter Visit Date: ");

        String doctor =
                readString("Enter Doctor Name: ");

        String diagnosis =
                readString("Enter Diagnosis: ");

        String treatment =
                readString("Enter Treatment: ");

        Visit visit = new Visit(
                visitId,
                date,
                doctor,
                diagnosis,
                treatment
        );

        VisitLinkedList history =
                visitHistories.get(patientId);

        history.addVisit(visit);

        System.out.println("Visit added successfully.");
    }

    // ==========================================
    // 12. REMOVE VISIT
    // ==========================================

    private static void removeVisit() {

        System.out.println("\n===== REMOVE PATIENT VISIT =====");

        int patientId = readInt("Enter Patient ID: ");

        Patient patient = patientBST.search(patientId);

        if (patient == null) {

            System.out.println("Patient not found.");

            return;
        }

        int visitId = readInt("Enter Visit ID to remove: ");

        VisitLinkedList history =
                visitHistories.get(patientId);

        boolean removed =
                history.removeVisit(visitId);

        if (removed) {

            System.out.println("Visit removed successfully.");

        } else {

            System.out.println("Visit not found.");
        }
    }

    // ==========================================
    // 13. SEARCH VISIT
    // ==========================================

    private static void searchVisit() {

        System.out.println("\n===== SEARCH PATIENT VISIT =====");

        int patientId = readInt("Enter Patient ID: ");

        Patient patient = patientBST.search(patientId);

        if (patient == null) {

            System.out.println("Patient not found.");

            return;
        }

        int visitId = readInt("Enter Visit ID to search: ");

        VisitLinkedList history =
                visitHistories.get(patientId);

        Visit visit =
                history.searchVisit(visitId);

        if (visit == null) {

            System.out.println("Visit not found.");

        } else {

            System.out.println("\nVisit found:");
            System.out.println(visit);
        }
    }

    // ==========================================
    // 14. DISPLAY VISIT HISTORY
    // ==========================================

    private static void displayVisitHistory() {

        System.out.println("\n===== PATIENT VISIT HISTORY =====");

        int patientId = readInt("Enter Patient ID: ");

        Patient patient = patientBST.search(patientId);

        if (patient == null) {

            System.out.println("Patient not found.");

            return;
        }

        VisitLinkedList history =
                visitHistories.get(patientId);

        history.displayVisits();
    }

    // ==========================================
    // INPUT METHODS
    // ==========================================

    private static int readInt(String message) {

        while (true) {

            System.out.print(message);

            try {

                return Integer.parseInt(
                        scanner.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }

    private static String readString(String message) {

        System.out.print(message);

        return scanner.nextLine();
    }
}