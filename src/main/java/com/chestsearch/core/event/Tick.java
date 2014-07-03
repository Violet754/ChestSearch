package com.chestsearch.core.event;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;

public class Tick {
	
	@SubscribeEvent
	public void onTick(TickEvent.RenderTickEvent event){
		if(event.phase == Phase.START){
			System.out.println("IT WORKS");
			

	  }else{
		 
	  }
			
	}
  }

