package Mod.Items;

import Mod.Block.ModBlocks;
import Mod.Main.Main;
import Mod.TileEntity.TileEntityShelf;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ModItemShelf extends Item{

	public ModItemShelf(int par1) {
		super(par1);
		
        this.maxStackSize = 16;
        this.setCreativeTab(Main.CreativeTab);
	}
	
    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (par7 == 0)
        {
            return false;
        }
        else if (!par3World.getBlockMaterial(par4, par5, par6).isSolid())
        {
            return false;
        }
        else
        {
            if (par7 == 1)
            {
                ++par5;
            }

            if (par7 == 2)
            {
                --par6;
            }

            if (par7 == 3)
            {
                ++par6;
            }

            if (par7 == 4)
            {
                --par4;
            }

            if (par7 == 5)
            {
                ++par4;
            }

            if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
            {
                return false;
            }
            else if (par3World.isRemote)
            {
                return true;
            }
            else
            {
                {
                    par3World.setBlock(par4, par5, par6, ModBlocks.Shelf.blockID, par7, 3);
                }

                --par1ItemStack.stackSize;
                TileEntityShelf tileentitysign = (TileEntityShelf)par3World.getBlockTileEntity(par4, par5, par6);


                return true;
            }
        }
    }

}
