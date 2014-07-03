package com.chestsearch.core.event;

import com.chestsearch.core.ChestSearch;
import com.chestsearch.core.item.ItemSearchDevice;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;







@SideOnly(Side.CLIENT)
public class Tick {
	private Minecraft mc; 
	private EntityLivingBase living;
	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent event){
		EntityPlayer player = event.player;
		MovingObjectPosition Pos = player.rayTrace(100, 1.0F);
	
	if (event.player.getHeldItem() != null){
		
		
		if(event.player.getHeldItem().getUnlocalizedName().contains("search")){
			System.out.println("hand is item");
			if( Pos.equals(living) == false){	
				Block block = mc.getMinecraft().theWorld.getBlock(Pos.blockX, Pos.blockY, Pos.blockZ);
				System.out.println("Found block:"+ block.getUnlocalizedName().toString());
					if(block.getUnlocalizedName().contains("chest") == true){
						
						
						
			 }
			
		}
		}
	}
  }
	
}

