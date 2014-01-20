package Mod.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import Mod.Container.ContainerBin;
import Mod.Container.ContainerBox;
import Mod.Container.ContainerCharger;
import Mod.Container.ContainerComputer;
import Mod.Container.ContainerCraftingInv;
import Mod.Container.ContainerElectricFurnace;
import Mod.Container.ContainerGenerator;
import Mod.Container.ContainerMill;
import Mod.Container.ContainerMiningChamber;
import Mod.Container.ContainerPizzaOven;
import Mod.Container.ContainerSolarPanel;
import Mod.Container.ContainerSquezer;
import Mod.Container.ContainerStorageBlock;
import Mod.Container.ContainerXpStorage;
import Mod.Main.Main;
import Mod.Network.PacketHandler;
import Mod.TileEntity.TileEntityBin;
import Mod.TileEntity.TileEntityBox;
import Mod.TileEntity.TileEntityCharger;
import Mod.TileEntity.TileEntityComputer;
import Mod.TileEntity.TileEntityCraftingInv;
import Mod.TileEntity.TileEntityElectricFurnace;
import Mod.TileEntity.TileEntityGenerator;
import Mod.TileEntity.TileEntityMill;
import Mod.TileEntity.TileEntityMiningChamber;
import Mod.TileEntity.TileEntityOvenCore;
import Mod.TileEntity.TileEntitySolarPanel;
import Mod.TileEntity.TileEntitySquezer;
import Mod.TileEntity.TileEntityStorageBlock;
import Mod.TileEntity.TileEntityXpStorage;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

    TileEntityXpStorage tile = null;
    
    public static final int ComputerID = 3;
    public static final int ChatID = 2;
    public static final int PlayerFindID = 4;
    public static final int TicTacToeID = 5;
	
    @Override

    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
       
        
        if(tile_entity instanceof TileEntityComputer){
        	return new ContainerComputer((TileEntityComputer)tile_entity);
        }
        
        if(tile_entity instanceof TileEntityStorageBlock){
        	return new ContainerStorageBlock(player.inventory, (TileEntityStorageBlock)tile_entity);
        }
        
        
        if(tile_entity instanceof TileEntityOvenCore){
        	
        	return new ContainerPizzaOven(player.inventory, (TileEntityOvenCore) tile_entity);
        }
        
        if(tile_entity instanceof TileEntityElectricFurnace){
        	
        	return new ContainerElectricFurnace(player.inventory, (TileEntityElectricFurnace) tile_entity);
        }
        
        if(tile_entity instanceof TileEntityMiningChamber){
        	
        	return new ContainerMiningChamber(player.inventory, (TileEntityMiningChamber) tile_entity);
        }
        
        if(tile_entity instanceof TileEntityCharger){
        	
        	return new ContainerCharger(player.inventory, (TileEntityCharger) tile_entity);
        }

        
        if(tile_entity instanceof TileEntityXpStorage){

            return new ContainerXpStorage(player.inventory, (TileEntityXpStorage) tile_entity);

        }
        
        if(tile_entity instanceof TileEntityBin){

            return new ContainerBin(player.inventory, (TileEntityBin) tile_entity);

        }

        
        if(tile_entity instanceof TileEntityBox){
        	
        	return new ContainerBox(player.inventory, (TileEntityBox) tile_entity);
        }
        
        if(tile_entity instanceof TileEntityCraftingInv){
        	
        	return new ContainerCraftingInv(player.inventory, (TileEntityCraftingInv) tile_entity);
        }
        
        if(tile_entity instanceof TileEntityMill){
        	
        	return new ContainerMill(player.inventory, (TileEntityMill) tile_entity);
        }
        
        if(tile_entity instanceof TileEntitySquezer){
        	
        	return new ContainerSquezer(player.inventory, (TileEntitySquezer) tile_entity);
        }
        
        if(tile_entity instanceof TileEntitySolarPanel){
        	
        	return new ContainerSolarPanel(player.inventory, (TileEntitySolarPanel) tile_entity);
        }
        
        if(tile_entity instanceof TileEntityGenerator){
        	
        	return new ContainerGenerator(player.inventory, (TileEntityGenerator) tile_entity);
        }

        
        
        
        return null;
    }
        


    @Override

    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        TileEntity tile_entity = world.getBlockTileEntity(x, y, z);


        switch(ID){
        
        case ChatID:
        	return new GuiChat(player.inventory, null);
        	
        case PlayerFindID:
        	return new GuiPlayerFinder();

        case TicTacToeID:
        	
            	return new GuiGame1Select();
            	
        }


        
        
        if(tile_entity instanceof TileEntityStorageBlock){
        	return new GuiStorageBlock(player.inventory, (TileEntityStorageBlock)tile_entity);
        }

        
        if(tile_entity instanceof TileEntityComputer){
        	return new GuiComputerScreen((TileEntityComputer)tile_entity);
        }
        
        if(tile_entity instanceof TileEntityXpStorage){
            return new GuiXpStorage(player.inventory, (TileEntityXpStorage) tile_entity);

        }
        
        if(tile_entity instanceof TileEntityElectricFurnace){
            return new GuiElectricFurnace(player.inventory, (TileEntityElectricFurnace) tile_entity);

        }
        
        if(ID == 1){
        	return new GuiPaintBrush(player.inventory.getCurrentItem());
        }
        

        
        if(tile_entity instanceof TileEntityBin){

            return new GuiTrashBin(player.inventory, (TileEntityBin) tile_entity);

        }

        
        if(tile_entity instanceof TileEntityBox){
        	
        	return new GuiBox(player.inventory, (TileEntityBox) tile_entity);
        }
        
        if(tile_entity instanceof TileEntityCraftingInv){
        	
        	return new GuiCraftingInv(player.inventory, (TileEntityCraftingInv) tile_entity);
        }
        
        if(tile_entity instanceof TileEntityMill){
        	
        	return new GuiMill(player.inventory, (TileEntityMill) tile_entity);
        }
        
        if(tile_entity instanceof TileEntitySquezer){
        	
        	return new GuiSquezer(player.inventory, (TileEntitySquezer) tile_entity);
        }
        
        
        
        if(tile_entity instanceof TileEntityOvenCore){
        	
        	return new GuiPizzaOven(player.inventory, (TileEntityOvenCore) tile_entity);
        }
        
        if(tile_entity instanceof TileEntityCharger){
        	
        	return new GuiCharger(player.inventory, (TileEntityCharger) tile_entity);
        }
        
        if(tile_entity instanceof TileEntitySolarPanel){
        	
        	return new GuiSolarPanel(player.inventory, (TileEntitySolarPanel) tile_entity);
        }
        
        if(tile_entity instanceof TileEntityGenerator){
        	
        	return new GuiGenerator(player.inventory, (TileEntityGenerator) tile_entity);
        }
        

        
        if(tile_entity instanceof TileEntityMiningChamber){
        	
        	return new GuiMiningChamber(player.inventory, (TileEntityMiningChamber) tile_entity);
        }



        return null;

    }
    
    public String GetGameInvites(EntityPlayer player, int GameNumber){
    	
    	if(player.getEntityData().hasKey("Game_" + GameNumber + "_PlayerName"))
    	return player.getEntityData().getString("Game_" + GameNumber + "_PlayerName");
    	else
    		return null;
    	
    }

}
