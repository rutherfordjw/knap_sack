package model;

/**
 * PopMember.java
 *
 * @author Triggs, Gabriel
 * @version 2013/3/27
 */

public class PopMember {
    //our Genome of data
    private Genome dataSet;
    //the "fitness" of this PopMember
    private double fitness;

    /*
     * Name: PopMember
     * Description: Creates a new PopMember object using
     *              genes(Genome) and score(double).
     */
    public PopMember(Genome genes, double score) {
        dataSet = genes;
        fitness = score;
    }
    
    /* Name: getGenome
     * Description: returns the Genome of the pop member
     * Return: genome - the Genome of this pop member
     */
    public Genome getGenome() {
    	return dataSet;
    }
    
    /*
     * Name: getFitness
     * Description: returns the fitness value associated
     *              with this PopMember
     * Return: fitness(double) - the fitness value or "score"
     */
    public double getFitness() {
        return fitness;
    }

    /*
     * Name: setFitness
     * Description: setter function for the fitness of this PopMember
     *              using score(double)
     */
    public void setFitness(double score) {
        fitness = score;
    }
}
