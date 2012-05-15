package com.rao.storediqtest.problem1;

/**
 * @author rajeshp
 *
 */
public class Rack {

	char label;
	

	int numberOfShelves;
	
	Shelf [] shelves ;
	
	public Rack(int n )
	{
		this.numberOfShelves= n;
		shelves = new Shelf[n];
	}

	public Rack(int shelvesOnEachRack, char c) {
		// TODO Auto-generated constructor stub
		this.numberOfShelves = numberOfShelves;
		this.label = c;
		
		shelves = new Shelf[shelvesOnEachRack];
		
		for(int i=0;i<shelves.length;i++)
		{
			shelves[i] =  new Shelf();
			
		}
		
	}
	
	
	public Rack(int shelvesOnEachRack, char c, int itemsLimitInShelf, int MaxWtLimit) {
		// TODO Auto-generated constructor stub
		this.numberOfShelves = numberOfShelves;
		this.label = c;
		
		shelves = new Shelf[shelvesOnEachRack];
		
		for(int i=0;i<shelves.length;i++)
		{
			shelves[i] =  new Shelf(MaxWtLimit, itemsLimitInShelf);
			
		}
		
	}
	

	public int getNumberOfShelves() {
		return numberOfShelves;
	}

	public void setNumberOfShelves(int numberOfShelves) {
		this.numberOfShelves = numberOfShelves;
	}

	
	
	public Shelf[] getShelves() {
		return shelves;
	}

	
	public void setShelves(Shelf[] shelves) {
		this.shelves = shelves;
	}
	
	


	public char getLabel() {
		return label;
	}

	public void setLabel(char label) {
		this.label = label;
	}

	
}
