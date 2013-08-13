package Mod.Gui;

import Mod.Container.ContainerBin;
import Mod.Container.ContainerShelf;
import Mod.Container.ContainerXpStorage;
import Mod.Main.Main;
import Mod.TileEntity.TileEntityBin;
import Mod.TileEntity.TileEntityShelf;
import Mod.TileEntity.TileEntityXpStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler{

	
    @Override

    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        TileEntity tile_entity = world.getBlockTileEntity(x, y, z);


        
        if(tile_entity instanceof TileEntityXpStorage){

            return new ContainerXpStorage(player.inventory, (TileEntityXpStorage) tile_entity);

        }
        
        if(tile_entity instanceof TileEntityBin){

            return new ContainerBin(player.inventory, (TileEntityBin) tile_entity);

        }
        
        if(tile_entity instanceof TileEntityShelf){

            return new ContainerShelf(player.inventory, (TileEntityShelf) tile_entity);

        }
        
        return null;
    }
        


    @Override

    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        TileEntity tile_entity = world.getBlockTileEntity(x, y, z);


        if(tile_entity instanceof TileEntityXpStorage){

            return new XpStorageGui(player.inventory, (TileEntityXpStorage) tile_entity);

        }
        
        if(tile_entity instanceof TileEntityBin){

            return new GuiTrashBin(player.inventory, (TileEntityBin) tile_entity);

        }
        
        if(tile_entity instanceof TileEntityShelf){

            return new GuiShelf(player.inventory, (TileEntityShelf) tile_entity);

        }
        
        


        return null;

    }

}
