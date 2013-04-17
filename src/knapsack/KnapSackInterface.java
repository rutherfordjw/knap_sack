package knapsack;

import view.UserInterface;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * @author John Rutherford
 * @version 4/16/13
 *
 * UI for running the knapsack genetic algorithm
 */
public class KnapSackInterface extends UserInterface {
    //standard input
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public void promptUser() {
        System.out.print("Input File: ");
        try {
			setName(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public void displayBestScore(double score) {
        System.out.println("Best Score: " + score);     
    }

    public void displayStatus(String status) {
        System.out.println("Current Status:\n" + status);
    }

    public void displayBestSolution(String solution) {
        System.out.println("Best Solution:\n" + solution);
    }
}