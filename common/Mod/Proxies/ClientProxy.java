package Mod.Proxies;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.MinecraftForge;
import Mod.Block.ModBlocks;
import Mod.Entity.EntityPowerArrow;
import Mod.Entity.EntitySilverArrow;
import Mod.GamePart.GamePartItemRender;
import Mod.GamePart.TileEntityGamePart;
import Mod.Gui.GuiListener;
import Mod.ItemRender.ComputerItemRender;
import Mod.ItemRender.DiceHolderItemRender;
import Mod.ItemRender.DisarmTrapItemRender;
import Mod.ItemRender.ItemPedestalItemRender;
import Mod.ItemRender.ItemRenderMetalPress;
import Mod.ItemRender.MiningChamberItemRender;
import Mod.ItemRender.PillarItemRender;
import Mod.ItemRender.PowerCableItemRender;
import Mod.ItemRender.TableItemRender;
import Mod.ItemRender.TeleporterItemRender;
import Mod.ItemRender.TrashBinItemRender;
import Mod.Lib.Colours;
import Mod.Misc.ItemHelper;
import Mod.Network.PacketRequestEvent;
import Mod.Network.PacketTypeHandler;
import Mod.Render.PowerArrowRender;
import Mod.Render.SilverArrowRender;
import Mod.Tick.ClientTickHandler;
import Mod.TileEntity.ModTileEntity;
import Mod.TileEntity.TileEntityBin;
import Mod.TileEntity.TileEntityComputer;
import Mod.TileEntity.TileEntityDiceHolder;
import Mod.TileEntity.TileEntityDisarmTrap;
import Mod.TileEntity.TileEntityItemPedestal;
import Mod.TileEntity.TileEntityMetalPress;
import Mod.TileEntity.TileEntityMiningChamber;
import Mod.TileEntity.TileEntityPillar;
import Mod.TileEntity.TileEntityPowerCable;
import Mod.TileEntity.TileEntityTable;
import Mod.TileEntity.TileEntityTeleporter;
import Mod.TileEntityRenderer.TileEntityBinRender;
import Mod.TileEntityRenderer.TileEntityComputerRender;
import Mod.TileEntityRenderer.TileEntityDiceHolderRender;
import Mod.TileEntityRenderer.TileEntityDisarmTrapRenderer;
import Mod.TileEntityRenderer.TileEntityGamePartRender;
import Mod.TileEntityRenderer.TileEntityItemPedestalRender;
import Mod.TileEntityRenderer.TileEntityMetalPressRender;
import Mod.TileEntityRenderer.TileEntityMiningChamberRender;
import Mod.TileEntityRenderer.TileEntityPillarRender;
import Mod.TileEntityRenderer.TileEntityPowerCableRender;
import Mod.TileEntityRenderer.TileEntityTableRender;
import Mod.TileEntityRenderer.TileEntityTeleporterRender;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ClientProxy extends ServerProxy{

	
    public void registerRenderThings() {
    	
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBin.class, new TileEntityBinRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDisarmTrap.class, new TileEntityDisarmTrapRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPowerCable.class, new TileEntityPowerCableRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityItemPedestal.class, new TileEntityItemPedestalRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMiningChamber.class, new TileEntityMiningChamberRender());
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGamePart.class, new TileEntityGamePartRender());

        
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPillar.class, new TileEntityPillarRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTable.class, new TileEntityTableRender());
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityComputer.class, new TileEntityComputerRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDiceHolder.class, new TileEntityDiceHolderRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTeleporter.class, new TileEntityTeleporterRender());
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMetalPress.class, new TileEntityMetalPressRender());
        
        
        RenderingRegistry.registerEntityRenderingHandler(EntitySilverArrow.class, new SilverArrowRender());
        RenderingRegistry.registerEntityRenderingHandler(EntityPowerArrow.class, new PowerArrowRender());
        
        
        MinecraftForgeClient.registerItemRenderer(ModBlocks.Bin.blockID, new TrashBinItemRender());
        MinecraftForgeClient.registerItemRenderer(ModBlocks.ItemPedestal.blockID, new ItemPedestalItemRender());
        MinecraftForgeClient.registerItemRenderer(ModBlocks.MiningChamber.blockID, new MiningChamberItemRender());
        MinecraftForgeClient.registerItemRenderer(ModBlocks.Pillar.blockID, new PillarItemRender());
        MinecraftForgeClient.registerItemRenderer(ModBlocks.PowerCable.blockID, new PowerCableItemRender());
        MinecraftForgeClient.registerItemRenderer(ModBlocks.DisarmTrap.blockID, new DisarmTrapItemRender());
        
        MinecraftForgeClient.registerItemRenderer(ModBlocks.Computer.blockID, new ComputerItemRender());
        
        
        MinecraftForgeClient.registerItemRenderer(ModBlocks.GamePart.blockID, new GamePartItemRender());
        
        MinecraftForgeClient.registerItemRenderer(ModBlocks.Table.blockID, new TableItemRender());
        
        MinecraftForgeClient.registerItemRenderer(ModBlocks.DiceHolder.blockID, new DiceHolderItemRender());
        MinecraftForgeClient.registerItemRenderer(ModBlocks.Teleporter.blockID, new TeleporterItemRender());
        
        MinecraftForgeClient.registerItemRenderer(ModBlocks.MetalPress.blockID, new ItemRenderMetalPress());

}
    
    
    @SideOnly(Side.CLIENT)
    @Override
    public int addArmor(String armor){
        return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }
    
    @Override
    public void registerClientTickHandler()
    {
    	
        tickHandlerClient = new ClientTickHandler();
        TickRegistry.registerTickHandler(tickHandlerClient, Side.CLIENT);

    }
    
    
	public void RegisterListeners(){
		
		MinecraftForge.EVENT_BUS.register(new GuiListener());
	}
    
    @Override
    public void sendRequestEventPacket(byte eventType, int originX, int originY, int originZ, byte sideHit, byte rangeX, byte rangeY, byte rangeZ, String data) {

        PacketDispatcher.sendPacketToServer(PacketTypeHandler.populatePacket(new PacketRequestEvent(eventType, originX, originY, originZ, sideHit, rangeX, rangeY, rangeZ, data)));
    }


    @Override
    public void handleTileWithItemPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName, int itemID, int metaData, int stackSize, int color) {

        World world = FMLClientHandler.instance().getClient().theWorld;
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

        this.handleTileEntityPacket(x, y, z, orientation, state, customName);

        if (tileEntity != null) {
            if (tileEntity instanceof TileEntityItemPedestal) {

                ItemStack itemStack = new ItemStack(itemID, stackSize, metaData);
                if (color != Integer.parseInt(Colours.PURE_WHITE, 16)) {
                    ItemHelper.setColor(itemStack, color);
                }

                ((TileEntityItemPedestal) tileEntity).setInventorySlotContents(0, itemStack);
                world.updateAllLightTypes(x, y, z);
            }
            
            if (tileEntity instanceof TileEntityMiningChamber) {

                ItemStack itemStack = new ItemStack(itemID, stackSize, metaData);
                if (color != Integer.parseInt(Colours.PURE_WHITE, 16)) {
                    ItemHelper.setColor(itemStack, color);
                }

                ((TileEntityMiningChamber) tileEntity).setInventorySlotContents(0, itemStack);
                world.updateAllLightTypes(x, y, z);
            }
            
          
        }
    }
    
    @Override
    public void handleTileEntityPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName) {

        TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getBlockTileEntity(x, y, z);

        if (tileEntity != null) {
            if (tileEntity instanceof ModTileEntity) {
                ((ModTileEntity) tileEntity).setOrientation(orientation);
                ((ModTileEntity) tileEntity).setState(state);
                ((ModTileEntity) tileEntity).setCustomName(customName);
            }
        }
    }




}
