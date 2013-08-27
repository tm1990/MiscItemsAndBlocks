package Mod.Gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import Mod.Container.ContainerBin;
import Mod.Container.ContainerBox;
import Mod.Container.ContainerCraftingInv;
import Mod.Container.ContainerShelf;
import Mod.Container.ContainerXpStorage;
import Mod.TileEntity.TileEntityBin;
import Mod.TileEntity.TileEntityBox;
import Mod.TileEntity.TileEntityCraftingInv;
import Mod.TileEntity.TileEntityShelf;
import Mod.TileEntity.TileEntityXpStorage;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

    TileEntityXpStorage tile = null;
	
    @Override

    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
        


        
        if(tile_entity instanceof TileEntityXpStorage){

        	tile = (TileEntityXpStorage) tile_entity;
            return new ContainerXpStorage(player.inventory, tile);

        }
        
        if(tile_entity instanceof TileEntityBin){

            return new ContainerBin(player.inventory, (TileEntityBin) tile_entity);

        }
        
        if(tile_entity instanceof TileEntityShelf){

            return new ContainerShelf(player.inventory, (TileEntityShelf) tile_entity);

        }
        
        if(tile_entity instanceof TileEntityBox){
        	
        	return new ContainerBox(player.inventory, (TileEntityBox) tile_entity);
        }
        
        if(tile_entity instanceof TileEntityCraftingInv){
        	
        	return new ContainerCraftingInv(player.inventory, (TileEntityCraftingInv) tile_entity);
        }
        
        return null;
    }
        


    @Override

    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        TileEntity tile_entity = world.getBlockTileEntity(x, y, z);


        if(tile_entity instanceof TileEntityXpStorage){
        	
        	if(tile != null){
            	System.out.println("XpStorage gui opend on client!");
            return new GuiXpStorage(player.inventory, tile);
        	}
        	
        	
        	System.out.println("XpStorage gui opend on server!");
            return new GuiXpStorage(player.inventory, (TileEntityXpStorage) tile_entity);

        }
        
        if(tile_entity instanceof TileEntityBin){

            return new GuiTrashBin(player.inventory, (TileEntityBin) tile_entity);

        }
        
        if(tile_entity instanceof TileEntityShelf){

            return new GuiShelf(player.inventory, (TileEntityShelf) tile_entity);

        }
        
        if(tile_entity instanceof TileEntityBox){
        	
        	return new GuiBox(player.inventory, (TileEntityBox) tile_entity);
        }
        
        if(tile_entity instanceof TileEntityCraftingInv){
        	
        	return new GuiCraftingInv(player.inventory, (TileEntityCraftingInv) tile_entity);
        }
        
        


        return null;

    }

}
