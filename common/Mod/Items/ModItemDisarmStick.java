package Mod.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

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
            list.add(StatCollector.translateToLocal("items.desc.disarmstick.1"));
            list.add(StatCollector.translateToLocal("items.desc.disarmstick.2"));
    }
    
    public void registerIcons(IconRegister par1IconRegister)
    {
    	
        this.itemIcon = par1IconRegister.registerIcon("stick");
        
    }


}
