package Mod.Misc;

import Mod.Block.ModBlockOrangeSapling;
import Mod.Block.ModBlocks;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class BoneMealEvent
{

        private int BlockID;
        @ForgeSubscribe
        public void bonemealUsed(BonemealEvent event)
        {

        if(event.world.getBlockId(event.X, event.Y, event.Z) == ModBlocks.OrangeSapling.blockID)
        {
        ((ModBlockOrangeSapling)ModBlocks.OrangeSapling).markOrGrowMarked(event.world, event.X, event.Y, event.Z, event.world.rand);
        event.setResult(Result.ALLOW);
        }

        }
}