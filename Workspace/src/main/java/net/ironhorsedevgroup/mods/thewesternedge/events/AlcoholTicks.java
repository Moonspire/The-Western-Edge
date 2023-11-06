package net.ironhorsedevgroup.mods.thewesternedge.events;

import net.ironhorsedevgroup.mods.thewesternedge.entity.player.PlayerUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AlcoholTicks {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingUpdateEvent event) {
		execute(event, event.getEntityLiving());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		int alcoholTimer = PlayerUtils.getAlcoholTimer(entity);
		if (alcoholTimer == 40) {
			alcoholTimer = 0;
			Double alcoholIngested = PlayerUtils.getAlcoholIngested(entity);
			Double alcoholDigested = PlayerUtils.getAlcoholDigested(entity);
			if (alcoholDigested >= 0.001 || alcoholIngested >= 0.1) {
				Double alcoholToDigest = 0.01 * alcoholIngested;
				if (alcoholToDigest < 0.001) {
					PlayerUtils.setAlcoholIngested(entity, 0.0);
					alcoholToDigest = -0.01 * alcoholDigested;
				}
				if (alcoholIngested != 0.0) {
					PlayerUtils.changeAlcoholIngested(entity, -Math.abs(alcoholToDigest));
				}
				PlayerUtils.changeAlcoholDigested(entity, alcoholToDigest);
			}
		} else {
			alcoholTimer = alcoholTimer + 1;
		}
		PlayerUtils.setAlcoholTimer(entity, alcoholTimer);
	}
}
