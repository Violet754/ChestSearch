package com.chestsearch.core.event;

import java.util.List;

import com.chestsearch.core.ChestSearch;
import com.chestsearch.core.inventory.InventoryHelper;
import com.chestsearch.core.item.ItemSearchDevice;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;







@SideOnly(Side.CLIENT)
public class Tick {
	private Minecraft mc; 
	//Search variable -note replace with search gui variable when gui is made
	private String search = "bed";
	private TileEntityChest invent;
	
	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent event){
		EntityPlayer player = event.player;
			if (player.getHeldItem() != null){
				if(player.getHeldItem().getUnlocalizedName().contains("search")){
					TileEntity ent = InventoryHelper.GetChestsNearPlayer();
					
				
					if(ent != null){
						invent = (TileEntityChest) ent;
								if(InventoryHelper.containsItem(invent, search)){
									//Debug remove when working
									event.player.setFire(1);
									System.out.println("Player set on fire for searching item:" + search);
						}
						
					
				}	
			}
				
		}
  }
	
}

