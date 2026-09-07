public class HospitalMain {

    public static void main(String[] args) {

        // Create the Binary Search Tree
        PatientBST patientBST = new PatientBST();

        // Create patients
        Patient patient1 = new Patient(
                1003,
                "Ahmed",
                30,
                "0771234567",
                "Fever"
        );

        Patient patient2 = new Patient(
                1001,
                "Mohamed",
                25,
                "0772345678",
                "Headache"
        );

        Patient patient3 = new Patient(
                1005,
                "Fathima",
                28,
                "0773456789",
                "Asthma"
        );

        Patient patient4 = new Patient(
                1002,
                "Aisha",
                22,
                "0774567890",
                "Cold"
        );

        Patient patient5 = new Patient(
                1004,
                "Ibrahim",
                35,
                "0775678901",
                "Diabetes"
        );

        // Insert patients into BST
        System.out.println("Adding patients...\n");

        patientBST.insert(patient1);
        patientBST.insert(patient2);
        patientBST.insert(patient3);
        patientBST.insert(patient4);
        patientBST.insert(patient5);

        // Display patients using in-order traversal
        patientBST.displayInOrder();

        // =========================
        // SEARCH TEST
        // =========================

        System.out.println("\nSearching for Patient ID 1002...");

        Patient foundPatient = patientBST.search(1002);

        if (foundPatient != null) {
            System.out.println("Patient found:");
            System.out.println(foundPatient);
        } else {
            System.out.println("Patient not found.");
        }

        // =========================
        // DELETE TEST
        // =========================

        System.out.println("\nDeleting Patient ID 1003...");

        patientBST.delete(1003);

        // Display BST after deletion
        patientBST.displayInOrder();
    }
}