package Mod.Gui;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.FMLCommonHandler;

public class GuiPlayerFinder extends GuiScreen{

	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/LargeGuiBlankOutInv.png");

    public static final int xSizeOfTexture = 176;
    public static final int ySizeOfTexture = 155;
    
    GuiTextField textField;
    GuiButton teleport;
    
    String player;
    String x;
    String y;
    String z;
    String Mode;
	
	 @Override
	    public void drawScreen(int x, int y, float f) {
	        drawDefaultBackground();

	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        Minecraft.getMinecraft().renderEngine.bindTexture(Texture);

	        int posX = (this.width - xSizeOfTexture) / 2;
	        int posY = (this.height - ySizeOfTexture) / 2;
	        

	        drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
	        
	        this.drawRect(posX + 5, posY + 150, posX + 170, posY + 80, new Color(100,100,100).getRGB());
         
	        
	        fontRenderer.drawString(StatCollector.translateToLocal("gui.string.enterplayername") + " " + StatCollector.translateToLocal("gui.string.casesensetive"), posX + 3, posY + 6, 10);

	        if((this.x != null && this.y != null && z != null && player != null) && Mode == "Valid"){
		    fontRenderer.drawString(player + "`s Coords: ", posX + 7, posY + 82, 10);
	        fontRenderer.drawString("X Coord: " + this.x, posX + 7, posY + 90, 10);
	        fontRenderer.drawString("Y Coord: " + this.y, posX + 7, posY + 98, 10);
	        fontRenderer.drawString("Z Coord: " + this.z, posX + 7, posY + 106, 10);
	        
	        if(Minecraft.getMinecraft().thePlayer.capabilities.isCreativeMode){
	        	teleport.enabled = true;
	        }
	        
	        }else if (Mode == "Invalid"){
			    fontRenderer.drawString("Invalid playername!", posX + 7, posY + 82, new Color(50,0,0).getRGB());
	        }
	        
	        textField.drawTextBox();
	        
	        
	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        GL11.glDisable(GL11.GL_LIGHTING);

	        super.drawScreen(x, y, f);
	    }
	 
	    @Override
	    public boolean doesGuiPauseGame() {
	        return false;
	    }
	    
	    
	    @Override
	    public void initGui() {
			super.initGui();
			buttonList.clear();
	        int posX = (this.width - xSizeOfTexture) / 2;
	        int posY = (this.height - ySizeOfTexture) / 2;
	        textField = new GuiTextField(fontRenderer, posX + 6, posY + 16, 164, 17);
	        teleport = new GuiButton(3, posX + 60, posY + 34, 50, 20, StatCollector.translateToLocal("gui.string.teleport"));
	        
	        buttonList.add(new GuiButton(1, posX + 6, posY + 34, 50, 20, StatCollector.translateToLocal("gui.string.enter")));
	        buttonList.add(new GuiButton(2, posX + 6, posY + 56, 50, 20, StatCollector.translateToLocal("gui.string.clear")));
	        buttonList.add(teleport);
	        
	        teleport.enabled = false;

	        
	        
	    }
	    
	    protected void mouseClicked(int x, int y, int par3)
	    {
	        super.mouseClicked(x, y, par3);
	    
	        this.textField.mouseClicked(x, y, par3);
	        
	    }
	    
	    protected void keyTyped(char par1, int par2)
	    {
	    	super.keyTyped(par1, par2);

	    	if(textField.isFocused() && par2 != Keyboard.KEY_RETURN){
	    		textField.textboxKeyTyped(par1, par2);
	    	}
	    	
	    }
	    
	    @Override
	    protected void actionPerformed(GuiButton par1GuiButton) {
	        switch (par1GuiButton.id) {
	        
	        case 1:
				EntityPlayerMP player = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().getPlayerForUsername(textField.getText());
				if(player != null){
					Mode = "Valid";
					x = (int)player.posX + "";
					y = (int)player.posY + "";
					z = (int)player.posZ + "";
					
					this.player = player.username;
					textField.setText("");
				}else{
					Mode = "Invalid";
				}
	        	break;
	        	
	        case 2:
	        	textField.setText("");
	        	x = null;
	        	y = null;
	        	z = null;
	        	Mode = "Empty";
	        	player = null;
	        	
	        	break;
	        
	        
	        	
	        case 3:
	        	if((this.x != null && this.y != null && z != null && this.player != null) && Mode == "Valid"){
	        		
	        		Minecraft.getMinecraft().thePlayer.setLocationAndAngles(Integer.valueOf(x), Integer.valueOf(y), Integer.valueOf(z), Minecraft.getMinecraft().thePlayer.rotationYaw, Minecraft.getMinecraft().thePlayer.rotationPitch);
	        		Minecraft.getMinecraft().thePlayer.closeScreen();
	        	}
	        	
	        	break;
	        
	        }
	        

	        }
}
