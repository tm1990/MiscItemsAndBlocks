package Mod.Network;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.NetClientHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetServerHandler;
import net.minecraft.network.packet.Packet250CustomPayload;
import Mod.Container.ContainerMiningChamber;
import Mod.Container.ContainerXpStorage;
import Mod.Gui.GuiChat;
import Mod.Items.ModItemPaintBrush;
import Mod.TileEntity.TileEntityMiningChamber;
import Mod.TileEntity.TileEntityXpStorage;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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
				return;
				
			case 2:

				int Red = reader.readInt();
				int Green = reader.readInt();
				int Blue = reader.readInt();
				
				if(entityPlayer.inventory.getCurrentItem() != null && entityPlayer.inventory.getCurrentItem().getItem() instanceof ModItemPaintBrush){
					ModItemPaintBrush item = (ModItemPaintBrush)entityPlayer.inventory.getCurrentItem().getItem();
					
					item.ReciveColors(Red, Green, Blue, entityPlayer.inventory.getCurrentItem());
				}
				
				
				return;
				
				
			case 3:
				String fullLine = reader.readLine();
				
				String[] text = fullLine.split("-");
				if(text.length > 1){
				
				String Player = text[0];
				String Message = text[1];
				String Channel = text[2];

				

				
				ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
				DataOutputStream dataStream = new DataOutputStream(byteStream);


				try {
					dataStream.writeByte((byte)4);
					
					dataStream.writeUTF(Player + "-" + Message + "-" + Channel);

					
					PacketDispatcher.sendPacketToAllPlayers(PacketDispatcher.getPacket("MiscItems", byteStream.toByteArray()));
				}catch(IOException ex) {
					System.err.append("Failed to send packet");
				}
				
				}
				
				return;
				
				
			case 4:
				
				String fullLine1 = reader.readLine();
				
				
				
				
				if(FMLClientHandler.instance().getClient().currentScreen != null && FMLClientHandler.instance().getClient().currentScreen instanceof GuiChat){
					GuiChat gui = (GuiChat)FMLClientHandler.instance().getClient().currentScreen;
					gui.ReciveChatMessage(fullLine1);
				}

				
				return;
				

				//Player Joined
			case 5:
				
				String fullLine2 = reader.readLine();
				String[] text1 = fullLine2.split("-");
				
				
				if(text1.length > 1){
				
				String Player1 = text1[0];
				String Channel = text1[1];
				
				if(FMLClientHandler.instance().getClient().currentScreen != null && FMLClientHandler.instance().getClient().currentScreen instanceof GuiChat){
					GuiChat gui = (GuiChat)FMLClientHandler.instance().getClient().currentScreen;
					gui.ReciveChatMessage(Player1 + "-#JC#Joined the chat.-" + Channel);
				}
				

					
					
					
				}
				
				return;
				
				
				//Player Left
			case 6:
				
				String[] text2 = reader.readLine().split("-", 3);
				if(text2.length > 1){
					
				
				String Player1 = text2[0];
				String Message = text2[1];
				String Channel = text2[2];

				
				if(FMLClientHandler.instance().getClient().currentScreen != null && FMLClientHandler.instance().getClient().currentScreen instanceof GuiChat){
					GuiChat gui = (GuiChat)FMLClientHandler.instance().getClient().currentScreen;
					gui.ReciveChatMessage(Player1 + "-" + "#LC#left the chat. " + "(" + Message + ")" + "-" + Channel);
				}
				
				

			
				}
				
				return;
				
				

		}
		
	       ModPacket ModPacket = PacketTypeHandler.buildPacket(packet.data);
	       ModPacket.execute(manager, player);
		

	}
	
	

	
	
}
