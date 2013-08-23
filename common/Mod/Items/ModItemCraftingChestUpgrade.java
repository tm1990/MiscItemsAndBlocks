package Mod.Items;

import java.util.List;

import Mod.Block.ModBlocks;
import Mod.Lib.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ModItemCraftingChestUpgrade extends Item{

	public ModItemCraftingChestUpgrade(int par1) {
		super(par1);
	}
	
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
    	
    	this.itemIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":CraftingChestUpgrade");
    }
    
    @Override
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
    {
            list.add("Shift-right click on crafting table to add a chest");
    }
    
    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
    {
    	
    	if(world.getBlockId(x, y, z) == Block.workbench.blockID){
    		world.setBlock(x, y, z, ModBlocks.CraftingInv.blockID);
    		
    		if(player.capabilities.isCreativeMode == false){
    			player.inventory.consumeInventoryItem(ModItems.CraftingUpgrade.itemID);
    			
    		}
    		
    	}
		return false;
    	
    	
    }

}
