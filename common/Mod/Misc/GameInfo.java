package Mod.Misc;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import Mod.Main.Main;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet131MapData;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class GameInfo
{

        public final EntityPlayer Player_1;
        public final EntityPlayer Player_2;

        
        public boolean terminate;
        
        public GameInfo(EntityPlayer t1, EntityPlayer t2)
        {
        	Player_1 = t1;
        	Player_2 = t2;
        }
        
        public GameInfo initialize()
        {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        DataOutputStream stream1 = new DataOutputStream(bytes);

        try
        {
                stream1.writeUTF(Player_1.username);
                stream1.writeUTF(Player_2.username);
                
                PacketDispatcher.sendPacketToPlayer(new Packet131MapData((short)Main.getNetId(), (short)2, bytes.toByteArray()), (Player)Player_1);
                PacketDispatcher.sendPacketToPlayer(new Packet131MapData((short)Main.getNetId(), (short)2, bytes.toByteArray()), (Player)Player_2);
        }
        catch(IOException e)
        {}
        
        return this;
        }
        
        public void terminate(EntityPlayer terminator)
        {
        	terminate = true;
        	
        	Player_1.sendChatToPlayer(ChatMessageComponent.createFromText("Game was closed."));
        	Player_2.sendChatToPlayer(ChatMessageComponent.createFromText("Game was closed."));
        	
        }
    
     
        public EntityPlayer getOtherPlayer(EntityPlayer player)
        {
                return player == Player_1 ? Player_2 : Player_1;
        }
        
        public boolean isPlayerInGame(EntityPlayer player)
        {
                return Player_1 == player || Player_2 == player;
        }

   
}