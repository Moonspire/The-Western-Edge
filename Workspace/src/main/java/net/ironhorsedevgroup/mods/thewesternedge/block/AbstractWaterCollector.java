package net.ironhorsedevgroup.mods.thewesternedge.block;

import net.ironhorsedevgroup.mods.thewesternedge.TWEUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class AbstractWaterCollector extends Block {
    public AbstractWaterCollector(BlockBehaviour.Properties blockproperties) {
        super(blockproperties);
    }

    public void addWaterToBlock(Level world, BlockPos pos, double amount) {
    }

    @Override
    public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
        super.use(blockstate, world, pos, entity, hand, hit);

        if (TWEUtils.drawFluid(world, hand, entity, pos, 1)) {
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}
