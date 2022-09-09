package net.ironhorsedevgroup.mods.thewesternedge.item;

import net.ironhorsedevgroup.mods.thewesternedge.init.TWETabs;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class PaintBrushItem extends Item {
	public PaintBrushItem() {
		super(new Item.Properties().tab(TWETabs.TAB_TWE_MARKINGS).durability(255).rarity(Rarity.COMMON));
	}
}
