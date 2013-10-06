package Mod.Block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import Mod.Lib.Refrence;
import Mod.TileEntity.TileEntityWindMill;

public class ModBlockWindMill extends ModBlockPowerModule {

	public ModBlockWindMill(int par1) {
		super(par1, Material.iron);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityWindMill();
	}

	@Override
	public boolean CanWork(World world, int X, int Y, int Z) {
		return Y > 80;
	}

	@Override
	public int PowerGenerated() {
		return 1;
	}

	@Override
	public int WorkTime() {
		return 8;
	}
	
    @SideOnly(Side.CLIENT)
	   public void registerIcons(IconRegister par1IconRegister)
	   {
		   this.blockIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "Module");
		   this.SideIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "WindMillSide");
		   this.TopIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "ModuleBlank");
		   
	   }

}
