package net.ironhorsedevgroup.mods.thewesternedge.block.wallmarkings;

import net.ironhorsedevgroup.mods.thewesternedge.init.TWEBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WallMarkingBlock extends Block implements SimpleWaterloggedBlock{
    public static final DirectionProperty FACING = DirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<WallMarkingMaterials> MATERIAL = TWEBlockStateProperties.MATERIAL;
    public static final EnumProperty<WallMarkingTypes> TEXTURE = TWEBlockStateProperties.TEXTURE;

    public WallMarkingBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false)
                .setValue(MATERIAL, WallMarkingMaterials.PLANKS).setValue(TEXTURE, WallMarkingTypes.MEDICAL));
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return state.getFluidState().isEmpty();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Vec3 offset = state.getOffset(world, pos);
        switch ((Direction) state.getValue(FACING)) {
            case SOUTH :
            default :
                return box(0, 0, 0, 16, 16, 1).move(offset.x, offset.y, offset.z);
            case NORTH :
                return box(0, 0, 15, 16, 16, 16).move(offset.x, offset.y, offset.z);
            case EAST :
                return box(0, 0, 0, 1, 16, 16).move(offset.x, offset.y, offset.z);
            case WEST :
                return box(15, 0, 0, 16, 16, 16).move(offset.x, offset.y, offset.z);
            case UP :
                return box(0, 0, 0, 16, 1, 16).move(offset.x, offset.y, offset.z);
            case DOWN :
                return box(0, 15, 0, 16, 16, 16).move(offset.x, offset.y, offset.z);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, MATERIAL, TEXTURE);
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction facing = context.getClickedFace();
        boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;;
        return this.defaultBlockState().setValue(FACING, facing).setValue(WATERLOGGED, flag);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos,
                                  BlockPos facingPos) {
        if (state.getValue(WATERLOGGED)) {
            world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }
        return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
    }
}
