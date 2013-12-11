package Mod.Gui;

import org.lwjgl.opengl.GL11;

import Mod.Items.ModItemPaintBrush;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiPaintBrush extends GuiScreen
{
	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/PaintBrushGui.png");
	
	
    public static final int xSizeOfTexture = 210;
    public static final int ySizeOfTexture = 114;
    
    private final ItemStack stack;
    
    GuiTextField textfieldRed;
    GuiTextField textfieldGreen;
    GuiTextField textfieldBlue;
    
    int Red;
    int Green;
    int Blue;
	
	
	public GuiPaintBrush(ItemStack stack){
		
		this.stack = stack;
	}

	 @Override
	    public void drawScreen(int x, int y, float f) {
	        drawDefaultBackground();

	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        Minecraft.getMinecraft().renderEngine.bindTexture(Texture);

	        int posX = (this.width - xSizeOfTexture) / 2;
	        int posY = (this.height - ySizeOfTexture) / 2;
	        

	        drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
	        

            textfieldRed.drawTextBox();
            textfieldGreen.drawTextBox();
            textfieldBlue.drawTextBox();
            
            
            textfieldRed.setMaxStringLength(3);
            textfieldGreen.setMaxStringLength(3);
            textfieldBlue.setMaxStringLength(3);
            
	        
	        StringBuilder text = new StringBuilder("Paint Editor");
	        fontRenderer.drawSplitString(text.toString(), posX + 10, posY + 6, 150, 4210752);
	        
	        StringBuilder text1 = new StringBuilder("Red Value (0-254)");
	        fontRenderer.drawSplitString(text1.toString(), posX + 80, posY + 25, 150, 4210752);
	        
	        StringBuilder text2 = new StringBuilder("Green Value (0-254)");
	        fontRenderer.drawSplitString(text2.toString(), posX + 80, posY + 55, 150, 4210752);
	        
	        StringBuilder text3 = new StringBuilder("Blue Value (0-254)");
	        fontRenderer.drawSplitString(text3.toString(), posX + 80, posY + 85, 150, 4210752);

	        

	        
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
	        
			textfieldRed = new GuiTextField(fontRenderer, posX + 5, posY + 20, 70, 20);
			textfieldGreen = new GuiTextField(fontRenderer, posX + 5, posY + 50, 70, 20);
			textfieldBlue = new GuiTextField(fontRenderer, posX + 5, posY + 80, 70, 20);

			
			buttonList.add(new GuiButton(0, posX + 175, posY + 90, 30, 20, "Clear"));
	    }
	    


	    @Override
	    protected void actionPerformed(GuiButton par1GuiButton) {
	        switch (par1GuiButton.id) {

	        case 0:
	        	textfieldRed.setText("0");
	        	textfieldGreen.setText("0");
	        	textfieldBlue.setText("0");
	        	break;
	        }
	    }
	    
	    public boolean HasInfo(ItemStack stack) {
	        return stack.hasTagCompound() && stack.getTagCompound().hasKey("Data");
	    }
	    
	    public void onGuiClosed() {
	    	
	    	
	    	
	    	String TextRed = textfieldRed.getText();
	    	String TextGreen = textfieldGreen.getText();
	    	String TextBlue = textfieldBlue.getText();
	    	
	    	if(TextRed == null || TextRed == "" || TextRed == " "){
	    		TextRed = "0";
	    	}
	    	
	    	if(TextGreen == null || TextGreen == "" || TextGreen == " "){
	    		TextGreen = "0";
	    	}
	    	
	    	if(TextBlue == null || TextBlue == "" || TextBlue == " "){
	    		TextBlue = "0";
	    	}
	    	
	    	
	    	Red = Integer.parseInt(TextRed);
	    	Green = Integer.parseInt(TextGreen);
	    	Blue = Integer.parseInt(TextBlue);
	    	
	    	if(Red > 254)
	    		Red = 254;
	    	
	    	if(Green > 254)
	    		Green = 254;
	    	
	    	if(Blue > 254)
	    		Blue = 254;
	    	
	    	
	    	   NBTTagCompound stackCompound = stack.hasTagCompound() ? stack.getTagCompound() : new NBTTagCompound();
		        NBTTagCompound compound = new NBTTagCompound();
		        
   			  compound.setInteger("Red", Red);
   			  compound.setInteger("Green", Green);
   			  compound.setInteger("Blue", Blue);
   			  
   			  
   			  
 	            stackCompound.setCompoundTag("Data", compound);
	            stack.setTagCompound(stackCompound);

	    	
	    	
	    }
	    
	    public void mouseClicked(int i, int j, int k){
	    	super.mouseClicked(i, j, k);
	    	textfieldRed.mouseClicked(i, j, k);
	    	textfieldGreen.mouseClicked(i, j, k);
	    	textfieldBlue.mouseClicked(i, j, k);
	    	}
	    
	    public void keyTyped(char c, int i){
	    	super.keyTyped(c, i);
	    	
	    	
	    	if(c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c == '0' || i == 14){
	    	
	    	if(textfieldRed.isFocused())
	    	textfieldRed.textboxKeyTyped(c, i);
	    	else if (textfieldGreen.isFocused())
	    	textfieldGreen.textboxKeyTyped(c, i);
	    	else if (textfieldBlue.isFocused())
	    	textfieldBlue.textboxKeyTyped(c, i);
	    	}
	    	}


}
