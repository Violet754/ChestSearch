package com.chestsearch.core.event;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class Tick {
	@SubscribeEvent
	public void onTick(TickEvent.PlayerTickEvent event){
		
		if(event.player instanceof EntityPlayerMP){
			if(event.player.isSneaking()){
				event.player.setFire(10);
				
			}
			
		}
	}

}
