package com.chestsearch.core;

import org.apache.logging.log4j.Logger;

import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

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
        public static final String VersionPub = Ver+ "."+PatchVer+"."+TestVer;
 
        //Create Items
        public static Item itemsearchdevice;
        
        //Proxy Stuff
        @SidedProxy(clientSide="com.chestsearch.core.client.ClientProxy", serverSide="com.chestsearch.core.CommonProxy")
        public static CommonProxy proxy;
        
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) {
        		logger.info("Chest Search: Starting Init Search!");
        		itemsearchdevice = new ItemSearchDevice().setTextureName(ChestSearch.modid + ":searchdevice");
        		
        		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        		config.load();
        		
        		Property searchhelm = config.get(config.CATEGORY_GENERAL, "Search Helm enabled:", true);
        		Property searchdevice = config.get(config.CATEGORY_GENERAL, "Handheld Search Enabled:", true);
        		
        		config.save();
        		if(searchdevice.getBoolean(true)){
        		GameRegistry.registerItem(itemsearchdevice, "itemsearchdevice");
        		}else{
        			logger.warn("Chest Search:Handheld Search Device Disabled!");
        		}
        		
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
