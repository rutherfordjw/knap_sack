package model;

/**
 * An interface providing the necessary method for mutating a Genome.
 * @author John Rutherford
 * @version 5/9/13
 */
public interface Mutation {
    public Genome mutate(Genome victim);
}
