package net.ironhorsedevgroup.mods.thewesternedge.block;

import net.ironhorsedevgroup.mods.thewesternedge.TWEUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.BiomeDictionary;

public class AbstractWellBlock extends AbstractWaterCollector {
    public AbstractWellBlock(BlockBehaviour.Properties blockproperties) {
        super(blockproperties);
    }

    @Override
    public void addWaterToBlock(Level world, BlockPos pos, double amount) {
        int depth = getWellDepth(world, pos);
        amount = amount * Math.pow(2, Math.pow(depth - 32, 2) / (-400));
        if (TWEUtils.isBiomeOfType(world, BiomeDictionary.Type.WET, pos.below(depth))) {
            amount = amount * 2;
        } else if (TWEUtils.isBiomeOfType(world, BiomeDictionary.Type.DRY, pos.below(depth))) {
            amount = amount * 0.4;
        }
        TWEUtils.addFluid(world, pos, 1, (int) amount);
    }

    private int getWellDepth(LevelAccessor world, BlockPos pos) {
        int depth = 1;
        boolean isShaft = true;
        while (isShaft) {
            if (world.getBlockState(pos.below(depth)).getBlock() instanceof AbstractWellShaftBlock) {
                depth = depth + 1;
            } else {
                depth = depth - 1;
                isShaft = false;
            }
        }
        return depth;
    }
}
