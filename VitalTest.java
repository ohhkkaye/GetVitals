// This utilizes JAVA to have multiple computers from several hospitals to be able to stream live 
//vital readings
import java.util.Random;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.*;
import java.io.*;


public class VitalTest {

	public static void main(String[] args){
		String answer;
		String patientAnswer;
		PatientInfo patient1 = new PatientInfo();
		Hospital patient11 = new Hospital();

		System.out.println("We're going to retrieve vitals for the next patient");
		System.out.println("Would you like to add a patient? Please respond 'yes' or 'no'.");
			Scanner c = new Scanner(System.in);
			answer=c.nextLine();
		

		while (answer.equals("yes")){
			patient1.getName();
			patient1.getDOB();
			patient1.readVitals();
			// patient1.addVitalInfo();
			
			System.out.println("Would you like to add another patient?" );
			Scanner b = new Scanner(System.in);
			answer=b.nextLine();
		}

		System.out.println("Would you like to pull up a patient?");
		Scanner y = new Scanner(System.in);
		patientAnswer=y.nextLine();
		
		while (patientAnswer.equals("yes")) {
			if (patientAnswer.equals("yes")){
				patient1.pullUpPatient();
				patient11.diagnosis();
			} else {
				System.out.println("You are exiting the system.");
			}
			System.out.println("Would you like to pull up a patient?");
			Scanner x = new Scanner(System.in);
			patientAnswer=x.nextLine();
		}
		patient1.retrieveDatabase();
		System.out.println("You are now exiting the system.");
	}
}

class PatientInfo extends Vitals {

	String name;
	ArrayList<String> nameDatabase = new ArrayList<String>();
	Map<String, String> database = new HashMap<String, String>();
	Map<String, Integer> databaseVitals = new HashMap<String, Integer>();
	String check_name;
	String dob;
	
	public void readVitals() {
		Vitals patient1vitals = new Vitals();

		patient1vitals.bpmReading();
		patient1vitals.bodyTempReading();
		patient1vitals.respirationReading();
		patient1vitals.bpReading();
		
		System.out.println(publicBodyTemp);
		databaseVitals.put(name, publicBodyTemp);
	}

	// public void addVitalInfo() {
	// 	S
	// }

	public void getName() {
		System.out.println("What is the patient's name: ");
		try {
			Scanner a = new Scanner(System.in);
			name=a.nextLine();
		} catch(Exception ex) {
			System.out.print("You have no name?");
		}
		nameDatabase.add(name);
		System.out.println("Currently saving...");
	}

	public void getDOB() {
		Scanner n = new Scanner(System.in);
		System.out.print("What is his/her DOB? (Use: MMDDYYYY): ");
		dob = n.nextLine();
		database.put(name, dob);
	}

	public void pullUpPatient() {
		System.out.println("What is the patient's name you are trying to locate? ");
		try {
			Scanner a = new Scanner(System.in);
			check_name=a.nextLine();
		} catch(Exception ex) {
			System.out.print("You have no name?");
			}
		if(nameDatabase.contains(check_name)){
			System.out.println(check_name + " is currently in the system. ");
			}	
		String dateOfBirth = database.get(name);
		int readBPM = databaseVitals.get(name);
		System.out.println("This patient has a date of birth of " + dateOfBirth);
		System.out.println("The BPM is currently: " + readBPM);
	}

	public void retrieveDatabase() {
		System.out.println("These are the patients added today: ");
		System.out.println(nameDatabase);		
	}
}


class Hospital extends Vitals {

	public void diagnosis(){
		if ((publicBodyTemp < 100) && (publicBodyTemp > 97)) {
			System.out.println("Body temperature is normal.");
		} else if(publicBodyTemp > 100) {
			System.out.println("Body temperature is too high. This patient has a fever");
		} else {
			System.out.println("Body temperature is too low.");
		}

		if ((publicBPM < 100) && (publicBPM > 60)) {
			System.out.println("Resting heart rate is normal.");
		} else if(publicBPM > 100) {
			System.out.println("Patient heart rate is very high.");
		} else {
			System.out.println("Patient heart rate is very low.");
		}

	}
}

class Vitals {

	private int bpm;
	private int bodyTemp;
	private int respiration;
	private int bloodPressure;
	public int publicBodyTemp;
	public int publicBPM;
	public int publicBloodPressure;
	public int publicRespiration;


	void bpmReading(){
		bpm = (int) (Math.random() * (121-39)) + 39; 
		System.out.println("The BPM is currently " + bpm + " beats per minute."); //+ " at " + c.get(c.HOUR_OF_DAY)
	}

	void bodyTempReading() {
		bodyTemp = (int) (Math.random() * (104-94)) + 94; 
		System.out.println("The body temperature is currently " + bodyTemp + " degrees Farenheit.");
	}

	void respirationReading(){
		respiration =(int) (Math.random() * (18-11)) + 11;
		System.out.println("The respiration reading is currently " + respiration + "."); //
	}
	void bpReading(){
		bloodPressure =(int) (Math.random() * (140 - 120)) +  120;
		System.out.println("The blood pressure is currently " + bloodPressure + "mm Hg."); //mm HG 
	}

	public void retrieveVitals(){
		publicBodyTemp=bodyTemp;
		publicBPM=bpm;
		publicBloodPressure=bloodPressure;
		publicRespiration=respiration;
	}
}
