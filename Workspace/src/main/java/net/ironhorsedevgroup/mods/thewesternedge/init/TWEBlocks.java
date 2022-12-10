package net.ironhorsedevgroup.mods.thewesternedge.init;

import com.tterrag.registrate.util.entry.RegistryEntry;
import net.ironhorsedevgroup.mods.thewesternedge.TheWesternEdgeMod;
import net.ironhorsedevgroup.mods.thewesternedge.block.berries.BerryBushBlock;
import net.ironhorsedevgroup.mods.thewesternedge.block.wallmarkings.WallMarkingBlock;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
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
import net.ironhorsedevgroup.mods.thewesternedge.block.RainBarrelBlock;
import net.ironhorsedevgroup.mods.thewesternedge.block.GauzeRollsBlock;
import net.ironhorsedevgroup.mods.thewesternedge.block.BrewersBarrelBlock;

public class TWEBlocks {
	//static {
	//	TheWesternEdgeMod.REGISTRATE.creativeModeTab(() -> TWETabs.TAB_TWE_SURVIVAL);
	//}
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, TheWesternEdgeMod.MODID);
	public static final RegistryObject<Block> RAIN_BARREL = REGISTRY.register("rain_barrel", () -> new RainBarrelBlock());
	public static final RegistryObject<Block> WELL_SHAFT = REGISTRY.register("well_shaft", () -> new WellShaftBlock());
	public static final RegistryObject<Block> WELL_SHAFT_LADDER = REGISTRY.register("well_shaft_ladder", () -> new WellShaftLadderBlock());
	public static final RegistryObject<Block> WELL_TOPPER = REGISTRY.register("well_topper", () -> new WellTopperBlock());
	public static final RegistryObject<Block> GAUZE_ROLLS = REGISTRY.register("gauze_rolls", () -> new GauzeRollsBlock());
	public static final RegistryObject<Block> BREWERS_BARREL = REGISTRY.register("brewers_barrel", () -> new BrewersBarrelBlock());

	// Foliage
	public static final RegistryObject<Block> BERRY_BUSH = REGISTRY.register("berry_bush", () -> new BerryBushBlock(BlockBehaviour.Properties.of(Material.PLANT).randomTicks().noCollission().sound(SoundType.SWEET_BERRY_BUSH)));

	// Wall Decals
	public static final RegistryObject<Block> WALL_DECAL_SMALL = REGISTRY.register("wall_decal_small", () -> new WallMarkingBlock(BlockBehaviour.Properties.of(Material.CLOTH_DECORATION).sound(SoundType.BAMBOO).instabreak().noCollission().noOcclusion().noDrops()));
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			RainBarrelBlock.registerRenderLayer();
			WellShaftBlock.registerRenderLayer();
			WellShaftLadderBlock.registerRenderLayer();
			WellTopperBlock.registerRenderLayer();
			GauzeRollsBlock.registerRenderLayer();

			// Foliage
			ItemBlockRenderTypes.setRenderLayer(BERRY_BUSH.get(), renderType -> renderType == RenderType.cutout());

			// Wall Decals
			ItemBlockRenderTypes.setRenderLayer(WALL_DECAL_SMALL.get(), renderType -> renderType == RenderType.translucent());
		}
	}
}
