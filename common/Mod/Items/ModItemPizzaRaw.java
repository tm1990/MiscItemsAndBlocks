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

public class ModItemPizzaRaw extends ItemFood{
	
	Icon PizzaRaw;



	public ModItemPizzaRaw(int par1) {
		super(par1, 1, false);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		
		this.setPotionEffect(Potion.hunger.id, 20, 2, 0.6F);

	}
	
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
    	
        this.PizzaRaw = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "PizzaRaw");



    }
    
    public Icon getIconFromDamage(int meta)
    {

    		return PizzaRaw;
    	
    }
    
    public String getItemDisplayName(ItemStack stack)
    {
    	int meta = stack.getItemDamage();

    	
    	if(meta == 0)return "Raw Fish Pizza";
    	if(meta == 1)return "Raw Pork Pizza";
    	if(meta == 2)return "Raw Beef Pizza";
    	if(meta == 3)return "Raw Chicken Pizza";
    	
    	
    	
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
