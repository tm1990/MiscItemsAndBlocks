package MiscItemsApi.Recipes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGlassBottle;
import net.minecraft.item.ItemStack;

public class SqueezerRecipes
{
    private static final SqueezerRecipes instance = new SqueezerRecipes();

    private HashMap<List<Integer>, ItemStack> Recipes = new HashMap<List<Integer>, ItemStack>();
    public static final SqueezerRecipes instance()
    {
        return instance;
    }

  
    /**
     * Registers a recipes for the squeezer (the main item will always be a glass bottle)
     * 
     * @param Input_1 input item number 1
     * @param Input_2 input item number 2
     * @param Output the recipes output
     */
    public void AddRecipe(ItemStack Input, ItemStack Output)
    {

    	Recipes.put(Arrays.asList(Input.itemID, Input.getItemDamage()), Output);
    	
    	
    }



    /**
     * Gets the result for a recipe in the squeezer
     * 
     * @param item_1 input item number 1
     * @param item_2 input item number 2
     * @return the result (null if nothing)
     */
    public ItemStack GetResult(ItemStack item_1, ItemStack item_2) 
    {

    	
    	if(item_1 == null || item_2 == null)
    	{
    		return null;
    	}
    	
    
    
    	if(item_1.getItem() instanceof ItemGlassBottle){
    		ItemStack result = (ItemStack)Recipes.get(Arrays.asList(item_2.itemID, item_2.getItemDamage()));
    		
    		return result;
    		
    	}
    	
    	
    	
    
    	return null;
    }


  

}
