
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.github.moonspire.thewesternedge.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import com.github.moonspire.thewesternedge.block.WellTopperBlock;
import com.github.moonspire.thewesternedge.block.WellShaftLadderBlock;
import com.github.moonspire.thewesternedge.block.WellShaftBlock;
import com.github.moonspire.thewesternedge.block.WallMarkingBlock;
import com.github.moonspire.thewesternedge.block.RainBarrelBlock;
import com.github.moonspire.thewesternedge.block.GauzeRollsBlock;
import com.github.moonspire.thewesternedge.block.BrewersBarrelBlock;
import com.github.moonspire.thewesternedge.ThewesternedgeMod;

public class ThewesternedgeModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ThewesternedgeMod.MODID);
	public static final RegistryObject<Block> RAIN_BARREL = REGISTRY.register("rain_barrel", () -> new RainBarrelBlock());
	public static final RegistryObject<Block> WELL_SHAFT = REGISTRY.register("well_shaft", () -> new WellShaftBlock());
	public static final RegistryObject<Block> WELL_SHAFT_LADDER = REGISTRY.register("well_shaft_ladder", () -> new WellShaftLadderBlock());
	public static final RegistryObject<Block> WELL_TOPPER = REGISTRY.register("well_topper", () -> new WellTopperBlock());
	public static final RegistryObject<Block> GAUZE_ROLLS = REGISTRY.register("gauze_rolls", () -> new GauzeRollsBlock());
	public static final RegistryObject<Block> BREWERS_BARREL = REGISTRY.register("brewers_barrel", () -> new BrewersBarrelBlock());
	public static final RegistryObject<Block> WALL_MARKING = REGISTRY.register("wall_marking", () -> new WallMarkingBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			RainBarrelBlock.registerRenderLayer();
			WellShaftBlock.registerRenderLayer();
			WellShaftLadderBlock.registerRenderLayer();
			WellTopperBlock.registerRenderLayer();
			GauzeRollsBlock.registerRenderLayer();
			WallMarkingBlock.registerRenderLayer();
		}
	}
}
