
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.ironhorsedevgroup.mods.thewesternedge.init;

import net.ironhorsedevgroup.mods.thewesternedge.TheWesternEdgeMod;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.ironhorsedevgroup.mods.thewesternedge.block.entity.WellTopperBlockEntity;
import net.ironhorsedevgroup.mods.thewesternedge.block.entity.RainBarrelBlockEntity;
import net.ironhorsedevgroup.mods.thewesternedge.block.entity.GauzeRollsBlockEntity;
import net.ironhorsedevgroup.mods.thewesternedge.block.entity.BrewersBarrelBlockEntity;

public class TWEBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES,
			TheWesternEdgeMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> RAIN_BARREL = register("rain_barrel", TWEBlocks.RAIN_BARREL,
			RainBarrelBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WELL_TOPPER = register("well_topper", TWEBlocks.WELL_TOPPER,
			WellTopperBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GAUZE_ROLLS = register("gauze_rolls", TWEBlocks.GAUZE_ROLLS,
			GauzeRollsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BREWERS_BARREL = register("brewers_barrel", TWEBlocks.BREWERS_BARREL,
			BrewersBarrelBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block,
			BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
