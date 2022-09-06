package net.ironhorsedevgroup.mods.thewesternedge.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AlcoholSystemProcedure {
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
		double AlcoholTimer = 0;
		AlcoholTimer = entity.getPersistentData().getDouble("AlcoholTimer");
		if (entity instanceof Player) {
			if (AlcoholTimer == 400) {
				AlcoholTimer = 0;
			} else {
				AlcoholTimer = AlcoholTimer + 1;
			}
			entity.getPersistentData().putDouble("AlcoholTimer", AlcoholTimer);
		}
	}
}
