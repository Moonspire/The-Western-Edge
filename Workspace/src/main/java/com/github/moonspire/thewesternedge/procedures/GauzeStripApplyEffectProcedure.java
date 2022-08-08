package com.github.moonspire.thewesternedge.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import com.github.moonspire.thewesternedge.init.ThewesternedgeModMobEffects;

public class GauzeStripApplyEffectProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		(itemstack).shrink(1);
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 300);
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(ThewesternedgeModMobEffects.BANDAGES_EFFECT.get(), 360, 0));
	}
}
