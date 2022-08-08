
package com.github.moonspire.thewesternedge.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

import com.github.moonspire.thewesternedge.init.ThewesternedgeModTabs;

public class PemmicanItem extends Item {
	public PemmicanItem() {
		super(new Item.Properties().tab(ThewesternedgeModTabs.TAB_TWE_SURVIVAL).stacksTo(64).rarity(Rarity.COMMON)
				.food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.5f)

						.meat().build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 32;
	}
}
