package net.ironhorsedevgroup.mods.thewesternedge.mixin;

import net.ironhorsedevgroup.mods.thewesternedge.item.bottles.BottleUtils;
import net.ironhorsedevgroup.mods.thewesternedge.item.bottles.BottleVariants;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;

@Mixin(PotionItem.class)
public class PotionItemMixins {

	@Inject(at = @At("HEAD"), method = "use(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/InteractionHand;)Lnet/minecraft/world/InteractionResultHolder;", cancellable = true)
	public void use(Level level, Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResultHolder<ItemStack>> callback) {
		ItemStack itemStack = BottleUtils.use(level, player, hand);
		if (itemStack != null) {
			callback.setReturnValue(InteractionResultHolder.pass(itemStack));
		}
	}

	@Inject(at = @At("HEAD"), method = "finishUsingItem(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/LivingEntity;)Lnet/minecraft/world/item/ItemStack;", cancellable = true)
	public void finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity, CallbackInfoReturnable<ItemStack> callback) {
		if (BottleUtils.getBottle(itemStack) != BottleVariants.POTION_BOTTLE || BottleUtils.getAmount(itemStack) != 1) {
			callback.setReturnValue(BottleUtils.useBottleItem(itemStack, level, livingEntity));
		}
	}

	@Inject(at = @At("RETURN"), method = "getDescriptionId(Lnet/minecraft/world/item/ItemStack;)Ljava/lang/String;", cancellable = true)
	public void getDescriptionId(ItemStack itemStack, CallbackInfoReturnable<String> callback) {
		String name = BottleUtils.getName(itemStack);
		if (name != itemStack.getItem().getDescriptionId()) {
			callback.setReturnValue(name);
		} else {
			callback.setReturnValue(callback.getReturnValue());
		}
	}
}
