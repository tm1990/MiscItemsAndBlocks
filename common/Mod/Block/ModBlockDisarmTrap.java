package Mod.Block;

import java.util.Random;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import Mod.Items.ModItems;
import Mod.Lib.Refrence;
import Mod.Main.ModConfig;
import Mod.Main.Main;
import Mod.Misc.MiscDamage;
import Mod.TileEntity.TileEntityDisarmTrap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ModBlockDisarmTrap extends BlockContainer{

	private Block BlockBelow;
	
	protected ModBlockDisarmTrap(int par1) {
		super(par1, Material.iron);
		setUnlocalizedName("DisarmTrap");
		setHardness(120);
		setCreativeTab(Main.CreativeTab);
		this.setBlockBounds(0F, 0F, 0F, 1F, 0.2F, 1F);
	}
	
	
	

	
	 
	
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {

    	
        player.inventory.dropAllItems();	
    	    	
            return true;
        }
    
    @Override
    public void onBlockAdded(World world, int x, int y, int z){
    	
    	if(world.doesBlockHaveSolidTopSurface(x, y - 1, z) == false){
    		
    		Random rand = new Random();
    		
    		world.setBlock(x, y, z, 0);
    		world.spawnEntityInWorld(new EntityItem(world, x + rand.nextInt(3), y + rand.nextInt(3), z + rand.nextInt(3), new ItemStack(ModBlocks.DisarmTrap)));
    	}
    	
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
        this.blockIcon = icon.registerIcon(Refrence.Mod_Id + ":DisarmTrap");
}
    
    
	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
		
		if(world.getClosestPlayer(x, y, z, 3) != null && world.getClosestPlayer(x, y, z, 3).capabilities.isCreativeMode == false){
			
			world.getClosestPlayer(x, y, z, 3).inventory.dropAllItems();
			entity.attackEntityFrom(new MiscDamage("Disarm Trap", "was Disarmed"), 4);
			
		}
		
	}
	
    public void onFallenUpon(World world, int x, int y, int z, Entity entity, float par6) {
    	
    	
		if(world.getClosestPlayer(x, y, z, 3) != null && world.getClosestPlayer(x, y, z, 3).capabilities.isCreativeMode == false){
			
			world.getClosestPlayer(x, y, z, 3).inventory.dropAllItems();
			entity.attackEntityFrom(new MiscDamage("Disarm Trap", "was Disarmed"), 4);
			
		}
			
    	
    }
    
    

	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityDisarmTrap();
	}
	
    public void onNeighborBlockChange(World world, int x, int y, int z, int BlockId)
    {
    	
    	if(world.doesBlockHaveSolidTopSurface(x, y - 1, z) == false){
    		
    		Random rand = new Random();
    		
    		world.setBlock(x, y, z, 0);
    		world.spawnEntityInWorld(new EntityItem(world, x + rand.nextInt(3), y + rand.nextInt(3), z + rand.nextInt(3), new ItemStack(ModBlocks.DisarmTrap)));
    	}
    	
    	
    }
		
    }




