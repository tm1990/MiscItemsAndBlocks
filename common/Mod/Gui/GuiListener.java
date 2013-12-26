package Mod.Gui;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;

public class GuiListener {
	
	private GuiOverlayInfoScreen overlay;
	
	public GuiListener()
	{
		this.overlay = new GuiOverlayInfoScreen();
	}
	
	@ForgeSubscribe(priority = EventPriority.NORMAL)
	public void onRenderGameOverlay(RenderGameOverlayEvent event) {
		if (event.type == ElementType.TEXT) {
			if (!event.isCancelable() && !Minecraft.getMinecraft().playerController.isInCreativeMode()) {
				overlay.renderOverlay();
			}
		} 
		}
	}

