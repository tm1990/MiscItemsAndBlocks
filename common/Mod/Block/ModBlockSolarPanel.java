package Mod.Block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Mod.Lib.Refrence;
import Mod.TileEntity.TileEntitySolarPanel;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ModBlockSolarPanel extends ModBlockPowerModule{

	public Icon TopIcon;
	public Icon SideIcon;
	
	protected ModBlockSolarPanel(int par1) {
		super(par1, Material.iron);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntitySolarPanel();
	}

	@Override
	public boolean CanWork(World world, int X, int Y, int Z) {
		if(!world.isRemote){
			
			if(world.isRaining()){
				world.setBlockMetadataWithNotify(X, Y, Z, 3, 2);
				return false;
			}
			
			if(!world.isDaytime()){
				world.setBlockMetadataWithNotify(X, Y, Z, 4, 2);
				return false;
			}
			
			
			if(world.getBlockId(X, Y - 1, Z) != ModBlocks.PowerCable.blockID && world.getBlockId(X, Y - 1, Z) != ModBlocks.Charger.blockID){
				world.setBlockMetadataWithNotify(X, Y, Z, 5, 2);
				return false;
			}
			
			if(!world.canBlockSeeTheSky(X, Y + 1, Z)){
				world.setBlockMetadataWithNotify(X, Y, Z, 2, 2);
				return false;
			}
			
			
			
			world.setBlockMetadataWithNotify(X, Y, Z, 0, 2);
			return world.canBlockSeeTheSky(X, Y + 1, Z) && world.isDaytime();
		}
		
		return false;
	}

	@Override
	public int PowerGenerated() {
		return 3;
	}

	@Override
	public int WorkTime() {
		return 5;
	}

	
	
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IconRegister par1IconRegister)
	   {
		   this.blockIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "Module");
		   this.TopIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "SolarPanelTop");
		   this.SideIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "ModuleBlank");
		   
	   }
	   
	    public Icon getIcon(int par1, int par2)
	    {
	        return par1 == 1 ? TopIcon : (par1 == 0 ? this.blockIcon : (par1 != 2 && par1 != 4 ? this.SideIcon : SideIcon) );
	    }
}
