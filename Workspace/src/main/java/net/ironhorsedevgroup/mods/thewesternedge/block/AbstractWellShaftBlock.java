package net.ironhorsedevgroup.mods.thewesternedge.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public abstract class AbstractWellShaftBlock extends Block implements SimpleWaterloggedBlock {
    public AbstractWellShaftBlock(BlockBehaviour.Properties blockproperties) {
        super(blockproperties);
    }
}
