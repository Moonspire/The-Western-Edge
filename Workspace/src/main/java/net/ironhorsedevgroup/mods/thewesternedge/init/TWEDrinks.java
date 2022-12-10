package net.ironhorsedevgroup.mods.thewesternedge.init;

import net.minecraft.util.StringRepresentable;

public enum TWEDrinks implements StringRepresentable {
    EMPTY("empty"),
    BLACKWATER("blackwater"),
    MEAD("mead"),
    BEER("beer"),
    WINE("wine");

    private final String name;

    private TWEDrinks(String str) {
        this.name = str;
    }

    public String getSerializedName() {
        return this.name;
    }
}
