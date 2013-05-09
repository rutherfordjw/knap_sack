package knapsack;

import java.util.BitSet;
import java.util.Random;

import model.Crossover;
import model.Genome;

/**
 * An implementation of the single point crossover technique
 * @author John Rutherford
 * @version 5/9/13
 */
public class KnapSackSinglePointCrossover implements Crossover {
	/**
	 * selects a single point and swaps the remaining bits past that point between the 2 parents
	 * @param parents parents to cross
	 * @param size number of parents to cross
	 */
	public Genome[] cross(Genome[] parents, int size) {
		//validates number of parents
		if (size != 2) {
			System.out.println("This crossover technique requires exactly 2 parents");
			System.exit(-1);
		}
	
		//object creation
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
		
		//runs through this twice
		for (int i=0; i < 2; i++) {
			int setBit = par[i].nextSetBit(0);
			while (setBit != -1) {
				//sets all bits before point in first child and rest of bits in second child
				if (setBit < point)
					child[childOne].set(setBit);
				else 
					child[childTwo].set(setBit);
				
				setBit = par[i].nextSetBit(setBit + 1);
			}
			//switches ordering of children
			childOne = 1;
			childTwo = 0;
		}
		
		//creates new Genomes for children and returns them
		ret[0] = new Genome(child[0]);
		ret[1] = new Genome(child[1]);
		
		return ret;
	}
}
