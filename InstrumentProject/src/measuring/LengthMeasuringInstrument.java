package measuring;

public abstract class LengthMeasuringInstrument extends MeasuringInstrument{
	public void measure() {
        System.out.println("Measuring Length");
    }

    abstract void calibrate();

}

class Caliper extends LengthMeasuringInstrument {
    public void calibrate() {
        System.out.println("Calibrating the caliper");
    }
    public void takeMeasurement() {
        System.out.println("Taking precise measurements using the caliper");
    }
}


class TapeMeasure extends LengthMeasuringInstrument {
    public void calibrate() {
        System.out.println("Calibrating the tape measure");
    }
    public void extendAndMeasure() {
        System.out.println("Extending the tape measure and measuring length");
    }
}
