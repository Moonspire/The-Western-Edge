package net.ironhorsedevgroup.mods.thewesternedge.block;

import net.ironhorsedevgroup.mods.thewesternedge.TWEUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.common.BiomeDictionary;

public abstract class AbstractRainBarrelBlock extends AbstractWaterCollector{
    public AbstractRainBarrelBlock(BlockBehaviour.Properties blockproperties) {
        super(blockproperties);
    }

    @Override
    public void addWaterToBlock(Level world, BlockPos pos, double amount) {
        if (world.isRaining() && world.canSeeSky(pos)) {
            if (TWEUtils.isBiomeOfType(world, BiomeDictionary.Type.WET, pos)) {
                amount = amount * 2;
            } else if (TWEUtils.isBiomeOfType(world, BiomeDictionary.Type.DRY, pos)) {
                amount = amount * 0.4;
            }
            TWEUtils.addFluid(world, pos, 1, (int) amount);
        }
    }
}
