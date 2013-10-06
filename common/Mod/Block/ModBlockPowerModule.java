package Mod.Block;

import Mod.Lib.Refrence;
import Mod.Main.Main;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public abstract class ModBlockPowerModule extends BlockContainer{

	protected ModBlockPowerModule(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setHardness(2);
	}
	
	public Icon TopIcon;
	public Icon SideIcon;
	
	public abstract boolean CanWork(World world, int X, int Y, int Z);
	public abstract int PowerGenerated();
	public abstract int WorkTime();
	
	
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
    
    
    
    @SideOnly(Side.CLIENT)
	   public void registerIcons(IconRegister par1IconRegister)
	   {
		   this.blockIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "Module");
		   this.SideIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "ModuleBlank");
		   this.TopIcon = SideIcon;
		   
	   }
	   
	    public Icon getIcon(int par1, int par2)
	    {
	        return par1 == 1 ? TopIcon : (par1 == 0 ? this.blockIcon : (par1 != 2 && par1 != 4 ? this.SideIcon : SideIcon) );
	    }
	    
	    public void OnWork(World world, int x, int y, int z){}

}
