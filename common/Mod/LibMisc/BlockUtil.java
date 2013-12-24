package Mod.LibMisc;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFluid;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet60Explosion;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidBlock;
import cpw.mods.fml.common.FMLCommonHandler;

public class BlockUtil {

    public static List<ItemStack> getItemStackFromBlock(World world, int i, int j, int k, int fortune) {
            Block block = Block.blocksList[world.getBlockId(i, j, k)];

            if (block == null)
                    return null;

            if (block.isAirBlock(world, i, j, k))
                    return null;

            int meta = world.getBlockMetadata(i, j, k);

            return block.getBlockDropped(world, i, j, k, meta, fortune);
    }

    public static void breakBlock(World world, int x, int y, int z) {
            breakBlock(world, x, y, z, 1200);
    }

    public static void breakBlock(World world, int x, int y, int z, int forcedLifespan) {
            if (!world.isAirBlock(x, y, z) && !world.isRemote && world.getGameRules().getGameRuleBooleanValue("doTileDrops")) {
                    int blockId = world.getBlockId(x, y, z);
                    List<ItemStack> items = Block.blocksList[blockId].getBlockDropped(world, x, y, z, world.getBlockMetadata(x, y, z), 0);

                    for (ItemStack item : items) {
                            float var = 0.7F;
                            double dx = world.rand.nextFloat() * var + (1.0F - var) * 0.5D;
                            double dy = world.rand.nextFloat() * var + (1.0F - var) * 0.5D;
                            double dz = world.rand.nextFloat() * var + (1.0F - var) * 0.5D;
                            EntityItem entityitem = new EntityItem(world, x + dx, y + dy, z + dz, item);

                            entityitem.lifespan = forcedLifespan;
                            entityitem.delayBeforeCanPickup = 10;

                            world.spawnEntityInWorld(entityitem);
                    }
            }

            world.setBlock(x, y, z, 0);
    }

    public static boolean canChangeBlock(World world, int x, int y, int z) {
            return canChangeBlock(world.getBlockId(x, y, z), world, x, y, z);
    }

    public static boolean isAnObstructingBlock(int blockID, World world, int x, int y, int z) {
            Block block = Block.blocksList[blockID];

            if (blockID == 0 || block == null || block.isAirBlock(world, x, y, z))
                    return false;
            return true;
    }

    public static boolean canChangeBlock(int blockID, World world, int x, int y, int z) {
            Block block = Block.blocksList[blockID];

            if (blockID == 0 || block == null || block.isAirBlock(world, x, y, z))
                    return true;

            if (block.getBlockHardness(world, x, y, z) < 0)
                    return false;


            if (blockID == Block.lavaStill.blockID || blockID == Block.lavaMoving.blockID)
                    return false;

            return true;
    }




    /**
     * Returns true if a block cannot be harvested without a tool.
     */
    public static boolean isToughBlock(World world, int x, int y, int z) {
            return !world.getBlockMaterial(x, y, z).isToolNotRequired();
    }

    public static boolean isFullFluidBlock(World world, int x, int y, int z) {
            return isFullFluidBlock(world.getBlockId(x, y, z), world, x, y, z);
    }

    public static boolean isFullFluidBlock(int blockId, World world, int x, int y, int z) {
            Block block = Block.blocksList[blockId];
            if (block instanceof BlockFluid || block instanceof IFluidBlock)
                    return world.getBlockMetadata(x, y, z) == 0;
            return false;
    }

    public static Fluid getFluid(int blockId) {
            Block block = Block.blocksList[blockId];
            if (block instanceof IFluidBlock) {
                    return ((IFluidBlock) block).getFluid();
            } else if (blockId == Block.waterStill.blockID || blockId == Block.waterMoving.blockID) {
                    return FluidRegistry.WATER;
            } else if (blockId == Block.lavaStill.blockID || blockId == Block.lavaMoving.blockID) {
                    return FluidRegistry.LAVA;
            }
            return null;
    }

    public static FluidStack drainBlock(World world, int x, int y, int z, boolean doDrain) {
            return drainBlock(world.getBlockId(x, y, z), world, x, y, z, doDrain);
    }

    public static FluidStack drainBlock(int blockId, World world, int x, int y, int z, boolean doDrain) {
            if (Block.blocksList[blockId] instanceof IFluidBlock) {
                    IFluidBlock fluidBlock = (IFluidBlock) Block.blocksList[blockId];
                    if (fluidBlock.canDrain(world, x, y, z))
                            return fluidBlock.drain(world, x, y, z, doDrain);
            } else if (blockId == Block.waterStill.blockID || blockId == Block.waterMoving.blockID) {
                    int meta = world.getBlockMetadata(x, y, z);
                    if (meta != 0)
                            return null;
                    if (doDrain)
                            world.setBlockToAir(x, y, z);
                    return new FluidStack(FluidRegistry.WATER, FluidContainerRegistry.BUCKET_VOLUME);
            } else if (blockId == Block.lavaStill.blockID || blockId == Block.lavaMoving.blockID) {
                    int meta = world.getBlockMetadata(x, y, z);
                    if (meta != 0)
                            return null;
                    if (doDrain)
                            world.setBlockToAir(x, y, z);
                    return new FluidStack(FluidRegistry.LAVA, FluidContainerRegistry.BUCKET_VOLUME);
            }
            return null;
    }

    /**
     * Create an explosion which only affects a single block.
     */
    @SuppressWarnings("unchecked")
    public static void explodeBlock(World world, int x, int y, int z) {
            if (FMLCommonHandler.instance().getEffectiveSide().isClient())
                    return;

            Explosion explosion = new Explosion(world, null, x + .5, y + .5, z + .5, 3f);
            explosion.affectedBlockPositions.add(new ChunkPosition(x, y, z));
            explosion.doExplosionB(true);

            for (EntityPlayer player : (List<EntityPlayer>) world.playerEntities) {
                    if (!(player instanceof EntityPlayerMP))
                            continue;

                    if (player.getDistanceSq(x, y, z) < 4096) {
                            ((EntityPlayerMP) player).playerNetServerHandler.sendPacketToPlayer(new Packet60Explosion(x + .5, y + .5, z + .5, 3f, explosion.affectedBlockPositions, null));
                    }
            }
    }
}