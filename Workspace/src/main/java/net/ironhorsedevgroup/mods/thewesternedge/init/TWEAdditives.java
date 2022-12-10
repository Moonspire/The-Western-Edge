package net.ironhorsedevgroup.mods.thewesternedge.init;

import net.minecraft.util.StringRepresentable;

public enum TWEAdditives implements StringRepresentable {
    EMPTY("empty"),
    BERRIES("berries");

    private final String name;

    private TWEAdditives(String str) {
        this.name = str;
    }

    public String getSerializedName() {
        return this.name;
    }
}
