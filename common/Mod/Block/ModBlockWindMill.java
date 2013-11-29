package Mod.Block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import Mod.Lib.Refrence;
import Mod.TileEntity.TileEntityWindMill;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModBlockWindMill extends BlockContainer {

	public ModBlockWindMill(int par1) {
		super(par1, Material.iron);
		this.setHardness(2);
	}
	
	Icon IconTop;
	Icon IconSide;

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityWindMill();
	}


	
    @SideOnly(Side.CLIENT)
	   public void registerIcons(IconRegister par1IconRegister)
	   {
		   this.IconSide = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "WindMillSide");
		   this.IconTop = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "ModuleBlank");
		   
	   }
    
	@Override
	public Icon getIcon(int side, int metadata)
	{
		
		return (side == 0 ? (IconTop) : (side == 1 ? IconTop : side == 0 ? IconSide : IconSide));
	}
    

}
