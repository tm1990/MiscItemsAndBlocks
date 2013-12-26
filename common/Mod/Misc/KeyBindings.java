package Mod.Misc;

import java.util.EnumSet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.src.ModLoader;

import org.lwjgl.input.Keyboard;

import Mod.Items.ModItemAntiFallChest;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class KeyBindings extends KeyHandler{
	
public static KeyBinding Flight = new KeyBinding("Flight key", Keyboard.KEY_F);



public static KeyBinding[] arrayOfKeys = new KeyBinding[] {Flight};

public static boolean[] areRepeating = new boolean[] {true};
public KeyBindings() {
  super(arrayOfKeys, areRepeating);
}
@Override
public String getLabel() {
  return "MiscItems KeyBindings";
}
@Override
public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
  if (tickEnd) {
	  if(kb.keyCode == Flight.keyCode){
		if (FMLClientHandler.instance().getClient().currentScreen == null) {
			EntityClientPlayerMP player = ModLoader.getMinecraftInstance().thePlayer;
			if(player.inventory.armorInventory[2] != null && player.inventory.armorInventory[2].getItem() instanceof ModItemAntiFallChest && player.inventory.armorInventory[2].getMaxDamage() - player.inventory.armorInventory[2].getItemDamage() > 0){
			
			player.fallDistance = 0;
			player.motionY = 0.6;
			
			}
			
		}
	  }
  }
}
@Override
public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {
}
@Override
public EnumSet<TickType> ticks() {
return EnumSet.of(TickType.CLIENT);
}
}