package experiment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
            ArrayList<Animal> animalList = new ArrayList<Animal>();
            for (int i = 0; i < allAnimals.length; i++) {
                animalList.add(new Animal(allAnimals[i].img, allAnimals[i].img_id, allAnimals[i].name));
            }
            Collections.sort(animalList, new Comparator<Animal>() {
                @Override
                public int compare(Animal a1, Animal a2) {
                    return a1.name.compareTo(a2.name);
                }
            });
            this.allAnimals = new Animal[allAnimals.length];
            for (int i = 0; i < animalList.size(); i++) {
                this.allAnimals[i] = animalList.get(i);
            }
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
