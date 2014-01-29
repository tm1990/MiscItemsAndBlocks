package Mod.Items;

import java.util.List;

import Mod.Lib.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ModItemDataChip extends Item{

	Icon[] icons = new Icon[2];
	
	public ModItemDataChip(int par1) {
		super(par1);
		this.setMaxStackSize(16);
		this.setHasSubtypes(true);
	}

	
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IconRegister par1IconRegister)
	   {
		   this.icons[0] = par1IconRegister.registerIcon(Refrence.Mod_Id + ":DataChipEmpty");
		   this.icons[1] = par1IconRegister.registerIcon(Refrence.Mod_Id + ":DataChipFull");
		   
	   }
	   
	    public Icon getIconFromDamage(int meta)
	    {
	    	
	    	return icons[meta];
	    	
	    }
	    
	    @Override
	    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	    {
	    	if(itemstack.stackTagCompound == null){
	    		list.add("No Data Stored.");
	    		
	    	}else{
	    		
	    		list.add(itemstack.stackTagCompound.getString("DataType") + " Data Stored on Chip.");

	    	}
	    	
	    	
	    	
	    }
	    
	    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
	    {
	    	if(!world.isRemote){
	    	if(player.isSneaking() && item.getItemDamage() == 1){
	    		item.setTagCompound(null);
	    		item.setItemDamage(0);
	    		player.addChatMessage("Removed Data from Chip");
	    		
	    	}
	    	}
	    	
	    	return item;
	    }
}
