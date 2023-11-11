package net.ironhorsedevgroup.mods.thewesternedge.block.entity;

import io.netty.buffer.Unpooled;
import net.ironhorsedevgroup.mods.thewesternedge.init.TWEBlockEntities;
import net.ironhorsedevgroup.mods.thewesternedge.world.inventory.BrewersBarrelGuiMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.stream.IntStream;

public class GlassblowersKilmEntity extends RandomizableContainerBlockEntity implements WorldlyContainer {
    private NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(8, ItemStack.EMPTY);

    public GlassblowersKilmEntity(BlockPos position, BlockState state) {
        super(TWEBlockEntities.BREWERS_BARREL.get(), position, state);
    }

    @Override
    protected void setItems(NonNullList<ItemStack> stacks) {
        this.stacks = stacks;
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.stacks;
    }

    @Override
    public Component getDefaultName() {
        return new TextComponent("glassblowers_kilm");
    }

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory) {
        return new BrewersBarrelGuiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(this.worldPosition));
    }

    @Override
    public int getContainerSize() {
        return stacks.size();
    }

    @Override
    public int[] getSlotsForFace(Direction side) {
        return IntStream.range(0, this.getContainerSize()).toArray();
    }

    @Override
    public boolean canPlaceItemThroughFace(int index, ItemStack stack, @Nullable Direction direction) {
        return this.canPlaceItem(index, stack);
    }

    @Override
    public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
        if (index == 0)
            return false;
        if (index == 1)
            return false;
        if (index == 2)
            return false;
        if (index == 3)
            return false;
        return true;
    }
}
