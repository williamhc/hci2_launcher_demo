package experiment;

public class Trial {
	private int trialNum;
	private int participantNum;
	public Treatment treatment;
	public int numOfErrors;
	public double timeTaken;
    private int numOfActions;
	public Animal searchAnimal;
    public Animal[] fiveAnimals;
    public Animal[] allAnimals;

	public Trial(int trialNum, int participantNum, Treatment treatment, Animal animal, Animal[] fiveAnimals, Animal[] allAnimals) {
		this.trialNum = trialNum;
		this.participantNum = participantNum;
		this.treatment = treatment;
        this.searchAnimal = animal;
        this.fiveAnimals = fiveAnimals;
        this.allAnimals = allAnimals;
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
		return fiveAnimals;
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
