package com.chestsearch.core.inventory;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;



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
	
	public static TileEntityChest GetChestsNearPlayer(){
		TileEntityChest found;
		
		List list = Minecraft.getMinecraft().theWorld.getEntitiesWithinAABB(TileEntityChest.class, AxisAlignedBB.getBoundingBox(Minecraft.getMinecraft().thePlayer.posX - 20, Minecraft.getMinecraft().thePlayer.posY - 20, Minecraft.getMinecraft().thePlayer.posZ - 20, Minecraft.getMinecraft().thePlayer.posX + 20, Minecraft.getMinecraft().thePlayer.posY + 20, Minecraft.getMinecraft().thePlayer.posZ + 20));
		for(int i = 0; i< list.size(); ++i){
			if(list.get(i) == TileEntityChest.INFINITE_EXTENT_AABB){
			TileEntity x = (TileEntity) list.get(i);
			if(x != null){
				System.out.println("FOUND SOMETHING");
				found = (TileEntityChest) x;
				return found;
			}}
			
		}
		
		
		
		return null;
		
	}
	
}
