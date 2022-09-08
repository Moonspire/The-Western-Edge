
package net.ironhorsedevgroup.mods.thewesternedge.item;

import net.ironhorsedevgroup.mods.thewesternedge.init.TWETabs;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class PemmicanItem extends Item {
	public PemmicanItem() {
		super(new Item.Properties().tab(TWETabs.TAB_TWE_SURVIVAL).stacksTo(64).rarity(Rarity.COMMON)
				.food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.5f)
						.meat().build()
				)
		);
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 32;
	}
}
