package model;

/**
 * Population.java
 *
 * This interface offers a base set 
 * of methods necesary for a population class.
 *
 * @author Brian Clee
 * @version 3/25/2013
 */

public interface Population {
    // Method shells
    public void insert(PopMember member);
    public void remove(PopMember member);
    public PopMember getBest();
    public PopMember[] getPopulation();
    public void populate();
    public PopMember[] returnParents(int numParents);
}
