package Mod.Items;

import Mod.Lib.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ModItemSilverArrow extends Item
{

	public ModItemSilverArrow(int par1) {
		super(par1);
	}

	
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
    	
    	this.itemIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":SilverArrow");
    }
    	


}
