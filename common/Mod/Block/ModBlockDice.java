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
	
	private int Number = 1;
	private int LastNumber = Number;
	
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
    	
    	
    	Random rand = new Random();
    	
    	this.blockIcon = Dice1;
    	
    	
    	
    }
    	
    
    public Icon DiceSide(int rand){

    	switch(rand){
    	
    	case 1:
    		return this.Dice1;
    		
    	case 2:
    		return this.Dice2;
    		
    	case 3:
    		return this.Dice3;
    		
    	case 4:
    		return this.Dice4;
    		
    	case 5:
    		return this.Dice5;
    		
    	case 6:
    		return this.Dice6;
    		
    		default :
    			return this.Dice1;
    	}
    }
    
    
    
	public boolean canPlaceBlockAt(World world, int x, int y, int z){
    	Random rand = new Random();
    	
    		Number = rand.nextInt(7);
    		Number = Number - rand.nextInt(3);
    		
    		while(Number <= 0 || Number == LastNumber){
        		Number = rand.nextInt(7);
        		Number = Number - rand.nextInt(3);
    		}

    	
    	LastNumber = Number;
    	
		return false;
	}
	
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    {
    	
        return DiceSide(Number);
    }
    

}
