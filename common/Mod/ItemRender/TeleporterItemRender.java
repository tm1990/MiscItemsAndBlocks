package Mod.ItemRender;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.techne.TechneModel;

import org.lwjgl.opengl.GL11;

import Mod.Models.TeleporterModel;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TeleporterItemRender implements IItemRenderer
{




	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch (type) {
		case ENTITY:
			return true;
		case EQUIPPED:
			return true;
		case EQUIPPED_FIRST_PERSON:
			return true;
		case INVENTORY:
			return true;
		default:
			return false;
	}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        
		
		TeleporterModel model = new TeleporterModel();
		
        GL11.glPushMatrix();
        GL11.glTranslatef((float) 0.5F, (float) 1.5F, (float) 0.5F);
        
        
        Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("miscitems" , "textures/models/TelePorter.png"));
        
        
     GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        
        GL11.glRotatef((2 * 90F), 0.0F, 1.0F, 0.0F);
        
        model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, 0);
        
        
        GL11.glPopMatrix();
        GL11.glPopMatrix();
	}
}