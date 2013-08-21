package Mod.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import Mod.Lib.Refrence;
import Mod.Main.Main;
import Mod.Misc.MiscDamage;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModItemSilverSword extends ItemSword {

	private int Kills;
	private EntityLivingBase LastKilled = new EntityCow(null);
	
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
    	
    	
    	if(EntityHit.getEntityName() != "EnderDragon" || EntityHit.getEntityName() != "Witer"){
    		
    		EntityHit.attackEntityFrom(new MiscDamage("Silver Sword", "Was Slain With Silver Sword by " + EntityAttacker.getTranslatedEntityName()), 80F);
    		
    		itemstack.damageItem(2, EntityAttacker);
    		
    			
    		
    		System.out.println(EntityHit);
    			Kills = Kills + 1;
    			LastKilled = EntityHit;
    	
    	}
    	
    	
		return false;
    	
    }
    
    
    @Override
    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
    {
    	
    	
    	int x = Kills / 2;
    	
            list.add("Idea by ErnieFlapps");
            list.add("One-hit killes mobs");
            list.add("Killes : " + x);
            list.add("Last Killed : " + LastKilled.getTranslatedEntityName());
    }
    
    
}