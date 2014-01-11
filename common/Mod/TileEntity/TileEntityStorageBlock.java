package Mod.TileEntity;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class TileEntityStorageBlock extends TileEntityInvBase{

	int Lines;
	
	public TileEntityStorageBlock() {
		super(6000, "Storage Block", 128);
	}
	
    @Override
   	public void writeToNBT(NBTTagCompound compound){
   		super.writeToNBT(compound);

   		compound.setInteger("Lines", Lines);
   		
   		
   		
   	}
   	
   	@Override
   	public void readFromNBT(NBTTagCompound compound){
   		super.readFromNBT(compound);
   	
   		Lines = compound.getInteger("Lines");
   		
   		
   	}

}
