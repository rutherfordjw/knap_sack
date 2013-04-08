package model;

import java.lang.Iterable;
import java.util.Iterator;

/**
 * @author John Rutherford
 * @version 3/27/13
 *
 * Genome stores and manipulates the chromosomes for the Genetic Algorithm
 */
public class Genome implements Iterable {
    private Chromosome[] chromosomes;

    /**
     * creates a genome with all given chromosomes
     * @param genotype an array of Chromosomes
     */
    public void Genome(Chromosome[] genotype) {
        chromosomes = genotype;
    }
    
    /**
     * returns the chromosomes stored in Genome
     * @return stored chromosomes
     */
    public Chromosome[] getChromosomes() {
        return chromosomes;
    }
    
    /**
     * returns an iterator for the current chromosoms
     * @return an iterator
     */
    public Iterator<Chromosome> iterator() {
        return new ChromosomeIterator(chromosomes);
    }
}
