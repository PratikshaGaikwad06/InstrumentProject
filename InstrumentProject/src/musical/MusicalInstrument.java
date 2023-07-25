package musical;

import instruments.Instruments;

public abstract class MusicalInstrument implements Instruments{
	@Override
	public void use() {
		System.out.println("Using musical instrument");
		
	}
	public abstract void play();
}
