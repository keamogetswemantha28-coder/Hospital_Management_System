import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter hospital name: ");
        String name = scanner.nextLine();
        Hospital hospitalType = new Hospital(name);


        while (true){
            System.out.println("*****Hospital*****");
            System.out.println("1. Add patients");
            System.out.println("2. Check admitted patients");
            System.out.println("3. Schedule an appointment");
            System.out.println("4. Complete an appointment");
            System.out.println("5. Cancel an appointment");
            System.out.println("6. Get the total revenue");
            System.out.println("7. Return a list of booked patients");
            System.out.println("8. Get patients list");
            System.out.println("9. Exit the System");
            System.out.println();
            System.out.println("Enter your option: ");


            int option = Integer.parseInt(scanner.nextLine());
            if (option == 1){
                System.out.println("Enter patient type: ");
                String patientType = scanner.nextLine().toLowerCase();
                if (patientType.equalsIgnoreCase("general")){
                    System.out.println("Enter patient Id: ");
                    String Id = scanner.nextLine();
                    System.out.println("Enter patient name: ");
                    String patientName = scanner.nextLine();
                    System.out.println("Enter age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter ward number: ");
                    int wardNumber = Integer.parseInt(scanner.nextLine());
                    GeneralPatient patient = new GeneralPatient(Id,patientName,age,wardNumber);
                    hospitalType.addPatient(patient);
                    System.out.println("Patient added successfully");
                } else if (patientType.equalsIgnoreCase("private")) {
                    System.out.println("Enter patient Id: ");
                    String Id = scanner.nextLine();
                    System.out.println("Enter patient name: ");
                    String patientName = scanner.nextLine();
                    System.out.println("Enter age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter medical aid: ");
                    String medicalAid = scanner.nextLine();
                    PrivatePatient patient = new PrivatePatient(Id, patientName, age, medicalAid);
                    hospitalType.addPatient(patient);
                    System.out.println("Patient added successfully");
                }else {
                    System.out.println("Enter a valid type");
                }
            } else if (option == 2) {
                System.out.println(hospitalType.admittedPatients());
            } else if (option == 3) {
                System.out.println("Enter Doctor name: ");
                String doctorName = scanner.nextLine();
                System.out.println("Enter patient Id: ");
                String Id = scanner.nextLine();
                System.out.println("Duration: ");
                int duration = Integer.parseInt(scanner.nextLine());
                System.out.println(hospitalType.scheduleAppointment(doctorName, Id, duration));
            } else if (option == 4) {
                System.out.println("Enter appointment Id: ");
                int Id = Integer.parseInt(scanner.nextLine());
                System.out.println(hospitalType.completeAppointment(Id));
            } else if (option == 5) {
                System.out.println("Enter appointment Id: ");
                int Id = Integer.parseInt(scanner.nextLine());
                System.out.println(hospitalType.cancelAppointment(Id));
            } else if (option == 6) {
                System.out.println(hospitalType.getTotalRevenue());
            } else if (option == 7) {
                System.out.println(hospitalType.appointments());
            } else if (option == 8) {
                System.out.println(hospitalType.patients());
            } else {
                System.exit(0);
            }

        }
    }
}
