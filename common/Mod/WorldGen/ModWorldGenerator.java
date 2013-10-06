package Mod.WorldGen;

import java.util.Random;

import Mod.Block.ModBlocks;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;

public class ModWorldGenerator extends WorldGenerator implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.dimensionId){
        case -1:
            generateNether(world, random, chunkX * 16, chunkZ * 16);
            break;
        case 0:
            generateSurface(world, random, chunkX * 16, chunkZ * 16);
            break;
        case 1:
            generateEnd(world, random, chunkX * 16, chunkZ * 16);
            break;
        }
    }

	@Override
	public boolean generate(World world, Random random, int i, int j, int k) {
		return false;
	}
	
    private void generateSurface(World world, Random random, int ChunkX, int ChunkZ) {

    	
    	for(int i = 0; i < 3; i++){
    		if(world.getBiomeGenForCoords(ChunkX, ChunkZ) == BiomeGenBase.plains){
    		
    		int Xcoord1 = ChunkX + random.nextInt(16);
    		int Ycoord1 = random.nextInt(90);
    		int Zcoord1 = ChunkZ + random.nextInt(16);
    		
    		(new WorldGenOrangeTree(false, 6, 0, 0, false)).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
    	}
    	}
    	
            int firstChunkXCoord = ChunkX + random.nextInt(16);
            int firstBlockYCoord = random.nextInt(24);
            int firstChunkZCoord = ChunkX + random.nextInt(16);

            (new ModSilverWorldGen()).generate(world, random, firstChunkXCoord, firstBlockYCoord, firstChunkZCoord);
        
    			
    		}
    
    
    private void generateNether(World world, Random rand, int chunkX, int chunkZ) {}
    private void generateEnd(World world, Random rand, int chunkX, int chunkZ) {}
}
