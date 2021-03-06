package Mod.TileEntityRenderer;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import Mod.Models.MiningChamberModel;
import Mod.TileEntity.TileEntityMiningChamber;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileEntityMiningChamberRender extends TileEntitySpecialRenderer {
    
    private final MiningChamberModel model;
    private final RenderItem customRenderItem;
   
    public TileEntityMiningChamberRender() {
            this.model = new MiningChamberModel();
            customRenderItem = new RenderItem() {

                @Override
                public boolean shouldBob() {

                    return false;
                };
            };

            customRenderItem.setRenderManager(RenderManager.instance);
    }
   
    private void adjustRotatePivotViaMeta(World world, int x, int y, int z) {
            int meta = world.getBlockMetadata(x, y, z);
            GL11.glPushMatrix();
            GL11.glRotatef(meta * (- 90), 0.0F, 0.0F, 1.0F);
            GL11.glPopMatrix();
    }
   
    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
    	if(te instanceof TileEntityMiningChamber){
    	TileEntityMiningChamber tile = (TileEntityMiningChamber)te;
    		
    		
    		
            GL11.glPushMatrix();
            
            
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);

            bindTexture(new ResourceLocation("miscitems" , "textures/models/MiningChamber.png"));
            
            this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, te, te.xCoord, te.yCoord, te.zCoord);
            
         GL11.glPopMatrix();
         GL11.glPushMatrix();
         

     
            if(tile.getStackInSlot(tile.ToolSlot) != null){
            float scaleFactor = getGhostItemScaleFactor(tile.getStackInSlot(tile.ToolSlot));
            float rotationAngle = (float) (520.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);

            EntityItem ghostEntityItem = new EntityItem(te.worldObj);
            ghostEntityItem.hoverStart = 0.0F;
            ghostEntityItem.setEntityItemStack(tile.getStackInSlot(tile.ToolSlot));

            GL11.glTranslatef((float) x + 0.5F, (float) y + 1F, (float) z + 0.5F);
            
            GL11.glScalef(scaleFactor + 0.004F, scaleFactor + 0.004F, scaleFactor + 0.004F);
            GL11.glRotatef(rotationAngle, 0.0F, 1.0F, 0.0F);

            customRenderItem.doRenderItem(ghostEntityItem, 0, 0, 0, 0, 0);
            }

   
            GL11.glPopMatrix();

    	}

    }
    
    private float getGhostItemScaleFactor(ItemStack itemStack) {

        float scaleFactor = 1.0F;

        if (itemStack != null) {
            if (itemStack.getItem() instanceof ItemBlock) {
                switch (customRenderItem.getMiniBlockCount(itemStack)) {
                    case 1:
                        return 0.90F;
                    case 2:
                        return 0.90F;
                    case 3:
                        return 0.90F;
                    case 4:
                        return 0.90F;
                    case 5:
                        return 0.80F;
                    default:
                        return 0.90F;
                }
            }
            else {
                switch (customRenderItem.getMiniItemCount(itemStack)) {
                    case 1:
                        return 0.65F;
                    case 2:
                        return 0.65F;
                    case 3:
                        return 0.65F;
                    case 4:
                        return 0.65F;
                    default:
                        return 0.65F;
                }
            }
        }

        return scaleFactor;
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