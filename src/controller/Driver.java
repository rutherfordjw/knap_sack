package controller;

import java.util.BitSet;

import model.Crossover;
import model.Genome;
import model.Mutation;
import model.PopMember;
import model.Population;
import knapsack.KnapSackCrossover;
import knapsack.KnapSackInterface;
import knapsack.KnapSackMutation;
import knapsack.ReadIn;
import knapsack.SackItem;
import knapsack.SortedPopulation;
import view.UserInterface;

/**
 * Driver.java
 * @author John Rutherford
 * @version 4/16/13
 * 
 * Runs a genetic algorithm.
*/

public class Driver {
	
	private SackItem[] items;
	
	private Read read;
	private Population pop;
	private Crossover cross;
	private Mutation mute;
	private UserInterface ui;
	private double mRate; // the mutation rate
	
	//TODO: Insert statistics variables of some sort?
	
	/**
	 * MAIN
	 * Change these settings to change basic genetic algorithm functions such as
	 * mutation technique, user interface, crossover technique, population, and mutation rate
	 */
	public static void main(String[] args) {
		Driver driver = new Driver(new ReadIn(), new KnapSackInterface(), new SortedPopulation(), new KnapSackCrossover(), new KnapSackMutation(), 0);
		driver.run();
	}
	
	/**
	 * Creates a driver that will use the input as the elements for its genetic algorithm
	 * @param population The population of data that the program will run on
	 * @param crossover The specific crossover implementation that will recombine two PopMembers
	 * @param mutation A function object that will slightly alter a PopMember
	 * @param mutationRate the percent chance, as a double, of a mutation occurring
	 */
	public Driver(Read read, UserInterface userInterface, Population population, Crossover crossover, Mutation mutation, double mutationRate) {
		// Initialize fields
		this.read = read;
		pop = population;
		cross = crossover;
		mute = mutation;
		ui = userInterface;
		mRate = mutationRate;
	}
	
	/**
	 * Creates an empty driver for progressive initialization using the getter/setter methods
	 */
	public Driver() {
		// TODO: Something here
	}
	
	/**
	 * I don't remember why this method exists
	 */
	public void setup() {
		
	}
	
	/**
	 * This method begins the execution of the genetic algorithm
	 */
	public void run() {
		setup();
		ui.promptUser();
		read.read(ui.getName());
		items = read.getItems();
		
		pop.setItems(items);
		pop.setCapacity(read.getCapacity());
		pop.populate();
		
		PopMember best = pop.getBest();
		ui.displayBestScore(best.getFitness());
		displayBestSolution(best);
		
		while(!stopCriteriaMet()) {
			
		}
	}
	
	/**
	 * Returns a random array of parents of size numParents
	 * @param numParents the number of parents to include in the returned array
	 * @return a random array of PopMembers from the population of size numParents
	 */
	public PopMember[] selectParents(int numParents) {
		return null; //TODO: Implement
	}
	
	/**
	 * Crosses the Genotypes contained within the parameter array and adds the child/children
	 * (depending upon what crossover is being employed) to the population
	 */
	public void cross(PopMember[] parents) {
		Genome[] genomes = new Genome[parents.length];
		for (int i = 0; i < parents.length; i++) {
			genomes[i] = parents[i].getGenome();
		}
		cross.cross(genomes);
	}
	
	/**
	 * Checks whether the stopping criteria for this algorithm has been met
	 * @return true if the algorithm should stop, false otherwise
	 */
	public boolean stopCriteriaMet() {
		return true; //TODO: Implement
	}
	
	public void displayBestSolution(PopMember best) {
		BitSet bits = best.getGenome().getBits();
		
		String soln = "";
		int next = bits.nextSetBit(0);
		while (next != -1) {
			soln = soln + items[next].toString();
			next = bits.nextSetBit(next + 1);
		}
		ui.displayBestSolution(soln);
	}
	
	/*
	 * GETTER AND SETTER METHODS
	 */
	
	/**
	 * @return the population
	 */
	public Population getPop() {
		return pop; 
	}

	/**
	 * @param pop the population to set
	 */
	public void setPop(Population pop) {
		this.pop = pop; 
	}

	/**
	 * @return the crossover
	 */
	public Crossover getCross() {
		return cross;
	}

	/**
	 * @param cross the crossover to set
	 */
	public void setCross(Crossover cross) {
		this.cross = cross;
	}

	/**
	 * @return the mutation object
	 */
	public Mutation getMute() {
		return mute;
	}

	/**
	 * @param mute the mutation object to set
	 */
	public void setMute(Mutation mute) {
		this.mute = mute;
	}

	/**
	 * @return the mutation rate
	 */
	public double getmRate() {
		return mRate;
	}

	/**
	 * @param mRate the mutation rate to set
	 */
	public void setmRate(double mRate) {
		this.mRate = mRate;
	}
}