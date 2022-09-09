package net.ironhorsedevgroup.mods.thewesternedge.block.wallmarkings;

import net.minecraft.util.StringRepresentable;

public enum WallMarkingTypes implements StringRepresentable {
    MEDICAL("medical"),
    ADVERT1("advert_1");

    private final String name;

    private WallMarkingTypes(String str) {
        this.name = str;
    }

    public String getSerializedName() {
        return this.name;
    }
}
