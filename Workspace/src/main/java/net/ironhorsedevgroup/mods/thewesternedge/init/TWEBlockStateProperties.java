package net.ironhorsedevgroup.mods.thewesternedge.init;

import net.ironhorsedevgroup.mods.thewesternedge.block.wallmarkings.WallMarkingMaterials;
import net.ironhorsedevgroup.mods.thewesternedge.block.wallmarkings.WallMarkingTypes;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class TWEBlockStateProperties {
    public static final EnumProperty<WallMarkingMaterials> MATERIAL = EnumProperty.create("material", WallMarkingMaterials.class);
    public static final EnumProperty<WallMarkingTypes> TEXTURE = EnumProperty.create("texture", WallMarkingTypes.class);
}
