public class GeneralPatient extends Patient implements Billable {
    public static final double TREATMENT_COST = 2000.0;

    private int wardNumber;
     public GeneralPatient(String patientId, String name, int age, int wardNumber){
         super(patientId, name, age);
         this.wardNumber = wardNumber;
     }

    public int wardNumber() {
        return wardNumber;
    }

    public void setWardNumber(int wardNumber) {
         if (wardNumber < 1){
             throw new IllegalArgumentException("Ward number cannot be negative");
         }
        this.wardNumber = wardNumber;
    }
    @Override
    public double calculateTreatmentCost(){
         return  TREATMENT_COST;
    }
    @Override
    public String toString(){
         return this.name() +"|"+ this.patientId() + "|" + this.age() + "|" + this.admitted() + "|" + this.wardNumber;
    }

    @Override
    public double totalBill() {
        return calculateTreatmentCost();
    }
}

