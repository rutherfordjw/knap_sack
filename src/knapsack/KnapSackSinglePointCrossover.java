package knapsack;

import java.util.BitSet;
import java.util.Random;

import model.Crossover;
import model.Genome;

public class KnapSackSinglePointCrossover implements Crossover {
	public Genome[] cross(Genome[] parents, int size) {
		BitSet[] par = new BitSet[2];
		par[0] = parents[0].getBits();
		par[1] = parents[1].getBits();
		
		Random rand = new Random();
		int point = rand.nextInt(size - 2);
				
		BitSet[] child = new BitSet[2];
		child[0] = new BitSet(size);
		child[1] = new BitSet(size);
		
		int childOne = 0;
		int childTwo = 1;
		Genome[] ret = new Genome[2];
		
		for (int i=0; i < 2; i++) {
			int setBit = par[i].nextSetBit(0);
			while (setBit != -1) {
				if (setBit < point)
					child[childOne].set(setBit);
				else 
					child[childTwo].set(setBit);
				
				setBit = par[i].nextSetBit(setBit + 1);
			}
			childOne = 1;
			childTwo = 0;
		}
		
		ret[0] = new Genome(child[0]);
		ret[1] = new Genome(child[1]);
		
		return ret;
	}
}
