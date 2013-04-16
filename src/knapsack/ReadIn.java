package knapsack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import controller.Read;

/**
 * Reads a file in and stores the list of items and the capacity of the sack
 * @author John Rutherford
 * @version 4/16/13
 */
public class ReadIn implements Read {
	private int numItems = -1;
	private double capacity;
	private SackItem[] items;
	
	/**
	 * for testing purposes
	 * @param args
	 */
	public static void main(String args[]) {
		ReadIn read = new ReadIn();
		read.read("dat/test.dat");
		
		SackItem[] items = read.getItems();
		System.out.println("Capacity: " + read.getCapacity());
		System.out.println("Items: ");
		for (int i=0; i < read.numItems; i++) {
			System.out.println(items[i].getBenefit() + "\t" + items[i].getVolume());
		}
	}
	
	/**
	 * reads and parses a file into usable objects for the knapsack genetic algorithm
	 * @param src location of input file
	 */
	public void read(String src) {
		int lineNum = 0;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(src));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		boolean done = false;
		while (!done) {
			String line = null;
			try {
				line = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if (!line.startsWith("#") && !line.isEmpty()) {
				double benefit;
				double volume;
				
				if (lineNum > 1) {
					String vals[] = line.split("\\s+");
					benefit = Double.parseDouble(vals[0]);
					volume = Double.parseDouble(vals[1]);
					items[lineNum - 2] = new SackItem(benefit, volume);
					lineNum++;
				} else if (lineNum == 0) {
					numItems = Integer.parseInt(line);
					items = new SackItem[numItems];
					lineNum++;
				} else if (lineNum == 1) {
					capacity = Double.parseDouble(line);
					lineNum++;
				}
			}
			
			if (lineNum - 2 == numItems) {
				done = true;
			}
		}
	}
	
	//getters
	public SackItem[] getItems() {
		return items;
	}
	
	public double getCapacity() {
		return capacity;
	}
}
