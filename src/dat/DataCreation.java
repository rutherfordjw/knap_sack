package dat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

/**
 * Creates a random Data set with a chosen number of itmes using empty.dat
 * @author John Rutherford
 * @version 5/9/13
 */
public class DataCreation {
	private int numItems;
	private String dest;
	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Main method for running program
	 * @param args
	 */
	public static void main(String[] args) {
		DataCreation data = new DataCreation();
		data.promptUser();	
		data.createFile(data.getDest(), data.getNumItems());
		System.out.println("\nNew File Created at " + data.getDest());
	}
	
	/**
	 * Prompts the user for the file name and number of items
	 */
	public void promptUser() {
		try {
			System.out.print("File Destination: ");
			dest = in.readLine();
			System.out.print("Number of Items: ");
			numItems = Integer.parseInt(in.readLine());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Creates the file by randomizing benefit and volume of each item
	 * @param dest destination of created file
	 * @param numItems items to create
	 */
	public void createFile(String dest, int numItems) {
		File destFile = new File(dest);
		if (dest.endsWith("empty.dat")) {
			System.out.println("Invalid File Name");
			System.exit(-1);
		} 
		
		if (destFile.exists()) {
			System.out.print("File at destination " + dest + " already exists!\nWould you like to overwrite it? (y/n) : ");
			
			String ans = null;
			boolean done = false;
			while (!done) {
				try {
					ans = in.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (ans.equals("n")) {
					System.out.println("Please Use Another Name");
					System.exit(0);
				} else if (ans.equals("y")) {
					try {
						Files.delete(Paths.get(dest));
					} catch (IOException e) {
						e.printStackTrace();
					}
					done = true;
				}
			}
		}
		
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Random rand = new Random();
		double capacity = Math.abs((double)rand.nextInt(100000000)/100);
		
		String write = numItems + "\n" + capacity + "\n";
		
		for (int i=0; i < numItems; i++) {
			write = write + Math.abs((double)rand.nextInt(10000)/100) + "\t" + (double)rand.nextInt((int)capacity)/200 + "\n";
		}
		
		try {
			FileOutputStream newFile = new FileOutputStream(new File(dest));
			Files.copy(Paths.get("dat/empty.dat"), newFile);
			newFile.write(write.getBytes());
			newFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//GETTERS
	public String getDest() {
		return dest;
	}
	
	public int getNumItems() {
		return numItems;
	}
}
