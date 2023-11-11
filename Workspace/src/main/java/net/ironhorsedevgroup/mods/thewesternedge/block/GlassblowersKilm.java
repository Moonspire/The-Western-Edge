package net.ironhorsedevgroup.mods.thewesternedge.block;

import net.ironhorsedevgroup.mods.thewesternedge.block.entity.BrewersBarrelBlockEntity;
import net.ironhorsedevgroup.mods.thewesternedge.block.entity.GlassblowersKilmEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;

public class GlassblowersKilm extends Block implements EntityBlock {
    public static final DirectionProperty FACING = DirectionalBlock.FACING;

    public GlassblowersKilm() {
        super(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(2f, 3f));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new GlassblowersKilmEntity(pos, state);
    }
}
