package view;

import controller.ReadIn;
import model.Genome;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * @author John Rutherford
 * @version 4/8/13
 *
 * UI for running the knapsack genetic algorithm
 */
public class KnapSackInterface extends UserInterface {
    //standard input
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String args[]) {
        KnapSackInterface ui = new KnapSackInterface();
        ui.promptUser();
    }
    
    public void promptUser() {
        System.out.print("Input File: ");
        try {
            String in = br.readLine();
            ReadIn read = new ReadIn();
            read.read(in);
        } catch (IOException e) {
            System.out.println("Invalid Name");
            e.printStackTrace();
        }
    }

    public void displayBestScore(double score) {
        
    }

    public void displayStatus(String status) {

    }

    public void displayBestSolution(Genome solution) {

    }
}
