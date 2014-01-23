package Mod.ItemBlock;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ModItemBlockDiceHolder extends ItemBlock{

	public ModItemBlockDiceHolder(int par1) {
		super(par1);
	}
	
    public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
    {
    	
    	world.setBlock(x, y, z, stack.getItem().itemID, stack.getItemDamage(), 2);
    	
    	return true;
    }

}
