package Mod.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class PieceModelMiddle extends ModelBase
{
  //fields
    ModelRenderer Shape7;
    ModelRenderer Shape20;
    ModelRenderer Shape21;
    ModelRenderer Shape22;
    ModelRenderer Shape23;
  
  public PieceModelMiddle()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Shape7 = new ModelRenderer(this, 0, 0);
      Shape7.addBox(0F, 0F, 0F, 6, 16, 6);
      Shape7.setRotationPoint(-3F, 8F, -3F);
      Shape7.setTextureSize(64, 32);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape20 = new ModelRenderer(this, 0, 0);
      Shape20.addBox(0F, 0F, 0F, 4, 16, 1);
      Shape20.setRotationPoint(-2F, 8F, 3F);
      Shape20.setTextureSize(64, 32);
      Shape20.mirror = true;
      setRotation(Shape20, 0F, 0F, 0F);
      Shape21 = new ModelRenderer(this, 0, 0);
      Shape21.addBox(0F, 0F, 0F, 1, 16, 4);
      Shape21.setRotationPoint(3F, 8F, -2F);
      Shape21.setTextureSize(64, 32);
      Shape21.mirror = true;
      setRotation(Shape21, 0F, 0F, 0F);
      Shape22 = new ModelRenderer(this, 0, 0);
      Shape22.addBox(0F, 0F, 0F, 4, 16, 1);
      Shape22.setRotationPoint(-2F, 8F, -4F);
      Shape22.setTextureSize(64, 32);
      Shape22.mirror = true;
      setRotation(Shape22, 0F, 0F, 0F);
      Shape23 = new ModelRenderer(this, 0, 0);
      Shape23.addBox(0F, 0F, 0F, 1, 16, 4);
      Shape23.setRotationPoint(-4F, 8F, -2F);
      Shape23.setTextureSize(64, 32);
      Shape23.mirror = true;
      setRotation(Shape23, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape7.render(f5);
    Shape20.render(f5);
    Shape21.render(f5);
    Shape22.render(f5);
    Shape23.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
