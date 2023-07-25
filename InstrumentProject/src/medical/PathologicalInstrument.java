package medical;

public abstract class PathologicalInstrument extends MedicalInstrument {
    abstract void analyzeSample();

    public void operate() {
        System.out.println("Operating " + this.getClass().getSimpleName());
    }
}


class Glucometer extends PathologicalInstrument {
    public void analyzeSample() {
        System.out.println("Analyzing blood sugar level using the glucometer");
    }

    public void displayResult() {
        System.out.println("Displaying the blood sugar level result on the glucometer screen");
    }
}

class ECGMachine extends PathologicalInstrument {
    public void analyzeSample() {
        System.out.println("Recording and analyzing the patient's heart activity using the ECG machine");
    }

    public void printReport() {
        System.out.println("Printing the ECG report with the patient's heart activity");
    }
}