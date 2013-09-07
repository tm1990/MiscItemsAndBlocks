package Mod.Items;

import java.util.List;

import Mod.Lib.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.Icon;

public class ModItemPizza extends ItemFood{
	
	
	Icon Pizza;

	public ModItemPizza(int par1) {
		super(par1, 6, false);
		
		this.setPotionEffect(Potion.field_76443_y.id, 10, 2, 1F);

	}
	
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
    	
        
        this.Pizza = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "Pizza");


    }
    
    public Icon getIconFromDamage(int meta)
    {


    		return Pizza;

    }
    
    public String getItemDisplayName(ItemStack stack)
    {
    	int meta = stack.getItemDamage();

    	
    	if(meta == 0)return "Fish Pizza";
    	if(meta == 1)return "Pork Pizza";
    	if(meta == 2)return "Beef Pizza";
    	if(meta == 3)return "Chicken Pizza";
    	
    	
    	
    	return null;
    }
    
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List list)
    {
        super.getSubItems(par1, par2CreativeTabs, list);
        
        list.add(new ItemStack(par1, 1, 1));
        list.add(new ItemStack(par1, 1, 2));
        list.add(new ItemStack(par1, 1, 3));
        
    }

}
