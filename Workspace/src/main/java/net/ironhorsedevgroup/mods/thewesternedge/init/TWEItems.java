
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.ironhorsedevgroup.mods.thewesternedge.init;

import net.ironhorsedevgroup.mods.thewesternedge.TheWesternEdgeMod;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.ironhorsedevgroup.mods.thewesternedge.item.PemmicanItem;
import net.ironhorsedevgroup.mods.thewesternedge.item.PaintBrushItem;
import net.ironhorsedevgroup.mods.thewesternedge.item.GauzeStripItem;
import net.ironhorsedevgroup.mods.thewesternedge.item.BrokenBottleItem;

public class TWEItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, TheWesternEdgeMod.MODID);
	public static final RegistryObject<Item> RAIN_BARREL = block(TWEBlocks.RAIN_BARREL, TWETabs.TAB_TWE_SURVIVAL);
	public static final RegistryObject<Item> WELL_SHAFT = block(TWEBlocks.WELL_SHAFT, TWETabs.TAB_TWE_SURVIVAL);
	public static final RegistryObject<Item> WELL_SHAFT_LADDER = block(TWEBlocks.WELL_SHAFT_LADDER, null);
	public static final RegistryObject<Item> WELL_TOPPER = block(TWEBlocks.WELL_TOPPER, TWETabs.TAB_TWE_SURVIVAL);
	public static final RegistryObject<Item> GAUZE_ROLLS = block(TWEBlocks.GAUZE_ROLLS, TWETabs.TAB_TWE_SURVIVAL);
	public static final RegistryObject<Item> GAUZE_STRIP = REGISTRY.register("gauze_strip", () -> new GauzeStripItem());
	public static final RegistryObject<Item> PEMMICAN = REGISTRY.register("pemmican", () -> new PemmicanItem());
	public static final RegistryObject<Item> BREWERS_BARREL = block(TWEBlocks.BREWERS_BARREL, TWETabs.TAB_TWE_SURVIVAL);
	public static final RegistryObject<Item> BROKEN_BOTTLE = REGISTRY.register("broken_bottle", () -> new BrokenBottleItem());
	public static final RegistryObject<Item> PAINT_BRUSH = REGISTRY.register("paint_brush", () -> new PaintBrushItem());
	public static final RegistryObject<Item> WALL_MARKING = block(TWEBlocks.WALL_MARKING, TWETabs.TAB_TWE_MARKINGS);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
