package net.ironhorsedevgroup.mods.thewesternedge.procedures;

import net.ironhorsedevgroup.mods.thewesternedge.init.ThewesternedgeModBlocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class WellShaftBreakLadderProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(new BlockPos(x, y, z), ThewesternedgeModBlocks.WELL_SHAFT.get().defaultBlockState(), 3);
	}
}
