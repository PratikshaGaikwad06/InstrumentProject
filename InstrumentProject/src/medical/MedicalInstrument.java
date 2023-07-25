package medical;

public abstract class MedicalInstrument {
	public void use() {
		System.out.println("Using medical instrument");
	}
	public abstract void operate();
}
