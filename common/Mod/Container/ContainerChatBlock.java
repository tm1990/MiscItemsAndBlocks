package Mod.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import Mod.TileEntity.TileEntityComputer;

public class ContainerChatBlock extends Container{

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return true;
	}
	
	public ContainerChatBlock(InventoryPlayer inv, TileEntityComputer tile){
		
	}

}
