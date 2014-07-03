package com.chestsearch.core;

import org.apache.logging.log4j.core.Logger;

import com.chestsearch.core.event.Tick;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; 
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid="ChestSearch", name="Chest Search", version="0.0.1")
public class ChestSearch {


        
		public static org.apache.logging.log4j.Logger logger = FMLLog.getLogger();
        
		@Instance(value = "ChestSearch")
        public static ChestSearch instance;
        
 
        @SidedProxy(clientSide="com.chestsearch.core.client.ClientProxy", serverSide="com.chestsearch.core.CommonProxy")
        public static CommonProxy proxy;
        
      
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) {

        }
        
        @EventHandler
    	public void init(FMLInitializationEvent event) {
                proxy.registerRenderers();
                proxy.initialize();
               
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) {

        }
}
