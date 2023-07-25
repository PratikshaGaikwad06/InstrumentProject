package musical;

public abstract class AirBasedMusicalInstrument extends MusicalInstrument{
	    public abstract void blowAir();

	    public void play() {
	        System.out.println("Playing the " + this.getClass().getSimpleName());
	    }

}

class Flute extends AirBasedMusicalInstrument {
    public void blowAir() {
        System.out.println("Blowing air into the flute");
    }

    // Specific method for the Flute class
    public void fingerPosition() {
        System.out.println("Adjusting finger positions to produce different notes");
    }
}

class Harmonium extends AirBasedMusicalInstrument {
    public void blowAir() {
        System.out.println("Blowing air into the harmonium");
    }

    // Specific method for the Harmonium class
    public void pumpBellows() {
        System.out.println("Pumping the bellows to generate sound");
    }
}
