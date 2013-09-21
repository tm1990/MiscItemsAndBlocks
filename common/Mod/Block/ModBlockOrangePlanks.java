package Mod.Block;

import Mod.Lib.Refrence;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class ModBlockOrangePlanks extends Block{

	public ModBlockOrangePlanks(int par1) {
		super(par1, Material.wood);
		
		this.setStepSound(soundWoodFootstep);
	}
	
    public void registerIcons(IconRegister par1IconRegister)
    {

    	this.blockIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "OrangePlanks");

        
    }

}
