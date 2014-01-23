package Mod.GamePart;

import org.lwjgl.opengl.GL11;

import Mod.Models.GamePartModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


@SideOnly(Side.CLIENT)
public class GamePartItemRender implements IItemRenderer
{

    private TileEntityGamePart tile = new TileEntityGamePart ();


    ResourceLocation Texutre = new ResourceLocation("textures/blocks/hardened_clay.png");

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
		
		
		 GL11.glPushMatrix();
         GL11.glTranslatef(0.5F, 1.4F, 0.5F);

         
         Minecraft.getMinecraft().renderEngine.bindTexture(Texutre);
		
        GamePartModel model = new GamePartModel();
        
        
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        
        model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, true, true, item.getItemDamage());
        
        
        GL11.glPopMatrix();
        GL11.glPopMatrix();
        
	}
}