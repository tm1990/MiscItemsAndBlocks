package Mod.Gui;

import org.lwjgl.opengl.GL11;

import Mod.Container.ContainerBin;
import Mod.Container.ContainerXpStorage;
import Mod.Lib.Messages;
import Mod.TileEntity.TileEntityBin;
import Mod.TileEntity.TileEntityXpStorage;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiTrashBin extends GuiContainer{

	 TileEntityBin tile = new TileEntityBin();
	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/BinGui.png");
	
	
	public GuiTrashBin(InventoryPlayer InvPlayer, TileEntityBin tile) {
		super(new ContainerBin(InvPlayer, tile));
	}
	
    @Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) {

            fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
            
            fontRenderer.drawString("Trash Bin", 7, 3, 4210752);
         
            
            
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int X, int Y)
	{
	    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

		 Minecraft.getMinecraft().func_110434_K().func_110577_a(Texture);
	         drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

	         

	}

	
	@Override
	public void initGui(){
		super.initGui();
		buttonList.clear();
		
		
		buttonList.add(new GuiTipButton(1, guiLeft, guiTop, "?", Messages.TrashBinTips));
	}
}
