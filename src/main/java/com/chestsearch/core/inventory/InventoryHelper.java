package com.chestsearch.core.inventory;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;



public class InventoryHelper {
	private static int slot;
	//use when searching for a item in a inventory [WIP]
	public static boolean containsItem(TileEntityChest Inv, String lookingfor){
		
		while(slot <= Inv.getSizeInventory()){

			if(Inv.getStackInSlot(slot) != null){
				System.out.println("Slot:"+ Inv.getStackInSlot(slot).getUnlocalizedName().toString());
					System.out.println("WE FOUND A ITEM");
				if(Inv.getStackInSlot(slot).getUnlocalizedName().toString().contains(lookingfor)){
					System.out.println("Item match");
					return true;
				}
			}
			slot++;
			if(slot >= Inv.getSizeInventory()){
				slot = 0;
				return false;
			}
		}
		return false;
		
	}
	
}
