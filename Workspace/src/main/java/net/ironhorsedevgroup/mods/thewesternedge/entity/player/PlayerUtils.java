package net.ironhorsedevgroup.mods.thewesternedge.entity.player;

import net.ironhorsedevgroup.mods.thewesternedge.TWEUtils;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class PlayerUtils {

    public static int getAlcoholTimer(Entity entity) {
        return TWEUtils.getIntTag(entity, "AlcoholTimer");
    }

    public static void setAlcoholTimer(Entity entity, int amount) {
        if (entity instanceof Player) {
            TWEUtils.putIntTag(entity, "AlcoholIngested", amount);
        }
    }

    public static void changeAlcoholIngested(Entity entity, int amount) {
        if (entity instanceof Player) {
            int timer = getAlcoholTimer(entity) + amount;
            if (timer <= 0) {
                timer = 0;
            }
            setAlcoholTimer(entity, timer);
        }
    }

    public static double getAlcoholIngested(Entity entity) {
        return TWEUtils.getDoubleTag(entity, "AlcoholIngested");
    }

    public static void setAlcoholIngested(Entity entity, Double amount) {
        if (entity instanceof Player) {
            TWEUtils.putDoubleTag(entity, "alcoholIngested", amount);
        }
    }

    public static void changeAlcoholIngested(Entity entity, Double amount) {
        if (entity instanceof Player) {
            Double alcohol = getAlcoholIngested(entity) + amount;
            if (alcohol <= 0.0) {
                alcohol = 0.0;
            }
            setAlcoholIngested(entity, alcohol);
        }
    }

    public static double getAlcoholDigested(Entity entity) {
        return TWEUtils.getDoubleTag(entity, "alcoholDigested");
    }

    public static void setAlcoholDigested(Entity entity, Double amount) {
        if (entity instanceof Player) {
            TWEUtils.putDoubleTag(entity, "alcoholDigested", amount);
        }
    }

    public static void changeAlcoholDigested(Entity entity, Double amount) {
        if (entity instanceof Player) {
            Double alcohol = getAlcoholDigested(entity) + amount;
            if (alcohol <= 0.0) {
                alcohol = 0.0;
            }
            setAlcoholDigested(entity, alcohol);
        }
    }
}
