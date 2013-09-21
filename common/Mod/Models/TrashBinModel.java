package Mod.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;




public class TrashBinModel extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
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
    ModelRenderer Shape18;
    ModelRenderer Shape19;
    ModelRenderer Shape20;
    ModelRenderer Shape21;
    ModelRenderer Shape22;
    ModelRenderer Shape23;
    ModelRenderer Shape24;
  
  public TrashBinModel()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 0, 23);
      Shape1.addBox(0F, 0F, 0F, 8, 1, 8);
      Shape1.setRotationPoint(-4F, 23F, -4F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 0);
      Shape2.addBox(0F, 0F, 0F, 1, 9, 8);
      Shape2.setRotationPoint(-5F, 14F, -4F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 0);
      Shape3.addBox(0F, 0F, 0F, 8, 9, 1);
      Shape3.setRotationPoint(-4F, 14F, -5F);
      Shape3.setTextureSize(64, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 0, 0);
      Shape4.addBox(0F, 0F, 0F, 8, 9, 1);
      Shape4.setRotationPoint(-4F, 14F, 4F);
      Shape4.setTextureSize(64, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 0, 0);
      Shape5.addBox(0F, 0F, 0F, 1, 9, 8);
      Shape5.setRotationPoint(4F, 14F, -4F);
      Shape5.setTextureSize(64, 32);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 0, 19);
      Shape6.addBox(0F, 0F, 0F, 8, 1, 8);
      Shape6.setRotationPoint(-4F, 13F, -4F);
      Shape6.setTextureSize(64, 32);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 0, 23);
      Shape7.addBox(0F, 0F, 0F, 2, 1, 8);
      Shape7.setRotationPoint(4F, 13F, -4F);
      Shape7.setTextureSize(64, 32);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 0, 29);
      Shape8.addBox(0F, 0F, 0F, 8, 1, 2);
      Shape8.setRotationPoint(-4F, 13F, -6F);
      Shape8.setTextureSize(64, 32);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 0, 29);
      Shape9.addBox(0F, 0F, 0F, 8, 1, 2);
      Shape9.setRotationPoint(-4F, 13F, 4F);
      Shape9.setTextureSize(64, 32);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
      Shape10 = new ModelRenderer(this, 0, 23);
      Shape10.addBox(0F, 0F, 0F, 2, 1, 8);
      Shape10.setRotationPoint(-6F, 13F, -4F);
      Shape10.setTextureSize(64, 32);
      Shape10.mirror = true;
      setRotation(Shape10, 0F, 0F, 0F);
      Shape11 = new ModelRenderer(this, 0, 30);
      Shape11.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape11.setRotationPoint(-5F, 13F, -5F);
      Shape11.setTextureSize(64, 32);
      Shape11.mirror = true;
      setRotation(Shape11, 0F, 0F, 0F);
      Shape12 = new ModelRenderer(this, 0, 30);
      Shape12.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape12.setRotationPoint(4F, 13F, -5F);
      Shape12.setTextureSize(64, 32);
      Shape12.mirror = true;
      setRotation(Shape12, 0F, 0F, 0F);
      Shape13 = new ModelRenderer(this, 0, 30);
      Shape13.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape13.setRotationPoint(4F, 13F, 4F);
      Shape13.setTextureSize(64, 32);
      Shape13.mirror = true;
      setRotation(Shape13, 0F, 0F, 0F);
      Shape14 = new ModelRenderer(this, 0, 30);
      Shape14.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape14.setRotationPoint(-5F, 13F, 4F);
      Shape14.setTextureSize(64, 32);
      Shape14.mirror = true;
      setRotation(Shape14, 0F, 0F, 0F);
      Shape15 = new ModelRenderer(this, 0, 27);
      Shape15.addBox(0F, 0F, 0F, 4, 1, 4);
      Shape15.setRotationPoint(-2F, 12F, -2F);
      Shape15.setTextureSize(64, 32);
      Shape15.mirror = true;
      setRotation(Shape15, 0F, 0F, 0F);
      Shape16 = new ModelRenderer(this, 0, 29);
      Shape16.addBox(0F, 0F, 0F, 4, 1, 2);
      Shape16.setRotationPoint(-2F, 12F, 2F);
      Shape16.setTextureSize(64, 32);
      Shape16.mirror = true;
      setRotation(Shape16, 0F, 0F, 0F);
      Shape17 = new ModelRenderer(this, 0, 27);
      Shape17.addBox(0F, 0F, 0F, 2, 1, 4);
      Shape17.setRotationPoint(2F, 12F, -2F);
      Shape17.setTextureSize(64, 32);
      Shape17.mirror = true;
      setRotation(Shape17, 0F, 0F, 0F);
      Shape18 = new ModelRenderer(this, 0, 27);
      Shape18.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape18.setRotationPoint(2F, 12F, 2F);
      Shape18.setTextureSize(64, 32);
      Shape18.mirror = true;
      setRotation(Shape18, 0F, 0F, 0F);
      Shape19 = new ModelRenderer(this, 0, 27);
      Shape19.addBox(0F, 0F, 0F, 4, 1, 2);
      Shape19.setRotationPoint(-2F, 12F, -4F);
      Shape19.setTextureSize(64, 32);
      Shape19.mirror = true;
      setRotation(Shape19, 0F, 0F, 0F);
      Shape20 = new ModelRenderer(this, 0, 27);
      Shape20.addBox(0F, 0F, 0F, 2, 1, 4);
      Shape20.setRotationPoint(-4F, 12F, -2F);
      Shape20.setTextureSize(64, 32);
      Shape20.mirror = true;
      setRotation(Shape20, 0F, 0F, 0F);
      Shape21 = new ModelRenderer(this, 0, 27);
      Shape21.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape21.setRotationPoint(2F, 12F, -3F);
      Shape21.setTextureSize(64, 32);
      Shape21.mirror = true;
      setRotation(Shape21, 0F, 0F, 0F);
      Shape22 = new ModelRenderer(this, 0, 27);
      Shape22.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape22.setRotationPoint(-3F, 12F, 2F);
      Shape22.setTextureSize(64, 32);
      Shape22.mirror = true;
      setRotation(Shape22, 0F, 0F, 0F);
      Shape23 = new ModelRenderer(this, 0, 27);
      Shape23.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape23.setRotationPoint(-3F, 12F, -3F);
      Shape23.setTextureSize(64, 32);
      Shape23.mirror = true;
      setRotation(Shape23, 0F, 0F, 0F);
      Shape24 = new ModelRenderer(this, 58, 29);
      Shape24.addBox(0F, 0F, 0F, 1, 1, 2);
      Shape24.setRotationPoint(-0.5F, 11F, -1F);
      Shape24.setTextureSize(64, 32);
      Shape24.mirror = true;
      setRotation(Shape24, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
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
    Shape18.render(f5);
    Shape19.render(f5);
    Shape20.render(f5);
    Shape21.render(f5);
    Shape22.render(f5);
    Shape23.render(f5);
    Shape24.render(f5);
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
