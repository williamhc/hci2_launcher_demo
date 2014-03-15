package experiment;

public class Trial {
	private int trialNum;
	private int participantNum;
	private Treatment treatment;
	private int numOfErrors;
	private double timeTaken;
	private Animal searchAnimal;
    private Animal[] allAnimals;

	public Trial(int trialNum, int participantNum, Treatment treatment, AnimalController animalController) {
		this.trialNum = trialNum;
		this.participantNum = participantNum;
		this.treatment = treatment;
		determineSearchImage(animalController);
		determineAnimalImageList(animalController);
	}
	
	public String toString() {
		return trialNum + "\t" + participantNum + "\t" + treatment.toString() + "\t" +
				numOfErrors + "\t" + timeTaken;
	}
	
	private void determineSearchImage(AnimalController animalController) {
		if (treatment.IsFrequentlyUsed())
			searchAnimal = animalController.FrequentImage(10);
		else
			searchAnimal = animalController.InfrequentImage(10);
	}
	
	private void determineAnimalImageList(AnimalController animalController) {
		if (treatment.AppsInstalled() == 50)
			allAnimals = animalController.AnimalImages50();
		else
			allAnimals = animalController.AnimalImages150();
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
