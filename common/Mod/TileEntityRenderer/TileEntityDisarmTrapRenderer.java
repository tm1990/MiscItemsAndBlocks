package Mod.TileEntityRenderer;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

import Mod.Block.ModBlockDisarmTrap;
import Mod.Models.TrapModel;
import Mod.TileEntity.TileEntityDisarmTrap;

public class TileEntityDisarmTrapRenderer extends TileEntitySpecialRenderer {
    
    private final TrapModel model;
   
    public TileEntityDisarmTrapRenderer() {
            this.model = new TrapModel();
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

            
            
            if(!te.hasWorldObj()){
                bindTexture(new ResourceLocation("textures/blocks/quartz_block_top.png"));
                GL11.glPushMatrix();
                GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
                this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, true);
                GL11.glPopMatrix();
                GL11.glPopMatrix();
            }else{
            	TileEntity tile_entity = te.worldObj.getBlockTileEntity(te.xCoord, te.yCoord, te.zCoord);
            	
            	if(tile_entity instanceof TileEntityDisarmTrap){
            		TileEntityDisarmTrap tile = (TileEntityDisarmTrap)tile_entity;
            		
            		if(tile.GetBlock() == null){
                        bindTexture(new ResourceLocation("textures/blocks/quartz_block_top.png"));
            		}else{
                        bindTexture(new ResourceLocation("textures/blocks/" + tile.GetBlock().getBlockTextureFromSide(0).getIconName() + ".png"));
            		}
            		
            		
            	}
            	
                
                

            
         GL11.glPushMatrix();
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            

            int Meta = te.worldObj.getBlockMetadata(te.xCoord, te.yCoord, te.zCoord);
            
            this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, Meta != 1);
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
}