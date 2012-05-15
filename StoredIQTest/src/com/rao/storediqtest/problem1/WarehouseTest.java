package com.rao.storediqtest.problem1;

public class WarehouseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Warehouse warehouse = WarehouseFactory.createWarehouse(2, 3);
		
		//public int store(int id, int ownerid, int color, float weight)
		
		warehouse.store(01, 01, 01, 52.5f);
		warehouse.store(02, 01, 02, 300.0f);
		warehouse.store(03, 02, 03, 155.5f);
		warehouse.store(04, 02, 03, 55.5f);
		warehouse.store(05, 02, 03, 655.5f);
		warehouse.store(06, 02, 03, 155.5f);
		warehouse.store(07, 02, 03, 25.5f);
		warehouse.store(8, 02, 03, 15.5f);
		warehouse.store(9, 02, 03, 55.5f);
		warehouse.store(10, 02, 03, 55.5f);
		warehouse.store(11, 02, 03, 255.5f);
		warehouse.store(12, 02, 03, 10.5f);
		warehouse.store(13, 02, 03, 10.5f);
		warehouse.store(14, 03, 05, 40.5f);
		warehouse.store(15, 03, 05, 40.5f);
		warehouse.store(16, 03, 05, 300);
		warehouse.store(16, 03, 05, 290);
		warehouse.store(17, 03, 05, 300);
		warehouse.store(18, 03, 05, 70f);
		warehouse.store(19, 03, 05, 299.9999f);
		warehouse.store(20, 03, 05, 301.99f);
		
		//items will not be added since id is already present
		System.out.println(warehouse.store(01, 03, 05, 01.99f));
		System.out.println(warehouse.store(02, 03, 05, 02.99f));
		
		for(int i=1;i<21;i++)
			System.out.println(warehouse.position(i));
		
		
		System.out.println();
		
		
		
		warehouse.printInventory();
		
		System.out.println();
		
		System.out.println(warehouse.position(01));
		
		//retrieve item with id=01
		
		System.out.println("retrive item 01 "+warehouse.retrieve(01));
		System.out.println("retrive item 20 "+warehouse.retrieve(20));
		System.out.println("retrive item 16 "+warehouse.retrieve(16));
		
		System.out.println(warehouse.position(01));
		System.out.println(warehouse.position(16));
		
		
		warehouse.store(19, 03, 05, 299.9999f);
		
		warehouse.printInventory();
		
	/*	System.out.println("Inventory Map :");
		
		warehouse.printInventoryMap();*/
		
	}
	
	
	

}
