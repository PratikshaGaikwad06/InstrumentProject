package measuring;

public class MeasuringInstrumentTest {

	public static void main(String[] args) {
		System.out.println("===========Length Measuring Instruments==============\n");
		//Length Measuring Instruments
		Caliper caliper = new Caliper();
		TapeMeasure tapeMeasure = new TapeMeasure();
//      caliper.measure();
		caliper.measure();
		caliper.calibrate();
		caliper.takeMeasurement();
		System.out.println("------------------------------------------------------");
//		tapeMeasure.use();
		tapeMeasure.measure();
		tapeMeasure.calibrate();
		tapeMeasure.extendAndMeasure();
		
		System.out.println("\n===========Time Measuring Instruments=================\n");
		//Time Measuring Instruments
		Stopwatch stopwatch = new Stopwatch();
		DigitalTimer digitalTimer = new DigitalTimer();
		
		stopwatch.measure();
		stopwatch.startTimer();
		stopwatch.pauseTimer();
		System.out.println("------------------------------------------------------");
		digitalTimer.measure();
		digitalTimer.startTimer();
		digitalTimer.setAlarm();

	}

}
