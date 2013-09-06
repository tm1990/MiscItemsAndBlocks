package Mod.Block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import Mod.Items.ModItems;
import Mod.Lib.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModBlockTomatoPlant extends Block {

	Icon State1;
	Icon State2;
	Icon State3;
	Icon State4;
	
	
	public ModBlockTomatoPlant(int par1) {
		super(par1, Material.plants);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F , 1.5F, 1.0F);
        this.setTickRandomly(true);
	}
	
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        return null;
    }
       
    public int getRenderType() {
        return 6; // Magic number.
    }
   
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public Icon getIcon(int par1, int par2)
    {

    	switch(par2){
    	
    	case 1:
    		return State1;
    		
    	case 2:
    		return State2;
    		
    	case 3:
    		return State3;
    		
    	case 4:
    		return State4;
    	
    	
    	default :
    		return State1;
    	}
    }
    
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IconRegister par1IconRegister)
	   {
		   this.State1 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":TomatoPlant1");
		   this.State2 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":TomatoPlant2");
		   this.State3 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":TomatoPlant3");
		   this.State4 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":TomatoPlant4");
		   
	   }
	   
	   @Override
	   public void updateTick(World world, int x, int y, int z, Random random) {
	       if (world.getBlockMetadata(x, y, z) == 1) {
	           return;
	       }

	       if (world.getBlockLightValue(x, y + 1, z) < 9) {
	           return;
	       }

	       if (random.nextInt(isFertile(world, x, y - 1, z) ? 12 : 25) != 0) {
	           return;
	       }

	       world.setBlockMetadataWithNotify(x, y, z, 1, 0);
	   }
	   
	   @Override
	   public void onNeighborBlockChange (World world, int x, int y, int z,
	           int neighborId) {
	       if (!canBlockStay(world, x, y, z)) {
	           dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
	           world.setBlockToAir(x, y, z);
	       }
	   }
	   
	   @Override
	   public boolean canBlockStay (World world, int x, int y, int z) {
	       Block soil = blocksList[world.getBlockId(x, y - 1, z)];
	       return (world.getFullBlockLightValue(x, y, z) >= 8 ||
	               world.canBlockSeeTheSky(x, y, z)) &&
	               (soil != null && soil.canSustainPlant(world, x, y - 1, z,
	                     ForgeDirection.UP, ModItems.TomatoSeeds));
	   }
	   
	   @Override
	   public int idPicked (World world, int x, int y, int z) {
	       return ModItems.TomatoSeeds.itemID;
	   }
	   
	    @Override
	    public int idDropped (int metadata, Random random, int par2) {
	        switch (metadata) {
	        case 0:
	            return ModItems.TomatoSeeds.itemID;
	        case 1:
	            return ModItems.Tomato.itemID;
	        default:
	            // Error case!
	            return -1; // air
	        }
	    }
    


}
