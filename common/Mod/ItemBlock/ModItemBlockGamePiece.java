package Mod.ItemBlock;

import net.minecraft.block.BlockColored;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;

public class ModItemBlockGamePiece extends ItemBlock{

	public ModItemBlockGamePiece(int par1) {
		super(par1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
	}

	
    public int getMetadata(int par1)
    {
        return par1;
    }
    
    public String getUnlocalizedName(ItemStack stack)
    {
    	int meta = stack.getItemDamage();
    	
//    	if(meta == 0)
//    		return "Blank Game Piece";
//    	
//    	else if(meta == 1)
//    		return "Red Game Piece";
//    	
//    	else if (meta == 2)
//    		return "Blue Game Piece";
//    	
//    	else if (meta == 3)
//    		return "Green Game Piece";
//    	
//    	else if (meta == 4)
//    		return "Yellow Game Piece";
    	

    	
    	return "item.GamePart.Number." + meta;
    }
}
