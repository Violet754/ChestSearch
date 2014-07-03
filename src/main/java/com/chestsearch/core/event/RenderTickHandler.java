package com.chestsearch.core.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.relauncher.Side;


//RenderTick is client side only, so we can place the SideOnly annotation here if we want:
@SideOnly(Side.CLIENT)
public class RenderTickHandler {

//we only need one method here, and you can name it whatever you want, but
//I like to name it according to the tick to which I am listening:
@SubscribeEvent
public void onRenderTick(RenderTickEvent event) {
System.out.println("sweg");

}
}