package net.ironhorsedevgroup.mods.thewesternedge;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class TWEUtils {

    public static int getFluidTankCapacity(LevelAccessor level, BlockPos pos, int tank) {
        AtomicInteger _retval = new AtomicInteger(0);
        BlockEntity _ent = level.getBlockEntity(pos);
        if (_ent != null)
            _ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
                    .ifPresent(capability -> _retval.set(capability.getTankCapacity(tank)));
        return _retval.get();
    }

    public static int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
        AtomicInteger _retval = new AtomicInteger(0);
        BlockEntity _ent = level.getBlockEntity(pos);
        if (_ent != null)
            _ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
                    .ifPresent(capability -> _retval.set(capability.getFluidInTank(tank).getAmount()));
        return _retval.get();
    }

    public static int getFluidToFull(LevelAccessor level, BlockPos pos, int tank) {
        return getFluidTankCapacity(level, pos, tank) - getFluidTankLevel(level, pos, tank);
    }

    public static void addFluid(Level world, BlockPos pos, int tank, int amount) {
        BlockEntity _ent = world.getBlockEntity(pos);
        if (_ent != null)
            _ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
                    .ifPresent(capability -> capability.fill(new FluidStack(Fluids.WATER, amount), IFluidHandler.FluidAction.EXECUTE));
    }

    public static void drainFluid(Level world, BlockPos pos, int tank, int amount) {
        BlockEntity _ent = world.getBlockEntity(pos);
        if (_ent != null)
            _ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
                    .ifPresent(capability -> capability.drain(new FluidStack(Fluids.WATER, amount), IFluidHandler.FluidAction.EXECUTE));
    }

    private static boolean drawFluid(Level world, InteractionHand hand, Player player, BlockPos pos, int tank, int drawAmount) { //Draws fluid into container from block
        boolean retval = false;
        if (getFluidTankLevel(world, pos, tank) >= drawAmount) {
            drainFluid(world, pos, tank, drawAmount);
            ItemStack itemstack = player.getItemInHand(hand);
            ItemStack newstack = itemstack;
            Item item = itemstack.getItem();
            if (item instanceof BucketItem bucketitem) {
                world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BUCKET_FILL, SoundSource.NEUTRAL, 1.0F, 1.0F);
                world.gameEvent(player, GameEvent.FLUID_PICKUP, pos);
                newstack = ItemUtils.createFilledResult(itemstack, player, new ItemStack(Items.WATER_BUCKET));
                retval = true;
            } else if (item instanceof BottleItem bottleitem) {
                world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BOTTLE_FILL, SoundSource.NEUTRAL, 1.0F, 1.0F);
                world.gameEvent(player, GameEvent.FLUID_PICKUP, pos);
                newstack = ItemUtils.createFilledResult(itemstack, player, PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER));
                retval = true;
            }
            player.setItemInHand(hand, newstack);
        } else {
            player.displayClientMessage(new TextComponent("Not enough water in source"), (true));
        }
        return retval;
    }

    public static boolean drawFluid(Level world, InteractionHand hand, Player player, BlockPos pos, int tank) {
        boolean retval = false;
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();
        if (item instanceof BucketItem) {
            retval = drawFluid(world, hand, player, pos, tank, 1000);
        } else if (item instanceof BottleItem) {
            retval = drawFluid(world, hand, player, pos, tank, 250);
        }
        return retval;
    }

    public static int getSlotAmount(LevelAccessor world, BlockPos pos, int slotid) {
        AtomicInteger _retval = new AtomicInteger(0);
        BlockEntity _ent = world.getBlockEntity(pos);
        if (_ent != null)
            _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
                    .ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
        return _retval.get();
    }

    public static int getSlotMaxStackSize(LevelAccessor world, BlockPos pos, int slotid) {
        AtomicInteger _retval = new AtomicInteger(0);
        BlockEntity _ent = world.getBlockEntity(pos);
        if (_ent != null)
            _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
                    .ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getMaxStackSize()));
        return _retval.get();
    }

    public static boolean isItemInSlotOf(LevelAccessor world, BlockPos pos, int slotid, ItemStack itemstack) {
        AtomicBoolean retbool = new AtomicBoolean(false);
        BlockEntity _ent = world.getBlockEntity(pos);
        if (_ent != null) {
            _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
                if (capability instanceof IItemHandlerModifiable) {
                    retbool.set(capability.getStackInSlot(slotid).sameItem(itemstack));
                }
            });
        }
        return retbool.get();
    }

    public static ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
        AtomicReference<ItemStack> retstack = new AtomicReference<>(ItemStack.EMPTY);
        BlockEntity _ent = world.getBlockEntity(pos);
        if (_ent != null) {
            _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
                if (capability instanceof IItemHandlerModifiable) {
                    retstack.set(capability.getStackInSlot(slotid).copy());
                }
            });
        }
        return retstack.get();
    }

    public static void setItemStackInSlot(LevelAccessor world, BlockPos pos, int slotid, ItemStack itemstack) {
        BlockEntity _ent = world.getBlockEntity(pos);
        if (_ent != null) {
            _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
                if (capability instanceof IItemHandlerModifiable) {
                    ((IItemHandlerModifiable) capability).setStackInSlot(slotid, itemstack);
                }
            });
        }
    }

    public static void growStackInSlot(LevelAccessor world, BlockPos pos, int slotid, int growth) {
        BlockEntity _ent = world.getBlockEntity(pos);
        if (_ent != null) {
            _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
                if (capability instanceof IItemHandlerModifiable) {
                    ItemStack itemstack = capability.getStackInSlot(slotid).copy();
                    itemstack.grow(growth);
                    ((IItemHandlerModifiable) capability).setStackInSlot(slotid, itemstack);
                }
            });
        }
    }

    public static void shrinkStackInSlot(LevelAccessor world, BlockPos pos, int slotid, int shrink) {
        BlockEntity _ent = world.getBlockEntity(pos);
        if (_ent != null) {
            _ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
                if (capability instanceof IItemHandlerModifiable) {
                    ItemStack itemstack = capability.getStackInSlot(slotid).copy();
                    itemstack.shrink(shrink);
                    ((IItemHandlerModifiable) capability).setStackInSlot(slotid, itemstack);
                }
            });
        }
    }


    public static boolean isBiomeOfType(LevelAccessor world, BiomeDictionary.Type biome, BlockPos pos) {
        if (world.getBiome(pos).value().getRegistryName() != null && BiomeDictionary.hasType(
                ResourceKey.create(Registry.BIOME_REGISTRY,
                        Objects.requireNonNull(world.registryAccess().registryOrThrow(Registry.BIOME_REGISTRY).getKey(world.getBiome(pos).value()))),
                biome)) {
            return true;
        }
        return false;
    }

    public static double getDoubleTag(ItemStack itemstack, String name) {
        try {
            return itemstack.getTag().getDouble("CustomModelData");
        } catch (Exception e) {
            return 0;
        }
    }
}
