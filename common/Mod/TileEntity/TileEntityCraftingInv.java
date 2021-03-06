package Mod.TileEntity;

import java.util.Random;

import Mod.Network.PacketHandler;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.PacketDispatcher;



public class TileEntityCraftingInv extends TileEntity implements IInventory,ISidedInventory
{
class LocalInventoryCrafting extends InventoryCrafting
{
public LocalInventoryCrafting() {
super(new Container(){
@Override
public boolean canInteractWith(EntityPlayer var1) {
return false;
}
}, 3, 3);
}
public Container eventHandler;
};

private ItemStack[] inv;
private boolean shouldUpdate = false;
public boolean teInit = false;
public boolean containerInit = false;
public boolean initSlots = false;
private boolean recentSync = true;

public IInventory craftResult;
public IInventory craftSupplyMatrix;
public LocalInventoryCrafting craftMatrix;
private ItemStack result = null;
private ItemStack lastResult;
private int sync = 0;
private int supplyMatrixStart = 9;
private int supplyMatrixSize = 18;

@Override
public void onInventoryChanged()
{
if(!containerInit && shouldUpdate){
findRecipe(false);
shouldUpdate = false;
}
super.onInventoryChanged();
}
public TileEntityCraftingInv()
{
craftSupplyMatrix = new InventoryBasic("CraftingSupply", true, 18);
craftResult = new InventoryCraftResult();
inv = new ItemStack[27];
shouldUpdate = true;
craftMatrix = new LocalInventoryCrafting();
}
public ItemStack findRecipe(boolean fromPacket)
{
if(worldObj == null)
return null;
lastResult = result;

ItemStack stack = null;
for(int i = 0; i < craftMatrix.getSizeInventory(); ++i)
{
stack = getStackInSlot(i);
craftMatrix.setInventorySlotContents(i, stack);
}

ItemStack recipe = CraftingManager.getInstance().findMatchingRecipe(craftMatrix, worldObj);
setResult(recipe);

if(!ItemStack.areItemStacksEqual(lastResult, result) && !fromPacket && !worldObj.isRemote){
if(!teInit) recentSync = false;
}

return recipe;
}

@Override
public void updateEntity()
    {
super.updateEntity();
sync++;
if(teInit){
findRecipe(false);
teInit = false;
}
if(sync > 200 && !recentSync){
recentSync = true;
}
if(sync > 6000){
sync = 0;
}
    }

public void markShouldUpdate(){
shouldUpdate = true;
}
public void updateResultSlot(){
craftResult.setInventorySlotContents(0, result);
}

public ItemStack getResult()
{
return (result == null) ? null : result.copy();
}
public void setResult(ItemStack stack)
{	
if(stack != null)
result = stack.copy();
else
result = null;

updateResultSlot();
}

@Override
public int getSizeInventory()
{
return inv.length;
}

@Override
public ItemStack getStackInSlot(int slot)
{
return inv[slot];
}

@Override
public ItemStack decrStackSize(int slot, int amount)
{
ItemStack stack = getStackInSlot(slot);
if(stack != null)
{
if(stack.stackSize <= amount)
{
setInventorySlotContents(slot, null);
} else
{
stack = stack.splitStack(amount);
if(stack.stackSize == 0)
{
setInventorySlotContents(slot, null);
}else
onInventoryChanged();
}
}
return stack;
}

@Override
public ItemStack getStackInSlotOnClosing(int slot)
{
ItemStack stack = getStackInSlot(slot);
if(stack != null)
{
setInventorySlotContents(slot, null);
}
onInventoryChanged();
return stack;
}

@Override
public void setInventorySlotContents(int slot, ItemStack stack)
{
inv[slot] = stack;
if(stack != null && stack.stackSize > getInventoryStackLimit())
{
stack.stackSize = getInventoryStackLimit();
}
if(slot < 9 && !initSlots)
markShouldUpdate();
onInventoryChanged();
}

public void emptyCraftingMatrix() {
Random rand = new Random();
for(int i = 0; i < 8; i++){
if(inv[i] != null){
float rx = rand.nextFloat() * 0.8F + 0.1F;
float ry = rand.nextFloat() * 0.8F + 0.1F;
float rz = rand.nextFloat() * 0.8F + 0.1F;
EntityItem ei = new EntityItem(worldObj, xCoord + rx, yCoord + ry, zCoord + rz,
new ItemStack(inv[i].itemID, inv[i].stackSize, inv[i].getItemDamage()));
if(inv[i].hasTagCompound())
ei.getEntityItem().setTagCompound((NBTTagCompound) inv[i].getTagCompound().copy());
float factor = 0.05f;
ei.motionX = rand.nextGaussian() * factor;
ei.motionY = rand.nextGaussian() * factor + 0.2F;
ei.motionZ = rand.nextGaussian() * factor;
if(!worldObj.isRemote)
worldObj.spawnEntityInWorld(ei);
inv[i].stackSize = 0;
}
}
}

@Override
public String getInvName()
{
return "CraftingInv";
}

@Override
public int getInventoryStackLimit()
{
return 64;
}

@Override
public boolean isUseableByPlayer(EntityPlayer player)
{
return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this &&
player.getDistanceSq(xCoord +0.5, yCoord +0.5, zCoord +0.5) < 64;
}

public int[] getRecipeStacksForPacket()
{
ItemStack result;
if(shouldUpdate){
result = findRecipe(true);
}
else{
result = this.result;
}
if(result != null)
{
int[] craftingStacks = new int[27];
int index = 0;
for(int i = 0; i < 9; i++)
{
if(inv[i] != null)
{
craftingStacks[index++] = inv[i].itemID;
craftingStacks[index++] = inv[i].stackSize;
craftingStacks[index++] = inv[i].getItemDamage();
} else
{
craftingStacks[index++] = 0;
craftingStacks[index++] = 0;
craftingStacks[index++] = 0;
}
}
return craftingStacks;
} else
return null;
}

public void buildResultFromPacket(int[] stacksData)
{
if(stacksData == null)
{
this.setResult(null);
return;
}
if(stacksData.length != 0 && stacksData[0] > 0)
{
this.setResult(new ItemStack(stacksData[0], stacksData[1], stacksData[2]));
} else
this.setResult(null);
}

@Override
public void openChest() {}

@Override
public void closeChest() {}


@Override
public void readFromNBT(NBTTagCompound tagCompound)
{
super.readFromNBT(tagCompound);

NBTTagList tagList = tagCompound.getTagList("Inventory");
for(int i = 0; i < tagList.tagCount(); i++)
{
NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
byte slot = tag.getByte("Slot");
if(slot >= 0 && slot < inv.length)
{
inv[slot] = ItemStack.loadItemStackFromNBT(tag);
}
}
if(worldObj == null)
teInit = true;
}
@Override
public void writeToNBT(NBTTagCompound tagCompound)
{
super.writeToNBT(tagCompound);

NBTTagList itemList = new NBTTagList();	

for(int i = 0; i < inv.length; i++)
{
ItemStack stack = inv[i];
if(stack != null)
{
NBTTagCompound tag = new NBTTagCompound();	
tag.setByte("Slot", (byte)i);
stack.writeToNBT(tag);
itemList.appendTag(tag);
}
}
tagCompound.setTag("Inventory", itemList);
}
@Override
public boolean isInvNameLocalized() {
return false;
}
public int getSupplyMatrixSize(){
return supplyMatrixSize;
}
public int getSupplyMatrixStart(){
return supplyMatrixStart;
}
@Override
public int[] getAccessibleSlotsFromSide(int side) {
int[] slots = null;
switch(side){
case 0:
slots = new int[9];
for(int i = 0; i < slots.length; i++)
slots[i] = i;
return slots;
default:
slots = new int[18];
for(int i = 0; i < slots.length; i++)
slots[i] = i +9;
return slots;
}
}
@Override
public boolean canInsertItem(int i, ItemStack itemstack, int j) {
return true;
}
@Override
public boolean canExtractItem(int i, ItemStack itemstack, int j) {
return true;
}
@Override
public boolean isItemValidForSlot(int i, ItemStack itemstack) {
return true;
}

}



