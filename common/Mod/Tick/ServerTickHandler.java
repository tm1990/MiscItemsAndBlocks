package Mod.Tick;

import java.util.EnumSet;
import java.util.Random;

import Mod.Items.ModItems;


import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ServerTickHandler implements ITickHandler{
	
	
	/*
	 * Helmet = 3
	 * ChestPlate = 2
	 * Leggings = 1
	 * Boots = 0
	 * 
	 */
	
	
	boolean Helmet = false;
	boolean ChestPlate = false;
	boolean Leggings = false;
	boolean Boots = false;

	int TickCountParticle = 0;
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		 if (type.equals(EnumSet.of(TickType.PLAYER)))
		  {
		    onPlayerTick((EntityPlayer)tickData[0]);
		  }
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.PLAYER, TickType.SERVER);
	}

	@Override
	public String getLabel() {
		return null;
	}
	
	private void onPlayerTick(EntityPlayer player) {
		
		if(player.capabilities.isCreativeMode == false){
			
			Flight(player);
			Diving(player);
			Speed(player);
			Jump(player);
			Full(player);
			
			
			
			}
			
			
		}
	
	
	public void Diving(EntityPlayer player){
		
		if(player.inventory.armorInventory[3] == null || player.inventory.armorInventory[3].itemID != ModItems.DivingHelmet.itemID){
			Helmet = false;
		}else if(player.inventory.armorInventory[3].itemID == ModItems.DivingHelmet.itemID){
             Helmet = true;
			if(player.isInWater()){
				
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 2, 10));
				player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 2, 10));
				
			}
			
		}
		
		
	}
	
	
	
	
	
	
	
	public void Flight(EntityPlayer player){
		if(player.inventory.armorInventory[2] == null || player.inventory.armorInventory[2].itemID != ModItems.FlightChestPlate.itemID){
			
			ChestPlate = false;
			player.capabilities.allowFlying = false;
		}else if(player.inventory.armorInventory[2].itemID == ModItems.FlightChestPlate.itemID){
			
			ChestPlate = true;
			player.capabilities.allowFlying = true;
			
			if(player.onGround == false && player.isInWater() == false && player.capabilities.allowFlying && player.isAirBorne){
				Random rand = new Random();
				if(TickCountParticle == 5){
			player.worldObj.spawnParticle("cloud", player.posX, player.posY + 0.6, player.posZ, rand.nextFloat() - 0.5, rand.nextFloat() - 0.2, rand.nextFloat() - 0.5);
			TickCountParticle = 0;
				}else{
					
					TickCountParticle++;
				}

			}
		}
		if(player.inventory.armorInventory[2] == null || player.inventory.armorInventory[2].itemID != ModItems.FlightChestPlate.itemID){
			
			
			if(player.onGround == false){
			
				
				if(player.capabilities.isFlying){
					player.capabilities.isFlying = false;
					
				}

			}
		}
		
	}
	
	
	public void Speed(EntityPlayer player){
		
		
		if(player.inventory.armorInventory[1] == null || player.inventory.armorInventory[1].itemID != ModItems.RunningLeggings.itemID){
			Leggings = false;
		}else if(player.inventory.armorInventory[1].itemID == ModItems.RunningLeggings.itemID){
			Leggings = true;
			if(player.onGround && player.isInWater() == false){
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10, 10));
			}
			
		}
	}
	
	
	public void Jump(EntityPlayer player){
		if(player.inventory.armorInventory[0] == null || player.inventory.armorInventory[0].itemID != ModItems.JumpingBoots.itemID){
			Boots = false;
		}else if(player.inventory.armorInventory[0].itemID == ModItems.JumpingBoots.itemID && player.isSneaking() == false){
			Boots = true;
			
			if(player.onGround && player.isInWater() == false && player.isSneaking() == false){
				player.addPotionEffect(new PotionEffect(Potion.jump.id, 10, 3));
			}
		
	}

	}
	
	
	public void Full(EntityPlayer player){
		

		if(Helmet && ChestPlate && Leggings && Boots){
			
						
						if(player.shouldHeal()){
							
							player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 10, 0));
							player.addPotionEffect(new PotionEffect(Potion.resistance.id, 10, 2));
							player.addPotionEffect(new PotionEffect(Potion.field_76443_y.id, 10, 1));
							
						}
						
						
					}
		
					
				}
				
		
	}
	



