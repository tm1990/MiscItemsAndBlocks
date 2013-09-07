package Mod.Block;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import Mod.Items.ModItems;
import Mod.Lib.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModBlockTomatoPlant extends BlockCrops {

	
	
	Icon[] IconArray = new Icon[5];
	
	
	public ModBlockTomatoPlant(int par1) {
		super(par1);
        float f = 0.5F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
        this.setTickRandomly(true);
	}
	
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        return null;
    }
       
    public int getRenderType() {
        return 6;
    }
   
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public Icon getIcon(int par1, int par2)
    {

    	
        if (par2 < 0 || par2 > 4)
        {
            par2 = 4;
        }

        
        return this.IconArray[par2];


    }
    
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IconRegister par1IconRegister)
	   {
		   
		   IconArray[0] = par1IconRegister.registerIcon(Refrence.Mod_Id + ":TomatoPlant0");
		   IconArray[1] = par1IconRegister.registerIcon(Refrence.Mod_Id + ":TomatoPlant1");
		   IconArray[2] = par1IconRegister.registerIcon(Refrence.Mod_Id + ":TomatoPlant2");
		   IconArray[3] = par1IconRegister.registerIcon(Refrence.Mod_Id + ":TomatoPlant3");
		   IconArray[4] = par1IconRegister.registerIcon(Refrence.Mod_Id + ":TomatoPlant4");
		   
		   
		   
	   }
	   
	   @Override
	    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	    {
	        super.updateTick(par1World, par2, par3, par4, par5Random);

	        if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
	        {
	            int l = par1World.getBlockMetadata(par2, par3, par4);

	            if (l < 7)
	            {
	                float f = this.getGrowthRate(par1World, par2, par3, par4);

	                if (par5Random.nextInt((int)(25.0F / f) + 1) == 0)
	                {
	                    ++l;
	                    par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
	                }
	            }
	        }
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
	   
	    
	    private float getGrowthRate(World par1World, int par2, int par3, int par4)
	    {
	        float f = 1.0F;
	        int l = par1World.getBlockId(par2, par3, par4 - 1);
	        int i1 = par1World.getBlockId(par2, par3, par4 + 1);
	        int j1 = par1World.getBlockId(par2 - 1, par3, par4);
	        int k1 = par1World.getBlockId(par2 + 1, par3, par4);
	        int l1 = par1World.getBlockId(par2 - 1, par3, par4 - 1);
	        int i2 = par1World.getBlockId(par2 + 1, par3, par4 - 1);
	        int j2 = par1World.getBlockId(par2 + 1, par3, par4 + 1);
	        int k2 = par1World.getBlockId(par2 - 1, par3, par4 + 1);
	        boolean flag = j1 == this.blockID || k1 == this.blockID;
	        boolean flag1 = l == this.blockID || i1 == this.blockID;
	        boolean flag2 = l1 == this.blockID || i2 == this.blockID || j2 == this.blockID || k2 == this.blockID;

	        for (int l2 = par2 - 1; l2 <= par2 + 1; ++l2)
	        {
	            for (int i3 = par4 - 1; i3 <= par4 + 1; ++i3)
	            {
	                int j3 = par1World.getBlockId(l2, par3 - 1, i3);
	                float f1 = 0.0F;

	                if (blocksList[j3] != null && blocksList[j3].canSustainPlant(par1World, l2, par3 - 1, i3, ForgeDirection.UP, this))
	                {
	                    f1 = 1.0F;

	                    if (blocksList[j3].isFertile(par1World, l2, par3 - 1, i3))
	                    {
	                        f1 = 3.0F;
	                    }
	                }

	                if (l2 != par2 || i3 != par4)
	                {
	                    f1 /= 4.0F;
	                }

	                f += f1;
	            }
	        }

	        if (flag2 || flag && flag1)
	        {
	            f /= 2.0F;
	        }

	        return f;
	    }
	    
	    protected int getSeedItem()
	    {
	        return ModItems.TomatoSeeds.itemID;
	    }


	    protected int getCropItem()
	    {
	        return ModItems.Tomato.itemID;
	    }

	    
	    public void fertilize(World par1World, int par2, int par3, int par4)
	    {
	        int l = par1World.getBlockMetadata(par2, par3, par4) + MathHelper.getRandomIntegerInRange(par1World.rand, 2, 5);

	        if (l > 4)
	        {
	            l = 4;
	        }

	        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
	    }
	    
	    
	    public int idDropped(int par1, Random par2Random, int par3)
	    {
	        return par1 == 4 ? this.getCropItem() : this.getSeedItem();
	    }


}
