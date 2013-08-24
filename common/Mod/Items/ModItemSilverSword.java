package Mod.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import Mod.Lib.Refrence;
import Mod.Main.Main;
import Mod.Misc.MiscDamage;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModItemSilverSword extends ItemSword {
	
	
    public ModItemSilverSword(int i, EnumToolMaterial enumToolMaterial){
        super(i, enumToolMaterial);
        setCreativeTab(Main.CreativeTab);
    }
      
    
 
    

    @Override
        @SideOnly(Side.CLIENT)
        public void registerIcons(IconRegister par1IconRegister)
        {
            this.itemIcon = par1IconRegister.registerIcon(Refrence.Mod_Id + ":" + "SilverSword");
        }
    
    
    public boolean hitEntity(ItemStack itemstack, EntityLivingBase EntityHit, EntityLivingBase EntityAttacker)
    {
    	
    	
    	if(EntityHit instanceof EntityDragon || EntityHit instanceof EntityWither || EntityHit instanceof EntityPlayer){
    	}else{
    		
    		EntityHit.attackEntityFrom(new MiscDamage("Silver Sword", "Was Slain With Silver Sword by " + EntityAttacker.getTranslatedEntityName()), 80F);
    		EntityHit.attackEntityAsMob(EntityAttacker);
    		
    		itemstack.damageItem(2, EntityAttacker);
    	
    	}
    	
    	
		return false;
    	
    }
    
    
    @Override
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
    {
    	
            list.add("Idea by ErnieFlapps");
            list.add("");
            list.add("One-hit killes mobs");

    }
    
    
    
}