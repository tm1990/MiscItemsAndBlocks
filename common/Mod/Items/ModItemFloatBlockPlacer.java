package Mod.Items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import Mod.Block.ModBlocks;

public class ModItemFloatBlockPlacer extends ModItemPowerTool{

	protected ModItemFloatBlockPlacer(int par1) {
		super(par1, 0, EnumToolMaterial.WOOD, new Block[]{});
		this.setMaxDamage(325);
		
		
	}
	
    
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
    	return false;
    	
    }
    
    

    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
    	if(!world.isRemote){
    		if(!player.isSneaking()){
    		
    	SetBlock((int)player.posX - 1, (int)player.posY - 2, (int)player.posZ, world);
    		
        	SetBlock((int)player.posX - 2, (int)player.posY - 2, (int)player.posZ, world);
        	
        	SetBlock((int)player.posX, (int)player.posY - 2, (int)player.posZ  , world);
        	
        	SetBlock((int)player.posX - 1, (int)player.posY - 2, (int)player.posZ + 1, world);
        	
        	SetBlock((int)player.posX - 2, (int)player.posY - 2, (int)player.posZ + 1, world);
        	
        	SetBlock((int)player.posX, (int)player.posY - 2, (int)player.posZ + 1, world);
        	
        	SetBlock((int)player.posX - 2, (int)player.posY - 2, (int)player.posZ - 1, world);
        	
        	SetBlock((int)player.posX - 1, (int)player.posY - 2, (int)player.posZ - 1, world);
        	
        	SetBlock((int)player.posX, (int)player.posY - 2, (int)player.posZ - 1, world);
        	
    	
    	player.fallDistance = 0;
    	player.motionY = 0;
    	
    	stack.attemptDamageItem(1, world.rand);
    		}
    	}
    	
    
    	
        return stack;
    }
    
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
    	
    	return 0;
    }
    
    public void SetBlock(int x, int y, int z, World world){
		if(world.getBlockId(x, y, z) == 0)
		world.setBlock(x, y , z, ModBlocks.TimedBlock.blockID);
    }

    
    public int getItemEnchantability()
    {
        return -1;
    }


    @Override
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
    {
            list.add("Places a floating platform under the player.");
            list.add(EnumChatFormatting.RED + "The floating platform will disappear after a few seconds!");
    }
    
}
