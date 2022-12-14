package net.ironhorsedevgroup.mods.thewesternedge.mixin;

import net.ironhorsedevgroup.mods.thewesternedge.TheWesternEdgeMod;
import net.ironhorsedevgroup.mods.thewesternedge.item.bottles.BottleUtils;
import net.ironhorsedevgroup.mods.thewesternedge.item.bottles.BottleVariants;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;


@Mixin(ItemUtils.class)
public class ItemUtilsMixins {
	@Inject(at = @At("HEAD"), method = "createFilledResult(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/item/ItemStack;Z)Lnet/minecraft/world/item/ItemStack;", cancellable = true)
	private static void createFilledResult(ItemStack originStack, Player player, ItemStack newItem, boolean boolFlag, CallbackInfoReturnable<ItemStack> callback) {
		if (newItem.getItem() == Items.POTION  && BottleUtils.getBottle(originStack) != BottleVariants.POTION_BOTTLE) {
			newItem = BottleUtils.addPotion(originStack, PotionUtils.getPotion(newItem));
			boolean flag = player.getAbilities().instabuild;
      		if (boolFlag && flag) {
         		if (!player.getInventory().contains(newItem)) {
            		player.getInventory().add(newItem);
         		}

        		callback.setReturnValue(originStack);
      		} else {
				player.displayClientMessage(new TextComponent(I18n.get("misc." + TheWesternEdgeMod.MODID + ".serving_name") + ": " + BottleUtils.getAmount(newItem)), (true));
				if (!flag) {
            		originStack.shrink(1);
         		}

         		if (originStack.isEmpty()) {
            		callback.setReturnValue(newItem);
         		} else {
            		if (!player.getInventory().add(newItem)) {
               			player.drop(newItem, false);
            		}

            		callback.setReturnValue(originStack);
         		}
      		}
   		} else if (newItem.getItem() == Items.GLASS_BOTTLE  && BottleUtils.getBottle(originStack) != BottleVariants.POTION_BOTTLE && PotionUtils.getPotion(originStack) == Potions.WATER) {
			if (!player.getAbilities().instabuild) {
				newItem = BottleUtils.drainAmount(originStack, 1.0);
				player.displayClientMessage(new TextComponent(I18n.get("misc." + TheWesternEdgeMod.MODID + ".serving_name") + ": " + BottleUtils.getAmount(newItem)), (true));
				callback.setReturnValue(newItem);
			} else if (!player.getInventory().contains(newItem)) {
				newItem = BottleUtils.createEmptyCopy(originStack);
				player.getInventory().add(newItem);
			}
		}
	}
}