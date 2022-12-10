package net.ironhorsedevgroup.mods.thewesternedge.world.features;

import com.mojang.serialization.Codec;
import net.ironhorsedevgroup.mods.thewesternedge.init.TWEBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.Random;

public class BushesGeneration extends Feature<NoneFeatureConfiguration> {
    public BushesGeneration(Codec<NoneFeatureConfiguration> featureCodec) {
        super(featureCodec);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featureContext) {
        int i = 0;
        WorldGenLevel worldgenlevel = featureContext.level();
        BlockPos blockpos = featureContext.origin();
        Random random = featureContext.random();
        int j = worldgenlevel.getHeight(Heightmap.Types.WORLD_SURFACE, blockpos.getX(), blockpos.getZ());
        BlockPos blockpos1 = new BlockPos(blockpos.getX(), j, blockpos.getZ());
        if (worldgenlevel.getBlockState(blockpos1).is(Blocks.AIR)) {
            BlockState blockstate = TWEBlocks.BERRY_BUSH.get().defaultBlockState();
        }

        return i > 0;
    }
}
