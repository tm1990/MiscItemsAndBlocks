package Mod.Block;

import java.util.List;

import Mod.Lib.Refrence;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockColored;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ModColordHalfSlab extends BlockColored{

    @SideOnly(Side.CLIENT)
    private Icon[] iconArray;
	
	public ModColordHalfSlab(int par1) {
		super(par1, Material.cloth);
		setStepSound(soundClothFootstep);
	}

	 @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
   public Icon getIcon(int Side, int MetaData)
    {
		
        return this.iconArray[MetaData];
    }
    

    public int damageDropped(int par1)
    {
        return par1;
    }


    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int j = 0; j < 16; ++j)
        {
            par3List.add(new ItemStack(par1, 1, j));
        }
    }

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.iconArray = new Icon[16];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon("wool_colored_" + ItemDye.field_94595_b[getDyeFromBlock(i)]);
        }
    }
}
