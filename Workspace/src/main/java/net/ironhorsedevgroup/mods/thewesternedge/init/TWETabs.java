package net.ironhorsedevgroup.mods.thewesternedge.init;

import net.minecraft.core.NonNullList;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class TWETabs {
	public static CreativeModeTab TAB_TWE_SURVIVAL;
	public static CreativeModeTab TAB_TWE_ALCOHOLS;
	public static CreativeModeTab TAB_TWE_MARKINGS;

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
		TAB_TWE_ALCOHOLS = new CreativeModeTab("tabtwe_alcohols") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(TWEBlocks.BREWERS_BARREL.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_TWE_MARKINGS = new CreativeModeTab("tabtwe_markings") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(TWEItems.BROKEN_BOTTLE.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
