package Mod.Proxies;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.MinecraftForgeClient;
import Mod.Block.ModBlocks;
import Mod.Entity.EntityPowerArrow;
import Mod.Entity.EntitySilverArrow;
import Mod.GamePart.TileEntityGamePartBlue;
import Mod.GamePart.TileEntityGamePartGreen;
import Mod.GamePart.TileEntityGamePartNull;
import Mod.GamePart.TileEntityGamePartRed;
import Mod.GamePart.TileEntityGamePartYellow;
import Mod.Models.PowerArrowRender;
import Mod.Models.SilverArrowRender;
import Mod.Render.LockableChestItemRender;
import Mod.Render.TrashBinItemRender;
import Mod.Tick.ClientTickHandler;
import Mod.TileEntity.TileEntityBin;
import Mod.TileEntity.TileEntityDisarmTrap;
import Mod.TileEntity.TileEntityLockableChest;
import Mod.TileEntity.TileEntityPillar;
import Mod.TileEntity.TileEntityPowerCable;
import Mod.TileEntity.TileEntitySidewaysPillar;
import Mod.TileEntityRenderer.TileEntityBinRender;
import Mod.TileEntityRenderer.TileEntityDisarmTrapRenderer;
import Mod.TileEntityRenderer.TileEntityGamePartRender;
import Mod.TileEntityRenderer.TileEntityLockableChestRender;
import Mod.TileEntityRenderer.TileEntityPillarRender;
import Mod.TileEntityRenderer.TileEntityPowerCableRender;
import Mod.TileEntityRenderer.TileEntitySidewaysPillarRender;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ClientProxy extends ServerProxy{

	
    public void registerRenderThings() {
    	
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBin.class, new TileEntityBinRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDisarmTrap.class, new TileEntityDisarmTrapRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPowerCable.class, new TileEntityPowerCableRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLockableChest.class, new TileEntityLockableChestRender());
        
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGamePartRed.class, new TileEntityGamePartRender("red"));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGamePartBlue.class, new TileEntityGamePartRender("blue"));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGamePartGreen.class, new TileEntityGamePartRender("green"));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGamePartYellow.class, new TileEntityGamePartRender("yellow"));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGamePartNull.class, new TileEntityGamePartRender("white"));
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPillar.class, new TileEntityPillarRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySidewaysPillar.class, new TileEntitySidewaysPillarRender());
        
        RenderingRegistry.registerEntityRenderingHandler(EntitySilverArrow.class, new SilverArrowRender());
        RenderingRegistry.registerEntityRenderingHandler(EntityPowerArrow.class, new PowerArrowRender());
        
        MinecraftForgeClient.registerItemRenderer(ModBlocks.LockableChest.blockID, new LockableChestItemRender());
        MinecraftForgeClient.registerItemRenderer(ModBlocks.Bin.blockID, new TrashBinItemRender());

}
    
    
    @SideOnly(Side.CLIENT)
    @Override
    public int addArmor(String armor){
        return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }
    
    @Override
    public void registerClientTickHandler()
    {
    	
    TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);

    }
    
    @Override
    public EntityPlayer getPlayer(){
    	return Minecraft.getMinecraft().thePlayer;
    }
}
