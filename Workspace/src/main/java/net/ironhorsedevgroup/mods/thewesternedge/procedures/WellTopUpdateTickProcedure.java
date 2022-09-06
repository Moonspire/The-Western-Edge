package net.ironhorsedevgroup.mods.thewesternedge.procedures;

import net.ironhorsedevgroup.mods.thewesternedge.init.ThewesternedgeModBlocks;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.common.BiomeDictionary;

import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicInteger;

public class WellTopUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean Loop = false;
		double Water = 0;
		double Y = 0;
		if (new Object() {
			public int getFluidTankCapacity(LevelAccessor level, BlockPos pos, int tank) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
							.ifPresent(capability -> _retval.set(capability.getTankCapacity(tank)));
				return _retval.get();
			}
		}.getFluidTankCapacity(world, new BlockPos(x, y, z), 1) != new Object() {
			public int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
							.ifPresent(capability -> _retval.set(capability.getFluidInTank(tank).getAmount()));
				return _retval.get();
			}
		}.getFluidTankLevel(world, new BlockPos(x, y, z), 1)) {
			Y = y;
			Water = 0;
			Loop = true;
			while (Loop) {
				Y = Y - 1;
				if (!((new ItemStack((world.getBlockState(new BlockPos(x, Y, z))).getBlock())).getItem() == ThewesternedgeModBlocks.WELL_SHAFT.get()
						.asItem()
						|| (new ItemStack((world.getBlockState(new BlockPos(x, Y, z))).getBlock()))
								.getItem() == ThewesternedgeModBlocks.WELL_SHAFT_LADDER.get().asItem())) {
					Y = Y + 1;
					Water = Math.pow(2, Math.pow(Y - 32, 2) / (-400));
					Loop = false;
				}
			}
			if (world.getBiome(new BlockPos(x, y, z)).value().getRegistryName() != null && BiomeDictionary.hasType(
					ResourceKey.create(Registry.BIOME_REGISTRY,
							world.registryAccess().registryOrThrow(Registry.BIOME_REGISTRY).getKey(world.getBiome(new BlockPos(x, y, z)).value())),
					BiomeDictionary.Type.WET)) {
				Water = Water * 400;
			} else if (world.getBiome(new BlockPos(x, y, z)).value().getRegistryName() != null && BiomeDictionary.hasType(
					ResourceKey.create(Registry.BIOME_REGISTRY,
							world.registryAccess().registryOrThrow(Registry.BIOME_REGISTRY).getKey(world.getBiome(new BlockPos(x, y, z)).value())),
					BiomeDictionary.Type.DRY)) {
				Water = Water * 80;
			} else {
				Water = Water * 200;
			}
			{
				BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
				int _amount = (int) Water;
				if (_ent != null)
					_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
							.ifPresent(capability -> capability.fill(new FluidStack(Fluids.WATER, _amount), IFluidHandler.FluidAction.EXECUTE));
			}
		}
	}
}
