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
		this.ySize = 205;
		
		this.tile = tile;
	}
	
  @Override
  protected void drawGuiContainerForegroundLayer(int param1, int param2) {

          fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
          fontRenderer.drawString("Mining Chamber", 59, 7, 4210752);
          
          
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
	         
	         int YLeft = CurrentY - LastY;
	         
	         fontRenderer.drawString("Power: " + Power + "/" + tile.MaxPower, x + 59, y + 17, 0x000000);
	         fontRenderer.drawString("Blocks Mined: " + BlocksMined, x + 59, y + 27, 0x000000);
	         if(YLeft > 0)
	         fontRenderer.drawString("Mining " + YLeft + " deeper.", x + 59, y + 37, 0x000000);
	         else
		         fontRenderer.drawString("Mining 0 deeper.", x + 59, y + 37, 0x000000);
	         fontRenderer.drawString("Mining down to: " + LastY, x + 59, y + 47, 0x000000);
	         fontRenderer.drawString("Currently at: " + CurrentY, x + 59, y + 57, 0x000000);
	         
	         

	}
	
	
	@Override
	public void initGui(){
		super.initGui();
		buttonList.clear();
		
		
		buttonList.add(new GuiButton(1, guiLeft + 61, guiTop + 80, 19, 20, "y-"));
		buttonList.add(new GuiButton(2, guiLeft + 40,  guiTop + 80, 19, 20, "y+"));
		buttonList.add(new GuiButton(3, guiLeft + 5, guiTop + 80, 33, 20, "Mine"));
		buttonList.add(new GuiButton(4, guiLeft + 82,  guiTop + 80, 53, 20, "Current y"));
		
		
		
	}
	
	
	@Override
	protected void actionPerformed(GuiButton button){
		PacketHandler.sendButtonPacket((byte)button.id);

	}
	
}