package experiment;

import android.content.Context;

import java.util.LinkedList;

public class Experiment {
	private int numTrials;
	private int TRIALS_PER_TREATMENT;
	private Trial listOfTrials[];
	private int currentTrialIndex = -1;
	private int participantNumber;
	private AnimalController animalController;
    private Animal[] frequent150, frequent50, infrequent150, infrequent50;
    private Context context;

    public Experiment(Context context, int trials, String technique, int trialsPerTreatment, int participantNum) {
		animalController = new AnimalController(context);
        this.numTrials = trials;
        this.TRIALS_PER_TREATMENT = trialsPerTreatment;
		this.listOfTrials = new Trial[trials];
        this.participantNumber = participantNum;
        this.context = context;
        initializeAnimals();
		initializeTrials(technique);
		currentTrialIndex = -1;
	}

    private void initializeAnimals() {
        frequent150 = animalController.getFrequentAnimals(150, TRIALS_PER_TREATMENT);
        infrequent150 = animalController.getInfrequentAnimals(150, TRIALS_PER_TREATMENT);
        frequent50 = animalController.getFrequentAnimals(50, TRIALS_PER_TREATMENT);
        infrequent50 = animalController.getInfrequentAnimals(50, TRIALS_PER_TREATMENT);
    }

    private void initializeTrials(String technique) {
        int treatmentOrder = participantNumber % 6;

        if (technique.equals("Fitts' Wheel")) {
            addTrialsForTechnique("Fitts' Wheel", TRIALS_PER_TREATMENT);
        }
        else if (technique.equals("GPS Launcher")) {
            addTrialsForTechnique("GPS Launcher", TRIALS_PER_TREATMENT);
        }
        else if (technique.equals("Keyboard Search")) {
            addTrialsForTechnique("Keyboard Search", TRIALS_PER_TREATMENT);
        }
        else {
            switch(treatmentOrder) {
                case 0:
                    addTrialsForTechnique("Fitts' Wheel", TRIALS_PER_TREATMENT);
                    addTrialsForTechnique("GPS Launcher", TRIALS_PER_TREATMENT);
                    addTrialsForTechnique("Keyboard Search", TRIALS_PER_TREATMENT);
                    break;
                case 1:
                    addTrialsForTechnique("Fitts' Wheel", TRIALS_PER_TREATMENT);
                    addTrialsForTechnique("Keyboard Search", TRIALS_PER_TREATMENT);
                    addTrialsForTechnique("GPS Launcher", TRIALS_PER_TREATMENT);
                    break;
                case 2:
                    addTrialsForTechnique("GPS Launcher", TRIALS_PER_TREATMENT);
                    addTrialsForTechnique("Fitts' Wheel", TRIALS_PER_TREATMENT);
                    addTrialsForTechnique("Keyboard Search", TRIALS_PER_TREATMENT);
                    break;
                case 3:
                    addTrialsForTechnique("GPS Launcher", TRIALS_PER_TREATMENT);
                    addTrialsForTechnique("Keyboard Search", TRIALS_PER_TREATMENT);
                    addTrialsForTechnique("Fitts' Wheel", TRIALS_PER_TREATMENT);
                    break;
                case 4:
                    addTrialsForTechnique("Keyboard Search", TRIALS_PER_TREATMENT);
                    addTrialsForTechnique("Fitts' Wheel", TRIALS_PER_TREATMENT);
                    addTrialsForTechnique("GPS Launcher", TRIALS_PER_TREATMENT);
                    break;
                case 5:
                    addTrialsForTechnique("Keyboard Search", TRIALS_PER_TREATMENT);
                    addTrialsForTechnique("GPS Launcher", TRIALS_PER_TREATMENT);
                    addTrialsForTechnique("Fitts' Wheel", TRIALS_PER_TREATMENT);
                    break;
            }
        }
	}
	
	private void addTrialsForTechnique(String technique, int trials) {
        if (trials == 1) {
            addOneTrial(new Treatment(technique, 50, true), this.frequent50, animalController.AnimalImages50(), 0);
            addOneTrial(new Treatment(technique, 150, false), this.infrequent150, animalController.AnimalImages150(), 0);
            addOneTrial(new Treatment(technique, 150, true), this.frequent150, animalController.AnimalImages150(), 1);
            addOneTrial(new Treatment(technique, 50, true), this.frequent50, animalController.AnimalImages50(), 1);
        }
        else {
            LinkedList<Integer> treatmentsRemaining = new LinkedList<Integer>();
            for (int index = 1; index <= trials-1; index++) {
                treatmentsRemaining.add(Integer.valueOf(index));
            }

            while (!treatmentsRemaining.isEmpty()) {
                int randomNumber = ((int)(Math.random() * 4)) + 1;
                if (randomNumber == 1 && treatmentsRemaining.contains(Integer.valueOf(1)))
                    addTrials(new Treatment(technique, 150, false), this.infrequent150, animalController.AnimalImages150());
                else if (randomNumber == 2 && treatmentsRemaining.contains(Integer.valueOf(2)))
                    addTrials(new Treatment(technique, 50, false), this.infrequent50, animalController.AnimalImages50());
                else if (randomNumber == 3 && treatmentsRemaining.contains(Integer.valueOf(3)))
                    addTrials(new Treatment(technique, 150, true), this.frequent150, animalController.AnimalImages150());
                else if (randomNumber == 4 && treatmentsRemaining.contains(Integer.valueOf(4)))
                    addTrials(new Treatment(technique, 50, true), this.frequent50, animalController.AnimalImages50());

                treatmentsRemaining.remove(Integer.valueOf(randomNumber));
            }
        }
	}
	
	private void addTrials(Treatment treatment, Animal[] animals, Animal[] allAnimals) {
		for (int index = 0; index < animals.length; index++) {
            currentTrialIndex++;
			listOfTrials[currentTrialIndex] = new Trial(currentTrialIndex + 1, participantNumber, treatment, animals[index], allAnimals);
		}
	}

    private void addOneTrial(Treatment treatment, Animal[] animals, Animal[] allAnimals, int animalIndex) {
        currentTrialIndex++;
        listOfTrials[currentTrialIndex] = new Trial(currentTrialIndex + 1, participantNumber, treatment, animals[animalIndex], allAnimals);
    }
	
	public Trial nextTrial() {
        this.currentTrialIndex += 1;

        if (currentTrialIndex >= listOfTrials.length) {
            return null;
        }

		return listOfTrials[currentTrialIndex];
	}

    public Trial currentTrial() {
        if(this.currentTrialIndex < this.listOfTrials.length)
            return this.listOfTrials[this.currentTrialIndex];
        else // return the last element
            return null;
    }


    public String getDataReport() {
		String title = "Participant_" + participantNumber + "_Data";
		String dataReport = "Trial\tPart#\tTech\tApps\tFreq\tErrors\tTime\n";
		
		for (int index = 0; index < listOfTrials.length; index++) {
			dataReport += listOfTrials[index].toString() + "\n";
		}

        return dataReport;
    }

}
