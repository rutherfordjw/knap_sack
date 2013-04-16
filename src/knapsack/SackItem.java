package knapsack;

/**
 * An item in a knapsack problem which has a benefit and a volume 
 * @author John Rutherford
 * @version 4/16/13
 */
public class SackItem {
	private double benefit;
	private double volume;
	
	/**
	 * Constructor
	 * @param benefit value of item
	 * @param volume size of item
	 */
	public SackItem(double benefit, double volume) {
		this.benefit = benefit;
		this.volume = volume;
	}
	
	//getters and setters
	public double getBenefit() {
		return benefit;
	}
	
	public void setBenefit(double benefit) {
		this.benefit = benefit;
	}
	
	public double getVolume() {
		return volume;
	}
	
	public void setVolume(double volume) {
		this.volume = volume;
	}
	
	public String toString() {
		return benefit + "|" + volume + ", ";
	}
}
