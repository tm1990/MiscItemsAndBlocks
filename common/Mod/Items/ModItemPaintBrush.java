package Mod.Items;

import java.awt.Color;
import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import Mod.Lib.Refrence;
import Mod.Main.Main;
import Mod.TileEntity.TileEntityPaintBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModItemPaintBrush extends Item{

	Icon[] icons = new Icon[6];

			
	int Change = 1;
	
	public ModItemPaintBrush(int par1) {
		super(par1);

		this.setHasSubtypes(true);
		this.setMaxStackSize(1);
	}
	
	   @SideOnly(Side.CLIENT)
	   public void registerIcons(IconRegister reg)
	   {
		   this.icons[0] = reg.registerIcon(Refrence.Mod_Id + ":" + "PaintBrush");
		   this.icons[1] = reg.registerIcon(Refrence.Mod_Id + ":" + "PaintBrushRed");
		   this.icons[2] = reg.registerIcon(Refrence.Mod_Id + ":" + "PaintBrushGreen");
		   this.icons[3] = reg.registerIcon(Refrence.Mod_Id + ":" + "PaintBrushBlue");
		   this.icons[4] = reg.registerIcon(Refrence.Mod_Id + ":" + "PaintBrushCopy");
		   this.icons[5] = reg.registerIcon(Refrence.Mod_Id + ":" + "PaintBrushEdit");
		   
	   }
	   
	   public String getItemDisplayName(ItemStack stack)
	    {
	    	int meta = stack.getItemDamage();

	    	if(meta == 0)return EnumChatFormatting.WHITE + "Blank Paint Brush";
	    	if(meta == 1)return EnumChatFormatting.RED + "Red Paint Brush";
	    	if(meta == 2)return EnumChatFormatting.GREEN + "Green Paint Brush";
	    	if(meta == 3)return EnumChatFormatting.BLUE + "Blue Paint Brush";
	    	if(meta == 4)return EnumChatFormatting.GOLD + "Paint Copy Brush";
	    	if(meta == 5)return EnumChatFormatting.GOLD + "Paint Editor Brush";
	    	
	    	
	    	
	    	return null;
	    }
	    
	    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List list)
	    {
	        super.getSubItems(par1, par2CreativeTabs, list);
	        
	        list.add(new ItemStack(par1, 1, 1));
	        list.add(new ItemStack(par1, 1, 2));
	        list.add(new ItemStack(par1, 1, 3));
	        list.add(new ItemStack(par1, 1, 4));
	        list.add(new ItemStack(par1, 1, 5));
	        
	    }
	    
	    public Icon getIconFromDamage(int meta)
	    {

	    	return icons[meta];

	    }
	    
	    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
	    {
	    	
	    	NBTTagCompound nbt = new NBTTagCompound();
	    	
	    	if(player.isSneaking())
	    	if(stack.getItemDamage() == 5){
				player.openGui(Main.instance, 1, world, 0, 0, 0);
	    	}
	    	
	    		
	    		
	    		TileEntity tile_e = world.getBlockTileEntity(x, y, z);
	    		
	    		if(tile_e instanceof TileEntityPaintBlock){
	    			TileEntityPaintBlock tile = (TileEntityPaintBlock)tile_e;

	    	    	world.markBlockForRenderUpdate(x, y, z);
	    			
	    			int Meta = stack.getItemDamage();
	    			
	    			if(!world.isRemote)
	    			System.out.println("Red: " + tile.GetRed() + " Green: " + tile.GetGreen() + " Blue : " + tile.GetBlue());
    				
	    			
	    			if(player.isSneaking()){


	    				
	    				
	    			if(Meta == 1){
	    				tile.SetRed(tile.GetRed() - Change);
	    				return true;
	    			}else if (Meta == 2){
	    				tile.SetGreen(tile.GetGreen() - Change);
	    				return true;
	    			}else if (Meta == 3){
	    				tile.SetBlue(tile.GetBlue() - Change);
	    				return true;
	    			}else if (Meta == 0){
	    				tile.SetRed(tile.GetRed() - Change);
	    				tile.SetGreen(tile.GetGreen() - Change);
	    				tile.SetBlue(tile.GetBlue() - Change);
	    				return true;
	    			}else if (Meta == 4){
	    		        NBTTagCompound stackCompound = stack.hasTagCompound() ? stack.getTagCompound() : new NBTTagCompound();
	    		        NBTTagCompound compound = new NBTTagCompound();
	    		        
		    			  
		    			  
		    			  compound.setInteger("Red", tile.GetRed());
		    			  compound.setInteger("Blue", tile.GetBlue());
		    			  compound.setInteger("Green", tile.GetGreen());
		    			  
		    			  
		    			  
		    			  
		  	            stackCompound.setCompoundTag("Data", compound);
			            stack.setTagCompound(stackCompound);

	    			}
	    			
	    			
	    			
	    			}else{
	    				
	    				if(Meta == 1 && tile.GetRed() >= 254)
	    					return false;
	    				
	    				if(Meta == 2 && tile.GetGreen() >= 254)
	    					return false;
	    				
	    				if(Meta == 3 && tile.GetBlue() >= 254)
	    					return false;
	    				
		    			if(Meta == 1){
			    			tile.SetRed(tile.GetRed() + Change);
		    				return true;
		    				
		    			}else if (Meta == 2){
			    			tile.SetGreen(tile.GetGreen() + Change);
		    				return true;
		    				
		    			}else if (Meta == 3){
		    				tile.SetBlue(tile.GetBlue() + Change);
		    				return true;
		    			}else if (Meta == 4){
		    				
		    				
		    				
		    				if(HasInfo(stack)){

		  	    			  NBTTagCompound Compound = stack.getTagCompound().getCompoundTag("Data");
		  	    			  
		  	    			  tile.SetRed(Compound.getInteger("Red"));
		  	    			  tile.SetGreen(Compound.getInteger("Green"));
		  	    			  tile.SetBlue(Compound.getInteger("Blue"));
		  	    			  
		    				}else if (Meta == 5){
		    					

			    				if(HasInfo(stack)){

			  	    			  NBTTagCompound Compound = stack.getTagCompound().getCompoundTag("Data");
			  	    			  
			  	    			  tile.SetRed(Compound.getInteger("Red"));
			  	    			  tile.SetGreen(Compound.getInteger("Green"));
			  	    			  tile.SetBlue(Compound.getInteger("Blue"));
			  	    			  
			    				}
		    				}
		    			}
		    			
	    			}
	    			
	    			
	    			
	    			
	    		
	    		
	    		
	    	}
	    	
	    	
	    	
	        return false;
	    }
	    
	    @Override
	    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	    {
	    	if(itemstack.getItemDamage() == 4 || itemstack.getItemDamage() == 5){
	    		
	    		if(HasInfo(itemstack)){
	    			
	    			
	    			
	    			  NBTTagCompound Compound = itemstack.getTagCompound().getCompoundTag("Data");
	    			  
	    			  list.add("Red : " + Compound.getInteger("Red"));
	    			  list.add("Green : " + Compound.getInteger("Green"));
	    			  list.add("Blue : " + Compound.getInteger("Blue"));
	    			  
	    		}
	    		
	    		
	    	}
	    	
	    	
	    }

	    
	    public boolean HasInfo(ItemStack stack) {
	        return stack.hasTagCompound() && stack.getTagCompound().hasKey("Data");
	    }
	    

}
