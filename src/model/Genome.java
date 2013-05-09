package model;

import java.util.BitSet;

/**
 * @author John Rutherford
 * @version 3/27/13
 *
 * Genome stores and manipulates the chromosomes for the Genetic Algorithm
 */
public class Genome {
    private BitSet bits;

    /**
     * creates a genome with all given chromosomes
     * @param genotype an array of Chromosomes
     */
    public Genome(BitSet bits) {
        this.bits = bits;
    }
    
    /**
     * returns the chromosomes stored in Genome
     * @return stored chromosomes
     */
    public BitSet getBits() {
        return bits;
    }
    
    /**
     * returns a string representation of the Genome
     * @return String representing the BitString contained
     */
    public String toString() {
    	return bits.toString();
    }
}
