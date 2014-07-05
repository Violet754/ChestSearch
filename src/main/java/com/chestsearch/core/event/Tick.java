package com.chestsearch.core.event;

import com.chestsearch.core.ChestSearch;
import com.chestsearch.core.InventoryHelper;
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
import net.minecraft.util.MovingObjectPosition;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;







@SideOnly(Side.CLIENT)
public class Tick {
	private Minecraft mc; 
	private String search = "red";
	private IInventory invent;
	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent event){
		EntityPlayer player = event.player;
			if (player.getHeldItem() != null){
				if(player.getHeldItem().getUnlocalizedName().contains("search")){
					MovingObjectPosition Pos = player.rayTrace(10, 1.0F);

					TileEntity ent = mc.getMinecraft().theWorld.getTileEntity(Pos.blockX, Pos.blockY, Pos.blockZ);
	
					if(ent != null){
						
						
				
						if(InventoryHelper.containsItem(invent, search)){
						event.player.setFire(1);
						System.out.println("PLAYER SET FIRE");
						}
						
					
				}	
			}
			
		}
  }
	
}

