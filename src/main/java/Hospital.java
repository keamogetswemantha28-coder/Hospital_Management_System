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