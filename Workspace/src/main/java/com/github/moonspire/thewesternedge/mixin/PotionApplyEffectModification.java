package com.github.moonspire.thewesternedge.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
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
	@Overwrite(remap = false)
	public ItemStack finishUsingItem(ItemStack p_42984_, Level p_42985_, LivingEntity p_42986_) {
		ItemStack emptyBottle = new ItemStack(Items.GLASS_BOTTLE);
		emptyBottle.getOrCreateTag().putDouble("CustomModelData", p_42984_.getOrCreateTag().getDouble("CustomModelData"));
		Player player = p_42986_ instanceof Player ? (Player)p_42986_ : null;
		if (player instanceof ServerPlayer) {
		 CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, p_42984_);
		}
		
		if (!p_42985_.isClientSide) {
		 for(MobEffectInstance mobeffectinstance : PotionUtils.getMobEffects(p_42984_)) {
		    if (mobeffectinstance.getEffect().isInstantenous()) {
		       mobeffectinstance.getEffect().applyInstantenousEffect(player, player, p_42986_, mobeffectinstance.getAmplifier(), 1.0D);
		    } else {
		       p_42986_.addEffect(new MobEffectInstance(mobeffectinstance));
		    }
		 }
		}
		
		if (player != null) {
		 player.awardStat(Stats.ITEM_USED.get(p_42984_.getItem()));
		 if (!player.getAbilities().instabuild) {
		    p_42984_.shrink(1);
		 }
		}
		
		if (player == null || !player.getAbilities().instabuild) {
		 if (p_42984_.isEmpty()) {
		    return emptyBottle;
		 }
		
		 if (player != null) {
		    player.getInventory().add(emptyBottle);
		 }
		}
		
		p_42985_.gameEvent(p_42986_, GameEvent.DRINKING_FINISH, p_42986_.eyeBlockPosition());
		return p_42984_;
	}
}
