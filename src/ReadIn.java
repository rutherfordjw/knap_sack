import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadIn {
	private double capacity;
	private SackItem[] items;
	
	/**
	 * for testing purposes
	 * @param args
	 */
	public static void main(String args[]) {
		ReadIn read = new ReadIn();
		read.read("dat/test.dat");
		
		System.out.println("Capacity: " + read.getCapacity());
		System.out.println("Items: ");
		SackItem[] items = read.getItems();
		for (int i=0; i < items.length; i++) {
			System.out.println(items[i].getBenefit() + " " + items[i].getVolume());
		}
	}
	
	public void read(String src) {
		int lineNum = 0;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(src));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int numItems = 0;
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
					String vals[] = line.split(" ");
					benefit = Double.parseDouble(vals[0]);
					volume = Double.parseDouble(vals[1]);
					items[lineNum - 1] = new SackItem(benefit, volume);
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
			
			if (lineNum - 1 == numItems) {
				done = true;
			}
		}
	}
	
	public double getCapacity() {
		return capacity;
	}
	
	public SackItem[] getItems() {
		return items;
	}
}
