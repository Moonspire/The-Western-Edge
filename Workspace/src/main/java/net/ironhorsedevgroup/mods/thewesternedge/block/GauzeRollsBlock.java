
package net.ironhorsedevgroup.mods.thewesternedge.block;

import net.ironhorsedevgroup.mods.thewesternedge.TWEUtils;
import net.ironhorsedevgroup.mods.thewesternedge.init.TWEBlocks;
import net.ironhorsedevgroup.mods.thewesternedge.init.TWEItems;
import net.ironhorsedevgroup.mods.thewesternedge.item.AbstractBandageItem;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.Containers;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import java.util.List;
import java.util.Collections;

import net.ironhorsedevgroup.mods.thewesternedge.block.entity.GauzeRollsBlockEntity;

public class GauzeRollsBlock extends Block implements SimpleWaterloggedBlock, EntityBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public GauzeRollsBlock() {
		super(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOL).strength(1f).noCollission().noOcclusion()
				.isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
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
				return box(0, 0, 0, 16, 8, 16).move(offset.x, offset.y, offset.z);
			case NORTH :
				return box(0, 0, 0, 16, 8, 16).move(offset.x, offset.y, offset.z);
			case EAST :
				return box(0, 0, 0, 16, 8, 16).move(offset.x, offset.y, offset.z);
			case WEST :
				return box(0, 0, 0, 16, 8, 16).move(offset.x, offset.y, offset.z);
		}
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, WATERLOGGED);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;;
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, flag);
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

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(TWEItems.GAUZE_STRIP.get(), 8));
	}

	@Override
	public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
		super.use(blockstate, world, pos, entity, hand, hit);
		ItemStack itemstack = entity.getItemInHand(hand);
		if (TWEUtils.getItemStack(world, pos, 0) == ItemStack.EMPTY) {
			return insertNewItem(entity, hand, world, pos);
		} else if (TWEUtils.isItemInSlotOf(world, pos, 0, itemstack)) {
			return addToItemStack(entity, hand, world, pos);
		} else if (entity.isCrouching()){
			return removeFromItemStack(entity, hand, world, pos);
		} else {
			return useBandageStack(entity, hand, world, pos);
		}
	}

	private InteractionResult insertNewItem(Player player, InteractionHand hand, Level world, BlockPos pos) {
		ItemStack itemstack = player.getItemInHand(hand);
		if (itemstack.getItem() instanceof AbstractBandageItem bandageitem) {
			if (!player.getAbilities().instabuild) {
				itemstack.shrink(1);
			}
			TWEUtils.setItemStackInSlot(world, pos, 0, new ItemStack(bandageitem));
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}

	private InteractionResult addToItemStack(Player player, InteractionHand hand, Level world, BlockPos pos) {
		ItemStack itemstack = player.getItemInHand(hand);
		if (TWEUtils.getSlotAmount(world, pos, 0) < TWEUtils.getSlotMaxStackSize(world, pos, 0)) {
			if (!player.getAbilities().instabuild) {
				itemstack.shrink(1);
			}
			TWEUtils.growStackInSlot(world, pos, 0, 1);
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}

	private InteractionResult removeFromItemStack(Player player, InteractionHand hand, Level world, BlockPos pos) {
		ItemStack itemstack = player.getItemInHand(hand);
		if (TWEUtils.getSlotAmount(world, pos, 0) > 0) {
			player.addItem(new ItemStack(TWEUtils.getItemStack(world, pos, 0).getItem()));
			TWEUtils.shrinkStackInSlot(world, pos, 0, 1);
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}

	private InteractionResult useBandageStack(Player player, InteractionHand hand, Level world, BlockPos pos) {
		ItemStack itemstack = TWEUtils.getItemStack(world, pos, 0);
		if (itemstack.getItem() instanceof AbstractBandageItem bandageitem) {
			bandageitem.applyGauzeStripEffect(player, itemstack, 0, bandageitem.getStrength() + 1, bandageitem.getEffectDuration() / 2, bandageitem.getMobEffect());
			TWEUtils.shrinkStackInSlot(world, pos, 0, 1);
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new GauzeRollsBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof GauzeRollsBlockEntity be) {
				Containers.dropContents(world, pos, be);
				world.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, world, pos, newState, isMoving);
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static void registerRenderLayer() {
		ItemBlockRenderTypes.setRenderLayer(TWEBlocks.GAUZE_ROLLS.get(), renderType -> renderType == RenderType.cutout());
	}

}
