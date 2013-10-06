package Mod.Block;

import Mod.Lib.Refrence;
import Mod.Main.Main;
import Mod.TileEntity.TileEntityCharger;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ModBlockCharger extends BlockContainer{

	public Icon TopIcon;
	public Icon SideIcon;
	
	
	public ModBlockCharger(int par1) {
		super(par1, Material.iron);
		this.setHardness(3);
	}
	
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IconRegister par1IconRegister)
	   {
		   this.TopIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "Module");
		   this.SideIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "ChargerSide");
		   
	   }
	   
	    public Icon getIcon(int par1, int par2)
	    {
	        return par1 == 1 ? TopIcon : (par1 == 0 ? this.TopIcon : (par1 != 2 && par1 != 4 ? this.SideIcon : SideIcon) );
	    }

		@Override
		public TileEntity createNewTileEntity(World world) {
			return new TileEntityCharger();
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
