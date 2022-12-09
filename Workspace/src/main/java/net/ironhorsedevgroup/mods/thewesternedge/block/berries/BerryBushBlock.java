package net.ironhorsedevgroup.mods.thewesternedge.block.berries;

import net.ironhorsedevgroup.mods.thewesternedge.init.TWEBlockStateProperties;
import net.ironhorsedevgroup.mods.thewesternedge.init.TWEItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
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
    public ItemStack getCloneItemStack(BlockGetter p_57256_, BlockPos p_57257_, BlockState p_57258_) {
        return new ItemStack(Items.SWEET_BERRIES);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context){
        ItemStack stack = context.getItemInHand();
        if (stack != null) {
            Item item = stack.getItem();
            if (item == TWEItems.AMBER_BERRIES.get()) {
                return this.defaultBlockState().setValue(BERRY_TYPE, BerryType.AMBER).setValue(AGE, 3);
            } else if (item == TWEItems.INDIGO_BERRIES.get()) {
                return this.defaultBlockState().setValue(BERRY_TYPE, BerryType.INDIGO).setValue(AGE, 3);
            } else if (item == TWEItems.JADE_BERRIES.get()) {
                return this.defaultBlockState().setValue(BERRY_TYPE, BerryType.JADE).setValue(AGE, 3);
            } else if (item == TWEItems.MAUVE_BERRIES.get()) {
                return this.defaultBlockState().setValue(BERRY_TYPE, BerryType.MAUVE).setValue(AGE, 3);
            } else if (item == TWEItems.RUSSET_BERRIES.get()) {
                return this.defaultBlockState().setValue(BERRY_TYPE, BerryType.RUSSET).setValue(AGE, 3);
            } else if (item == TWEItems.TEAL_BERRIES.get()) {
                return this.defaultBlockState().setValue(BERRY_TYPE, BerryType.TEAL).setValue(AGE, 3);
            } else if (item == TWEItems.VERMILLION_BERRIES.get()) {
                return this.defaultBlockState().setValue(BERRY_TYPE, BerryType.VERMILLION).setValue(AGE, 3);
            }
        }
        return this.defaultBlockState();
    }
}
