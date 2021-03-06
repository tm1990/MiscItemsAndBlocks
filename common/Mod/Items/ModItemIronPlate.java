package Mod.Items;

import java.util.List;

import Mod.Lib.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.StatCollector;

public class ModItemIronPlate extends Item{

	Icon[] Textures = new Icon[5];
	
	public ModItemIronPlate(int par1) {
		super(par1);
		this.setMaxStackSize(16);
		this.setHasSubtypes(true);
	}
	
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
    	
        this.Textures[0] = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "IronPlate");
        this.Textures[1] = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "RawIronPlate");
        this.Textures[2] = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "HardIronPlate");

    }
    
    public Icon getIconFromDamage(int meta)
    {

    	return Textures[meta];

    }
    
    public String getItemDisplayName(ItemStack stack)
    {
    	int meta = stack.getItemDamage();

    	
    	if(meta == 0)return StatCollector.translateToLocal("items.name.ironplate.1");
    	if(meta == 1)return StatCollector.translateToLocal("items.name.ironplate.2");
    	if(meta == 2)return StatCollector.translateToLocal("items.name.ironplate.3");
    	
    	
    	
    	return null;
    }
    
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List list)
    {
        super.getSubItems(par1, par2CreativeTabs, list);
        
        list.add(new ItemStack(par1, 1, 1));
        list.add(new ItemStack(par1, 1, 2));
        
    }
	   

}
