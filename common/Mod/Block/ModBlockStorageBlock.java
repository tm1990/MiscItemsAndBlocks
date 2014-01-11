package Mod.Block;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import Mod.Main.Main;
import Mod.TileEntity.TileEntityStorageBlock;

public class ModBlockStorageBlock extends BlockContainer{

	protected ModBlockStorageBlock(int par1) {
		super(par1, Material.iron);

	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityStorageBlock();
	}

	
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("furnace_top");
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
