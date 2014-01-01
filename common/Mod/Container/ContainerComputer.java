package Mod.Container;

import Mod.TileEntity.TileEntityComputer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerComputer extends Container{
	
	public ContainerComputer(TileEntityComputer tile){
		
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return true;
	}

}
