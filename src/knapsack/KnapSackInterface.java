package knapsack;

import view.UserInterface;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * @author John Rutherford
 * @version 4/19/13
 *
 * UI for running the knapsack genetic algorithm
 */
public class KnapSackInterface extends UserInterface {
    //standard input
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    /**
     * prompts the user for necessary information
     */
    public void promptUser() {
        try {
            System.out.print("Input File: ");
            setName(br.readLine());
            System.out.print("Mutation Rate: ");
            setMRate(Double.parseDouble(br.readLine()));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    /**
     * displays the best known score in the population
     */
    public void displayBestScore(double score) {
        System.out.println("Best Score: " + score);     
    }

    /**
     * displays the status of the algorithm
     */
    public void displayStatus(String status) {
        System.out.println("Current Status:\n" + status);
    }

    /**
     * displays the best known solution of the algorithm
     */
    public void displayBestSolution(String solution) {
        System.out.println("Best Solution:\n" + solution);
    }
}
