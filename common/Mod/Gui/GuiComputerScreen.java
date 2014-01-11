package Mod.Gui;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import Mod.Container.ContainerComputer;
import Mod.Main.Main;
import Mod.TileEntity.TileEntityComputer;

public class GuiComputerScreen extends GuiContainer{

	TileEntityComputer tile;
	
	boolean Menu = false;
	boolean Hide = false;
	
	double Version = 0.01;

	
	
	GuiButton Button_Chat;
	GuiButton Button_PlayerFinder;
	GuiButton Button_Hide;
	
	GuiButton Button_1;
	GuiButton Button_2;
	
	GuiButton Button_3;
	GuiButton Button_4;
	
	GuiButton Button_5;
	GuiButton Button_6;
	
	GuiButton Button_7;
	GuiButton Button_8;
	
	GuiButton Button_9;
	GuiButton Button_10;
	
	public GuiComputerScreen(TileEntityComputer tile) {
		super(new ContainerComputer(tile));
		this.tile = tile;
	}

	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/ComputerScreenGui.png");
	
	
    public static final int xSizeOfTexture = 256;
    public static final int ySizeOfTexture = 177;
    
    int ButtonSizeX = 75;
    int ButtonSizeY = 20;
    

   
    
	
	    @Override
	    public boolean doesGuiPauseGame() {
	        return false;
	    }
	    
	    @Override
	    public void initGui() {
			super.initGui();
			buttonList.clear();
			
	        Random rand = new Random();

			
	        int posX = (this.width - xSizeOfTexture) / 2;
	        int posY = (this.height - ySizeOfTexture) / 2;
	        
	        
	        Button_Chat = new GuiButton(1, posX + 8, posY + 4, ButtonSizeX, ButtonSizeY, StatCollector.translateToLocal("gui.string.chat"));
	        Button_PlayerFinder = new GuiButton(2, posX + 90, posY + 4, ButtonSizeX, ButtonSizeY, StatCollector.translateToLocal("gui.string.playerfinder"));
	        Button_1 = new GuiButton(3, posX + 170, posY + 4, ButtonSizeX, ButtonSizeY, "[Game]");
	        
	        Button_2 = new GuiButton(4, posX + 8, posY + 4 + (ButtonSizeY * 2) - 16, ButtonSizeX, ButtonSizeY, "[Game]");
	        Button_3 = new GuiButton(5, posX + 90, posY + 4 + (ButtonSizeY * 2) - 16, ButtonSizeX, ButtonSizeY, "[Paint]");
	        Button_4 = new GuiButton(6, posX + 170, posY + 4 + (ButtonSizeY * 2) - 16, ButtonSizeX, ButtonSizeY, "[Something]");
	        
	        Button_5 = new GuiButton(7, posX + 8, posY + 4 + (ButtonSizeY * 3) - 12, ButtonSizeX, ButtonSizeY, "[Something]");
	        Button_6 = new GuiButton(8, posX + 90, posY + 4 + (ButtonSizeY * 3) - 12, ButtonSizeX, ButtonSizeY, "[Something]");
	        Button_7 = new GuiButton(9, posX + 170, posY + 4 + (ButtonSizeY * 3) - 12, ButtonSizeX, ButtonSizeY, "[Something]");
	        
	        Button_8 = new GuiButton(10, posX + 8, posY + 4 + (ButtonSizeY * 4) - 8, ButtonSizeX, ButtonSizeY, "[Something]");
	        Button_9 = new GuiButton(11, posX + 90, posY + 4 + (ButtonSizeY * 4)  - 8, ButtonSizeX, ButtonSizeY, "[Something]");
	        Button_10 = new GuiButton(12, posX + 170, posY + 4 + (ButtonSizeY * 4) - 8, ButtonSizeX, ButtonSizeY, "[Something]");
	        
	        Button_Hide = new GuiButton(13, posX + 218, posY + 82, 33, 16, "Hide");
	        
	        
	        Button_1.enabled = false;
	        Button_2.enabled = false;
	        Button_3.enabled = false;
	        Button_4.enabled = false;
	        Button_5.enabled = false;
	        Button_6.enabled = false;
	        Button_7.enabled = false;
	        Button_8.enabled = false;
	        Button_9.enabled = false;
	        Button_10.enabled = false;
	        
	        buttonList.add(Button_Chat);
	        buttonList.add(Button_PlayerFinder);
	        buttonList.add(Button_Hide);
	        
	        buttonList.add(Button_1);
	        buttonList.add(Button_2);
	        buttonList.add(Button_3);
	        buttonList.add(Button_4);
	        buttonList.add(Button_5);
	        buttonList.add(Button_6);
	        buttonList.add(Button_7);
	        buttonList.add(Button_8);
	        buttonList.add(Button_9);
	        buttonList.add(Button_10);
	        
	        
			
	        
	    }
	    
	    @Override
	    protected void actionPerformed(GuiButton par1GuiButton) {
	        switch (par1GuiButton.id) {
	        
	        
	        case 1:
	        	Minecraft.getMinecraft().thePlayer.openGui(Main.instance, GuiHandler.ChatID, Minecraft.getMinecraft().thePlayer.worldObj, 0, 0, 0);
	        	break;
	        	
	        case 2:
	        	Minecraft.getMinecraft().thePlayer.openGui(Main.instance, GuiHandler.PlayerFindID, Minecraft.getMinecraft().thePlayer.worldObj, 0, 0, 0);
	        	break;
	        
	        case 13:
	        	if(Hide)
	        		Hide = false;
	        	else
	        		Hide = true;
	        	break;
	        }
	        
	    }
	    

		@Override
		protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
			  drawDefaultBackground();
			  
		        GL11.glEnable(GL11.GL_BLEND);


		        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		        Minecraft.getMinecraft().renderEngine.bindTexture(Texture);

		        int posX = (this.width - xSizeOfTexture) / 2;
		        int posY = (this.height - ySizeOfTexture) / 2;
		        

		        //TODO Make background color changeable thru RGB
		        
		        drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
		        
		        
		        
		        if(Hide){
			        Button_1.drawButton = false;
			        Button_2.drawButton = false;
			        Button_3.drawButton = false;
			        Button_4.drawButton = false;
			        Button_5.drawButton = false;
			        Button_6.drawButton = false;
			        Button_7.drawButton = false;
			        Button_8.drawButton = false;
			        Button_9.drawButton = false;
			        Button_10.drawButton = false;
			        
			        Button_Chat.drawButton = false;
			        Button_PlayerFinder.drawButton = false;
			        
			        Button_Hide.displayString = "Show";
			        
		        }else{
			        Button_1.drawButton = true;
			        Button_2.drawButton = true;
			        Button_3.drawButton = true;
			        Button_4.drawButton = true;
			        Button_5.drawButton = true;
			        Button_6.drawButton = true;
			        Button_7.drawButton = true;
			        Button_8.drawButton = true;
			        Button_9.drawButton = true;
			        Button_10.drawButton = true;
			        
			        Button_Chat.drawButton = true;
			        Button_PlayerFinder.drawButton = true;
			        
			        Button_Hide.displayString = "Hide";
		        }
		        
		        
		        
		        if(Menu){
			        drawTexturedModalRect(posX + 208, posY + 160, 223, 195, 15, 15);
			        
			        drawTexturedModalRect(posX + 149, posY + 81, 0, 178, 103, 78);
			        
			        
			        GL11.glScalef(0.5F, 0.5F, 0.5F);
			        fontRenderer.drawString(StatCollector.translateToLocal("gui.computer"), (posX + 152) * 2, (posY + 84) * 2, 1);
			        fontRenderer.drawString(StatCollector.translateToLocal("gui.string.computerversion") + Version, (posX + 152) * 2, (posY + 90) * 2, 1);
			        fontRenderer.drawString(StatCollector.translateToLocal("gui.string.loggedinas") + ": " + Minecraft.getMinecraft().thePlayer.username, (posX + 152) * 2, (posY + 96) * 2, 1);
			        
			        fontRenderer.drawString("Cords: ", (posX + 152) * 2, (posY + 146) * 2, 1);
			        fontRenderer.drawString("X: " + tile.xCoord + " Y: " + tile.yCoord + " Z: " + tile.zCoord, (posX + 152) * 2, (posY + 152) * 2, 1);
			       //8 and below to not overwrite menu
			        
			        Button_8.drawButton = false;
			        Button_9.drawButton = false;
			        Button_10.drawButton = false;
			        
			        Button_Hide.drawButton = true;
		        }else{
			        drawTexturedModalRect(posX + 208, posY + 160, 223, 179, 15, 15);
			        
			        if(!Hide){
			        Button_8.drawButton = true;
			        Button_9.drawButton = true;
			        Button_10.drawButton = true;
			        }
			        
			        Button_Hide.drawButton = false;
		        }
		        
		        
		
		        if(!Menu)
		        GL11.glScalef(1F, 1F, 1F);
		        else
			        GL11.glScalef(2F, 2F, 2F);	
		        
		        
		        
		        GL11.glDisable(GL11.GL_BLEND);
		        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		        GL11.glDisable(GL11.GL_LIGHTING);
		        
		        
		}
		        
		        
			
	    
		
		public void ButtonPressed(int x, int y){
			
	        int posX = (this.width - xSizeOfTexture) / 2;
	        int posY = (this.height - ySizeOfTexture) / 2;
	        
	        if(x >= posX + 207 && x <= posX + 207 + 15 && y >= posY + 159 && y <= posY + 159 + 15){
	        	
	        	if(Menu){
	        		Menu = false;
	        	}else{
	        		Menu = true;
	        	}
	        }
			
			
		}
		
	    protected void mouseClicked(int x, int y, int z)
	    {
	    	super.mouseClicked(x, y, z);
	    	ButtonPressed(x, y);
	    }
}
