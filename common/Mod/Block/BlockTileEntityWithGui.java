package Mod.Block;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import Mod.Lib.Refrence;
import Mod.Main.ModConfig;
import Mod.Main.Main;
import Mod.TileEntity.TileEntityShelf;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockTileEntityWithGui extends BlockContainer{

	TileEntity tile;
	int GuIid;
	
	public BlockTileEntityWithGui(int par1, Material par2Material, TileEntity tile, int GuiId) {
		super(par1, par2Material);
		this.tile = tile;
		this.GuIid = GuiId;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return tile;
	}
	
	
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (par1World.isRemote)
        {
            return true;
        }
        else
        {
        	
        	
        	FMLNetworkHandler.openGui(par5EntityPlayer, Main.instance, GuIid, par1World, par2, par3, par4);
            return true;
        }
    }
    
    
    public void registerIcons(IconRegister icon) {
        this.blockIcon = icon.registerIcon(Refrence.Mod_Name + ":" + this.getUnlocalizedName().substring(5));
}

}
