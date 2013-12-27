package Mod.Items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Mod.Lib.Refrence;
import Mod.Main.Main;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.Icon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ModItemXpExtractor extends Item{

	private static EntityPlayer player;
	
	private Icon _icon1;
private Icon _icon2;
private Icon _icon3;
	
	public ModItemXpExtractor(int par1) {
		super(par1);
		
		setCreativeTab(Main.CreativeTab);
        this.maxStackSize = 1;
        this.setUnlocalizedName("XpExtractor");
       
	}
	
	
    public ItemStack onItemRightClick(ItemStack stack, World par2World, EntityPlayer player)
    {

    	
    	if(player.experienceLevel > 0 ){
    	
    		if(player.inventory.hasItem(Item.glassBottle.itemID) || player.capabilities.isCreativeMode){
    			
    			player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
    			
    	
    	}
    	
    	}
    	
        return stack;
    }
    

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
    	
    	_icon1 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + getUnlocalizedName().substring(5) + ".1");
    	_icon2 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + getUnlocalizedName().substring(5) + ".2");
    	_icon3 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + getUnlocalizedName().substring(5) + ".3");
    	
    	itemIcon = _icon1;
    }
    
	@Override
public EnumAction getItemUseAction(ItemStack stack)
{
return EnumAction.bow;
}
	
	@Override
public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
{

		if(player.experienceLevel > 0 && player.inventory.hasItem(Item.glassBottle.itemID) || player.capabilities.isCreativeMode)

		{

			player.addExperienceLevel(-1);

			player.inventory.consumeInventoryItem(Item.glassBottle.itemID);

			if(!player.inventory.addItemStackToInventory(new ItemStack(Item.expBottle)))

			{

				player.dropItem(Item.expBottle.itemID, 1);

			}

		}
return stack;
}
	
	@Override

	public Icon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)

	{

		//TODO Look at before 1.7
		if(usingItem != null && usingItem.itemID == itemID)

		{

			if(useRemaining > 24)  return _icon1;

			if(useRemaining > 12) return _icon2;

			return _icon3;

		}

		return _icon1;

	}
	
	@Override
public int getMaxItemUseDuration(ItemStack stack)
{
return 32;
}
	
    @Override
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
    {
            list.add(StatCollector.translateToLocal("items.desc.xpextractor.1") + ": ");
            list.add("1." +  StatCollector.translateToLocal("items.desc.xpextractor.2"));
            list.add("2." + StatCollector.translateToLocal("items.desc.xpextractor.3"));
    }
    
    
    

}
