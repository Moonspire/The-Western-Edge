
package net.ironhorsedevgroup.mods.thewesternedge.item;

import net.ironhorsedevgroup.mods.thewesternedge.init.TWETabs;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;

public class GauzeStripItem extends AbstractBandageItem {
	public GauzeStripItem() {
		super(new Item.Properties().tab(TWETabs.TAB_TWE_SURVIVAL).stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public int getEffectDuration() {
		return 240;
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.DRINK;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return this.getUseDuration();
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		return ItemUtils.startUsingInstantly(world, entity, hand);
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		return this.applyGauzeStripEffect(entity, itemstack, this.getCooldown(), this.getStrength(), this.getEffectDuration(), this.getMobEffect());
	}

	@Override
	public int mobInteract(InteractionHand hand, Entity entity, Player player) {
		if (entity instanceof LivingEntity livingentity) {
			ItemStack itemstack = player.getItemInHand(hand);
			this.applyGauzeStripEffect(livingentity, itemstack, this.getCooldown(), this.getStrength(), this.getEffectDuration(), this.getMobEffect());
			return this.getCooldown();
		} else {
			return 0;
		}
	}
}
