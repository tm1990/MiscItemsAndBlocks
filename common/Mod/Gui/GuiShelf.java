package Mod.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import Mod.Container.ContainerBin;
import Mod.Container.ContainerShelf;
import Mod.Lib.Messages;
import Mod.TileEntity.TileEntityBin;
import Mod.TileEntity.TileEntityShelf;

public class GuiShelf extends GuiContainer{

	 TileEntityBin tile = new TileEntityBin();
	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/ShelfGui.png");
	
	
	public GuiShelf(InventoryPlayer InvPlayer, TileEntityShelf tile) {
		super(new ContainerShelf(InvPlayer, tile));
	}
	
   @Override
   protected void drawGuiContainerForegroundLayer(int param1, int param2) {

           fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
           
           fontRenderer.drawString("Shelf", 7, 3, 4210752);
        
           
           
   }

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int X, int Y)
	{
	    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

	    Minecraft.getMinecraft().renderEngine.bindTexture(Texture);
	         drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

	         

	}
	
	@Override
	public void initGui(){
		super.initGui();
		buttonList.clear();
		
		
		buttonList.add(new GuiTipButton(1, guiLeft, guiTop, "?", Messages.ShelfTipes));
	}

}