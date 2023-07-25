package medical;

public abstract class SurgicalInstrument extends MedicalInstrument{
    abstract void sterile();

    public void operate() {
        System.out.println("Operating " + this.getClass().getSimpleName());
    }
}

class SurgicalCutter extends SurgicalInstrument {
	public void sterile() {
        System.out.println("Sterilizing the surgical cutter before the procedure");
    }
    public void performIncision() {
        System.out.println("Performing incision using the surgical cutter");
    }

}

class SurgicalNeedle extends SurgicalInstrument {
	public void sterile() {
        System.out.println("Sterilizing the surgical needle before the procedure");
    }
    

    // Specific method for the SurgicalNeedle class
    public void threadNeedle() {
        System.out.println("Threading the surgical needle with the suture material");
    }
}