package com.github.moonspire.thewesternedge.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.minecraft.world.item.alchemy.Potion;
import java.util.List;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.TextComponent;

@Mixin(Item.class)
public class ItemAddPotionHitEffect {
	@Inject(at = @At("HEAD"), method = "hurtEnemy(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/entity/LivingEntity;)Z", cancellable = true, remap = false)
	public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity, CallbackInfoReturnable<Boolean> callback) {
    	if (itemstack.getItem() == Items.POTION) {
    		if (sourceentity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("Message"), (false));
    		Potion potion = PotionUtils.getPotion(itemstack);
	   		List<MobEffectInstance> list = PotionUtils.getMobEffects(itemstack);
     		boolean flag = potion == Potions.WATER && list.isEmpty();
     		if (!list.isEmpty() && !flag) {
        	   	this.makeAreaOfEffectCloud(itemstack, potion, 1.0F, 1.0F, 10, sourceentity, entity);
     		}
     		
     		int i = potion.hasInstantEffects() ? 2007 : 2002;
     		entity.level.levelEvent(i, entity.blockPosition(), PotionUtils.getColor(itemstack));
     		callback.setReturnValue(true);
    	}
	}

	public void makeAreaOfEffectCloud(ItemStack itemstack, Potion potion, float rad, float useRad, int waitTime, LivingEntity srcEntity, LivingEntity entity) {
      AreaEffectCloud areaeffectcloud = new AreaEffectCloud(entity.level, entity.getX(), entity.getY(), entity.getZ());
      
      areaeffectcloud.setRadius(rad);
      areaeffectcloud.setRadiusOnUse(useRad);
      areaeffectcloud.setWaitTime(waitTime);
      areaeffectcloud.setRadiusPerTick(-areaeffectcloud.getRadius() / (float)areaeffectcloud.getDuration());
      areaeffectcloud.setPotion(potion);

      for(MobEffectInstance mobeffectinstance : PotionUtils.getCustomEffects(itemstack)) {
         areaeffectcloud.addEffect(new MobEffectInstance(mobeffectinstance));
      }

      CompoundTag compoundtag = itemstack.getTag();
      if (compoundtag != null && compoundtag.contains("CustomPotionColor", 99)) {
         areaeffectcloud.setFixedColor(compoundtag.getInt("CustomPotionColor"));
      }

      srcEntity.level.addFreshEntity(areaeffectcloud);
   }
}