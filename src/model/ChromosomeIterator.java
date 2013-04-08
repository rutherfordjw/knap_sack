package model;

import java.util.Arrays;
import java.util.Iterator;

/**
 * An iterator class for chromosomes
 */
public class ChromosomeIterator implements Iterator {
    private int loc = 0;
    private Chromosome[] chromosomes;
    
    /**
     * constructor for ChromosomeIterator
     * @param chromosomes list of chromosomes
     */
    public ChromosomeIterator(Chromosome[] chromosomes) {
        this.chromosomes = chromosomes;
    }

    /**
     * checks if there are any more chromosomes
     * @return true if there is another chromosome in the array and false if there is not
     */
    public boolean hasNext() {
        if (loc >= chromosomes.length - 1)
            return false;
        return true;
    }

    /**
     * returns the next chromosome in the list
     * @return the next chromosome
     */
    public Chromosome next() {
        loc++;
        return chromosomes[loc];
    }

    /**
     * removes the chromosome at the current location
     */
    public void remove() {
        for (int i = loc; i < chromosomes.length - 1; i++) {
            chromosomes[i] = chromosomes[i+1];
        }
        chromosomes = Arrays.copyOfRange(chromosomes, 0, loc - 1);
    }
}
