package Mod.Block;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Mod.Lib.Refrence;
import Mod.Main.Main;
import Mod.TileEntity.TileEntityXpStorage;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockXpStorage extends BlockContainer{

	public BlockXpStorage(int par1) {
		super(par1, Material.iron);
		
		setCreativeTab(Main.CreativeTab);
		setUnlocalizedName("BlockXpStorage");

	}
	
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IconRegister par1IconRegister)
	   {
		   this.blockIcon = par1IconRegister.registerIcon(Refrence.Mod_Name + ":" + "XpStorage");
		   
	   }


	
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (par1World.isRemote)
        {
            return true;
        }
        else
        {
        	
        	FMLNetworkHandler.openGui(par5EntityPlayer, Main.instance, 1, par1World, par2, par3, par4);
            return true;
        }
    }
    
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityXpStorage();
	}
}
