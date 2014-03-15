
public class Trial {
	private int trialNum;
	private int participantNum;
	private Treatment treatment;
	private int numOfErrors;
	private double timeTaken;
	
	public Trial(int trialNum, int participantNum, Treatment treatment) {
		this.trialNum = trialNum;
		this.participantNum = participantNum;
		this.treatment = treatment;
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
