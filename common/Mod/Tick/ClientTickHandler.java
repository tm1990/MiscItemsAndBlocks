package Mod.Tick;

import java.util.EnumSet;

import Mod.Items.ModItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ClientTickHandler extends ServerTickHandler implements ITickHandler{

	
	/*
	 * Helmet = 3
	 * ChestPlate = 2
	 * Leggings = 1
	 * Boots = 0
	 * 
	 */
	
	public Minecraft mc;

	public ClientTickHandler() {
        this.mc = Minecraft.getMinecraft();
}

	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
	}

}
