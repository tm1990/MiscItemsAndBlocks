package Mod.Block;

import Mod.Lib.Refrence;
import Mod.TileEntity.TileEntityGenerator;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ModBlockGenerator extends ModBlockPowerModule{

	protected ModBlockGenerator(int par1) {
		super(par1, Material.iron);
	}
	
	public static final int META_ISACTIVE = 0x00000008;
	public static final int MASK_DIR = 0x00000007;
	public static final int META_DIR_NORTH = 0x00000001;
	public static final int META_DIR_SOUTH = 0x00000002;
	public static final int META_DIR_EAST = 0x00000003;
	public static final int META_DIR_WEST = 0x00000000;
	
	Icon IconTop;
	Icon IconSide;
	Icon IconFront;

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityGenerator();
	}

	@Override
	public boolean CanWork(World world, int X, int Y, int Z) {
		
		TileEntityGenerator tile;
		
		if(world.getBlockTileEntity(X, Y, Z) instanceof TileEntityGenerator){
			tile = (TileEntityGenerator)world.getBlockTileEntity(X, Y, Z);
			
			if(tile.GetFuel() > 0){
				return true;
			}else{
				return false;
			}
			}
		
		return false;
	}

	@Override
	public int PowerGenerated() {
		return 3;
	}

	@Override
	public int WorkTime() {
		return 10;
	}
	
	private static int getSideFromFacing(int facing)
	{
		switch(facing)
		{
		case META_DIR_WEST:
			return 4;
			
		case META_DIR_EAST:
			return 5;
			
		case META_DIR_NORTH:
			return 2;
			
		case META_DIR_SOUTH:
			return 3;
			
		default:
			return 4;
		}
	}
	
	   public void registerIcons(IconRegister par1IconRegister)
	    {
	    	
	        this.IconTop = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "ModuleBlank");
	        this.IconSide = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "ModuleBlank");
	        this.IconFront = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "GeneratorFront");
	        this.blockIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "Module");
	        
	    }
	    
		@Override
		public Icon getIcon(int side, int metadata)
		{
			boolean isActive = ((metadata >> 3) == 1);
			int facing = (metadata & MASK_DIR);
			
			return (side == getSideFromFacing(facing) ? (IconFront) : (side == 1 ? this.IconTop : side == 0 ? this.blockIcon : this.IconSide));
		}
	    
		@Override
		public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack)
		{
			int metadata = 0;
			int facing = META_DIR_WEST;
			
			int dir = MathHelper.floor_double((double)(entity.rotationYaw * 4f / 360f) + 0.5) & 3;
			if(dir == 0)
				facing = META_DIR_NORTH;
			if(dir == 1)
				facing = META_DIR_EAST;
			if(dir == 2)
				facing = META_DIR_SOUTH;
			if(dir == 3)
				facing = META_DIR_WEST;
			
			metadata |= facing;
			world.setBlockMetadataWithNotify(x, y, z, metadata, 2);
		}
		
		
		  @Override
		    public void breakBlock(World World, int x, int y, int z, int id, int meta)
		    {
		    	TileEntity tile = World.getBlockTileEntity(x, y, z);
		    	
		    	if(tile != null && tile instanceof IInventory){
		    		IInventory inv = (IInventory)tile;
		    		
		    		for(int i = 0; i < inv.getSizeInventory(); i++){
		    			ItemStack stack = inv.getStackInSlotOnClosing(i);
		    			
		    			if(stack != null){
		    				float spawnX = x + World.rand.nextFloat();
		    				float spawnY = y + World.rand.nextFloat();
		    				float spawnZ = z + World.rand.nextFloat();
		    				
		    				
		    				EntityItem droppedItem = new EntityItem(World, spawnX, spawnY, spawnZ, stack);
		    				
		    				float mult = 0.05F;
		    				
		    				droppedItem.motionX = (-0.5 + World.rand.nextFloat()) * mult;
		    				droppedItem.motionY = (4 + World.rand.nextFloat()) * mult;
		    				droppedItem.motionZ = (-0.5 + World.rand.nextFloat()) * mult;
		    				
		    				
		    				World.spawnEntityInWorld(droppedItem);
		    				super.breakBlock(World, x, y, z, id, meta);
		    			}
		    			
		    		}
		    	}
		    }
		  
		    public void OnWork(World world, int x, int y, int z){
				
				TileEntityGenerator tile;
		    	
				if(world.getBlockTileEntity(x, y, z) instanceof TileEntityGenerator){
					tile = (TileEntityGenerator)world.getBlockTileEntity(x, y, z);
					
					tile.SetFuel(tile.GetFuel() - 1);
					
				}
		    	
		    }

}
