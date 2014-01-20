package Mod.Gui;


import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet131MapData;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import Mod.Main.Main;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.PacketDispatcher;

public class GuiGame_1_Invite extends GuiScreen{

	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/GameInvite.png");

    protected int xSize = 176;
    protected int ySize = 170;
    
    EntityPlayer player;

    
    protected int guiLeft;
    protected int guiTop;
    
    
    public ArrayList<String> players = new ArrayList<String>();
    
    @Override
    public void updateScreen()
    {
    	 for(int i = 0; i < mc.theWorld.playerEntities.size(); i++)
         {
                 EntityPlayer player = (EntityPlayer)mc.theWorld.playerEntities.get(i);
                 if(player.isEntityAlive() && !players.contains(player.username))
                 {
                         players.add(player.username);
                 }
         }
         Collections.sort(players);
         
         
         buttonList.clear();
         
         for(int i = 0; i < players.size(); i++)
         {
                 if(i == 12)
                 {
                         break;
                 }
                 if(players.get(i) == Minecraft.getMinecraft().thePlayer.username)
                     buttonList.add(new GuiButton(i, guiLeft + 6 + (i % 2 == 1 ? 84 : 0), guiTop + 4 + 22 * (int)Math.floor((double)i / 2D), 80, 20, "Your self"));
                 else
                 buttonList.add(new GuiButton(i, guiLeft + 6 + (i % 2 == 1 ? 84 : 0), guiTop + 4 + 22 * (int)Math.floor((double)i / 2D), 80, 20, players.get(i)));
         }
         
 }
    	
    
	
	 @Override
	    public void drawScreen(int x, int y, float f) {
	        drawDefaultBackground();

	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        Minecraft.getMinecraft().renderEngine.bindTexture(Texture);

	        int posX = (this.width - xSize) / 2;
	        int posY = (this.height - ySize) / 2;
	        

	        drawTexturedModalRect(posX, posY, 0, 0, xSize, ySize);
	        
	        

	        
	        
	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        GL11.glDisable(GL11.GL_LIGHTING);

	        super.drawScreen(x, y, f);
	    }
	 
	    @Override
	    public boolean doesGuiPauseGame() {
	        return false;
	    }
	    
	    
	    @Override
	    public void initGui() {
			super.initGui();
	        this.guiLeft = (this.width - this.xSize) / 2;
	        this.guiTop = (this.height - this.ySize) / 2;
	      


	        
	        
	    }
	    
	
	    
	    @Override
	    protected void actionPerformed(GuiButton button) {

	        	
	        	 ByteArrayOutputStream bytes = new ByteArrayOutputStream();
	             DataOutputStream stream = new DataOutputStream(bytes);

	             try
	             {
	                     stream.writeUTF(players.get(button.id));
	                     
	                     PacketDispatcher.sendPacketToServer(new Packet131MapData((short)Main.getNetId(), (short)1, bytes.toByteArray()));
	             }
	             catch(IOException e)
	             {}
	        	
	        
	        

	        }
	    
//	    public void onGuiClosed() {
//            FMLClientHandler.instance().displayGuiScreen(Minecraft.getMinecraft().thePlayer, new GuiGame1Select());
//	    	
//	    }
	    
	    protected void keyTyped(char par1, int par2)
	    {

	    	if(par2 == 1){
	            FMLClientHandler.instance().displayGuiScreen(Minecraft.getMinecraft().thePlayer, new GuiGame1Select());
	    	}
	    }
}