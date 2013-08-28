package Mod.nei;

import net.minecraft.client.gui.inventory.GuiContainer;
import Mod.Gui.GuiCraftingInv;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import codechicken.nei.api.IOverlayHandler;
import codechicken.nei.recipe.DefaultOverlayHandler;
import codechicken.nei.recipe.IRecipeHandler;

public class NeiCraftingInvConfig implements IConfigureNEI, IOverlayHandler {
@Override
public void loadConfig() {
API.registerGuiOverlay(GuiCraftingInv.class, "crafting", 5, 11);
        API.registerGuiOverlayHandler(GuiCraftingInv.class, new DefaultOverlayHandler(5, 11), "crafting");
        //If NEI is active, we need to change the method called in ProjectBenchGui!
        GuiCraftingInv.setIsNEIActive(true);
}

@Override
public String getName() {
return "MiscItemsAndBlocks_plugin";
}

@Override
public String getVersion() {
return "1.0";
}

@Override
public void overlayRecipe(GuiContainer firstGui, IRecipeHandler recipe,
int recipeIndex, boolean shift) {
System.out.println("asdf");

}
}