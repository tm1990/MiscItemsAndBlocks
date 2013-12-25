package Mod.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import org.lwjgl.opengl.GL11;

import Mod.Items.ModItemAntiFallChest;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GuiFlyChestOverlay extends GuiIngame{

	public GuiFlyChestOverlay() {
		super(Minecraft.getMinecraft());
	}

	
	@SideOnly(Side.CLIENT)
	public void renderOverlay()
	{
		ScaledResolution scaledresolution = new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);
        int width = scaledresolution.getScaledWidth();
        int height = scaledresolution.getScaledHeight();
        int eighth = width/20;
		
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_LIGHTING);
		
		EntityClientPlayerMP player = this.mc.thePlayer;
		
		
		if(player.inventory.armorInventory[2] != null && player.inventory.armorInventory[2].getItem() instanceof ModItemAntiFallChest){
			ItemStack armor = player.inventory.armorInventory[2];


		float PowerLeft = armor.getMaxDamage() - armor.getItemDamage();
		int Percent = (int)(PowerLeft / armor.getMaxDamage() * 100);

		
		EnumChatFormatting Color = null;
		
		if(Percent > 80){
			Color = EnumChatFormatting.GREEN;
		}else if (Percent < 81 && Percent > 50){
			Color = EnumChatFormatting.BLUE;
		}else if (Percent < 51 && Percent > 25){
			Color = EnumChatFormatting.RED;
		}else{
			Color = EnumChatFormatting.DARK_RED;
		}
		
		String Text = EnumChatFormatting.GOLD + "Anti-fall Power: " + Color + (int)(PowerLeft / armor.getMaxDamage() * 100) + "%";

		
		if(Percent > 9 && Percent < 100){
			this.drawCenteredString(this.mc.fontRenderer, Text, eighth+ 33 - Text.length() / 8, height/22, 0xffffff);
			
		}else if (Percent > 99){
			this.drawCenteredString(this.mc.fontRenderer, Text, eighth+ 36 - Text.length() / 8, height/22, 0xffffff);
		}else{
			this.drawCenteredString(this.mc.fontRenderer, Text, eighth+ 29 - Text.length() / 8, height/22, 0xffffff);
		}
		
		
		if(PowerLeft == 0)
			this.drawCenteredString(this.mc.fontRenderer, EnumChatFormatting.RED + "Out of power recharge!", eighth+ 40, height/12, 0xffffff);
		}
	}
}
