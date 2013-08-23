package Mod.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import Mod.Container.ContainerBox;
import Mod.Container.ContainerShelf;
import Mod.TileEntity.TileEntityBin;
import Mod.TileEntity.TileEntityBox;
import Mod.TileEntity.TileEntityShelf;

public class GuiBox extends GuiContainer{

	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/BoxGui.png");
	
	
	public GuiBox(InventoryPlayer InvPlayer, TileEntityBox tile) {
		super(new ContainerBox(InvPlayer, tile));
	}
	
  @Override
  protected void drawGuiContainerForegroundLayer(int param1, int param2) {

          fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
          
          fontRenderer.drawString("Cardboard Box", 7, 3, 4210752);
       
          
          
  }

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int X, int Y)
	{
	    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

		 Minecraft.getMinecraft().func_110434_K().func_110577_a(Texture);
	         drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

	         

	}
}