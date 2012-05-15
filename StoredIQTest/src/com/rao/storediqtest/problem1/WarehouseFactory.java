package com.rao.storediqtest.problem1;

public class WarehouseFactory {

	public static Warehouse createWarehouse(int numberOfRacks, int ShelvesOnEachRack)
	{

		Warehouse  w = new Warehouse();
		
		Rack[] racks = new Rack[numberOfRacks];
		
		int a=0;
		
		char[] c = new char[]{'A','B','C','D'};
		
		for(int i=0;i<racks.length;i++)
		{
			racks[i] =  new Rack(ShelvesOnEachRack, c[a++]);
		}
		
		
		w.setRacksCount(numberOfRacks);
		w.setRacks(racks);
		
		
		
		return w;
	}

	
	public static Warehouse createWarehouse(int numberOfRacks, int ShelvesOnEachRack, int itemsLimitInShelf, int MaximumWeightLimit)
	{
		
		Warehouse  w = new Warehouse();
		
		Rack[] racks = new Rack[numberOfRacks];
		
		int a=0;
		
		char[] c = new char[]{'A','B','C','D'};
		
		for(int i=0;i<racks.length;i++)
		{
			racks[i] =  new Rack(ShelvesOnEachRack, c[a++]);
		}
		
		
		w.setRacksCount(numberOfRacks);
		w.setRacks(racks);
		
		
		
		return w;
		
	}
	
	
	
	
}
