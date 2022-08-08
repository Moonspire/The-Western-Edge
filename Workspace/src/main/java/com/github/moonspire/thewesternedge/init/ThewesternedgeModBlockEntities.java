
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.github.moonspire.thewesternedge.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import com.github.moonspire.thewesternedge.block.entity.WellTopperBlockEntity;
import com.github.moonspire.thewesternedge.block.entity.RainBarrelBlockEntity;
import com.github.moonspire.thewesternedge.block.entity.GauzeRollsBlockEntity;
import com.github.moonspire.thewesternedge.block.entity.BrewersBarrelBlockEntity;
import com.github.moonspire.thewesternedge.ThewesternedgeMod;

public class ThewesternedgeModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES,
			ThewesternedgeMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> RAIN_BARREL = register("rain_barrel", ThewesternedgeModBlocks.RAIN_BARREL,
			RainBarrelBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WELL_TOPPER = register("well_topper", ThewesternedgeModBlocks.WELL_TOPPER,
			WellTopperBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GAUZE_ROLLS = register("gauze_rolls", ThewesternedgeModBlocks.GAUZE_ROLLS,
			GauzeRollsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BREWERS_BARREL = register("brewers_barrel", ThewesternedgeModBlocks.BREWERS_BARREL,
			BrewersBarrelBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block,
			BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
