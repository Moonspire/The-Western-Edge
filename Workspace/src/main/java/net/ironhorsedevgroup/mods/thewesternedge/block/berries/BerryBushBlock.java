package net.ironhorsedevgroup.mods.thewesternedge.block.berries;

import net.ironhorsedevgroup.mods.thewesternedge.init.TWEBlockStateProperties;
import net.ironhorsedevgroup.mods.thewesternedge.init.TWEItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class BerryBushBlock extends SweetBerryBushBlock {
    public static final EnumProperty<BerryType> BERRY_TYPE = TWEBlockStateProperties.BERRY_TYPE;
    public BerryBushBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(BERRY_TYPE, BerryType.AMBER));
    }

    @Override
    public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
        if (entity instanceof LivingEntity && entity.getType() != EntityType.FOX && entity.getType() != EntityType.BEE) {
            entity.makeStuckInBlock(blockState, new Vec3((double)0.8F, 0.75D, (double)0.8F));
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BERRY_TYPE);
        super.createBlockStateDefinition(builder);
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState) {
        return new ItemStack(getBerryItem(blockState));
    }

    public Item getBerryItem(BlockState blockState) {
        Item item = TWEItems.AMBER_BERRIES.get();
        BerryType berry = blockState.getValue(BERRY_TYPE);
        if (berry == BerryType.INDIGO) {
            item = TWEItems.INDIGO_BERRIES.get();
        } else if (berry == BerryType.JADE) {
            item = TWEItems.JADE_BERRIES.get();
        } else if (berry == BerryType.MAUVE) {
            item = TWEItems.MAUVE_BERRIES.get();
        } else if (berry == BerryType.RUSSET) {
            item = TWEItems.RUSSET_BERRIES.get();
        } else if (berry == BerryType.TEAL) {
            item = TWEItems.TEAL_BERRIES.get();
        } else if (berry == BerryType.VERMILLION) {
            item = TWEItems.VERMILLION_BERRIES.get();
        }
        return item;
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitPos) {
        int i = blockState.getValue(AGE);
        boolean flag = i == 3;
        if (!flag && player.getItemInHand(hand).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (i > 1) {
            int j = 1 + level.random.nextInt(2);
            popResource(level, blockPos, new ItemStack(getBerryItem(blockState), j + (flag ? 1 : 0)));
            level.playSound((Player)null, blockPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            level.setBlock(blockPos, blockState.setValue(AGE, Integer.valueOf(1)), 2);
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return super.use(blockState, level, blockPos, player, hand, hitPos);
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context){
        ItemStack stack = context.getItemInHand();
        if (stack != null) {
            Item item = stack.getItem();
            if (item == TWEItems.AMBER_BERRIES.get()) {
                return this.defaultBlockState().setValue(BERRY_TYPE, BerryType.AMBER).setValue(AGE, 0);
            } else if (item == TWEItems.INDIGO_BERRIES.get()) {
                return this.defaultBlockState().setValue(BERRY_TYPE, BerryType.INDIGO).setValue(AGE, 0);
            } else if (item == TWEItems.JADE_BERRIES.get()) {
                return this.defaultBlockState().setValue(BERRY_TYPE, BerryType.JADE).setValue(AGE, 0);
            } else if (item == TWEItems.MAUVE_BERRIES.get()) {
                return this.defaultBlockState().setValue(BERRY_TYPE, BerryType.MAUVE).setValue(AGE, 0);
            } else if (item == TWEItems.RUSSET_BERRIES.get()) {
                return this.defaultBlockState().setValue(BERRY_TYPE, BerryType.RUSSET).setValue(AGE, 0);
            } else if (item == TWEItems.TEAL_BERRIES.get()) {
                return this.defaultBlockState().setValue(BERRY_TYPE, BerryType.TEAL).setValue(AGE, 0);
            } else if (item == TWEItems.VERMILLION_BERRIES.get()) {
                return this.defaultBlockState().setValue(BERRY_TYPE, BerryType.VERMILLION).setValue(AGE, 0);
            }
        }
        return this.defaultBlockState();
    }
}
