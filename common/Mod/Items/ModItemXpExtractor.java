package Mod.Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Mod.Lib.Refrence;
import Mod.Main.Main;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ModItemXpExtractor extends Item{

	private static EntityPlayer player;
	
	public ModItemXpExtractor(int par1) {
		super(par1);
		
		setCreativeTab(Main.CreativeTab);
        this.maxStackSize = 1;
	}
	
	
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer player)
    {

    	
    	if(player.experienceLevel > 0 ){
    	
    		if(player.inventory.hasItem(Item.glassBottle.itemID) || player.capabilities.isCreativeMode){
    	player.addExperienceLevel(-1);
    	
    	
    	if(player.capabilities.isCreativeMode == false){
    	player.inventory.consumeInventoryItem(Item.glassBottle.itemID);
    	}
    	
    	player.inventory.addItemStackToInventory(new ItemStack(Item.expBottle));
    	
    	}
    	
    	}
    	
        return par1ItemStack;
    }
    

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
    	
    	this.itemIcon = par1IconRegister.registerIcon(Refrence.Mod_Name + ":" + "XpExtractor");
    }
    
    
    

}
