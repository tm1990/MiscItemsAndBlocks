package Mod.Network;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.NetClientHandler;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.NetServerHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet131MapData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import Mod.Gui.GuiGame_1;
import Mod.Main.Main;
import Mod.Misc.GameInfo;
import Mod.Misc.GameInvite;
import Mod.TileEntity.TileEntityMetalPress;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.ITinyPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TinyPacketHandler
implements ITinyPacketHandler
{
        @Override
        public void handle(NetHandler handler, Packet131MapData mapData)
        {
                int id = mapData.uniqueID;
                if(handler instanceof NetServerHandler)
                {
                        handleServerPacket((NetServerHandler)handler, mapData.uniqueID, mapData.itemData, (EntityPlayerMP)handler.getPlayer());
                }
                else
                {
                        handleClientPacket((NetClientHandler)handler, mapData.uniqueID, mapData.itemData);
                }
        }

        public void handleServerPacket(NetServerHandler handler, short id, byte[] data, EntityPlayerMP player)
        {
                DataInputStream stream = new DataInputStream(new ByteArrayInputStream(data));
                try
                {
                	
                	
                	
                        switch(id)
                        {
                        
                        
                        case 1:
                        {
                                //Game request;
                                String plyr1 = stream.readUTF();
                                
                                EntityPlayerMP plyr = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().getPlayerForUsername(plyr1);
                                
                                        GameInvite tr1 = Main.proxy.tickHandlerServer.playerGameRequests.get(player.username);
                                        
                                        if(tr1 != null && tr1.Name.equalsIgnoreCase(plyr.username))
                                        {
                                        	Main.proxy.tickHandlerServer.initializeGame(player, plyr);
                                                break;
                                        }
                                        
                                        GameInvite tr = Main.proxy.tickHandlerServer.playerGameRequests.get(plyr.username);
                                        if(tr == null || !tr.Name.equalsIgnoreCase(player.username))
                                        {
                                        	Main.proxy.tickHandlerServer.playerGameRequests.put(plyr.username, new GameInvite(player.username));
                                                
                                 ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                                 DataOutputStream stream1 = new DataOutputStream(bytes);

                                 try
                                 {
                                         stream1.writeUTF(player.username);
                                         
                                         PacketDispatcher.sendPacketToPlayer(new Packet131MapData((short)Main.getNetId(), (short)1, bytes.toByteArray()), (Player)plyr);
                                 }
                                 catch(IOException e)
                                 {}
                                        }

                                
                                break;
                        }
                        
                        case 2:
                        {
                        	
                            //Accept request
                            String plyr1 = stream.readUTF();
                            
                            GameInvite tr = Main.proxy.tickHandlerServer.playerGameRequests.get(player.username);
                            if(tr == null)
                            {
                                    player.sendChatToPlayer(ChatMessageComponent.createFromText("Cannot Accept Game Invite"));
                                    break;
                            }
                            
                            
                            EntityPlayerMP plyr = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().getPlayerForUsername(plyr1);
                            
                            if(plyr != null && plyr.isEntityAlive() )
                            {

                                    Main.proxy.tickHandlerServer.playerGameRequests.remove(player.username);
                                    Main.proxy.tickHandlerServer.initializeGame(player, plyr);
                                    
                            }
                            else
                            {
                                    player.sendChatToPlayer(ChatMessageComponent.createFromText("Cannot Accept Game Invite"));

                            }
                            
                            break;
                        }
                        
                        
                        case 3:	
                        {
                        	
                        	int Number = stream.readInt() - 1;
                        	int Player = stream.readInt();
                        	String Player_1 = stream.readUTF();
                        	String Player_2 = stream.readUTF();
                        	
                        	
                       	 ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        	             DataOutputStream stream1 = new DataOutputStream(bytes);


        	                     try {
        	                         stream1.writeInt(Number);
        								stream1.writeInt(Player);
        								stream1.writeUTF(Player_1);
        								stream1.writeUTF(Player_2);
        								
        								

        									PacketDispatcher.sendPacketToAllPlayers(new Packet131MapData((short)Main.getNetId(), (short)3, bytes.toByteArray()));
        									
        								
        		    
        							} catch (IOException e) {
        								e.printStackTrace();
        							}
        	                     
                        	
                        	
                        }
                        
                        
                        case 4:	
                        {
                        	
                        	String Player_1 = stream.readUTF();
                        	String Player_2 = stream.readUTF();
                        	
                        	
                       	 ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        	             DataOutputStream stream1 = new DataOutputStream(bytes);


        	                     try {
        								stream1.writeUTF(Player_1);
        								stream1.writeUTF(Player_2);
        								
        								

        									PacketDispatcher.sendPacketToAllPlayers(new Packet131MapData((short)Main.getNetId(), (short)4, bytes.toByteArray()));
        									
        								
        		    
        							} catch (IOException e) {
        								e.printStackTrace();
        							}
        	                     
                        	
                        	
                        }
                        
                        
                        
                        
                        case 5:	
                        {
                        	
                        	String Player_1 = stream.readUTF();
                        	String Player_2 = stream.readUTF();
                        	
                        	
                        	
                        	  for(GameInfo ti : Main.proxy.tickHandlerServer.activeGames)
                              {
                                      if(ti.isPlayerInGame(player))
                                      {
                                    	  ti.terminate(player);
                                              break;
                                      }
                              }
                        	
                        	
                       	 ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        	             DataOutputStream stream1 = new DataOutputStream(bytes);


        	                     try {
        								stream1.writeUTF(Player_1);
        								stream1.writeUTF(Player_2);
        								
        								

        									PacketDispatcher.sendPacketToAllPlayers(new Packet131MapData((short)Main.getNetId(), (short)5, bytes.toByteArray()));
        									
        								
        		    
        							} catch (IOException e) {
        								e.printStackTrace();
        							}
        	                     
                        	
                        	
                        }
                        
                        

                        
                        
                        
                        }
                }
  
                
                catch(IOException e)
                {
                }
        }
        


        @SideOnly(Side.CLIENT)
        public void handleClientPacket(NetClientHandler handler, short id, byte[] data)
        {
                DataInputStream stream = new DataInputStream(new ByteArrayInputStream(data));
                try
                {
                	
                        switch(id)
                        {
                        
                        case 1:
                        {
                                //received Trade request
                            Main.proxy.tickHandlerClient.tradeReq = stream.readUTF();
                            
                                Minecraft.getMinecraft().sndManager.playSound("random.successful_hit", (float)Minecraft.getMinecraft().thePlayer.posX, (float)Minecraft.getMinecraft().thePlayer.posY, (float)Minecraft.getMinecraft().thePlayer.posZ, 1.0F, 1.0F);

                                Minecraft.getMinecraft().thePlayer.addChatMessage(EnumChatFormatting.GOLD + "You have recived a game invite to play tic tac toe!");
                                
                                break;
                        }
                        
                        case 2:
                        {
                                //begin game session
                                FMLClientHandler.instance().displayGuiScreen(Minecraft.getMinecraft().thePlayer, new GuiGame_1(stream.readUTF(), stream.readUTF()));
                                Main.proxy.tickHandlerClient.tradeReq = null;
                                break;
                        }
                        
                        
                        //Button Change
                        case 3:
                        {
                        	int Number = stream.readInt();
                        	int Player = stream.readInt();
                        	String Player_1 = stream.readUTF();
                        	String Player_2 = stream.readUTF();
                        	
                        		

                        	
                          		if((Player == 1 && Minecraft.getMinecraft().thePlayer.username.equalsIgnoreCase(Player_2)) || (Player == 2 && Minecraft.getMinecraft().thePlayer.username.equalsIgnoreCase(Player_1)) ){
                          		
                        		
                    		if(Minecraft.getMinecraft().currentScreen instanceof GuiGame_1){
                    			GuiGame_1 gui = (GuiGame_1)Minecraft.getMinecraft().currentScreen;
                    			

                    			
                    			if(!gui.CheckWinBlue() && !gui.CheckWinRed()){
                    				if(Player == 1){
                    					gui.Buttons[Number].displayString = gui.Mark_X;
                    					gui.Buttons[Number].enabled = false;
                    					gui.CurrentTurn = 2;
                    					gui.CurrentPlayer = gui.player_2;
                    					
                    				}else if (Player == 2){
                    					gui.Buttons[Number].displayString = gui.Mark_O;
                    					gui.Buttons[Number].enabled = false;
                    					gui.CurrentTurn = 1;
                    					gui.CurrentPlayer = gui.player_1;
                    				}
                    				
                    				

                    				
                    			}
                    			
                    			
                    				
                    				if(gui.CheckWinBlue() || gui.CheckWinRed()){
                    					gui.Button_Restart.enabled = true;
                    					
                    					if(gui.CheckWinBlue()){
                    						gui.BlueWins++;
                    						gui.BlueWin = true;
                    					}else if (gui.CheckWinRed()){
                    						gui.RedWins++;
                    						gui.RedWin = true;
                    						
                    					}
                    					
                    					
                    					
                    					for(int i = 0; i < gui.Buttons.length; i++){
                    						gui.Buttons[i].enabled = false;
                    					}
                    					
                    				}
                    				
                    				
                    				for(int i = 0; i < gui.Buttons.length; i++){
                    		    		
                    		    		if(gui.Buttons[i].enabled){
                    		    			return;
                    		    		}
                    		    	}
                    		    	
                    		    	gui.Button_Restart.enabled = true;
                    				
                    			}
                    		
                        	
                        	
                        	
                        	
                          		}
                        	
                        }
                        //Restart
                        case 4:
                        {
                        	
                        	
                        	
                        	String Player_1 = stream.readUTF();
                        	String Player_2 = stream.readUTF();
                        	
                        	
                        	if((Minecraft.getMinecraft().thePlayer.username.equalsIgnoreCase(Player_2)) || (Minecraft.getMinecraft().thePlayer.username.equalsIgnoreCase(Player_1)) ){
                        	
                        if(Minecraft.getMinecraft().currentScreen instanceof GuiGame_1){
                			GuiGame_1 gui = (GuiGame_1)Minecraft.getMinecraft().currentScreen;
                			
                			for(int i = 0; i < gui.Buttons.length; i++){
                				gui.Buttons[i].displayString = "";
                				gui.Buttons[i].enabled = true;
                			}
                			
        					gui.CurrentTurn = 1;
        					gui.CurrentPlayer = gui.player_1;
        					gui.RedWin = false;
        					gui.BlueWin = false;
        					
        					gui.Button_Restart.enabled = false;
                			
                        }
                        	
                        	
                        }
                        	
                        }
                        
                        case 6:
                        {

                        	int x = stream.readInt();
                        	int y = stream.readInt();
                        	int z = stream.readInt();
                        	
                        	int WorkTime = stream.readInt();
                        	
                        	boolean PlaySound = stream.readBoolean();
                        	
                        	World world = Minecraft.getMinecraft().thePlayer.worldObj;
                        	
                        TileEntity tile_e = world.getBlockTileEntity(x, y, z);
                        
                        if(tile_e != null){
                        	
                        	if(tile_e instanceof TileEntityMetalPress){
                        		TileEntityMetalPress tile = (TileEntityMetalPress)tile_e;
                        		
                        		tile.SetWorkTime(WorkTime);

                        		if(PlaySound)
                        			world.playSound(x, y, z, "random.anvil_land", 0.3F, 1.5F, false);
                        		
                        	}
                        }
                        	
                        	
                        }
                        
                      
                        
                        
                        
                        }
                        

                }
                catch(IOException e)
                {
                }
        }

}