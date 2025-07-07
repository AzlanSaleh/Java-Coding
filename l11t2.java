import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract Person class
abstract class Person {
    private String id;
    private String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract void displayDetails();
}

// Doctor class
class Doctor extends Person implements Diagnosable {
    private String specialization;

    public Doctor(String id, String name, String specialization) {
        super(id, name);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public void diagnose() {
        System.out.println("Doctor " + getName() + " is diagnosing a patient.");
    }

    @Override
    public void displayDetails() {
        System.out.println("Doctor ID: " + getId() + ", Name: " + getName() + ", Specialization: " + specialization);
    }
}

// Patient class
class Patient extends Person {
    private String medicalHistory;

    public Patient(String id, String name, String medicalHistory) {
        super(id, name);
        this.medicalHistory = medicalHistory;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    @Override
    public void displayDetails() {
        System.out.println("Patient ID: " + getId() + ", Name: " + getName());
    }
}

// Staff class
class Staff extends Person {
    private String role;

    public Staff(String id, String name, String role) {
        super(id, name);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public void displayDetails() {
        System.out.println("Staff ID: " + getId() + ", Name: " + getName() + ", Role: " + role);
    }
}

// Schedulable interface
interface Schedulable {
    void scheduleAppointment(String date, String time) throws AppointmentClashException;
}

// Diagnosable interface
interface Diagnosable {
    void diagnose();
}

// AppointmentClashException
class AppointmentClashException extends Exception {
    public AppointmentClashException(String message) {
        super(message);
    }
}

// Appointment class
class Appointment implements Schedulable {
    private String doctorId;
    private String patientId;
    private String date;
    private String time;

    public Appointment(String doctorId, String patientId) {
        this.doctorId = doctorId;
        this.patientId = patientId;
    }

    @Override
    public void scheduleAppointment(String date, String time) throws AppointmentClashException {
        // Simulate checking for appointment clashes
        if ("10:00 AM".equals(time)) {
            throw new AppointmentClashException("Appointment time clashes with an existing appointment.");
        }
        this.date = date;
        this.time = time;
        System.out.println("Appointment scheduled for Doctor ID: " + doctorId + " and Patient ID: " + patientId + " on " + date + " at " + time);
    }
}

// Main class to test the system
public class l11t2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Doctor> doctors = new ArrayList<>();
        List<Patient> patients = new ArrayList<>();
        List<Staff> staffMembers = new ArrayList<>();

        while (true) {
            System.out.println("Choose an option: \n1. Add Doctor \n2. Add Patient \n3. Add Staff \n4. Schedule Appointment \n5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter Doctor ID:");
                    String doctorId = scanner.nextLine();
                    System.out.println("Enter Doctor Name:");
                    String doctorName = scanner.nextLine();
                    System.out.println("Enter Specialization:");
                    String specialization = scanner.nextLine();
                    doctors.add(new Doctor(doctorId, doctorName, specialization));
                    System.out.println("Doctor added successfully.");
                    break;

                case 2:
                    System.out.println("Enter Patient ID:");
                    String patientId = scanner.nextLine();
                    System.out.println("Enter Patient Name:");
                    String patientName = scanner.nextLine();
                    System.out.println("Enter Medical History:");
                    String medicalHistory = scanner.nextLine();
                    patients.add(new Patient(patientId, patientName, medicalHistory));
                    System.out.println("Patient added successfully.");
                    break;

                case 3:
                    System.out.println("Enter Staff ID:");
                    String staffId = scanner.nextLine();
                    System.out.println("Enter Staff Name:");
                    String staffName = scanner.nextLine();
                    System.out.println("Enter Role:");
                    String role = scanner.nextLine();
                    staffMembers.add(new Staff(staffId, staffName, role));
                    System.out.println("Staff added successfully.");
                    break;

                case 4:
                    System.out.println("Enter Doctor ID for the appointment:");
                    String appDoctorId = scanner.nextLine();
                    System.out.println("Enter Patient ID for the appointment:");
                    String appPatientId = scanner.nextLine();
                    System.out.println("Enter Appointment Date (e.g., 29-Apr-2025):");
                    String date = scanner.nextLine();
                    System.out.println("Enter Appointment Time (e.g., 10:00 AM):");
                    String time = scanner.nextLine();

                    Appointment appointment = new Appointment(appDoctorId, appPatientId);
                    try {
                        appointment.scheduleAppointment(date, time);
                    } catch (AppointmentClashException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Exiting the system. Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}