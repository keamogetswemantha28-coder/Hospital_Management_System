public class Appointment {
    private int appointmentId;
    private String doctorName;
    private Patient patient;
    private int durationMinutes;
    private AppointmentStatus status;

    public enum AppointmentStatus{
        SCHEDULED,
        COMPLETED,
        CANCELLED;
    }

    public Appointment(int appointmentId, String doctorName, Patient patient, int durationMinutes) {
        this.appointmentId = appointmentId;
        this.doctorName = doctorName;
        this.patient = patient;
        if (durationMinutes < 1) {
            throw new IllegalArgumentException("Duration cannot be negative");
        }
        this.durationMinutes = durationMinutes;
        this.status = AppointmentStatus.SCHEDULED;
    }

    public int appointmentId() {
        return appointmentId;
    }

    public String doctor() {
        return doctorName;
    }

    public Patient patient() {
        return patient;
    }

    public int durationMinutes() {
        return durationMinutes;
    }

    public AppointmentStatus status() {
        return status;
    }

    public void updateStatus(AppointmentStatus status){
        this.status = status;
    }
    public void updateDuration(int duration){
        if (duration < 1){
            throw new IllegalArgumentException("Duration cannot be negative");
        }
        this.durationMinutes = duration;
    }

    public double consultationFee(){
        return patient.calculateTreatmentCost();
    }

    @Override
    public String toString() {
        return this.appointmentId + "|" + this.doctorName +"|" + this.patient + "|" + this.durationMinutes + "|"+this.status;
    }
}