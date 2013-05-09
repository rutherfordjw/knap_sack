package controller;

/**
 * @author John Rutherford
 * @version 5/9/13
 * An interface providing necessary methods for reading in an input file
 */
import knapsack.SackItem;

public interface Read {
	public void read(String filename);
	public SackItem[] getItems();
	public double getCapacity();
}
