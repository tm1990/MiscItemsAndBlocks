package Mod.Gui;


import org.lwjgl.opengl.GL11;

import Mod.Block.ModBlocks;
import Mod.Container.ContainerXpStorage;
import Mod.Lib.Messages;
import Mod.Network.PacketHandler;
import Mod.TileEntity.TileEntityXpStorage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiXpStorage extends GuiContainer{
	
	
	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/XpStorageGui.png");
	
	GuiTextField textfield;
	
	TileEntityXpStorage tile;
	

 
 
	public GuiXpStorage(InventoryPlayer InvPlayer, TileEntityXpStorage tile) {
		super(new ContainerXpStorage(InvPlayer, tile));
		
		this.tile = tile;
	}

	
    @Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) {

            fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
            
            fontRenderer.drawString("Xp Storage Block", 7, 3, 4210752);
            
            
            textfield.drawTextBox();
            


            
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
		
		
		buttonList.add(new GuiButton(1, guiLeft + 20,  guiTop + 45, 60, 20, "Withdraw"));
		buttonList.add(new GuiButton(2, guiLeft + 96, guiTop + 45, 60, 20, "Deposit"));
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
	
	public void updateScreen(){
		
		textfield.setText("Levels stored : " + tile.GetLevels());
		
		
		}


	
	
	
	}

