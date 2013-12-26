package Mod.Network;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import Mod.Container.ContainerMiningChamber;
import Mod.Container.ContainerXpStorage;
import Mod.Items.ModItemPaintBrush;
import Mod.TileEntity.TileEntityMiningChamber;
import Mod.TileEntity.TileEntityXpStorage;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler{

	
	
	public static void sendButtonPacket(byte id) {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		DataOutputStream dataStream = new DataOutputStream(byteStream);

		try {
			dataStream.writeByte((byte)1);
			dataStream.writeByte(id);			
			
			PacketDispatcher.sendPacketToServer(PacketDispatcher.getPacket("MiscItems", byteStream.toByteArray()));
		}catch(IOException ex) {
			System.err.append("Failed to send button click packet");
		}
	}
	
	public static void sendPaintBrushColorChange(int Red, int Green, int Blue) {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		DataOutputStream dataStream = new DataOutputStream(byteStream);


		try {
			dataStream.writeByte((byte)2);
			dataStream.writeInt(Red);		
			dataStream.writeInt(Green);
			dataStream.writeInt(Blue);
			
			PacketDispatcher.sendPacketToServer(PacketDispatcher.getPacket("MiscItems", byteStream.toByteArray()));
		}catch(IOException ex) {
			System.err.append("Failed to send paint brush color change packet");
		}
	}
	

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		
	       
	       
		
	       ByteArrayDataInput reader = ByteStreams.newDataInput(packet.data);
		EntityPlayer entityPlayer = (EntityPlayer)player;
		
		byte packetId = reader.readByte();
		
		
		
		
		switch (packetId) {
			case 1:		
				byte buttonId = reader.readByte();
				Container container = entityPlayer.openContainer;
				
				if (container != null && container instanceof ContainerXpStorage) {
					TileEntityXpStorage XpStorage = ((ContainerXpStorage)container).getTile();
					XpStorage.receiveButtonEvent(buttonId);
					
				}else if (container != null && container instanceof ContainerMiningChamber) {
					TileEntityMiningChamber MiningChamber = ((ContainerMiningChamber)container).getTile();
					MiningChamber.receiveButtonEvent(buttonId);
				}
				
			case 2:

				int Red = reader.readInt();
				int Green = reader.readInt();
				int Blue = reader.readInt();
				
				if(entityPlayer.inventory.getCurrentItem() != null && entityPlayer.inventory.getCurrentItem().getItem() instanceof ModItemPaintBrush){
					ModItemPaintBrush item = (ModItemPaintBrush)entityPlayer.inventory.getCurrentItem().getItem();
					
					item.ReciveColors(Red, Green, Blue, entityPlayer.inventory.getCurrentItem());
				}
				
				
				return;
				
				

		}
		
	       ModPacket ModPacket = PacketTypeHandler.buildPacket(packet.data);
	       ModPacket.execute(manager, player);
		

	}
	
	
}
