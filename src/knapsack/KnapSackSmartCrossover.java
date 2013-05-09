package knapsack;

import java.util.BitSet;

import model.Crossover;
import model.Genome;

/**
 * A Crossover Technique using two parents for the 0-1 knapsack problem
 * @author John Rutherford
 * @version 5/9/13
 */
public class KnapSackSmartCrossover implements Crossover {
	/**
	 * Takes two parents and alternates the bits to create two new children
	 * @param parents a list of parent Genomes used for crossing
	 * @param number of parents listed
	 * @return 2 new children Genomes 
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

        int length = parents.length;

        BitSet[] child = new BitSet[2];
		child[0] = new BitSet(length);
		child[1] = new BitSet(length);
        
        boolean oneDone = false;
        boolean twoDone = false;
        
        int[] setBit = new int[2];
        setBit[0] = par[0].nextSetBit(0);
        setBit[1] = par[1].nextSetBit(0);
        
        int select1 = 0;
        int select2 = 1;

        //alternate setting the bits of parents until one parent has gone through
        //all of its set bits
        while (!oneDone && !twoDone) {
            child[0].set(setBit[select1]);
            child[1].set(setBit[select2]);
            
            int temp = select1;
            select1 = select2;
            select2 = temp;

            if (!oneDone) {
                setBit[0] = par[0].nextSetBit(setBit[0]+1);
                if (setBit[0] == -1) {
                    oneDone = true;
                }
            }

            if (!twoDone) {
                setBit[1] = par[1].nextSetBit(setBit[1]+1);
                if (setBit[1] == -1) {
                    twoDone = true;
                }
            }
        }

        //creates a list of children Genomes and returns it
	    Genome[] ret = new Genome[2];	
		ret[0] = new Genome(child[0]);
		ret[1] = new Genome(child[1]);
		
		return ret;
	}
}
