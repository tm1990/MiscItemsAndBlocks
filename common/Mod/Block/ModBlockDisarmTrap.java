package Mod.Block;

import java.util.Iterator;
import java.util.List;
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
import net.minecraft.block.EnumMobType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ModBlockDisarmTrap extends BlockContainer{

	private Block BlockBelow;
	
	protected ModBlockDisarmTrap(int par1) {
		super(par1, Material.iron);
		setUnlocalizedName("DisarmTrap");
		setHardness(8);
		setCreativeTab(Main.CreativeTab);
		this.setBlockBounds(0F, 0F, 0F, 1F, 0.1F, 1F);
	}
	


	
	 
	
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {

    	if(player.isSneaking()){
    		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
    		if(tile_entity instanceof TileEntityDisarmTrap){
    			TileEntityDisarmTrap tile = (TileEntityDisarmTrap)tile_entity;
    			
    			if(tile.GetBlock() == null){
    				Block block = Block.blocksList[world.getBlockId(x, y - 1, z)];
    				tile.SetBlock(block);
    				
    				
    			}else{
    				tile.SetBlock(null);
    			}
    		}
    	}else{
    		
        player.inventory.dropAllItems();	
    	    	
    	}
            return true;
        }
    
    
	public boolean canPlaceBlockAt(World world, int x, int y, int z){
		
		return world.doesBlockHaveSolidTopSurface(x, y - 1, z);
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

		int Meta = world.getBlockMetadata(x, y, z);
		
		if(Meta == 0){
		
		if(entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)entity;
			
           world.playSoundEffect((double)x + 0.5D, (double)y + 0.1D, (double)z + 0.5D, "random.click", 0.3F, 0.5F);
			
			world.setBlockMetadataWithNotify(x, y, z, 1, 2);
			
			if(!player.capabilities.isCreativeMode){
			player.inventory.dropAllItems();
			entity.attackEntityFrom(DamageSource.anvil, 2);
			}
		}else{
			if(entity instanceof EntityItem){
				
		}else{
			entity.attackEntityFrom(DamageSource.anvil, 2);
			
			
		}
		}
		
		}
		
		
	}
	
    public void onFallenUpon(World world, int x, int y, int z, Entity entity, float par6) {
    	
    	onEntityWalking(world, x, y, z, entity);
			
    	
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
    
    
    

    
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
        if (!world.isRemote)
        {
        	onEntityWalking(world, x, y, z, entity);
            
        }
    }
    
    
    
    
		
    }




