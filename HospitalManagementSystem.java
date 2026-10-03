import java.util.ArrayList;
import java.util.Scanner;

public class HospitalManagementSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Patient> patients = new ArrayList<>();
    static int nextPatientId = 1;

    static class Patient {
        int id;
        String name;
        int age;
        String gender;
        String disease;
        String phone;

        Patient(int id, String name, int age, String gender,
                String disease, String phone) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.disease = disease;
            this.phone = phone;
        }

        void display() {
            System.out.println("--------------------------------");
            System.out.println("Patient ID : " + id);
            System.out.println("Name       : " + name);
            System.out.println("Age        : " + age);
            System.out.println("Gender     : " + gender);
            System.out.println("Disease    : " + disease);
            System.out.println("Phone      : " + phone);
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n==================================");
            System.out.println("   HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("==================================");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Update Patient");
            System.out.println("5. Delete Patient");
            System.out.println("6. View Doctor Details");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = readInt();

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    viewPatients();
                    break;
                case 3:
                    searchPatient();
                    break;
                case 4:
                    updatePatient();
                    break;
                case 5:
                    deletePatient();
                    break;
                case 6:
                    viewDoctors();
                    break;
                case 0:
                    System.out.println("Thank you for using the system!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        sc.close();
    }

    static int readInt() {
        while (!sc.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            sc.nextLine();
        }
        int value = sc.nextInt();
        sc.nextLine(); // Clear the newline
        return value;
    }

    static void addPatient() {
        System.out.println("\n--- Add Patient ---");
        System.out.print("Enter patient name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = readInt();

        System.out.print("Enter gender: ");
        String gender = sc.nextLine();

        System.out.print("Enter disease/reason for visit: ");
        String disease = sc.nextLine();

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        Patient patient = new Patient(
                nextPatientId++, name, age, gender, disease, phone);
        patients.add(patient);

        System.out.println("Patient added successfully. Patient ID: "
                + patient.id);
    }

    static void viewPatients() {
        System.out.println("\n--- All Patients ---");
        if (patients.isEmpty()) {
            System.out.println("No patient records found.");
            return;
        }

        for (Patient patient : patients) {
            patient.display();
        }
    }

    static Patient findPatientById(int id) {
        for (Patient patient : patients) {
            if (patient.id == id) {
                return patient;
            }
        }
        return null;
    }

    static void searchPatient() {
        System.out.print("Enter patient ID to search: ");
        int id = readInt();

        Patient patient = findPatientById(id);
        if (patient != null) {
            patient.display();
        } else {
            System.out.println("Patient not found.");
        }
    }

    static void updatePatient() {
        System.out.print("Enter patient ID to update: ");
        int id = readInt();

        Patient patient = findPatientById(id);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.println("Enter new details (leave no field blank):");
        System.out.print("New name: ");
        patient.name = sc.nextLine();

        System.out.print("New age: ");
        patient.age = readInt();

        System.out.print("New gender: ");
        patient.gender = sc.nextLine();

        System.out.print("New disease/reason for visit: ");
        patient.disease = sc.nextLine();

        System.out.print("New phone number: ");
        patient.phone = sc.nextLine();

        System.out.println("Patient details updated successfully.");
    }

    static void deletePatient() {
        System.out.print("Enter patient ID to delete: ");
        int id = readInt();

        Patient patient = findPatientById(id);
        if (patient != null) {
            patients.remove(patient);
            System.out.println("Patient record deleted successfully.");
        } else {
            System.out.println("Patient not found.");
        }
    }

    static void viewDoctors() {
        System.out.println("\n--- Doctor Details (Sample Data) ---");
        System.out.println("1. Dr. Arun     - General Physician");
        System.out.println("2. Dr. Priya    - Cardiologist");
        System.out.println("3. Dr. Kumar    - Orthopedic");
        System.out.println("Note: These are sample details for the project.");
    }
}
