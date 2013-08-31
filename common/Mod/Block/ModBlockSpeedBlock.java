package Mod.Block;

import Mod.Lib.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ModBlockSpeedBlock extends Block{

	public ModBlockSpeedBlock(int par1) {
		super(par1, Material.rock);
		this.slipperiness = 1.2F;
		this.setHardness(0.7F);
	}
	
    @SideOnly(Side.CLIENT)
    private Icon Top;
    
    @SideOnly(Side.CLIENT)
    private Icon TextureSide;
    

    
    @SideOnly(Side.CLIENT)

    public Icon getIcon(int par1, int par2)
    {
    	
        return par1 == 1 ? Top : TextureSide;
    }
    
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.Top = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "SpeedTop");
        this.TextureSide = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "SpeedSide");
    }
    
 
    
    
    
    


}
