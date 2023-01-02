
package net.ironhorsedevgroup.mods.thewesternedge.item;

import net.ironhorsedevgroup.mods.thewesternedge.item.bottles.BottleUtils;
import net.ironhorsedevgroup.mods.thewesternedge.init.TWETabs;
import net.ironhorsedevgroup.mods.thewesternedge.item.bottles.BottleVariants;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.entity.EquipmentSlot;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class BrokenBottleItem extends SwordItem {
	public BrokenBottleItem() {
		super(Tiers.WOOD, 2, -3.0F, new Item.Properties().tab(TWETabs.TAB_TWE_BOTTLES).durability(3).rarity(Rarity.COMMON));
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

	@Override
	public void fillItemCategory(CreativeModeTab tab, NonNullList<ItemStack> itemStack) {
		if (this.allowdedIn(tab)) {
			for (BottleVariants bottle : BottleVariants.values()) {
				ItemStack newStack = new ItemStack(Items.GLASS_BOTTLE);
				BottleUtils.setBottle(newStack, bottle);
				itemStack.add(newStack);
				if (BottleUtils.isBreakable(newStack) && BottleUtils.isLabeled(newStack)) {
					itemStack.add(BottleUtils.createBrokenCopy(newStack));
				}
			}
		}
	}
}
