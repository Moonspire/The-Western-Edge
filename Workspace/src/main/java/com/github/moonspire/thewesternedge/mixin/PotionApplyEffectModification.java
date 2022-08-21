package com.github.moonspire.thewesternedge.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.stats.Stats;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.level.gameevent.GameEvent;

@Mixin(PotionItem.class)
public class PotionApplyEffectModification {
	@Inject(at = @At("HEAD"), method = "finishUsingItem(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/LivingEntity;)Lnet/minecraft/world/item/ItemStack;", cancellable = true)
	public void finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity, CallbackInfoReturnable<ItemStack> callback) {
		if (itemStack.getOrCreateTag().getDouble("CustomModelData") != 0) {
			ItemStack emptyBottle = new ItemStack(Items.GLASS_BOTTLE);
			emptyBottle.getOrCreateTag().putDouble("CustomModelData", itemStack.getOrCreateTag().getDouble("CustomModelData"));
			Player player = livingEntity instanceof Player ? (Player)livingEntity : null;
			if (player instanceof ServerPlayer) {
			 CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, itemStack);
			}
			
			if (!level.isClientSide) {
			 for(MobEffectInstance mobeffectinstance : PotionUtils.getMobEffects(itemStack)) {
			    if (mobeffectinstance.getEffect().isInstantenous()) {
			       mobeffectinstance.getEffect().applyInstantenousEffect(player, player, livingEntity, mobeffectinstance.getAmplifier(), 1.0D);
			    } else {
			       livingEntity.addEffect(new MobEffectInstance(mobeffectinstance));
			    }
			 }
			}
			
			if (player != null) {
			 player.awardStat(Stats.ITEM_USED.get((PotionItem)(Object)this));
			 if (!player.getAbilities().instabuild) {
			    itemStack.shrink(1);
			 }
			}
			
			if (player == null || !player.getAbilities().instabuild) {
			 if (itemStack.isEmpty()) {
			    callback.setReturnValue(emptyBottle);
			 }
			
			 if (player != null) {
			    player.getInventory().add(emptyBottle);
			 }
			}
			
			level.gameEvent(livingEntity, GameEvent.DRINKING_FINISH, livingEntity.eyeBlockPosition());
			callback.setReturnValue(itemStack);
		}
	}
}
