import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Hospital {
    private String hospitalName;
    private List<Patient> patients;
    private List<Appointment> appointments;
    private int appointmentCounter = 0;

    public Hospital(String hospitalName){
        this.hospitalName = hospitalName;
        this.appointments = new ArrayList<>();
        this.patients = new ArrayList<>();
        this.appointmentCounter = 0;
    }

//    public void administrator(){
//        Scanner scanner = new Scanner(System.in);
//
//        while (true){
//            System.out.println("*****Hospital*****");
//            System.out.println("1. Add patients");
//            System.out.println("2. Check admitted patients");
//            System.out.println("3. Schedule an appointment");
//            System.out.println("4. Complete an appointment");
//            System.out.println("5. Cancel an appointment");
//            System.out.println("6. Get the total revenue");
//            System.out.println("7. Return a list of booked patients");
//            System.out.println("8. Get patients list");
//            System.out.println("9. Exit the System");
//            System.out.println("Enter your option");
//            int option = Integer.parseInt(scanner.nextLine());
//            if (option == 1){
//                System.out.println("Enter the type of patient: ");
//                String patientType = scanner.nextLine().toLowerCase();
//                if (patientType.equalsIgnoreCase("general")){
//                    System.out.println("Enter patient Id: ");
//                    String Id = scanner.nextLine();
//                    System.out.println("Enter patient name: ");
//                    String name = scanner.nextLine();
//                    System.out.println("Enter age: ");
//                    int age = Integer.parseInt(scanner.nextLine());
//                    System.out.println("Enter ward number: ");
//                    int wardNumber = Integer.parseInt(scanner.nextLine());
//                    GeneralPatient patient = new GeneralPatient(Id, name,age,wardNumber);
//                    addPatient(patient);
//                } else if (patientType.equalsIgnoreCase("private")) {
//                    System.out.println("Enter patient Id: ");
//                    String Id = scanner.nextLine();
//                    System.out.println("Enter patient name: ");
//                    String name = scanner.nextLine();
//                    System.out.println("Enter age: ");
//                    int age = Integer.parseInt(scanner.nextLine());
//                    System.out.println("Enter medical aid: ");
//                    String medicalAid = scanner.nextLine();
//                    PrivatePatient patient = new PrivatePatient(Id, name, age, medicalAid);
//                    addPatient(patient);
//                }else {
//                    throw new IllegalArgumentException("Invalid patient type");
//                }
//            } else if (option == 2) {
//                admittedPatients();
//            } else if (option == 3) {
//                System.out.println("Enter Doctor name: ");
//                String name = scanner.nextLine();
//                System.out.println("Enter patient Id: ");
//                String Id = scanner.nextLine();
//                System.out.println("Duration: ");
//                int duration = Integer.parseInt(scanner.nextLine());
//                scheduleAppointment(name, Id, duration);
//            } else if (option == 4) {
//                System.out.println("Enter appointment Id: ");
//                int Id = Integer.parseInt(scanner.nextLine());
//                completeAppointment(Id);
//            } else if (option == 5) {
//                System.out.println("Enter appointment Id: ");
//                int Id = Integer.parseInt(scanner.nextLine());
//                cancelAppointment(Id);
//            } else if (option == 6) {
//                getTotalRevenue();
//            } else if (option == 7) {
//                appointments();
//            } else if (option == 8) {
//                patients();
//            } else {
//                System.exit(0);
//            }
//
//        }
//
//    }
    public void addPatient(Patient patient){
        patients.add(patient);
    }

    public List<Patient> patients() {
        return Collections.unmodifiableList(patients);
    }
    public List<Patient> admittedPatients(){
        List<Patient> admitted = new ArrayList<>();
        for (Patient patient : patients){
            if (patient.admitted()) {
                admitted.add(patient);
            }
        }
        return admitted;
    }
    public Appointment scheduleAppointment(String doctorName, String patientId, int durationMinutes){
        for (Patient patient: patients){
            if (patient.patientId().equalsIgnoreCase(patientId)){
                Appointment appointment = new Appointment(++appointmentCounter, doctorName, patient, durationMinutes);
                appointments.add(appointment);
                return appointment;

            }
        }
        throw new IllegalArgumentException("Patient not found");
    }
    public Appointment completeAppointment(int appointmentId){
        for (Appointment appointment: appointments){
            if (appointment.appointmentId() == appointmentId){
                appointment.updateStatus(Appointment.AppointmentStatus.COMPLETED);
                appointment.patient().makeAdmitted(true);
                return appointment;
            }
        }
        throw new IllegalArgumentException("Appointment not found");
    }
    public Appointment cancelAppointment(int appointmentId){
        for (Appointment appointment : appointments){
            if (appointment.appointmentId() == appointmentId){
                appointment.updateStatus(Appointment.AppointmentStatus.CANCELLED);
                appointment.patient().makeAdmitted(false);
                return appointment;
            }
        }
        throw new IllegalArgumentException("Appointment not found");
    }

    public List<Appointment> appointments() {
        return Collections.unmodifiableList(appointments);
    }

    public String name() {
        return hospitalName;
    }

    public double getTotalRevenue(){
        double totalBill = 0;
        for (Patient patient: patients){
            if (patient instanceof Billable){
                totalBill += ((Billable) patient).totalBill();
            }
        }
        return totalBill;
    }
}