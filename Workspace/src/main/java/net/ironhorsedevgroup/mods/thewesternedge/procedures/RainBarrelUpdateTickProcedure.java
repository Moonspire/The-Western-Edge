package net.ironhorsedevgroup.mods.thewesternedge.procedures;

import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.common.BiomeDictionary;

import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicInteger;

public class RainBarrelUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double water = 0;
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
			if (world.canSeeSkyFromBelowWater(new BlockPos(x, y, z)) && world.getLevelData().isRaining()) {
				water = 50;
				if (world.getBiome(new BlockPos(x, y, z)).value().getRegistryName() != null && BiomeDictionary.hasType(ResourceKey.create(
						Registry.BIOME_REGISTRY,
						world.registryAccess().registryOrThrow(Registry.BIOME_REGISTRY).getKey(world.getBiome(new BlockPos(x, y, z)).value())),
						BiomeDictionary.Type.WET)) {
					water = 100;
				} else if (world.getBiome(new BlockPos(x, y, z)).value().getRegistryName() != null && BiomeDictionary.hasType(ResourceKey.create(
						Registry.BIOME_REGISTRY,
						world.registryAccess().registryOrThrow(Registry.BIOME_REGISTRY).getKey(world.getBiome(new BlockPos(x, y, z)).value())),
						BiomeDictionary.Type.DRY)) {
					water = 20;
				}
				{
					BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
					int _amount = (int) water;
					if (_ent != null)
						_ent.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)
								.ifPresent(capability -> capability.fill(new FluidStack(Fluids.WATER, _amount), IFluidHandler.FluidAction.EXECUTE));
				}
			}
		}
	}
}
