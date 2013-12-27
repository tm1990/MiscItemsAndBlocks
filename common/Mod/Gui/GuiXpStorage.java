package Mod.Gui;


import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import Mod.Container.ContainerXpStorage;
import Mod.Lib.Messages;
import Mod.Network.PacketHandler;
import Mod.TileEntity.TileEntityXpStorage;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GuiXpStorage extends GuiContainer{
	
	
	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/GuiBlank.png");
	
	GuiTextField textfield;
	
	private TileEntityXpStorage tile;
	

 
 
	public GuiXpStorage(InventoryPlayer InvPlayer, TileEntityXpStorage tile) {
		super(new ContainerXpStorage(InvPlayer, tile));
		
		this.tile = tile;
	}

	
    @Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) {

            fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 2, ySize - 96 + 2, 4210752);
            
            fontRenderer.drawString(StatCollector.translateToLocal("gui.xpstorage"), 7, 3, 4210752);
            
            
            textfield.drawTextBox();
            


            
    }

	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int X, int Y)
	{
	    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

	    Minecraft.getMinecraft().renderEngine.bindTexture(Texture);
	         drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	         
	         int Xp = this.tile.GetLevels();

	         
	 		textfield.setText(StatCollector.translateToLocal("gui.string.levelsstored") + ": " + Xp);


	         

	}
	
	@Override
	public void initGui(){
		super.initGui();
		buttonList.clear();
		
		
		buttonList.add(new GuiButton(1, guiLeft + 20,  guiTop + 39, 60, 20, StatCollector.translateToLocal("words.withdraw")));
		buttonList.add(new GuiButton(2, guiLeft + 96, guiTop + 39, 60, 20, StatCollector.translateToLocal("words.deposit")));
		buttonList.add(new GuiTipButton(3, guiLeft, guiTop, "?", Messages.XpStorageTips));
		
		textfield = new GuiTextField(fontRenderer, 24, 15, 120, 20);
		
		
		
	}
	
	
	@Override
	protected void actionPerformed(GuiButton button){
		PacketHandler.sendButtonPacket((byte)button.id);

		
		switch(button.id){
		  
		case 1:
			break;
			
		case 2:
			break;
			
		case 3:
			break;
		
		}
		
		
		}
	
	


	
	
	
	}

