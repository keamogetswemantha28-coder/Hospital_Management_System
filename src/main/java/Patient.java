public abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private boolean admitted = true;


    public Patient(String patientId, String name, int age){
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.admitted = true;
    }

    public String patientId() {
        return patientId;
    }

    public String name() {
        return name;
    }

    public int age() {
        return age;
    }

    public boolean admitted() {
        return admitted;
    }

    public void defineAge(int age) {
        if (age < 0 || age > 150){
            throw new IllegalArgumentException("age must be valid");
        }
        this.age = age;
    }

    public void makeAdmitted(boolean admitted) {
        this.admitted = admitted;
    }

    @Override
    public String toString() {
        return this.name +"|"+ this.patientId + "|" + this.age + "|" + this.admitted;
    }

    //Abstract method
    public abstract double calculateTreatmentCost();
}
