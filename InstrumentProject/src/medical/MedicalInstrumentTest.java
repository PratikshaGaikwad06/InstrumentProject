package medical;

public class MedicalInstrumentTest {

	public static void main(String[] args) {
		//Pathological Instrument
		Glucometer glucometer =  new Glucometer();
		ECGMachine ecgMachine = new ECGMachine();
		System.out.println("===========Pathological Based Musical Instruments==========");
		glucometer.operate();
		glucometer.analyzeSample();
		glucometer.displayResult();
		System.out.println("------------------------------------------------------");
		ecgMachine.operate();
		ecgMachine.analyzeSample();
		ecgMachine.printReport();
		
		//Surgical Instrument
		SurgicalCutter surgicalCutter = new SurgicalCutter();
		SurgicalNeedle surgicalNeedle = new SurgicalNeedle();
		System.out.println("===========Surgical Based Musical Instruments==========");
		surgicalCutter.operate();
		surgicalCutter.sterile();
		surgicalCutter.performIncision();
		System.out.println("------------------------------------------------------");
		surgicalNeedle.operate();
		surgicalNeedle.sterile();
		surgicalNeedle.threadNeedle();
		
		
	}

}
