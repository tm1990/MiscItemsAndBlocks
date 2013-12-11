package Mod.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import Mod.Container.ContainerSquezer;
import Mod.Lib.Messages;
import Mod.TileEntity.TileEntitySquezer;


public class GuiSquezer extends GuiContainer{

	 private TileEntitySquezer tile;
	 
	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/SquezerGui.png");
	
	
	public GuiSquezer(InventoryPlayer InvPlayer, TileEntitySquezer tile) {
		super(new ContainerSquezer(InvPlayer, tile));
		
		this.tile = tile;
		
		this.xSize = 176;
		this.ySize = 166;
	}
	
 @Override
 protected void drawGuiContainerForegroundLayer(int param1, int param2) {

         fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
         
         fontRenderer.drawString("Squeezer", 7, 3, 4210752);
         fontRenderer.drawString("Bottle", 32, 13, 4210752);
         fontRenderer.drawString("Item", 117, 13, 4210752);
      
         
         
 }

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int X, int Y)
	{
	    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

	    Minecraft.getMinecraft().renderEngine.bindTexture(Texture);
	         
	        int x = (this.width - this.xSize) / 2;
	        int y = (this.height - this.ySize) / 2;
	         drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	         
	         int Time = this.tile.GetWorkTime();
	         if(Time > 0)
             this.drawTexturedModalRect(x + 66, y + 28, 176, 3, 43, Time / 16);
	         


	         


	         

	}
	
	@Override
	public void initGui(){
		super.initGui();
		buttonList.clear();
		
		
		buttonList.add(new GuiTipButton(1, guiLeft, guiTop, "?", Messages.SquezerTips));
	}
}