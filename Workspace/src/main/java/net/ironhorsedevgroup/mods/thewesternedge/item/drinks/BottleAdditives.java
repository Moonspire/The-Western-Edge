package net.ironhorsedevgroup.mods.thewesternedge.item.drinks;

import net.minecraft.util.StringRepresentable;

public enum BottleAdditives implements StringRepresentable {
    EMPTY("empty"),
    AMBER_BERRIES("amber_berries"),
    INDIGO_BERRIES("indigo_berries"),
    JADE_BERRIES("jade_berries"),
    MAUVE_BERRIES("mauve_berries"),
    RUSSET_BERRIES("russet_berries"),
    TEAL_BERRIES("teal_berries"),
    VERMILLION_BERRIES("vermillion_berries"),
    CACTUS_FRUIT("cactus_fruit");

    private final String name;

    private BottleAdditives(String str) {
        this.name = str;
    }

    public String getSerializedName() {
        return this.name;
    }
}
