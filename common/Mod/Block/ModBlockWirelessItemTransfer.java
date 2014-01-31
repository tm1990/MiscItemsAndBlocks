package Mod.Block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import Mod.TileEntity.TileEntityWirelessItemTrans;

public class ModBlockWirelessItemTransfer extends BlockContainer{

	protected ModBlockWirelessItemTransfer(int par1) {
		super(par1, Material.iron);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityWirelessItemTrans();
	}

}
