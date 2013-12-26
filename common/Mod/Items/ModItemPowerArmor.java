package Mod.Items;

import java.util.List;

import Mod.Lib.Refrence;
import Mod.Main.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModItemPowerArmor extends ItemArmor {

    private String iconName;
    private int ArmorTypeNumber;
    
    private static EnumArmorMaterial material = ModItems.PowerArmor;
    
    public ModItemPowerArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, int par5) {
        super(par1, par2EnumArmorMaterial, par3, par4);
        this.setCreativeTab(Main.CreativeTab);

    }

    @Override
    public Item setUnlocalizedName(String par1Str) {
    iconName = par1Str;
    return super.setUnlocalizedName(par1Str);
    }

    @Override
        @SideOnly(Side.CLIENT)
        public void registerIcons(IconRegister par1IconRegister)
        {
            this.itemIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + iconName);
            
        }
        


    

    
    @SideOnly(Side.CLIENT)
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
    {
    	
    	if(stack.getItem() == ModItems.FlightChestPlate || stack.getItem() == ModItems.DivingHelmet || stack.getItem() == ModItems.JumpingBoots){
    		return Refrence.Mod_Id + ":" + "textures/models/armor/PowerArmor_layer_1.png";

    	}
    	if(stack.getItem() == ModItems.RunningLeggings){
    		
    		return Refrence.Mod_Id + ":" + "textures/models/armor/PowerArmor_layer_2.png";
    		
    	}else{
    		
    		
		return null;
    	}
    }
    
    public boolean getIsRepairable(ItemStack ItemToRepair, ItemStack RepairItem)
    {
        return RepairItem.getItem() == ModItems.SilverIngot;
    }
    
    
    @Override
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
    {
		list.add("");
		
    	if(itemstack.getItem() == ModItems.DivingHelmet){

    		list.add("Active when in water");
    		list.add("Gives water breathing");
    		list.add("Gives night vision");
    		
    	}else if(itemstack.getItem() == ModItems.FlightChestPlate){
    		
    		list.add("Always active");
    		list.add("Allows flight");
    		
    	}else if(itemstack.getItem() == ModItems.RunningLeggings){
    		
    		list.add("Always active while on ground");
    		list.add("Gives speed effect");
    		
    	}else if(itemstack.getItem() == ModItems.JumpingBoots){
    		
    		list.add("Always active while on ground");
    		list.add("Gives jump effect");
    		
    	}
    	
    	
    	
    	
    }
    


    
    }


