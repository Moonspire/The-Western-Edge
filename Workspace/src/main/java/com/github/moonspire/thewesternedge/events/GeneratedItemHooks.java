package com.github.moonspire.thewesternedge.events;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.lang.reflect.InvocationTargetException;
@Mod.EventBusSubscriber
public class GeneratedItemHooks {
    private static final int USEDURATION = 20;
    @SubscribeEvent
    public static void OnEntityInteract(PlayerInteractEvent.EntityInteract event) {
        // Interprets interaction with entities to call "public int mobInteract(ItemStack itemstack, Entity entity, Player player)" in the item used in interaction.
        Player player = event.getPlayer();
        Entity target = event.getTarget();
        InteractionHand interactionhand = event.getHand();
        ItemStack itemstack = player.getItemInHand(interactionhand);
        Item item = itemstack.getItem();
        if (!player.getCooldowns().isOnCooldown(item)) {
            try {
                Object[] args = new Object[3];
                args[0] = interactionhand;
                args[1] = target;
                args[2] = player;
                int itemCooldownModifier = (int) item.getClass().getMethod("mobInteract", new Class[]{InteractionHand.class, Entity.class, Player.class}).invoke(item, args);
                if (itemstack.getUseDuration() + itemCooldownModifier > USEDURATION) {
                    player.getCooldowns().addCooldown(item, itemstack.getUseDuration() + itemCooldownModifier);
                } else {
                    player.getCooldowns().addCooldown(item, USEDURATION);
                }
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException e) {
                System.out.println("No 'mobInteract' method found, skipping action");
            }
        }
    }
}
