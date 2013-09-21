package Mod.PillarModels;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class SidewaysPillarTwo extends ModelBase
{
  //fields
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape13;
    ModelRenderer Shape14;
    ModelRenderer Shape15;
    ModelRenderer Shape16;
    ModelRenderer Shape17;
    ModelRenderer Shape22;
    ModelRenderer Shape23;
    ModelRenderer Shape24;
    ModelRenderer Shape25;
  
  public SidewaysPillarTwo()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Shape7 = new ModelRenderer(this, 0, 0);
      Shape7.addBox(0F, 0F, 0F, 6, 12, 1);
      Shape7.setRotationPoint(-3F, 12F, -8F);
      Shape7.setTextureSize(64, 32);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 0, 0);
      Shape8.addBox(0F, 0F, 0F, 12, 6, 1);
      Shape8.setRotationPoint(-6F, 15F, -8F);
      Shape8.setTextureSize(64, 32);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 0, 0);
      Shape9.addBox(0F, 0F, 0F, 2, 2, 1);
      Shape9.setRotationPoint(-5F, 13F, -8F);
      Shape9.setTextureSize(64, 32);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
      Shape10 = new ModelRenderer(this, 0, 0);
      Shape10.addBox(0F, 0F, 0F, 2, 2, 1);
      Shape10.setRotationPoint(3F, 13F, -8F);
      Shape10.setTextureSize(64, 32);
      Shape10.mirror = true;
      setRotation(Shape10, 0F, 0F, 0F);
      Shape11 = new ModelRenderer(this, 0, 0);
      Shape11.addBox(0F, 0F, 0F, 2, 2, 1);
      Shape11.setRotationPoint(-5F, 21F, -8F);
      Shape11.setTextureSize(64, 32);
      Shape11.mirror = true;
      setRotation(Shape11, 0F, 0F, 0F);
      Shape12 = new ModelRenderer(this, 0, 0);
      Shape12.addBox(0F, 0F, 0F, 2, 2, 1);
      Shape12.setRotationPoint(3F, 21F, -8F);
      Shape12.setTextureSize(64, 32);
      Shape12.mirror = true;
      setRotation(Shape12, 0F, 0F, 0F);
      Shape13 = new ModelRenderer(this, 0, 0);
      Shape13.addBox(0F, 0F, 0F, 6, 6, 16);
      Shape13.setRotationPoint(-3F, 15F, -8F);
      Shape13.setTextureSize(64, 32);
      Shape13.mirror = true;
      setRotation(Shape13, 0F, 0F, 0F);
      Shape14 = new ModelRenderer(this, 0, 0);
      Shape14.addBox(0F, 0F, 0F, 8, 2, 1);
      Shape14.setRotationPoint(-4F, 13F, -7F);
      Shape14.setTextureSize(64, 32);
      Shape14.mirror = true;
      setRotation(Shape14, 0F, 0F, 0F);
      Shape15 = new ModelRenderer(this, 0, 0);
      Shape15.addBox(0F, 0F, 0F, 2, 8, 1);
      Shape15.setRotationPoint(-5F, 14F, -7F);
      Shape15.setTextureSize(64, 32);
      Shape15.mirror = true;
      setRotation(Shape15, 0F, 0F, 0F);
      Shape16 = new ModelRenderer(this, 0, 0);
      Shape16.addBox(0F, 0F, 0F, 8, 2, 1);
      Shape16.setRotationPoint(-4F, 21F, -7F);
      Shape16.setTextureSize(64, 32);
      Shape16.mirror = true;
      setRotation(Shape16, 0F, 0F, 0F);
      Shape17 = new ModelRenderer(this, 0, 0);
      Shape17.addBox(0F, 0F, 0F, 2, 8, 1);
      Shape17.setRotationPoint(3F, 14F, -7F);
      Shape17.setTextureSize(64, 32);
      Shape17.mirror = true;
      setRotation(Shape17, 0F, 0F, 0F);
      Shape22 = new ModelRenderer(this, 0, 0);
      Shape22.addBox(0F, 0F, 0F, 4, 1, 15);
      Shape22.setRotationPoint(-2F, 14F, -7F);
      Shape22.setTextureSize(64, 32);
      Shape22.mirror = true;
      setRotation(Shape22, 0F, 0F, 0F);
      Shape23 = new ModelRenderer(this, 0, 0);
      Shape23.addBox(0F, 0F, 0F, 1, 4, 15);
      Shape23.setRotationPoint(-4F, 16F, -7F);
      Shape23.setTextureSize(64, 32);
      Shape23.mirror = true;
      setRotation(Shape23, 0F, 0F, 0F);
      Shape24 = new ModelRenderer(this, 0, 0);
      Shape24.addBox(0F, 0F, 0F, 4, 1, 15);
      Shape24.setRotationPoint(-2F, 21F, -7F);
      Shape24.setTextureSize(64, 32);
      Shape24.mirror = true;
      setRotation(Shape24, 0F, 0F, 0F);
      Shape25 = new ModelRenderer(this, 0, 0);
      Shape25.addBox(0F, 0F, 0F, 1, 4, 15);
      Shape25.setRotationPoint(3F, 16F, -7F);
      Shape25.setTextureSize(64, 32);
      Shape25.mirror = true;
      setRotation(Shape25, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape7.render(f5);
    Shape8.render(f5);
    Shape9.render(f5);
    Shape10.render(f5);
    Shape11.render(f5);
    Shape12.render(f5);
    Shape13.render(f5);
    Shape14.render(f5);
    Shape15.render(f5);
    Shape16.render(f5);
    Shape17.render(f5);
    Shape22.render(f5);
    Shape23.render(f5);
    Shape24.render(f5);
    Shape25.render(f5);
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
