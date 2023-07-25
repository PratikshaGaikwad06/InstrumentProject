package musical;


public abstract class DrumBasedMusicalInstrument extends MusicalInstrument {
    abstract void hitDrum();
    
    @Override
    public void play() {
        System.out.println("Playing " + this.getClass().getSimpleName());
    }
}


class Tabla extends DrumBasedMusicalInstrument {
    @Override
    public void hitDrum() {
        System.out.println("Hitting the tabla drum");
    }
    public void useFingers() {
        System.out.println("Using fingers to create different sounds on tabla");
    }

	
}

class Dhol extends DrumBasedMusicalInstrument {
    @Override
    public void hitDrum() {
        System.out.println("Hitting the dhol drum");
    }
    public void playRhythm() {
        System.out.println("Playing a rhythm on the dhol drum");
    }
}
