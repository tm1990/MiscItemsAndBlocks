package Mod.Block;

import Mod.Main.Main;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class ModBlockStair extends BlockStairs{

	public ModBlockStair(int par1, Block par2Block, int par3, String Name) {
		super(par1, par2Block, par3);
		setUnlocalizedName(Name);
		
		this.setCreativeTab(Main.CreativeTab);
	}

}
