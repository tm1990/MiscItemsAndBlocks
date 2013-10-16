package Mod.Block;

import Mod.Main.Main;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public abstract class ModBlockPowerMachine extends BlockContainer{

	protected ModBlockPowerMachine(int par1, Material par2Material) {
		super(par1, par2Material);
	}
	
	  public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	    {
	        if (par1World.isRemote)
	        {
	        	
	            return true;
	        }
	        else
	        {
	        	
	        	
	        	
	        	FMLNetworkHandler.openGui(par5EntityPlayer, Main.instance, 0, par1World, par2, par3, par4);
	            return true;
	        }
	    }

}
