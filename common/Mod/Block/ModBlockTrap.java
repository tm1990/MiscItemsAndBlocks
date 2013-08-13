package Mod.Block;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import Mod.Lib.Refrence;
import Mod.Main.Config;
import Mod.Main.Main;
import Mod.TileEntity.TileEntityTrap;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ModBlockTrap extends BlockContainer{

	protected ModBlockTrap(int par1) {
		super(par1, Material.iron);
		setUnlocalizedName("Trap");
		setHardness(120);
		
		this.setBlockBounds(0F, 0F, 0F, 1F, 0.2F, 1F);
	}
	

	
	 
	
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {

        player.inventory.dropAllItems();	
    	
            return true;
        }
    
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
	{
	   return false;
	}

	public boolean isOpaqueCube()
	{
	   return false;
	}


	
    @Override
    public int getRenderType() {
            return -1;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
}
    
    
    
    public void registerIcons(IconRegister icon) {
        this.blockIcon = icon.registerIcon(Refrence.Mod_Name + ":Trap");
}
    
    
	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
		
		if(world.getClosestPlayer(x, y, z, 1) != null){
			
			world.getClosestPlayer(x, y, z, 1).inventory.dropAllItems();
			world.getClosestPlayer(x, y, z, 1).heal(-4);
			
		}
		
	}
	
    public void onFallenUpon(World world, int x, int y, int z, Entity par5Entity, float par6) {
    	
    	
		if(world.getClosestPlayer(x, y, z, 1) != null){
			
			world.getClosestPlayer(x, y, z, 1).inventory.dropAllItems();
			world.getClosestPlayer(x, y, z, 1).heal(-4);
			
		}
			
    	
    }
    
    

	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityTrap();
	}
		
    }




