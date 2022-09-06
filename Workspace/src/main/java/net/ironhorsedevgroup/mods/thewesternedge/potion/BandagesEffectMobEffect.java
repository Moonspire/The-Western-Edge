
package net.ironhorsedevgroup.mods.thewesternedge.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.ironhorsedevgroup.mods.thewesternedge.procedures.BandagesPreformEffectProcedure;
import net.ironhorsedevgroup.mods.thewesternedge.procedures.BandagesActiveTickDeterminerProcedure;

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
