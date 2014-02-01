package Mod.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import Mod.Container.ContainerMetalPress;
import Mod.Network.PacketHandler;
import Mod.TileEntity.TileEntityMetalPress;

public class GuiMetalPress extends GuiContainer{

	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/MetalPressGui.png");
	
	TileEntityMetalPress tile;
	
	
	
	public GuiMetalPress(InventoryPlayer InvPlayer, TileEntityMetalPress tile) {
		super(new ContainerMetalPress(InvPlayer, tile));
		this.tile = tile;
	}
	
  @Override
  protected void drawGuiContainerForegroundLayer(int param1, int param2) {

          fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);

       
          
  }

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int X, int Y)
	{
	    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

	    Minecraft.getMinecraft().renderEngine.bindTexture(Texture);
	         drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	         
	         int x = (this.width - this.xSize) / 2;
	         int y = (this.height - this.ySize) / 2;

	         
	         int Mode = tile.GetMode();
	         
	         if(Mode == 1){
	        	 this.drawTexturedModalRect(x + 10, y + 10, 179, 3, 16, 16);
	        	 
	        	 this.drawTexturedModalRect(x + 52, y + 10, 179, 3, 16, 16);
	        	 
	        	 this.drawTexturedModalRect(x + 10, y + 52, 179, 3, 16, 16);
	        	 
	        	 this.drawTexturedModalRect(x + 52, y + 52, 179, 3, 16, 16);
	         }else if (Mode == 2){
	        	 
	        	 this.drawTexturedModalRect(x + 31, y + 31, 179, 3, 16, 16);
	         }
	         
	         this.drawTexturedModalRect(x + 87, y + 29, 179, 20, tile.GetWorkTime() / 2, 16);

	         
	}
	
	

	@Override
	public void initGui(){
		super.initGui();
		buttonList.clear();
		
	
		buttonList.add(new GuiButton(1, guiLeft + 73, guiTop + 56, 66, 20, "Change Mode"));
		
		
		
	}
	
	@Override
	protected void actionPerformed(GuiButton button){
		PacketHandler.sendButtonPacket((byte)button.id);
		
	}

}