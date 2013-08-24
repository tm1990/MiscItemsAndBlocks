package Mod.Gui;

import Mod.Lib.Messages;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

public class GuiTipButton extends GuiButton{

	int x;
	int y;
	String[] MessageList;
	int Current;
	
	public GuiTipButton(int ButtonNumber, int GuiX, int GuiY, String Text, String[] Message) {
		super(ButtonNumber, GuiX + 149, GuiY + 4, 20, 20, Text);
		x = GuiX;
		y = GuiY;
		this.MessageList = Message;
	}
	
    public boolean mousePressed(Minecraft mc, int par2, int par3)
    {
    	
    	if(par2 > x + 149 && par2 < x + 149 + 20){
    		if(par3 > y + 4 && par3 < y + 4 + 20){
    			
    			mc.getMinecraft().thePlayer.addChatMessage("[Info]" + MessageList[Current]);
    			
				if(MessageList[Current + 1] == null){
					Current = 0;
				}else{
					Current++;
				}
				
    		}
    	}
    	
        return this.enabled && this.drawButton && par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height;
    }
    

}
