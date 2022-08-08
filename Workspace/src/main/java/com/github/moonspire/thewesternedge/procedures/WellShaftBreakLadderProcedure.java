package com.github.moonspire.thewesternedge.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import com.github.moonspire.thewesternedge.init.ThewesternedgeModBlocks;

public class WellShaftBreakLadderProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(new BlockPos(x, y, z), ThewesternedgeModBlocks.WELL_SHAFT.get().defaultBlockState(), 3);
	}
}
