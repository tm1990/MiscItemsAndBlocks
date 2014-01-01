package Mod.Gui;

import java.awt.Color;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.FMLCommonHandler;

import Mod.Container.ContainerComputer;
import Mod.Main.Main;
import Mod.TileEntity.TileEntityComputer;

public class GuiComputerScreen extends GuiContainer{

	TileEntityComputer tile;
	
	
	public GuiComputerScreen(TileEntityComputer tile) {
		super(new ContainerComputer(tile));
		this.tile = tile;
	}

	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/ComputerScreenGui.png");
	
	
    public static final int xSizeOfTexture = 176;
    public static final int ySizeOfTexture = 176;
    
    int ButtonSizeX = 75;
    int ButtonSizeY = 20;
    

    
    String OSversion;
    
	
	    @Override
	    public boolean doesGuiPauseGame() {
	        return false;
	    }
	    
	    @Override
	    public void initGui() {
			super.initGui();
			buttonList.clear();
			
	        Random rand = new Random();
			
			OSversion = (rand.nextInt(5) + "." + rand.nextInt(99) + "." + rand.nextInt(10));
			
	        int posX = (this.width - xSizeOfTexture) / 2;
	        int posY = (this.height - ySizeOfTexture) / 2;
	        
	        
	        buttonList.add(new GuiButton(1, posX + 6, posY + 37, ButtonSizeX, ButtonSizeY, StatCollector.translateToLocal("gui.string.chat")));
	        buttonList.add(new GuiButton(2, posX + 96, posY + 37, ButtonSizeX, ButtonSizeY, StatCollector.translateToLocal("gui.string.playerfinder")));
	        
			
	        
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
	        
	    
	        }
	        
	    }
	    

		@Override
		protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
			  drawDefaultBackground();

		        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		        Minecraft.getMinecraft().renderEngine.bindTexture(Texture);

		        int posX = (this.width - xSizeOfTexture) / 2;
		        int posY = (this.height - ySizeOfTexture) / 2;
		        

		        //TODO Make background color changable thru RGB
		        
		        drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
		        
		        
		        this.drawRect(posX + 4, posY + 4, posX + 4 + 168, posY + 4 + 31, new Color(100,100,100).getRGB());
		        

		        fontRenderer.drawString(StatCollector.translateToLocal("gui.computer"), posX + 5, posY + 5, 1);
		        fontRenderer.drawString(StatCollector.translateToLocal("gui.string.computerversion") + OSversion, posX + 5, posY + 13, 1);
		        fontRenderer.drawString(StatCollector.translateToLocal("gui.string.loggedinas") + ": " + Minecraft.getMinecraft().thePlayer.username, posX + 5, posY + 24, 1);

		        
		        
		        
		        
		        
		        
		        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		        GL11.glDisable(GL11.GL_LIGHTING);
		}
			
	    
}
