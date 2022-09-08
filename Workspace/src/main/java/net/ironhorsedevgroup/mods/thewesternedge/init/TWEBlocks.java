
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.ironhorsedevgroup.mods.thewesternedge.init;

import net.ironhorsedevgroup.mods.thewesternedge.TheWesternEdgeMod;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.ironhorsedevgroup.mods.thewesternedge.block.WellTopperBlock;
import net.ironhorsedevgroup.mods.thewesternedge.block.WellShaftLadderBlock;
import net.ironhorsedevgroup.mods.thewesternedge.block.WellShaftBlock;
import net.ironhorsedevgroup.mods.thewesternedge.block.WallMarkingBlock;
import net.ironhorsedevgroup.mods.thewesternedge.block.RainBarrelBlock;
import net.ironhorsedevgroup.mods.thewesternedge.block.GauzeRollsBlock;
import net.ironhorsedevgroup.mods.thewesternedge.block.BrewersBarrelBlock;

public class TWEBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, TheWesternEdgeMod.MODID);
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
