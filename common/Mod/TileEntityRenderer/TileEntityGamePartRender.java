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

public class TileEntityGamePartRender extends TileEntitySpecialRenderer {
    
    private GamePartModel model;

    
    ResourceLocation Texutre;
    
   
    public TileEntityGamePartRender() {
        this.model = new GamePartModel();

            
            this.Texutre = new ResourceLocation("textures/blocks/hardened_clay.png");
                }
   
    private void adjustRotatePivotViaMeta(World world, int x, int y, int z) {
            int meta = world.getBlockMetadata(x, y, z);
            GL11.glPushMatrix();
            GL11.glRotatef(meta * (- 90), 0.0F, 0.0F, 1.0F);
            GL11.glPopMatrix();
    }
   
    @Override
    public void renderTileEntityAt(TileEntity te, double X, double Y, double Z, float scale) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float) X + 0.5F, (float) Y + 1.5F, (float) Z + 0.5F);

            
            bindTexture(Texutre);
            
            	int Meta = te.worldObj.getBlockMetadata(te.xCoord, te.yCoord, te.zCoord);
            	int Id = te.worldObj.getBlockId(te.xCoord, te.yCoord, te.zCoord);
            	
            	World world = te.worldObj;
            	int x = te.xCoord;
            	int y = te.yCoord;
            	int z = te.zCoord;
            	
            	boolean Top = world.getBlockId(x, y + 1, z) != Id && world.getBlockMetadata(x, y + 1, z) != Meta;
            	if(Meta == 0)
            		Top = world.getBlockId(x, y + 1, z) != Id && world.getBlockMetadata(x, y + 1, z) == Meta;
            	
            	
            	boolean Bottom = world.getBlockId(x, y - 1, z) != Id && world.getBlockMetadata(x, y - 1, z) != Meta;
            	
            	if(Meta == 0)
            		Bottom = world.getBlockId(x, y - 1, z) != Id && world.getBlockMetadata(x, y - 1, z) == Meta;
            
            
         GL11.glPushMatrix();
         GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);

         this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, Top, Bottom, Meta);

         
         
         
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