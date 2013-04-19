package knapsack;

import java.util.BitSet;
import java.util.Random;

import model.Genome;
import model.Mutation;

public class KnapSackMutation implements Mutation {
	private Random rand = new Random();
	
	public Genome mutate(Genome victim) {
		BitSet bits = victim.getBits();
		bits.flip(rand.nextInt(bits.length()));
		return new Genome(bits);
	}
}
