package musical;


public abstract class StringBasedMusicalInstrument extends MusicalInstrument {
    public abstract void tuneStrings();

    public void play() {
        System.out.println("Playing the " + this.getClass().getSimpleName());
    }
}


class Guitar extends StringBasedMusicalInstrument {
    public void tuneStrings() {
        System.out.println("Tuning the Guitar strings");
    }

    public void pluck() {
        System.out.println("Plucking the Guitar strings");
    }
}

class Violin extends StringBasedMusicalInstrument {
    public void tuneStrings() {
        System.out.println("Tuning the Violin strings");
    }

    public void bowing() {
        System.out.println("Bowing the Violin strings");
    }
}

class Cello extends StringBasedMusicalInstrument {
    public void tuneStrings() {
        System.out.println("Tuning the Cello strings");
    }

    public void longBowing() {
        System.out.println("Long bowing the Cello strings");
    }
}

class ElectronicGuitar extends StringBasedMusicalInstrument {
    public void tuneStrings() {
        System.out.println("Tuning the Electronic Guitar strings");
    }

    public void preset() {
        System.out.println("Using preset on the Electronic Guitar");
    }
}
