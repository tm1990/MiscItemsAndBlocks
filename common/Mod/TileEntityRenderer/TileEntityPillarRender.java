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

import Mod.Block.ModBlockPillar;
import Mod.Models.PillarModel;



public class TileEntityPillarRender extends TileEntitySpecialRenderer {
    
    private final PillarModel model;
   
    public TileEntityPillarRender() {
            this.model = new PillarModel();
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
            
            
            bindTexture(new ResourceLocation("textures/blocks/quartz_block_top.png"));
            
            if(te.hasWorldObj()){
            
            World world = te.worldObj;
            int X = te.xCoord;
            int Y = te.yCoord;
            int Z = te.zCoord;
            
            
            boolean top, bottom, front, back, right, left;
            
            bottom = IsPillar(world, X, Y - 1, Z);
            
            top = IsPillar(world, X, Y + 1, Z);
            
            front = IsPillar(world, X, Y, Z + 1);
            
            back = IsPillar(world, X, Y, Z - 1);
            
            right = IsPillar(world, X - 1, Y, Z);
            
            left = IsPillar(world, X + 1, Y, Z);
            
         GL11.glPushMatrix();
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            
            this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, top, bottom, front, back, left, right, false);
            
            GL11.glPopMatrix();
            GL11.glPopMatrix();
            }else{
                
           
                
             GL11.glPushMatrix();
                GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
                this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, true, true, false, false, false, false, true);
                
                GL11.glPopMatrix();
                GL11.glPopMatrix();
            }
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
    
    public boolean IsPillar(World world, int x, int y, int z){
    	
    	int BlockID = world.getBlockId(x, y, z);
    	
    	Block block = Block.blocksList[BlockID];
    	
    	if(block instanceof ModBlockPillar)return true;

    	
    	return false;
    }
}
