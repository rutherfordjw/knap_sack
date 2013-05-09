package knapsack;

import java.util.BitSet;
import java.util.Random;

import model.Genome;
import model.Mutation;

/**
 * Mutates a Genome
 * @author John Rutherford
 * @version 5/9/13
 */
public class KnapSackMutation implements Mutation {
	private Random rand = new Random();
	
	/**
	 * mutates a random bit of the victim Genome
	 * @param victim Genome to be mutated
	 * @return the mutated Genome
	 */
	public Genome mutate(Genome victim) {
		BitSet bits = victim.getBits();
        int length = bits.length();
        bits.flip(rand.nextInt(length));
        return new Genome(bits);
	}
}
