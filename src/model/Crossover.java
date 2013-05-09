package model;

/**
 * provides the necessary method for crossing two Genomes
 * @author John Rutherford
 * @version 5/9/13
 */
public interface Crossover {
    public Genome[] cross(Genome[] parents, int size);
}
