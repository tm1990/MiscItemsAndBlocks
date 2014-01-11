package Mod.Gui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import Mod.Container.ContainerStorageBlock;
import Mod.TileEntity.TileEntityStorageBlock;

public class GuiStorageBlock extends GuiContainer{

	private final ResourceLocation Texture = new ResourceLocation("miscitems" , "textures/gui/StorageBlockGui.png");
	
	
	public GuiStorageBlock(InventoryPlayer InvPlayer, TileEntityStorageBlock tile) {
		super(new ContainerStorageBlock(InvPlayer, tile));
		this.xSize = 176;
		this.ySize = 235;
		
		 Items = new ArrayList<ItemStack>();
		 
     
	}
	
	
    public ArrayList<ItemStack> Items;
	
	int Lines = 10;
	boolean Scrolling;
    public int invSlots = 12;
	float ScrollProg;
	
  @Override
  protected void drawGuiContainerForegroundLayer(int param1, int param2) {

         // fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
          
       
          
          
  }

  
  public void drawScreen(int par1, int par2, float par3)
  {

	  
      drawDefaultBackground();
      
      
      if(mc == null)
      {
              mc = Minecraft.getMinecraft();
              fontRenderer = mc.fontRenderer;
      }
      
      
      boolean flag = Mouse.isButtonDown(0);
      if(!flag)
      {

              Scrolling = false;
      }
      else if(Scrolling)
      {
              ScrollProg = MathHelper.clamp_float((float)((guiTop + 95 + 7) - par2) / 82F, 0.0F, -1.55F);
      }
      
      
      super.drawScreen(par1, par2, par3);
	    mc.renderEngine.bindTexture(Texture);
      
	  
	     if(Lines < 9){
     	 drawTexturedModalRect(guiLeft + 157, guiTop + 6, 192, 27, 12, 15);
     	 
     	 
     	 
      }else{
     	 
          GL11.glPopMatrix();
          GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                  GL11.glPushMatrix();
          	    mc.renderEngine.bindTexture(Texture);
                  GL11.glTranslatef(0.0F, -82F * ScrollProg, 0.0F);
                  
     	 drawTexturedModalRect(guiLeft + 157, guiTop + 6, 180, 27, 12, 15);
     	 
     	 
     	 

          
      }

	     
	     drawInv();
	     

	    
  }
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int X, int Y)
	{
	    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);

	    Minecraft.getMinecraft().renderEngine.bindTexture(Texture);
	         drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

	    

	}
	
	
	 protected void mouseClicked(int x, int y, int par3)
	  {
	      super.mouseClicked(x, y, par3);
	  

	      boolean isOnScroll = x >= guiLeft + 157 && x < guiLeft + 157 + 12 && y >= guiTop + 6 && y < guiTop + 147 + 15;
	      if(isOnScroll)
	      {
	              Scrolling = true;
	      }
	      

	  }

	 public void drawInv()
	  {
		  
	          
	      GL11.glEnable(GL11.GL_STENCIL_TEST);
	      GL11.glColorMask(false, false, false, false);

	      GL11.glStencilFunc(GL11.GL_ALWAYS, 1, 0xFF);
	      GL11.glStencilOp(GL11.GL_KEEP, GL11.GL_KEEP, GL11.GL_REPLACE); // draw 1s on test fail (always)
	      GL11.glStencilMask(0xFF);
	      GL11.glClear(GL11.GL_STENCIL_BUFFER_BIT);

	          drawSolidRect(guiLeft + 7, guiTop + 5, 144, 144, 0xffffff, 1.0F);
	          
	              GL11.glStencilMask(0x00);
	              GL11.glStencilFunc(GL11.GL_EQUAL, 1, 0xFF);

	      GL11.glColorMask(true, true, true, true);
	          
	              GL11.glPushMatrix();
	      
	          
	          

	          GL11.glPopMatrix();
	          GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	                  GL11.glPushMatrix();
	          	    mc.renderEngine.bindTexture(Texture);

	          	    
	                        GL11.glTranslatef(0.0F, -(Lines - 8) * 0.0F * (-1.55F - ScrollProg), 0.0F);
	                
	                
	          for(int i = 0; i < Lines; i++){
	        	  
	          	 drawTexturedModalRect(guiLeft + 7, guiTop + 5 + (i * 18), 7, 152, 144, 18);
	        	  
	          }
	          
	          
	      GL11.glDisable(GL11.GL_STENCIL_TEST);
	          
	          GL11.glPopMatrix();
	          GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	  }
	 
	  public void drawSolidRect(int par0, int par1, int par2, int par3, int par4, float alpha)
	  {
		  float f1 = (float)(par4 >> 16 & 255) / 255.0F;
		  float f2 = (float)(par4 >> 8 & 255) / 255.0F;
		  float f3 = (float)(par4 & 255) / 255.0F;
		  Tessellator tessellator = Tessellator.instance;
		  GL11.glDisable(GL11.GL_TEXTURE_2D);
		  GL11.glColor4f(f1, f2, f3, alpha);
		  tessellator.startDrawingQuads();
		  tessellator.addVertex((double)(par0 + 0), (double)(par1 + par3), (double)this.zLevel);
		  tessellator.addVertex((double)(par0 + par2), (double)(par1 + par3), (double)this.zLevel);
		  tessellator.addVertex((double)(par0 + par2), (double)(par1 + 0), (double)this.zLevel);
		  tessellator.addVertex((double)(par0 + 0), (double)(par1 + 0), (double)this.zLevel);
		  tessellator.draw();
		  GL11.glEnable(GL11.GL_TEXTURE_2D);
	  }
	  
	   public void drawItemStack(ItemStack itemstack, int par2, int par3)
	    {
	        if (itemstack != null)
	        {
	                GL11.glTranslatef(0.0F, 0.0F, 50.0F);

	         GL11.glEnable(GL12.GL_RESCALE_NORMAL);
	         RenderHelper.enableGUIStandardItemLighting();
	            itemRenderer.renderItemAndEffectIntoGUI(this.mc.fontRenderer, this.mc.getTextureManager(), itemstack, par2, par3);
	            itemRenderer.renderItemOverlayIntoGUI(this.mc.fontRenderer, this.mc.getTextureManager(), itemstack, par2, par3);
	         RenderHelper.disableStandardItemLighting();
	         GL11.glDisable(GL12.GL_RESCALE_NORMAL);

	                GL11.glTranslatef(0.0F, 0.0F, -50.0F);
	        }
	    }
	  

	  protected void drawTooltip(List par1List, int par2, int par3)
	    {
	        if (!par1List.isEmpty())
	        {
	            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
	            GL11.glDisable(GL11.GL_DEPTH_TEST);
	            int k = 0;
	            Iterator iterator = par1List.iterator();

	            while (iterator.hasNext())
	            {
	                String s = (String)iterator.next();
	                int l = this.fontRenderer.getStringWidth(s);

	                if (l > k)
	                {
	                    k = l;
	                }
	            }

	            int i1 = par2 + 12;
	            int j1 = par3 - 12;
	            int k1 = 8;

	            if (par1List.size() > 1)
	            {
	                k1 += 2 + (par1List.size() - 1) * 10;
	            }

	            if (i1 + k > this.width)
	            {
	                i1 -= 28 + k;
	            }

	            if (j1 + k1 + 6 > this.height)
	            {
	                j1 = this.height - k1 - 6;
	            }

	            this.zLevel = 300.0F;
	            int l1 = -267386864;
	            this.drawGradientRect(i1 - 3, j1 - 4, i1 + k + 3, j1 - 3, l1, l1);
	            this.drawGradientRect(i1 - 3, j1 + k1 + 3, i1 + k + 3, j1 + k1 + 4, l1, l1);
	            this.drawGradientRect(i1 - 3, j1 - 3, i1 + k + 3, j1 + k1 + 3, l1, l1);
	            this.drawGradientRect(i1 - 4, j1 - 3, i1 - 3, j1 + k1 + 3, l1, l1);
	            this.drawGradientRect(i1 + k + 3, j1 - 3, i1 + k + 4, j1 + k1 + 3, l1, l1);
	            int i2 = 1347420415;
	            int j2 = (i2 & 16711422) >> 1 | i2 & -16777216;
	            this.drawGradientRect(i1 - 3, j1 - 3 + 1, i1 - 3 + 1, j1 + k1 + 3 - 1, i2, j2);
	            this.drawGradientRect(i1 + k + 2, j1 - 3 + 1, i1 + k + 3, j1 + k1 + 3 - 1, i2, j2);
	            this.drawGradientRect(i1 - 3, j1 - 3, i1 + k + 3, j1 - 3 + 1, i2, i2);
	            this.drawGradientRect(i1 - 3, j1 + k1 + 2, i1 + k + 3, j1 + k1 + 3, j2, j2);

	            for (int k2 = 0; k2 < par1List.size(); ++k2)
	            {
	                String s1 = (String)par1List.get(k2);
	                this.fontRenderer.drawStringWithShadow(s1, i1, j1, -1);

	                if (k2 == 0)
	                {
	                    j1 += 2;
	                }

	                j1 += 10;
	            }

	            this.zLevel = 0.0F;
	            GL11.glEnable(GL11.GL_DEPTH_TEST);
	            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
	        }
	    }
	
}
