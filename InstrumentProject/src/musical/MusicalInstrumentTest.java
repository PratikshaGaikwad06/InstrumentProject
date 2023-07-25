package musical;

public class MusicalInstrumentTest {

	public static void main(String[] args) {
		
		//String Based
		System.out.println("===========String Based Musical Instruments==========");
	    Guitar guitar = new Guitar();
	    Violin violin = new Violin();
	    Cello cello = new Cello();
	    ElectronicGuitar electronicGuitar = new ElectronicGuitar();

//	    guitar.use();
	    guitar.play(); 
	    guitar.tuneStrings(); 
	    guitar.pluck(); 
	    System.out.println("------------------------------------------------------");
//	    violin.use();
	    violin.play(); 
	    violin.tuneStrings(); 
	    violin.bowing();
	    System.out.println("------------------------------------------------------");
//	    cello.use();
	    cello.play(); 
	    cello.tuneStrings(); 
	    cello.longBowing(); 
	    System.out.println("------------------------------------------------------");
//	    electronicGuitar.use();
	    electronicGuitar.play(); 
	    electronicGuitar.tuneStrings();
	    electronicGuitar.preset();
	    
	    //DrumBased
	    System.out.println("===========Drum Based Musical Instruments==========");
	    Tabla tabla = new Tabla();
	    Dhol dhol  = new Dhol();
//	    tabla.use();
	    tabla.play();
	    tabla.hitDrum();
	    tabla.useFingers();
	    System.out.println("------------------------------------------------------");
//	    dhol.use();
	    dhol.play();
	    dhol.hitDrum();
	    dhol.playRhythm();
	    
	    //AirBased
	    System.out.println("===========Air Based Musical Instruments==========");
	    Flute flute = new Flute();
	    Harmonium harmonium = new Harmonium();
	    
//	    flute.use();
	    flute.play();
	    flute.blowAir();
	    flute.fingerPosition();
	    System.out.println("------------------------------------------------------");
//	    harmonium.use();
	    harmonium.play();
	    harmonium.blowAir();
	    harmonium.pumpBellows();
	    
	    
	    
	    
	}

}
