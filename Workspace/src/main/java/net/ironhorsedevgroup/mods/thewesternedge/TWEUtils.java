package net.ironhorsedevgroup.mods.thewesternedge;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

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
            Item item = itemstack.getItem();
            ItemStack newstack = itemstack;
            if (item == Items.BUCKET) {
                newstack = ItemUtils.createFilledResult(itemstack, player, new ItemStack(Items.WATER_BUCKET));
                retval = true;
            } else if (item == Items.GLASS_BOTTLE) {
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
        if (item == Items.BUCKET) {
            retval = drawFluid(world, hand, player, pos, tank, 1000);
        } else if (item == Items.GLASS_BOTTLE) {
            retval = drawFluid(world, hand, player, pos, tank, 250);
        } else {
            player.displayClientMessage(new TextComponent("You can't fill this"), (true));
        }
        return retval;
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
}
