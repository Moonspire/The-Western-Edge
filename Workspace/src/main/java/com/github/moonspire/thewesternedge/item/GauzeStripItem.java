
package com.github.moonspire.thewesternedge.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

import com.github.moonspire.thewesternedge.procedures.GauzeStripApplyEffectProcedure;
import com.github.moonspire.thewesternedge.procedures.GauzeRollsRightClickedProcedure;
import com.github.moonspire.thewesternedge.init.ThewesternedgeModTabs;

public class GauzeStripItem extends Item {
	public GauzeStripItem() {
		super(new Item.Properties().tab(ThewesternedgeModTabs.TAB_TWE_SURVIVAL).stacksTo(64).rarity(Rarity.COMMON)
				.food((new FoodProperties.Builder()).nutrition(0).saturationMod(0.0f).alwaysEat()

						.build()));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.DRINK;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 64;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		GauzeStripApplyEffectProcedure.execute(entity, itemstack);
		return retval;
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		GauzeStripApplyEffectProcedure.execute(entity, itemstack);
		return retval;
	}
}
