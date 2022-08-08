
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.github.moonspire.thewesternedge.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class ThewesternedgeModTabs {
	public static CreativeModeTab TAB_TWE_SURVIVAL;
	public static CreativeModeTab TAB_TWE_ALCOHOLS;

	public static void load() {
		TAB_TWE_SURVIVAL = new CreativeModeTab("tabtwe_survival") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(ThewesternedgeModBlocks.WELL_TOPPER.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_TWE_ALCOHOLS = new CreativeModeTab("tabtwe_alcohols") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(Items.POTION);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
