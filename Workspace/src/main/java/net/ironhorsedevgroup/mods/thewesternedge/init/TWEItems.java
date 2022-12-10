package net.ironhorsedevgroup.mods.thewesternedge.init;

import net.ironhorsedevgroup.mods.thewesternedge.TheWesternEdgeMod;
import net.ironhorsedevgroup.mods.thewesternedge.item.*;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

public class TWEItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, TheWesternEdgeMod.MODID);
	public static final RegistryObject<Item> RAIN_BARREL = block(TWEBlocks.RAIN_BARREL, TWETabs.TAB_TWE_SURVIVAL);
	public static final RegistryObject<Item> WELL_SHAFT = block(TWEBlocks.WELL_SHAFT, TWETabs.TAB_TWE_SURVIVAL);
	//public static final RegistryObject<Item> WELL_SHAFT_LADDER = block(TWEBlocks.WELL_SHAFT_LADDER, null);
	public static final RegistryObject<Item> WELL_TOPPER = block(TWEBlocks.WELL_TOPPER, TWETabs.TAB_TWE_SURVIVAL);
	public static final RegistryObject<Item> GAUZE_ROLLS = block(TWEBlocks.GAUZE_ROLLS, TWETabs.TAB_TWE_SURVIVAL);
	public static final RegistryObject<Item> GAUZE_STRIP = REGISTRY.register("gauze_strip", () -> new GauzeStripItem());
	public static final RegistryObject<Item> PEMMICAN = REGISTRY.register("pemmican", () -> new PemmicanItem());
	public static final RegistryObject<Item> BREWERS_BARREL = block(TWEBlocks.BREWERS_BARREL, TWETabs.TAB_TWE_SURVIVAL);
	public static final RegistryObject<Item> BROKEN_BOTTLE = REGISTRY.register("broken_bottle", () -> new BrokenBottleItem());
	public static final RegistryObject<Item> PAINT_BRUSH = REGISTRY.register("paint_brush", () -> new PaintBrushItem());

	//Berries
	public static final RegistryObject<Item> AMBER_BERRIES = berries("amber_berries");
	public static final RegistryObject<Item> INDIGO_BERRIES = berries("indigo_berries");
	public static final RegistryObject<Item> JADE_BERRIES = berries("jade_berries");
	public static final RegistryObject<Item> MAUVE_BERRIES = berries("mauve_berries");
	public static final RegistryObject<Item> RUSSET_BERRIES = berries("russet_berries");
	public static final RegistryObject<Item> TEAL_BERRIES = berries("teal_berries");
	public static final RegistryObject<Item> VERMILLION_BERRIES = berries("vermillion_berries");

	//Drinks
	public static final RegistryObject<Item> DRINK = REGISTRY.register("drink", () -> new DrinkItem((new Item.Properties()).stacksTo(1).tab(TWETabs.TAB_TWE_ALCOHOLS)));

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
	private static RegistryObject<Item> berries(String regName) {
		return REGISTRY.register(regName, () -> new ItemNameBlockItem(TWEBlocks.BERRY_BUSH.get(), new Item.Properties().tab(TWETabs.TAB_TWE_ALCOHOLS).food(Foods.SWEET_BERRIES)));
	}
}