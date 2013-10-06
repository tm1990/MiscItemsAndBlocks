package Mod.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import Mod.Container.ContainerLockableChest;
import Mod.Lib.Messages;
import Mod.TileEntity.TileEntityLockableChest;

public class GuiLockableChest extends GuiContainer{

	private TileEntityLockableChest tile;
	private final ResourceLocation Texture = new ResourceLocation("textures/gui/container/generic_54.png");
	
	public GuiLockableChest(InventoryPlayer InvPlayer, TileEntityLockableChest tile) {
		super(new ContainerLockableChest(InvPlayer, tile));
		
		this.xSize = 176;
		this.ySize = 222;
		
		this.tile = tile;
	}
	
  @Override
  protected void drawGuiContainerForegroundLayer(int param1, int param2) {

          fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
          fontRenderer.drawString("Lockable Chest", 2, 3, 4210752);
          
          
  }

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int X, int Y)
	{
	    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

	    Minecraft.getMinecraft().renderEngine.bindTexture(Texture);
	         
	         int x = (this.width - this.xSize) / 2;
	         int y = (this.height - this.ySize) / 2;
	         drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);


	         

	}
	

}
