package Mod.WorldGen;

import java.util.Random;

import Mod.Block.ModBlocks;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;

public class ModSilverWorldGen extends WorldGenerator {
	



	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		 for(int k = 0; k < 5; k++){
	            int firstBlockXCoord = x + random.nextInt(16);
	            int firstBlockYCoord = random.nextInt(24);
	            int firstBlockZCoord = z + random.nextInt(16);
	            
	            (new WorldGenMinable(ModBlocks.SilverOre.blockID, 5)).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
	        }
		return false;
	}

}