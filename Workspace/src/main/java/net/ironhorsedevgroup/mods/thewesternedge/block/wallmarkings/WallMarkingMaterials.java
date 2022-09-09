package net.ironhorsedevgroup.mods.thewesternedge.block.wallmarkings;

import net.minecraft.util.StringRepresentable;

public enum WallMarkingMaterials implements StringRepresentable {
    PLANKS("planks"),
    COBBLESTONE("cobblestone"),
    STONE("stone"),
    LOG("log"),
    WOOL("wool"),
    MISC("misc");

    private final String name;

    private WallMarkingMaterials(String str) {
        this.name = str;
    }

    public String getSerializedName() {
        return this.name;
    }
}
