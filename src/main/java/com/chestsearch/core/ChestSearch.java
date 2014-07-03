package com.chestsearch.core;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; 
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;


@Mod(modid="ChestSearch", name="Chest Search", version="0.0.1")
public class ChestSearch {


        @Instance(value = "ChestSearch")
        public static ChestSearch instance;
        
 
        @SidedProxy(clientSide="com.chestsearch.core.client.ClientProxy", serverSide="com.chestsearch.core.CommonProxy")
        public static CommonProxy proxy;
        
        
        public void onUpdate(ItemStack item,World world,Entity entity,int par4,boolean par5){
    	if(entity instanceof EntityPlayerMP && ((EntityPlayerMP) entity).getHeldItem().getUnlocalizedName() == "" || entity instanceof EntityPlayerMP && ((EntityPlayerMP) entity).getEquipmentInSlot(103).getUnlocalizedName() == ""){
        	entity = (EntityPlayerMP)entity;
        	
        }
    	
        }

        public void preInit(FMLPreInitializationEvent event) {
                
        }
        

        public void load(FMLInitializationEvent event) {
                proxy.registerRenderers();
        }
        

        public void postInit(FMLPostInitializationEvent event) {

        }
}
