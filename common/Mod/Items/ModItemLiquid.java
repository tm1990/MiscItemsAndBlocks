package Mod.Items;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import Mod.Lib.Refrence;
import Mod.Main.Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModItemLiquid extends Item{

	
	Icon[] Textures = new Icon[20];
	
	
	public ModItemLiquid(int par1) {
		super(par1);

		this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setMaxStackSize(1);
        this.setCreativeTab(Main.CreativeTab);
		
	}
	
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
    	
        this.Textures[0] = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "AppleJuice");
        this.Textures[2] = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "OrangeJuice");
        this.Textures[1] = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "TomatoSauce");
        this.Textures[3] = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "CarrotJuice");
    }
    
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	
    	if(Drinkable(par1ItemStack.getItemDamage())){
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
    	}
        return par1ItemStack;
    	
    }
    
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        return false;
    }
    
    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
    {
    	
    	player.addPotionEffect(GetEffect(stack.getItemDamage()));
    	
    	if(player.capabilities.isCreativeMode == false){
    	player.inventory.getCurrentItem().stackSize = 0;
    	player.inventory.addItemStackToInventory(ReturnItem(stack.getItemDamage()));
    	}
    	return stack;
    }
    
    public Icon getIconFromDamage(int meta)
    {

    	return Textures[meta];

    }
    
    public String getItemDisplayName(ItemStack stack)
    {
    	int meta = stack.getItemDamage();

    	
    	if(meta == 0)return StatCollector.translateToLocal("items.name.liquid.1");
    	if(meta == 1)return StatCollector.translateToLocal("items.name.liquid.2");
    	if(meta == 2)return StatCollector.translateToLocal("items.name.liquid.3");
    	if(meta == 3)return StatCollector.translateToLocal("items.name.liquid.4");
    	
    	
    	
    	return null;
    }
    
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List list)
    {
        super.getSubItems(par1, par2CreativeTabs, list);
        
        list.add(new ItemStack(par1, 1, 1));
        list.add(new ItemStack(par1, 1, 2));
        list.add(new ItemStack(par1, 1, 3));
        
    }
    
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 32;
    }
    
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.drink;
    }
    
    public boolean Drinkable(int meta){
    	
    	if(GetEffect(meta) != null)return true;
    	
    	return false;
    }
    
    public PotionEffect GetEffect(int meta){
    	
    	if(meta == 0)return new PotionEffect(Potion.regeneration.id, 300);
    	if(meta == 2)return new PotionEffect(Potion.regeneration.id, 600);
    	if(meta == 3)return new PotionEffect(Potion.nightVision.id, 300);
    	
    	return null;
    }
    
    public ItemStack ReturnItem(int meta){
    	
    	if(meta == 0)return new ItemStack(Item.glassBottle);
    	if(meta == 2)return new ItemStack(Item.glassBottle);
    	if(meta == 3)return new ItemStack(Item.glassBottle);
    	
    	return null;
    }
    
    @Override
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
    {
            int meta = itemstack.getItemDamage();
            
            if(meta == 0){list.add(StatCollector.translateToLocal("items.desc.liquid.defaultdesc")); list.add(StatCollector.translateToLocal("items.desc.liquid.1_effect"));}
            if(meta == 1)list.add(StatCollector.translateToLocal("items.desc.liquid.2"));
            if(meta == 2){list.add(StatCollector.translateToLocal("items.desc.liquid.defaultdesc")); list.add(StatCollector.translateToLocal("items.desc.liquid.3_effect"));}
            if(meta == 3){list.add(StatCollector.translateToLocal("items.desc.liquid.defaultdesc")); list.add(StatCollector.translateToLocal("items.desc.liquid.4_effect"));}
    }

}
