
package com.github.moonspire.thewesternedge.item;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;

import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap;

import com.github.moonspire.thewesternedge.init.ThewesternedgeModTabs;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class BrokenBottleItem extends SwordItem {
	public BrokenBottleItem() {
		super(Tiers.WOOD, 2, -3.0F, new Item.Properties().tab(ThewesternedgeModTabs.TAB_TWE_ALCOHOLS).durability(3).rarity(Rarity.COMMON));
	}
	@Override
	public boolean canAttackBlock(BlockState block, Level level, BlockPos pos, Player player) {
		if (!player.isCreative()) {
			hurtSelf(player.getMainHandItem(), player);
		}
		return false;
	}
	@Override
	public float getDestroySpeed(ItemStack item, BlockState block) {
		return 1000.0F;
	}
	@Override
	public boolean canPerformAction(ItemStack stack, net.minecraftforge.common.ToolAction toolAction) {
		return false;
	}
	public void hurtSelf(ItemStack item, Player player) {
		item.hurtAndBreak(item.getMaxDamage(),player, (player1) -> {
			player1.broadcastBreakEvent(EquipmentSlot.MAINHAND);
		});
		player.hurt(DamageSource.playerAttack(player),3);
	}
}
