package controller;

import knapsack.SackItem;

public interface Read {
	public void read(String filename);
	public SackItem[] getItems();
	public double getCapacity();
}
