package net.ironhorsedevgroup.mods.thewesternedge.events;

import net.ironhorsedevgroup.mods.thewesternedge.init.TWEItems;
import net.ironhorsedevgroup.mods.thewesternedge.item.ItemRightClickTrigger;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.SuspiciousStewRecipe;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.awt.*;
import java.rmi.registry.RegistryHandler;

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
            int itemCooldownModifier = 0;
            if (item instanceof ItemRightClickTrigger itemrct) {
                itemCooldownModifier = itemrct.mobInteract(interactionhand, target, player);
                if (itemstack.getUseDuration() + itemCooldownModifier > USEDURATION) {
                    player.getCooldowns().addCooldown(item, itemstack.getUseDuration() + itemCooldownModifier);
                } else {
                    player.getCooldowns().addCooldown(item, USEDURATION);
                }
            }
        }
    }
}
