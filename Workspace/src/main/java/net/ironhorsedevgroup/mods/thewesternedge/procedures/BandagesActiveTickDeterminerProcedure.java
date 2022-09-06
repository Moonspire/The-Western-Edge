package net.ironhorsedevgroup.mods.thewesternedge.procedures;

import net.minecraft.world.item.ItemStack;

public class BandagesActiveTickDeterminerProcedure {
	public static boolean execute(double amplifier, double duration) {
		ItemStack pickaxe = ItemStack.EMPTY;
		double EnchtSize = 0;
		double i = 0;
		double j = 0;
		double k = 0;
		double baseRate = 0;
		double rateWithAmplifier = 0;
		baseRate = 50;
		rateWithAmplifier = baseRate / (1 + amplifier);
		if (Math.floor(rateWithAmplifier) > 0) {
			return duration % Math.floor(rateWithAmplifier) == 0;
		}
		return true;
	}
}
