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

import Mod.Models.ShelfModelBack;
import Mod.Models.ShelfModelFront;
import Mod.Models.ShelfModelLeft;
import Mod.Models.ShelfModelRight;

public class TileEntityShelfRender extends TileEntitySpecialRenderer {
    
    private ShelfModelFront modelFront;
    private ShelfModelBack modelBack;
    private ShelfModelRight modelRight;
    private ShelfModelLeft modelLeft;
    
    
    ResourceLocation Texutre;
   
    public TileEntityShelfRender() {
            this.modelFront = new ShelfModelFront();
            this.modelBack = new ShelfModelBack();
            this.modelRight = new ShelfModelRight();
            this.modelLeft = new ShelfModelLeft();
            
            this.Texutre = new ResourceLocation("textures/blocks/planks_oak.png");
    }
   
   
    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
    	
    	   int meta = te.worldObj.getBlockMetadata(te.xCoord, te.yCoord, te.zCoord);
    	
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);

        
        bindTexture(Texutre);
        
        
     GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);

            
            
            if(meta == 1){
                this.modelBack.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            }
            
            if(meta == 2){
                this.modelLeft.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);//
            }
            
            if(meta == 3){
                this.modelFront.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            }

            if(meta == 4){
                this.modelRight.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            }
            

            
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
    
    private void adjustRotatePivotViaMeta(World world, int x, int y, int z) {
        int meta = world.getBlockMetadata(x, y, z);
        GL11.glPushMatrix();
        GL11.glRotatef(meta * (- 90), 0.0F, 0.0F, 1.0F);
        GL11.glPopMatrix();
}
     

}