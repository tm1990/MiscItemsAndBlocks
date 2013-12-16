package Mod.TileEntity;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.packet.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import Mod.Misc.ItemHelper;
import Mod.Network.PacketTileWithItemUpdate;
import Mod.Network.PacketTypeHandler;

public class TileEntityItemPedestal extends TileEntityInvBase implements IInventory{


	public TileEntityItemPedestal() {
		super(1, "Pedestal", 64);
	}

	   @Override
	    public Packet getDescriptionPacket() {

	        ItemStack itemStack = getStackInSlot(0);

	        if (itemStack != null && itemStack.stackSize > 0)
	            return PacketTypeHandler.populatePacket(new PacketTileWithItemUpdate(xCoord, yCoord, zCoord, orientation, state, customName, itemStack.itemID, itemStack.getItemDamage(), itemStack.stackSize, ItemHelper.getColor(itemStack)));
	        else
	            return super.getDescriptionPacket();
	    }
  	
  	
}
