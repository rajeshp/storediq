package com.rao.storediqtest.problem1;

import java.util.HashMap;

public class Warehouse {

	int racksCount;
	
	Rack[] racks ;
	
	HashMap<Integer, ItemWrapper> items_list = new HashMap<Integer, ItemWrapper>();
	
	
	
	
	public Warehouse()
	{
		
	}
	public Warehouse(int n)
	{
		racksCount = n;
		racks = new Rack[n];
		
		
	}
	public int getRacksCount() {
		return racksCount;
	}
	public void setRacksCount(int racksCount) {
		this.racksCount = racksCount;
	}
	public Rack[] getRacks() {
		return racks;
	}
	public void setRacks(Rack[] racks) {
		this.racks = racks;
	}
	
	
public int store(int id, int ownerid, int color, float weight)
	{
	
		if(items_list.containsKey(id))
		{
			return -1;
		}
		
		Item newItem = new Item();
		newItem.setItemID(id);
		newItem.setOwnerID(ownerid);
		newItem.setColor(color);
		newItem.setWeight(weight);
		
		String pos= store(newItem);
		
		if(pos!=null)
			{
			ItemWrapper iw = new ItemWrapper(newItem, pos); 
			items_list.put(id, iw);
			return 1;
			}
		
		// pos== null, therefore item cannot be stored.
		return -1;
		
		
		
	}
	
	
	private String store(Item i)
	{
				
		for(Rack rack : racks)
		{
			int k=1;
			for(Shelf s : rack.getShelves())
			{
			
				if((s.currentWeight + i.getWeight()) <= s.maxWeightLimit && s.itemsCounter<s.maxItems)
				{
					int p = s.addToShelf(i);
					return ""+rack.getLabel()+" "+k+" "+p;
				}
					
				k++;
			}
			
		}
		
		return null;
	}
		
	
	public String position(int id)
	{
		
		if(items_list.get(id)!=null)
			return items_list.get(id).position;
		else {
			return null;
		}
	}
	

	
	public void printInventory()
	{
		System.out.println();
		
		for(Rack rack : racks)
		{
			int k=1;
			System.out.println("Rack "+rack.getLabel()+" : ");
			for(Shelf s : rack.getShelves())
			{
				System.out.print("Shelf "+k+" : items="+s.itemsCounter+" currentWeight="+s.currentWeight+"    ");
				
				for(int i=0;i<s.itemsCounter;i++)
				{
					if(s.items.get(i)!=null)
					System.out.print("| id="+s.items.get(i).getItemID()+" wt="+s.items.get(i).getWeight()+" |");
				}
				System.out.println();
				k++;
			}
			
			
			System.out.println();
		}
		
		
	}
	
	
	public void printInventoryMap()
	{
		System.out.println();
		
		for(Rack rack : racks)
		{
			int k=1;
			System.out.println("Rack "+rack.getLabel()+" : ");
			for(Shelf s : rack.getShelves())
			{
				System.out.print("Shelf "+k+" : ");
				int i=0;
				for(i=0;i<s.maxItems && i<s.items.size();i++)
				{
					if(s.items.get(i)!=null)
					System.out.print("| id="+s.items.get(i).getItemID()+" wt="+s.items.get(i).getWeight()+" |");
					else {
						System.out.print("| ---EMPTY---|");
					}
				}
				
				while(i<s.maxItems)
				{
					System.out.print("| ----XX----|");
					i++;
				}
				
				
				System.out.println();
				k++;
			}
			
			
			System.out.println();
		}
		
		
	}
	
	
	
	public int retrieve(int id)
	{
		if(items_list.containsKey(id))
		{
			String pos = items_list.get(id).position;
			
			for(Rack r : racks)
			{
				if(r.label == pos.charAt(0))
				{
					
					Shelf s = r.shelves[Integer.parseInt(""+pos.charAt(2))-1];
					
					int index=0;

					if(s!=null )
					{
						
					int itemIndex = Integer.parseInt(""+pos.charAt(4)) - 1 ;
					
						if(itemIndex>=0 && itemIndex<s.items.size())
						{
							Item i = s.items.get(itemIndex);
							// item removed from the shelf, space allocated back to shelf
							s.itemsCounter--;
							s.currentWeight-=i.getWeight();
							s.items.remove(itemIndex);
							this.items_list.remove(id); //remove item from inventory register.
							return 1;
						}

						
					}
					/*for(Item i : s.items)
					{
						
						if(i.getItemID() == id)
						{
							// item removed from the shelf, space allocated back to shelf
							s.itemsCounter--;
							s.currentWeight-=i.getWeight();
							s.items.remove(index);
							this.items_list.remove(id); //remove item from inventory register.
						}
						index++;
					}*/
					
				}
				
				
			}
			
			
		}
		return -1;
	}
	
	
	
}
