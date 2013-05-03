package model;

public interface Crossover {
    public Genome[] cross(Genome[] parents, int size);
}
