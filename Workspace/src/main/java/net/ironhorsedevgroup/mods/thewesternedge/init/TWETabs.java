package net.ironhorsedevgroup.mods.thewesternedge.init;

import net.ironhorsedevgroup.mods.thewesternedge.item.bottles.BottleDrinks;
import net.ironhorsedevgroup.mods.thewesternedge.item.bottles.BottleUtils;
import net.ironhorsedevgroup.mods.thewesternedge.item.bottles.BottleVariants;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class TWETabs {
	public static CreativeModeTab TAB_TWE_SURVIVAL;
	public static CreativeModeTab TAB_TWE_DRINKS;
	public static CreativeModeTab TAB_TWE_BOTTLES;
	public static CreativeModeTab TAB_TWE_MARKINGS;
	public static CreativeModeTab TAB_TWE_GAMES;

	public static void load() {
		TAB_TWE_SURVIVAL = new CreativeModeTab("tabtwe_survival") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(TWEBlocks.WELL_TOPPER.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_TWE_DRINKS = new CreativeModeTab("tabtwe_drinks") {
			@Override
			public ItemStack makeIcon() {
				return BottleUtils.addDrink(BottleUtils.createBottle(BottleVariants.LABELED_DOOR_BOTTLE), BottleDrinks.MEAD);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_TWE_BOTTLES = new CreativeModeTab("tabtwe_bottles") {
			@Override
			public ItemStack makeIcon() {
				return BottleUtils.createBottle(BottleVariants.WATERSKIN);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		};
		TAB_TWE_MARKINGS = new CreativeModeTab("tabtwe_markings") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(TWEItems.PAINT_BRUSH.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_TWE_GAMES = new CreativeModeTab("tabtwe_games") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(TWEItems.CARD.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
