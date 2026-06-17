public class PrivatePatient extends Patient implements Billable{

    public static final double TREATMENT_COST = 8000.0;

    private String medicalAidProvider;

    public PrivatePatient(String patientId, String name, int age, String medicalAidProvider){
        super(patientId, name,age);
        this.medicalAidProvider = medicalAidProvider;

    }

    public String medicalAidProvider() {
        return medicalAidProvider;
    }

    public void setMedicalAidProvider(String medicalAidProvider) {
        if (medicalAidProvider == null || medicalAidProvider.isEmpty()){
            throw new IllegalArgumentException("Medical Provider cannot be empty or null");
        }
        this.medicalAidProvider = medicalAidProvider;
    }

    @Override
    public double calculateTreatmentCost() {
        return TREATMENT_COST;
    }

    @Override
    public String toString() {
        return this.name() +"|"+ this.patientId() + "|" + this.age() + "|" + this.admitted() + "|" + this.medicalAidProvider;
    }

    @Override
    public double totalBill() {
        return calculateTreatmentCost();
    }
}
