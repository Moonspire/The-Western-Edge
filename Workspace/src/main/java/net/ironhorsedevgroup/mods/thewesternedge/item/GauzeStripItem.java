package net.ironhorsedevgroup.mods.thewesternedge.item;

import net.ironhorsedevgroup.mods.thewesternedge.init.TWETabs;
import net.minecraft.world.item.*;

public class GauzeStripItem extends AbstractBandageItem {
	public GauzeStripItem() {
		super(new Item.Properties().tab(TWETabs.TAB_TWE_SURVIVAL).stacksTo(64).rarity(Rarity.COMMON));
	}
}
