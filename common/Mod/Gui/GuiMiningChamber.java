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
		this.ySize = 235;
		
		this.tile = tile;
	}
	
  @Override
  protected void drawGuiContainerForegroundLayer(int param1, int param2) {

          fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
          fontRenderer.drawString(StatCollector.translateToLocal("gui.miningchamber"), 59, 7, 4210752);
          
          
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
	         int CurrentY = this.tile.GetMinedY();
	         int LastY = this.tile.GetLastY();
	         int HoleSize = this.tile.GetSize();
	         
	         int YLeft = CurrentY - LastY;
	         
	         fontRenderer.drawString(StatCollector.translateToLocal("words.power") + ": " + Power + "/" + tile.MaxPower, x + 59, y + 17, 0x000000);
	         fontRenderer.drawString(StatCollector.translateToLocal("words.holesize") + ": " + HoleSize + "x" + HoleSize, x + 59, y + 27, 0x000000);
	         if(YLeft > 0)
	         fontRenderer.drawString(StatCollector.translateToLocal("words.mining") + ": " + YLeft + " "+  StatCollector.translateToLocal("words.deeper") + ".", x + 59, y + 37, 0x000000);
	         else
		         fontRenderer.drawString(StatCollector.translateToLocal("words.mining") + "0" + StatCollector.translateToLocal("words.deeper") , x + 59, y + 37, 0x000000);
	         fontRenderer.drawString(StatCollector.translateToLocal("gui.string.miningdownto") + ": " + LastY, x + 59, y + 47, 0x000000);
	         fontRenderer.drawString(StatCollector.translateToLocal("gui.string.currentlyat") + ": " + CurrentY, x + 59, y + 57, 0x000000);
	         
	         

	}
	
	
	@Override
	public void initGui(){
		super.initGui();
		buttonList.clear();
		
		int Meta = this.tile.worldObj.getBlockMetadata(tile.xCoord, tile.yCoord, tile.zCoord);
		
		buttonList.add(new GuiButton(1, guiLeft + 48, guiTop + 86, 19, 20, "y-"));
		buttonList.add(new GuiButton(2, guiLeft + 70,  guiTop + 86, 19, 20, "y+"));
		
		buttonList.add(new GuiButton(3, guiLeft + 5, guiTop + 86, 40, 20, Meta == 1 ? StatCollector.translateToLocal("words.stop") : StatCollector.translateToLocal("words.start")));

		buttonList.add(new GuiButton(4, guiLeft + 92,  guiTop + 86, 79, 20, StatCollector.translateToLocal("gui.string.settostart")  + " y"));
		
		buttonList.add(new GuiButton(5, guiLeft + 5,  guiTop + 111, 50, 20, StatCollector.translateToLocal("words.size") + " +"));
		buttonList.add(new GuiButton(6, guiLeft + 58,  guiTop + 111, 50, 20, StatCollector.translateToLocal("words.size") + " -"));
		
		
		
	}
	
	
	@Override
	protected void actionPerformed(GuiButton button){
		PacketHandler.sendButtonPacket((byte)button.id);

	}
	
}