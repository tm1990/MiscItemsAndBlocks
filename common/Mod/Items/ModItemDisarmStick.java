package Mod.Items;

import java.util.List;

import Mod.Lib.Refrence;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ModItemDisarmStick extends Item{

	public ModItemDisarmStick(int par1) {
		super(par1);
	}
	
    public boolean hitEntity(ItemStack stack, EntityLivingBase EntityHit, EntityLivingBase EntityAttacker)
    {
    	
    	
    	if(EntityHit instanceof EntityPlayer){
    		EntityPlayer player = (EntityPlayer)EntityHit;
    		
    		player.inventory.dropAllItems();
    	}else{
    		EntityHit.setDead();
    	}
    	
    	return false;
    }
    
    @Override
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
    {
            list.add("Disarms the player hit.");
            list.add("Creative only!");
    }
    
    public void registerIcons(IconRegister par1IconRegister)
    {
    	
        this.itemIcon = par1IconRegister.registerIcon("stick");
        
    }


}
