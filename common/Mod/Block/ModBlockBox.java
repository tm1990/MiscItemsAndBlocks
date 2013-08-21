package Mod.Block;

import Mod.Lib.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class ModBlockBox extends Block{

	public Icon TopIcon;
	public Icon SideIcon;
	
	public ModBlockBox(int par1) {
		super(par1, Material.wood);
	}
	
	
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IconRegister par1IconRegister)
	   {
		   this.blockIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "Box");
		   this.TopIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "BoxTop");
		   this.SideIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "BoxSide");
		   
	   }
	   
	    public Icon getIcon(int par1, int par2)
	    {
	        return par1 == 1 ? TopIcon : (par1 == 0 ? this.blockIcon : (par1 != 2 && par1 != 4 ? this.SideIcon : SideIcon) );
	    }

}
