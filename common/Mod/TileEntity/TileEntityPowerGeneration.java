package Mod.TileEntity;

import net.minecraft.world.World;

public abstract class TileEntityPowerGeneration extends TileEntityPowerInv{

	public TileEntityPowerGeneration(int Slots, String Name, int Size, int PowerMax) {
		super(Slots, Name, Size, PowerMax);
	}
	
	public abstract boolean CanWork(World world, int X, int Y, int Z);
	public abstract int WorkTime();
	
    public void OnWork(World world, int x, int y, int z){}

}
