package Mod.Items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

public class ModItemPowerStorage extends ModItemPowerTool{

	public ModItemPowerStorage(int par1, int par2) {
		super(par1,  0, EnumToolMaterial.IRON, new Block[]{});
		this.setMaxStackSize(1);
		this.setMaxDamage(par2);
		this.damageVsEntity = 0;
	}
	
	
    @Override
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
    {
    	list.add("Can be charge in a charger.");
    	list.add("Can transfer power to another charger.");
    	int Damage = itemstack.getMaxDamage() - itemstack.getItemDamage();
    	int MaxDamage = itemstack.getMaxDamage();
    	
    	list.add("Power: " + Damage + "/" + MaxDamage);
    	
    	
    }
    
    
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
        return false;
    }
    
    public void onCreated(ItemStack item, World par2World, EntityPlayer par3EntityPlayer) {
    	
    	item.setItemDamage(item.getMaxDamage());
    	
    }

    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase)
    {
    	
    	return false;
    }
    
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List list)
    {
        super.getSubItems(par1, par2CreativeTabs, list);
        
        Item item = Item.itemsList[par1];
        
        list.add(new ItemStack(par1, 1, item.getMaxDamage()));
        
    }
	
	

}
