package net.ironhorsedevgroup.mods.thewesternedge.mixin;

import net.ironhorsedevgroup.mods.thewesternedge.TWEUtils;
import net.ironhorsedevgroup.mods.thewesternedge.TheWesternEdgeMod;
import net.ironhorsedevgroup.mods.thewesternedge.item.drinks.BottleUtils;
import net.ironhorsedevgroup.mods.thewesternedge.item.drinks.BottleVariants;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
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
		ItemStack itemStack = player.getItemInHand(hand);
		HitResult hitresult = TWEUtils.getPlayerPOVHitResult(level, player, ClipContext.Fluid.SOURCE_ONLY);
		if (hitresult.getType() == HitResult.Type.BLOCK) {
			BlockPos blockpos = ((BlockHitResult)hitresult).getBlockPos();
			if (level.mayInteract(player, blockpos) && level.getFluidState(blockpos).is(FluidTags.WATER)) {
				if (BottleUtils.getAmount(itemStack) < BottleUtils.getBottleSize(itemStack)) {
					level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BOTTLE_FILL, SoundSource.NEUTRAL, 1.0F, 1.0F);
					level.gameEvent(player, GameEvent.FLUID_PICKUP, blockpos);
					itemStack = BottleUtils.addPotion(itemStack, Potions.WATER);
					player.displayClientMessage(new TextComponent(I18n.get("misc." + TheWesternEdgeMod.MODID + ".serving_name") + ": " + BottleUtils.getAmount(itemStack)), (true));
					callback.setReturnValue(InteractionResultHolder.pass(itemStack));
				}
			}
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
