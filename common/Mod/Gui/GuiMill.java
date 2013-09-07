package Mod.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import Mod.Container.ContainerMill;
import Mod.Lib.Messages;
import Mod.TileEntity.TileEntityMill;


public class GuiMill extends GuiContainer{

	 TileEntityMill tile = new TileEntityMill();
	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/MillGui.png");
	
	
	public GuiMill(InventoryPlayer InvPlayer, TileEntityMill tile) {
		super(new ContainerMill(InvPlayer, tile));
	}
	
  @Override
  protected void drawGuiContainerForegroundLayer(int param1, int param2) {

          fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
          
          fontRenderer.drawString("Mill", 7, 3, 4210752);
       
          
          
  }

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int X, int Y)
	{
	    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

		 Minecraft.getMinecraft().func_110434_K().func_110577_a(Texture);
	         
	         int k = (this.width - this.xSize) / 2;
	         int l = (this.height - this.ySize) / 2;
	         drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);


	         

	}
	
	@Override
	public void initGui(){
		super.initGui();
		buttonList.clear();
		
		
		buttonList.add(new GuiTipButton(1, guiLeft, guiTop, "?", Messages.MillTips));
	}
	
	

}