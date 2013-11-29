package Mod.TileEntity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityWindMill extends TileEntityPowerGeneration{

	public TileEntityWindMill() {
		super(0, "Wind", 0, 0);
	}

	@Override
	public boolean CanWork(World world, int X, int Y, int Z) {
		return Y > 80;
	}


	@Override
	public int WorkTime() {
		return 8;
	}

}
