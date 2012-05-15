package com.rao.storediqtest.problem1;

import java.util.ArrayList;

public class Shelf {

	int maxItems = 5;
	float maxWeightLimit=300.0f;
	
	int itemsCounter;
	float currentWeight;
	
	
	final ArrayList<Item> items;
	
	public Shelf()
	{
		items = new ArrayList<Item>(maxItems);
	}
	
	public Shelf(int MaxItems, int MaxWeightSupported)
	{
		this.maxItems=MaxItems;
		items = new ArrayList<Item>(maxItems);
		this.maxWeightLimit = MaxWeightSupported;
	}
	
	public int addToShelf(Item i)
	{
		float a= currentWeight + i.getWeight();
		
		if(a <= maxWeightLimit && itemsCounter < maxItems)
			{
				this.items.add(i);
				this.currentWeight+=i.getWeight();
				this.itemsCounter++;
				
			return itemsCounter;
			}
		
		return -1;
	}
	
	
}
