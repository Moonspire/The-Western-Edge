package net.ironhorsedevgroup.mods.thewesternedge.mixin;

import net.ironhorsedevgroup.mods.thewesternedge.TWEUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;


@Mixin(ItemUtils.class)
public class CreateFilledResultReplacement {
	@Inject(at = @At("HEAD"), method = "createFilledResult(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/item/ItemStack;Z)Lnet/minecraft/world/item/ItemStack;", cancellable = true)
	private static void createFilledResult(ItemStack originStack, Player player, ItemStack newItem, boolean boolFlag, CallbackInfoReturnable<ItemStack> callback) {
		if (TWEUtils.getDoubleTag(originStack, "CustomModelData") != 0) {
	  		newItem.getOrCreateTag().putDouble("CustomModelData", originStack.getOrCreateTag().getDouble("CustomModelData"));
      		boolean flag = player.getAbilities().instabuild;
      		if (boolFlag && flag) {
         		if (!player.getInventory().contains(newItem)) {
            		player.getInventory().add(newItem);
         		}

        		callback.setReturnValue(originStack);
      		} else {
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
   		}
	}
}