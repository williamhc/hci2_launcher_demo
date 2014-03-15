package experiment;

import android.graphics.Bitmap;

public class Trial {
	private int trialNum;
	private int participantNum;
	private Treatment treatment;
	private int numOfErrors;
	private double timeTaken;
	private Bitmap searchImage;
	private Bitmap animalImages[];
	
	public Trial(int trialNum, int participantNum, Treatment treatment, ImageController imageController) {
		this.trialNum = trialNum;
		this.participantNum = participantNum;
		this.treatment = treatment;
		determineSearchImage(imageController);
		determineAnimalImageList(imageController);
	}
	
	public String toString() {
		return trialNum + "\t" + participantNum + "\t" + treatment.toString() + "\t" +
				numOfErrors + "\t" + timeTaken;
	}
	
	private void determineSearchImage(ImageController imageController) {
		if (treatment.IsFrequentlyUsed())
			searchImage = imageController.FrequentImage(10);
		else
			searchImage = imageController.InfrequentImage(10);
	}
	
	private void determineAnimalImageList(ImageController imageController) {
		if (treatment.AppsInstalled() == 50)
			animalImages = imageController.AnimalImages50();
		else
			animalImages = imageController.AnimalImages150();
	}
	
	public int TrialNum() {
		return trialNum;
	}
	
	public Bitmap SearchImage() {
		return searchImage;
	}
	
	public Bitmap[] AnimalImages() {
		return animalImages;
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
