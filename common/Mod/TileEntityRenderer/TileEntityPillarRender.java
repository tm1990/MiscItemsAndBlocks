package Mod.TileEntityRenderer;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import Mod.Models.GamePartModel;

public class TileEntityPillarRender extends TileEntitySpecialRenderer {
    
    private GamePartModel model;
    
    ResourceLocation Texutre;
    
   
    public TileEntityPillarRender() {
    	
        this.model = new GamePartModel();
            
            this.Texutre = new ResourceLocation("textures/blocks/quartz_block_top.png");
                }
   
    private void adjustRotatePivotViaMeta(World world, int x, int y, int z) {
            int meta = world.getBlockMetadata(x, y, z);
            GL11.glPushMatrix();
            GL11.glRotatef(meta * (- 90), 0.0F, 0.0F, 1.0F);
            GL11.glPopMatrix();
    }
   
    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);

            
            bindTexture(Texutre);

            int Id = te.worldObj.getBlockId(te.xCoord, te.yCoord, te.zCoord);
            
            
         GL11.glPushMatrix();
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);

            this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, te.worldObj.getBlockId(te.xCoord, te.yCoord + 1, te.zCoord) != Id, te.worldObj.getBlockId(te.xCoord, te.yCoord - 1, te.zCoord) != Id);
            
            
            GL11.glPopMatrix();
            GL11.glPopMatrix();
    }
     
    private void adjustLightFixture(World world, int i, int j, int k, Block block) {
            Tessellator tess = Tessellator.instance;
            float brightness = block.getBlockBrightness(world, i, j, k);
            int skyLight = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
            int modulousModifier = skyLight % 65536;
            int divModifier = skyLight / 65536;
            tess.setColorOpaque_F(brightness, brightness, brightness);
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,  (float) modulousModifier,  divModifier);
    }
}