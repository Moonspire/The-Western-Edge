package net.ironhorsedevgroup.mods.thewesternedge.item.drinks;

import net.minecraft.util.StringRepresentable;

public enum BottleAdditives implements StringRepresentable {
    EMPTY("empty"),
    BERRIES("berries");

    private final String name;

    private BottleAdditives(String str) {
        this.name = str;
    }

    public String getSerializedName() {
        return this.name;
    }
}
