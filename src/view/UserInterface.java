package view;

import model.Genome;

/**
 * @author John Rutherford
 * @version 3/27/13
 *
 * Interface setting guidelines for interacting with user
 */
public abstract class UserInterface {
    //prompts user for input needed to start running genetic algorithm
    public abstract void promptUser();
    //displays the best score found
    public abstract void displayBestScore(double score);
    //displays the current status of the genetic algorithm
    public abstract void displayStatus(String status);
    //displays the best solution found
    public abstract void displayBestSolution(Genome soln);
    
    /**
     * displays score, status, and soln, using methods written for displaying
     * each one individually
     * @param score best score found at the current time
     * @param status the current status of the algorithm
     * @param soln the best solution found at the current time
     */
    public void displayAll(double score, String status, Genome soln) {
        displayBestScore(score);
        displayStatus(status);
        displayBestSolution(soln);
    }
}
