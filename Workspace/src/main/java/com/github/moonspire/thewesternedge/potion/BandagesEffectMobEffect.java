
package com.github.moonspire.thewesternedge.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import com.github.moonspire.thewesternedge.procedures.BandagesPreformEffectProcedure;
import com.github.moonspire.thewesternedge.procedures.BandagesActiveTickDeterminerProcedure;

public class BandagesEffectMobEffect extends MobEffect {
	public BandagesEffectMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -65536);
	}

	@Override
	public String getDescriptionId() {
		return "effect.thewesternedge.bandages_effect";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		BandagesPreformEffectProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return BandagesActiveTickDeterminerProcedure.execute(amplifier, duration);
	}
}
