package experiment;

public class Trial {
	private int trialNum;
	private int participantNum;
	private Treatment treatment;
	private int numOfErrors;
	private double timeTaken;
    private int numOfActions;
	public Animal searchAnimal;
    public Animal[] allAnimals;

	public Trial(int trialNum, int participantNum, Treatment treatment, Animal animal, Animal[] animals) {
		this.trialNum = trialNum;
		this.participantNum = participantNum;
		this.treatment = treatment;
        this.searchAnimal = animal;
        this.allAnimals = animals;
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
	
	public Animal[] AnimalImages() {
		return allAnimals;
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
