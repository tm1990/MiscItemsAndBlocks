package Mod.Network;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet131MapData;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.ChatMessageComponent;
import Mod.Container.ContainerMiningChamber;
import Mod.Container.ContainerXpStorage;
import Mod.Gui.GuiChat;
import Mod.Gui.GuiGame_1;
import Mod.Items.ModItemPaintBrush;
import Mod.Main.Main;
import Mod.Misc.GameInvite;
import Mod.Tick.ServerTickHandler;
import Mod.TileEntity.TileEntityMiningChamber;
import Mod.TileEntity.TileEntityXpStorage;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
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
	
	public static void Game_1Invite(String From, String To) {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		DataOutputStream dataStream = new DataOutputStream(byteStream);


		try {
			dataStream.writeByte((byte)7);
			dataStream.writeBytes(From + "-" + To);

			
			PacketDispatcher.sendPacketToServer(PacketDispatcher.getPacket("MiscItems", byteStream.toByteArray()));
		}catch(IOException ex) {
			System.err.append("Failed to send packet");
		}
	}

	
	
	public static void SendGameChange(String Player, int Number) {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		DataOutputStream dataStream = new DataOutputStream(byteStream);


		try {
			dataStream.writeByte((byte)8);
			dataStream.writeInt(Number);
			dataStream.writeBytes(Player);

			
			PacketDispatcher.sendPacketToPlayer(PacketDispatcher.getPacket("MiscItems", byteStream.toByteArray()), (Player)FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().getPlayerForUsername(Player));
		}catch(IOException ex) {
			System.err.append("Failed to send packet");
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
//				
//				//Game_1 request
//			case 7:
//				
//				
//				//TODO
//				//FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().getPlayerForUsername(textField.getText());
//				
//				String[] InputInfoRequest = reader.readLine().split("-", 2);
//		
//				
//				if(InputInfoRequest.length > 1){
//				String From = InputInfoRequest[0];
//				String To = InputInfoRequest[1];
//				
//				
//				EntityPlayer ToPlayer = (EntityPlayer)FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().getPlayerForUsername(To);
//				EntityPlayer FromPlayer = (EntityPlayer)FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().getPlayerForUsername(From);
//				
//				if(ToPlayer != null){
//					if(!ToPlayer.username.equalsIgnoreCase(From)){
//					ToPlayer.addChatMessage(From + " has invited you to play tic tac toe.");
//					ToPlayer.addChatMessage("Open tic tac toe from a computer to join");
//					}
//					if(FromPlayer != null){
//						if(!ToPlayer.username.equalsIgnoreCase(From))
//						FromPlayer.addChatMessage("Invitation was succsessfully sent.");
//					}
//				
//					ToPlayer.getEntityData().setString("Game_1_PlayerName", From);
//				}
//				}
//				
//				return;
//				
//				//Game_1 Button Click
////			case 8:
////				
////				int Number = reader.readInt();
////				String ChangePlayer = reader.readLine();
////				
////				EntityPlayer ToPlayer = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().getPlayerForUsername(ChangePlayer);
////				
////				if(FMLClientHandler.instance().getClient().currentScreen instanceof GuiGame_1){
////
////					
////					GuiGame_1 gui = (GuiGame_1)FMLClientHandler.instance().getClient().currentScreen;
////
////					
////					
////				//	gui.actionPerformed(gui.Buttons[Number - 1]);
////					
////					
////					if(Number == 10){
////			    		
////			    		for(int i = 0; i < gui.Buttons.length; i++){
////			    			gui.Buttons[i].displayString = "";
////			    			gui.Buttons[i].enabled = true;
////			    		}
////			    		
////			    		gui.CurrentTurn = gui.player_1;
////
////			    		
////			    		gui.Button_Restart.enabled = false;
////			    		return;
////			    	}
////					
////					if(!gui.CheckWinBlue() && !gui.CheckWinRed()){
////				    	if(gui.CurrentTurn == Minecraft.getMinecraft().thePlayer || gui.player_1.equals(gui.player_2)){
////				    	
////				    	if(gui.Buttons[Number - 1].enabled){
////				    		if(gui.CurrentTurn == gui.player_1){
////				    			gui.Buttons[Number - 1].displayString = gui.Mark_X;
////				    			gui.Buttons[Number - 1].enabled = false;
////				    			gui.CurrentTurn = gui.player_2;
////				    		}else{
////				    			gui.Buttons[Number - 1].displayString = gui.Mark_O;
////				    			gui.Buttons[Number - 1].enabled = false;
////				    			gui.CurrentTurn = gui.player_1;
////				    		}
////				    	
////				    	}
////
////				    }
////					
////				}else if(gui.CheckWinBlue() || gui.CheckWinRed()){
////					gui.Button_Restart.enabled = true;
////			    	
////			    	if(gui.CheckWinBlue())
////			    		gui.BlueWins++;
////			    	else if (gui.CheckWinRed())
////			    		gui.RedWins++;
////			    	
////			    	
////			    	for(int h = 0; h < gui.Buttons.length; h++){
////			    		gui.Buttons[h].enabled = false;
////			    	}
////		        }
////				}
////				
////				return;
////				
////				//Game_1 Win
////			case 9:
////				
////				return;
////				
			


		}
		
	       ModPacket ModPacket = PacketTypeHandler.buildPacket(packet.data);
	       ModPacket.execute(manager, player);
		

	}
	
	

	
	
}
