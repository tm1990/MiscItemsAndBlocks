package Mod.Block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import Mod.Lib.Refrence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModBlockDice extends Block{

	Icon Dice1;
	Icon Dice2;
	Icon Dice3;
	Icon Dice4;
	Icon Dice5;
	Icon Dice6;
	
	Icon[] icons;
	
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
    	return false;
    }
	public ModBlockDice(int par1) {
		super(par1, Material.wood);
	}
	
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
    	
    	this.Dice1 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":Dice1");
    	this.Dice2 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":Dice2");
    	this.Dice3 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":Dice3");
    	this.Dice4 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":Dice4");
    	this.Dice5 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":Dice5");
    	this.Dice6 = par1IconRegister.registerIcon(Refrence.Mod_Id + ":Dice6");
    	
    	
    	this.blockIcon = Dice1;
    	
    	icons = new Icon[]{Dice1, Dice2, Dice3, Dice4, Dice5, Dice6};
    	
    }

    
    
	
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    {

        return icons[par2];
        
        
    }
    

}
