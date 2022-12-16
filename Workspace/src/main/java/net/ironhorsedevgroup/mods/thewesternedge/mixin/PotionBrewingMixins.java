package net.ironhorsedevgroup.mods.thewesternedge.mixin;

import net.ironhorsedevgroup.mods.thewesternedge.TWEUtils;
import net.ironhorsedevgroup.mods.thewesternedge.item.drinks.BottleUtils;
import net.ironhorsedevgroup.mods.thewesternedge.item.drinks.BottleVariants;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.ItemStack;

@Mixin(PotionBrewing.class)
public class PotionBrewingMixins {
	@Inject(at = @At("RETURN"), method = "mix(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemStack;)Lnet/minecraft/world/item/ItemStack;", cancellable = true)
	private static void mix(ItemStack ingredient, ItemStack potion, CallbackInfoReturnable<ItemStack> callback) {
    	if (BottleUtils.getBottle(potion) != BottleVariants.POTION_BOTTLE) {
    		ItemStack retPot = callback.getReturnValue();
    		BottleUtils.copyBottleProperties(potion, retPot);
			TWEUtils.putDoubleTag(retPot, "Servings", BottleUtils.getAmount(potion));
	    	callback.setReturnValue(retPot);
	    } else {
	    	callback.setReturnValue(callback.getReturnValue());
	    }
	}
}