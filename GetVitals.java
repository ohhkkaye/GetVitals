// This utilizes JAVA to have multiple computers from several hospitals to be able to stream live 
//vital readings
import java.util.Random;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.lang.reflect.*;


public class GetVitals {

	public static void main(String[] args){
		System.out.println("We're going to retrieve vitals");

		PatientInfo patient1 = new PatientInfo(); // instantiate patient info object

		patient1.getName();
		patient1.getDOB();

		Vitals patient1vitals = new Vitals();

		patient1vitals.bpmReading();

	}
	
		// Method m=Vitals.class.getDeclaredMethod("bmpReading");
		// m.setAccessible(true);
		// m.invoke(p1v);

		// Field f=GetVitals;

		//then get vitals from 'machine' - this isn't printed 

		// receive vitals
		//read vitals
}

class PatientInfo {

	public void getName() {
		System.out.println("What is your name: ");
		Scanner a = new Scanner(System.in);
		String name=a.nextLine();

	}
	public void getDOB() {
		Scanner n = new Scanner(System.in);
		int dob;
		System.out.println("What is your DOB: ");
		dob = n.nextInt();
	}
	public void receiveVitals() {

	}
}

class Hospital extends Vitals {

	String database;
	String patient;

	public void pullUpPatient() {
		//get patient info from patient info
	}
	public void copyVitals(){
		// copy vitals into a 'database'
	}
	public void readVitals(){
		//get private vitals and present them on screen
		
	}
	public void recordVitals(){
		//receive vitals and match them up to the patient
	}
	public void diagnosis(){
		//diagnosis if vitals are stable or emergency/unstable
		// if bloodpressure is less than 120 mm Hg  or greater than 140- systolic pressure
		//less than 80 mm Hg or greater than 90mm Hg diastolic pressure
	
	}
}

class Vitals {

	private double bpm;
	private double bodyTemp;
	private double respiration;
	private double bloodPressure;
		
	void bpmReading(){
		// make this random number every 5 minutes and update it //60 - 100 is normal, 40 is bad
		bpm = (Math.random() * (121-39)); //collects BPM received from 'monitor'
		System.out.println("The BPM is currently " + bpm); //+ " at " + c.get(c.HOUR_OF_DAY)
	}

	void bodyTempReading() {
		bodyTemp = (Math.random() * (104-86)); //body temp
		System.out.println("The body temperature is currently " + bodyTemp);
	}

	void respirationReading(){
		respiration = (Math.random() * (11-18));
		System.out.println("The body temperature is currently " + respiration); //
	}
	void bpReading(){
		bloodPressure = (Math.random() * (11-18));
		System.out.println("The body temperature is currently " + bloodPressure); //mm HG 
	}
}