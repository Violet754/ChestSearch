package com.chestsearch.core.event;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
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
		MovingObjectPosition Pos = event.player.rayTrace(100, 1.0F);
		if( Pos.equals(living) == false){
			
			 Block block = mc.getMinecraft().theWorld.getBlock(Pos.blockX, Pos.blockY, Pos.blockZ);
			 if(block.getUnlocalizedName().contains("chest") == true){
				 block.setLightLevel(17);
			 }
			
		}
  }
	
}

