package net.ironhorsedevgroup.mods.thewesternedge.block.berries;

import net.minecraft.util.StringRepresentable;

public enum BerryType implements StringRepresentable {
    AMBER("amber"),
    INDIGO("indigo"),
    JADE("jade"),
    MAUVE("mauve"),
    RUSSET("russet"),
    TEAL("teal"),
    VERMILLION("vermillion");

    private final String name;

    private BerryType(String str) {
        this.name = str;
    }

    public String getSerializedName() {
        return this.name;
    }
}