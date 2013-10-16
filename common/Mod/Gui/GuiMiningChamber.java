package Mod.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import Mod.Container.ContainerMiningChamber;
import Mod.Lib.Messages;
import Mod.Network.PacketHandler;
import Mod.TileEntity.TileEntityMiningChamber;

public class GuiMiningChamber extends GuiContainer{

	private TileEntityMiningChamber tile;
	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/MiningChamberGui.png");
	
	public GuiMiningChamber(InventoryPlayer InvPlayer, TileEntityMiningChamber tile) {
		super(new ContainerMiningChamber(InvPlayer, tile));
		
		this.xSize = 176;
		this.ySize = 214;
		
		this.tile = tile;
	}
	
  @Override
  protected void drawGuiContainerForegroundLayer(int param1, int param2) {
//63
          fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
          fontRenderer.drawString("Mining Chamber", 53, 12, 4210752);
          
          
  }

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int X, int Y)
	{
	    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

	    Minecraft.getMinecraft().renderEngine.bindTexture(Texture);
	         
	         int x = (this.width - this.xSize) / 2;
	         int y = (this.height - this.ySize) / 2;
	         drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

	         int Power = this.tile.GetPower();
	         int BlocksMined = this.tile.GetBlocksMined();
	         int CurrentY = this.tile.GetMinedY();
	         int LastY = this.tile.GetLastY();
	         
	         fontRenderer.drawString("Power: " + Power + "/" + tile.MaxPower, x + 53, y + 24, 0x000000);
	         fontRenderer.drawString("Blocks Mined: " + BlocksMined, x + 53, y + 34, 0x000000);
	         fontRenderer.drawString("Mining y: " + CurrentY + "/" + LastY, x + 53, y + 44, 0x000000);
	         
	         

	}
	
	
	@Override
	public void initGui(){
		super.initGui();
		buttonList.clear();
		
		
		buttonList.add(new GuiButton(1, guiLeft + 5,  guiTop + 7, 12, 14, "y+"));
		buttonList.add(new GuiButton(2, guiLeft + 18, guiTop + 7, 12, 14, "y-"));
		buttonList.add(new GuiButton(3, guiLeft + 31, guiTop + 7, 18, 14, "Mine"));
		buttonList.add(new GuiButton(4, guiLeft + 3,  guiTop + 51, 46, 12, "Current y"));
		
		
		
	}
	
	
	@Override
	protected void actionPerformed(GuiButton button){
		PacketHandler.sendButtonPacket((byte)button.id);

	}
	
}