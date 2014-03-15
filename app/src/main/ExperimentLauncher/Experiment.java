import java.util.LinkedList;


public class Experiment {
	private final int NUM_TRIALS = 60;
	private final int TRIALS_PER_TREATMENT = 5;
	private Trial listOfTrials[];
	private int currentTrialIndex = 0;
	private int participantNumber = 1;
	
	public Experiment() {
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
			listOfTrials[currentTrialIndex] = new Trial(trialNum, participantNumber, treatment);
			currentTrialIndex++;
		}
	}
	
	public Trial GetCurrentTrial() {
		return listOfTrials[currentTrialIndex];
	}
	
	public Trial GetNextTrial() {
		currentTrialIndex++;
		return listOfTrials[currentTrialIndex];
	}
}
