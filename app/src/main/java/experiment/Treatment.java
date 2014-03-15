package experiment;

public class Treatment {
	private String technique;
	private int appsInstalled;
	private boolean isFrequentlyUsed;
	
	public Treatment(String technique, int appsInstalled, boolean isFrequentlyUsed) {
		this.technique = technique;
		this.appsInstalled = appsInstalled;
		this.isFrequentlyUsed = isFrequentlyUsed;
	}
	
	public String toString() {
		return technique + "\t" + appsInstalled + "\t" + isFrequentlyUsed;
	}
	
	public String Technique() {
		return technique;
	}
	
	public int AppsInstalled() {
		return appsInstalled;
	}
	
	public boolean IsFrequentlyUsed() {
		return isFrequentlyUsed;
	}
}
