package measuring;

public abstract class TimeMeasuringInstrument extends MeasuringInstrument {
	abstract void startTimer();

    public void measure() {
        System.out.println("Measuring Time");
    }
}

class Stopwatch extends TimeMeasuringInstrument {
    public void startTimer() {
        System.out.println("Starting the stopwatch timer");
    }

    public void pauseTimer() {
        System.out.println("Pausing the stopwatch timer");
    }
}

class DigitalTimer extends TimeMeasuringInstrument {
    public void startTimer() {
        System.out.println("Starting the digital timer");
    }

    public void setAlarm() {
        System.out.println("Setting the alarm on the digital timer");
    }
}

