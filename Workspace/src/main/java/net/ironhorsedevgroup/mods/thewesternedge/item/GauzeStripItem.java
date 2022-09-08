
package net.ironhorsedevgroup.mods.thewesternedge.item;

import net.ironhorsedevgroup.mods.thewesternedge.init.TWEMobEffects;
import net.ironhorsedevgroup.mods.thewesternedge.init.TWETabs;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;

public class GauzeStripItem extends Item implements ItemRightClickTrigger {
	private final static int COOLDOWN = 300;
	private final static int STRENGTH = 0;
	private final static int USEDURATION = 64;
	private final static int EFFECTDURATION = 240;
	public GauzeStripItem() {
		super(new Item.Properties().tab(TWETabs.TAB_TWE_SURVIVAL).stacksTo(64).rarity(Rarity.COMMON));
	}

	public ItemStack applyGauzeStripEffect(LivingEntity entity, ItemStack itemstack, int cooldown) {
		itemstack.shrink(1);
		if (entity instanceof Player player) {
			Item item = itemstack.getItem();
			player.getCooldowns().addCooldown(item, (cooldown + item.getUseDuration(itemstack)));
		}
		entity.addEffect(new MobEffectInstance(TWEMobEffects.BANDAGES_EFFECT.get(), EFFECTDURATION, STRENGTH));
		return itemstack;
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.DRINK;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return USEDURATION;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		return ItemUtils.startUsingInstantly(world, entity, hand);
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		return this.applyGauzeStripEffect(entity, itemstack, COOLDOWN);
	}

	public int mobInteract(InteractionHand hand, Entity entity, Player player) {
		if (entity instanceof LivingEntity livingentity) {
			ItemStack itemstack = player.getItemInHand(hand);
			this.applyGauzeStripEffect(livingentity, itemstack, COOLDOWN);
			return COOLDOWN;
		} else {
			return 0;
		}
	}
}
