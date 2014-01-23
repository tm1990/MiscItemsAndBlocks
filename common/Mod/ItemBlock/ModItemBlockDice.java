package Mod.ItemBlock;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ModItemBlockDice extends ItemBlock{

	public ModItemBlockDice(int par1) {
		super(par1);
		this.setMaxStackSize(1);
		this.setMaxDamage(0);
	}

    public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
    {
    	return false;
    }
	
    public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player)
    {
    	
    	Random rand = new Random();
    	
    	item.setItemDamage(rand.nextInt(6));

    	
        return true;
    }
}
