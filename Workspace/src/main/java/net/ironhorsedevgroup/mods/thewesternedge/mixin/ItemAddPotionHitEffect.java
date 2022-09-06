package net.ironhorsedevgroup.mods.thewesternedge.mixin;

import net.ironhorsedevgroup.mods.thewesternedge.init.ThewesternedgeModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.item.Item;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionHand;

@Mixin(Item.class)
public class ItemAddPotionHitEffect {
	@Inject(at = @At("HEAD"), method = "hurtEnemy(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/entity/LivingEntity;)Z", cancellable = true)
	public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity, CallbackInfoReturnable<Boolean> callback) {
    	if (itemstack.getItem() == Items.POTION) {
    		Potion potion = PotionUtils.getPotion(itemstack);
	   		List<MobEffectInstance> list = PotionUtils.getMobEffects(itemstack);
     		boolean flag = potion == Potions.WATER && list.isEmpty();
     		if (!list.isEmpty() && !flag) {
        	   	this.makeAreaOfEffectCloud(itemstack, potion, 2.0F, 0.0F, 0, sourceentity, entity);
     		}
     		
     		int i = potion.hasInstantEffects() ? 2007 : 2002;
     		entity.level.levelEvent(i, entity.blockPosition(), PotionUtils.getColor(itemstack));
     		ItemStack _setstack = new ItemStack(ThewesternedgeModItems.BROKEN_BOTTLE.get());
			_setstack.setCount(1);
			_setstack.getOrCreateTag().putDouble("CustomModelData", itemstack.getOrCreateTag().getDouble("CustomModelData"));
			sourceentity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
			if (sourceentity instanceof Player _player)
				_player.getInventory().setChanged();
     		callback.setReturnValue(true);
    	}
	}

	public void makeAreaOfEffectCloud(ItemStack itemstack, Potion potion, float rad, float useRad, int waitTime, LivingEntity srcEntity, LivingEntity entity) {
      AreaEffectCloud areaeffectcloud = new AreaEffectCloud(entity.level, entity.getX(), entity.getY(), entity.getZ());
      
      areaeffectcloud.setRadius(rad);
      areaeffectcloud.setRadiusOnUse(useRad);
      areaeffectcloud.setWaitTime(waitTime);
      areaeffectcloud.setRadiusPerTick(0.0F);
	  areaeffectcloud.setDuration(40);
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