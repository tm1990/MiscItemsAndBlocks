package Mod.Misc;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;

public class MiscDamage extends DamageSource{

	private String DeathMessage;
	
	public MiscDamage(String DamageName, String DeathMessage) {
		super(DamageName);
		
		this.DeathMessage = DeathMessage;
		this.damageType = DamageName;
	}
	
    public ChatMessageComponent getDeathMessage(EntityLivingBase par1EntityLivingBase)
    {
        EntityLivingBase entitylivingbase1 = par1EntityLivingBase.func_94060_bK();
        
        String Message = par1EntityLivingBase.getTranslatedEntityName() + " " + DeathMessage;
        
        return entitylivingbase1 != null ? ChatMessageComponent.func_111082_b(Message, new Object[] {par1EntityLivingBase.getTranslatedEntityName(), entitylivingbase1.getTranslatedEntityName()}): ChatMessageComponent.func_111082_b(Message, new Object[] {par1EntityLivingBase.getTranslatedEntityName()});
    }

}
