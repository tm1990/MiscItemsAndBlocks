package Mod.Block;

import Mod.Lib.Refrence;
import Mod.Main.Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class ModBlockSilverOre extends Block{

	public ModBlockSilverOre(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(Main.CreativeTab);
		this.setHardness(70);
	}
	
	
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IconRegister par1IconRegister)
	   {
		   this.blockIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":SilverOre");
		   
	   }

}
