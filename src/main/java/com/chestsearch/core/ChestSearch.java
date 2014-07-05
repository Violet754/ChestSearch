package com.chestsearch.core;

import org.apache.logging.log4j.Logger;

import net.minecraft.item.Item;

import com.chestsearch.core.item.ItemSearchDevice;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid=ChestSearch.modid, name=ChestSearch.PubName, version=ChestSearch.Ver + "."+ ChestSearch.PatchVer + "." + ChestSearch.TestVer)
public class ChestSearch {

		
	    //Set logger
		public static Logger logger = FMLLog.getLogger();
		
		@Instance(value = "ChestSearch")
        public static ChestSearch instance;
		
		//Set Name and Version Strings
		public static final String PubName = "Chest Search";
        public static final String modid="chestsearch";
        public static final String Ver = "0";
        public static final String PatchVer = "0";
        public static final String TestVer = "1";
 
        //Create Items
        public static Item itemsearchdevice;
        
        //Proxy Stuff
        @SidedProxy(clientSide="com.chestsearch.core.client.ClientProxy", serverSide="com.chestsearch.core.CommonProxy")
        public static CommonProxy proxy;
        
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) {
        		//Temporary log message until i can come up with a better one
        		logger.info("Chest Search: Starting Init Search!");
        		itemsearchdevice = new ItemSearchDevice().setTextureName(ChestSearch.modid + ":searchdevice");
        	
        		GameRegistry.registerItem(itemsearchdevice, "itemsearchdevice");
        }
        
        @EventHandler
    	public void init(FMLInitializationEvent event) {
        		logger.info("Chest Search: Almost Done!");
                proxy.registerRenderers();
                proxy.initialize();
               
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) {
        	logger.info("Chest Search: Init Complete. Have a nice day!");

        }
}
