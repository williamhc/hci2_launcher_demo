package experiment;

import android.content.Context;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;

public class Experiment {
	private final int NUM_TRIALS = 60;
	private final int TRIALS_PER_TREATMENT = 5;
	private Trial listOfTrials[];
	private int currentTrialIndex = 0;
	private int participantNumber = 1;
	private AnimalController animalController;
	
	public Experiment() {
		animalController = new AnimalController();
		this.listOfTrials = new Trial[NUM_TRIALS];
		initializeTrials();
		currentTrialIndex = 0;
	}
	
	private void initializeTrials() {
		addTrialsForTechnique("Fitts' Wheel", TRIALS_PER_TREATMENT);
		addTrialsForTechnique("GPS Launcher", TRIALS_PER_TREATMENT);
		addTrialsForTechnique("Keyboard Search", TRIALS_PER_TREATMENT);
	}
	
	private void addTrialsForTechnique(String technique, int trials) {
		LinkedList<Integer> treatmentsRemaining = new LinkedList<Integer>();
		
		for (int index = 1; index <= 4; index++) {
			treatmentsRemaining.add(Integer.valueOf(index));
		}
		
		while (!treatmentsRemaining.isEmpty()) {
			int randomNumber = (int)(Math.random() * 4) + 1;
			if (randomNumber == 1 && treatmentsRemaining.contains(Integer.valueOf(1)))
				addTrials(new Treatment(technique, 200, false), trials);
			else if (randomNumber == 2 && treatmentsRemaining.contains(Integer.valueOf(2)))
				addTrials(new Treatment(technique, 50, false), trials);
			else if (randomNumber == 3 && treatmentsRemaining.contains(Integer.valueOf(3)))
				addTrials(new Treatment(technique, 200, true), trials);
			else if (randomNumber == 4 && treatmentsRemaining.contains(Integer.valueOf(4)))
				addTrials(new Treatment(technique, 50, true), trials);
			
			treatmentsRemaining.remove(Integer.valueOf(randomNumber));
		}
	}
	
	private void addTrials(Treatment treatment, int trials) {
		for (int index = 0; index < trials; index++) {
			int trialNum = currentTrialIndex + 1;
			listOfTrials[currentTrialIndex] = new Trial(trialNum, participantNumber, treatment, animalController);
			currentTrialIndex++;
		}
	}
	
	public Trial currentTrial() {
		return listOfTrials[currentTrialIndex];
	}
	
	public Trial nextTrial() {
		Trial t = listOfTrials[currentTrialIndex];
        this.currentTrialIndex += 1;
        return t;
	}
	
	public void WriteDataToDisk(Context ctx) {
		String fileName = "Participant_" + participantNumber + "_Data";
		String buffer = "Trial\tPart#\tTech\tApps\tFreq\tErrors\tTime\n";
		
		for (int index = 0; index < listOfTrials.length; index++) {
			buffer += listOfTrials.toString() + "\n";
		}
		
		try {
			FileOutputStream fos = ctx.openFileOutput(fileName, Context.MODE_PRIVATE);
			fos.write(buffer.getBytes());
			fos.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
