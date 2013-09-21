package Mod.Block;

import java.util.List;
import java.util.Random;

import Mod.Lib.Refrence;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ModBlockOrangeLog extends BlockRotatedPillar {

	protected ModBlockOrangeLog(int par1) {
		super(par1, Material.wood);
		this.setStepSound(soundWoodFootstep);
	}
	
    @SideOnly(Side.CLIENT)
    private Icon[] field_111052_c = new Icon[1];
    @SideOnly(Side.CLIENT)
    private Icon[] tree_top = new Icon[1];


    public int quantityDropped(Random par1Random)
    {
        return 1;
    }


    public int idDropped(int par1, Random par2Random, int par3)
    {
        return ModBlocks.OrangeLog.blockID;
    }


    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        byte b0 = 4;
        int j1 = b0 + 1;

        if (par1World.checkChunksExist(par2 - j1, par3 - j1, par4 - j1, par2 + j1, par3 + j1, par4 + j1))
        {
            for (int k1 = -b0; k1 <= b0; ++k1)
            {
                for (int l1 = -b0; l1 <= b0; ++l1)
                {
                    for (int i2 = -b0; i2 <= b0; ++i2)
                    {
                        int j2 = par1World.getBlockId(par2 + k1, par3 + l1, par4 + i2);

                        if (Block.blocksList[j2] != null)
                        {
                            Block.blocksList[j2].beginLeavesDecay(par1World, par2 + k1, par3 + l1, par4 + i2);
                        }
                    }
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)


    protected Icon getSideIcon(int par1)
    {
        return this.field_111052_c[par1];
    }

    @SideOnly(Side.CLIENT)


    protected Icon getEndIcon(int par1)
    {
        return this.tree_top[par1];
    }


    public static int limitToValidMetadata(int par0)
    {
        return par0 & 3;
    }



    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {

    	for(int i = 0; i < tree_top.length; i++){
    		
    		
    		tree_top[i] = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "OrangeLog_top_" + i);
    	}
    	
    	for(int i = 0; i < field_111052_c.length; i++){
    		
    		
    		field_111052_c[i] = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "OrangeLog_" + i);
    	}
    	
    }

    @Override
    public boolean canSustainLeaves(World world, int x, int y, int z)
    {
        return true;
    }

    @Override
    public boolean isWood(World world, int x, int y, int z)
    {
        return true;
    }

}
