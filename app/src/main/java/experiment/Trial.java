package experiment;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Trial {
	private int trialNum;
	private int participantNum;
	public Treatment treatment;
	public int numOfErrors;
	public double timeTaken;
    private int numOfActions;
	public Animal searchAnimal;
    public Animal[] allAnimals;

	public Trial(int trialNum, int participantNum, Treatment treatment, Animal animal, Animal[] allAnimals) {
		this.trialNum = trialNum;
		this.participantNum = participantNum;
		this.treatment = treatment;
        this.searchAnimal = animal;
        if (this.treatment.Technique().equals("Fitts' Wheel")) {
            List<Animal> animalList = Arrays.asList(allAnimals);
            Collections.sort(animalList, new Comparator<Animal>() {
                @Override
                public int compare(Animal a1, Animal a2) {
                    return a1.name.compareTo(a2.name);
                }
            });
            this.allAnimals = (Animal[]) animalList.toArray();
        }
        else {
            this.allAnimals = allAnimals;
        }
	}

	public String toString() {
		return trialNum + "\t" + participantNum + "\t" + treatment.toString() + "\t" +
				numOfErrors + "\t" + timeTaken;
	}
	
	public int TrialNum() {
		return trialNum;
	}
	
	public Animal SearchImage() {
		return searchAnimal;
	}

	public int NumOfErrors() {
		return numOfErrors;
	}
	
	public void NumOfErrors(int errors) {
		this.numOfErrors = errors;
	}
	
	public double TimeTaken() {
		return timeTaken;
	}
	
	public void TimeTaken(double timeTaken) {
		this.timeTaken = timeTaken;
	}
}
