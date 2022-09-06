
package net.ironhorsedevgroup.mods.thewesternedge.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class MeadEffectMobEffect extends MobEffect {
	public MeadEffectMobEffect() {
		super(MobEffectCategory.NEUTRAL, -21248);
	}

	@Override
	public String getDescriptionId() {
		return "effect.thewesternedge.mead_effect";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
