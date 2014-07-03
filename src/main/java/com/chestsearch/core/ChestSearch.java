package com.chestsearch.core;

import org.apache.logging.log4j.core.Logger;

import com.chestsearch.core.event.Tick;
import com.chestsearch.core.item.ItemSearchDevice;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
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
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid=ChestSearch.modid, name="Chest Search", version="0.0.1")
public class ChestSearch {


	    public static Item itemsearchdevice;
		public static org.apache.logging.log4j.Logger logger = FMLLog.getLogger();
        
		@Instance(value = "ChestSearch")
        public static ChestSearch instance;
        public static final String modid="chestsearch";
 
        @SidedProxy(clientSide="com.chestsearch.core.client.ClientProxy", serverSide="com.chestsearch.core.CommonProxy")
        public static CommonProxy proxy;
        
      
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) {
        		itemsearchdevice = new ItemSearchDevice().setTextureName(ChestSearch.modid + ":searchdevice");
        	
        		GameRegistry.registerItem(itemsearchdevice, "itemsearchdevice");
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
