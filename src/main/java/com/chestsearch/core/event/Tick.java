package com.chestsearch.core.event;

import com.chestsearch.core.ChestSearch;
import com.chestsearch.core.InventoryHelper;
import com.chestsearch.core.item.ItemSearchDevice;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
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
	private EntityLivingBase living;
	private String search = "red";
	private IInventory invblock = null;
	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent event){
		EntityPlayer player = event.player;
			if (event.player.getHeldItem() != null){
				if(event.player.getHeldItem().getUnlocalizedName().contains("search")){
					MovingObjectPosition Pos = player.rayTrace(10, 1.0F);
					
					TileEntity ent = mc.getMinecraft().theWorld.getTileEntity(Pos.blockX, Pos.blockY, Pos.blockZ);
					
					if(ent instanceof IInventory){
						invblock = (IInventory) ent;
						if(InventoryHelper.containsItem(invblock, search)){
						event.player.setFire(1);
						System.out.println("PLAYER SET FIRE");
						}
					
				}	
			}
		}
  }
	
}

