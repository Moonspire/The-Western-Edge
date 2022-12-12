package net.ironhorsedevgroup.mods.thewesternedge.init;

import net.minecraft.util.StringRepresentable;

public enum TWEDrinks implements StringRepresentable {
    EMPTY("empty", 0.0, 0),
    BLACKWATER("blackwater", 0.0, 7),
    MEAD("mead", 1.0, 3),
    BEER("beer", 0.6, 9),
    WINE("wine", 0.4, 9);

    private final String name;
    private final Double strength;
    private final Integer bottle;

    private TWEDrinks(String Name, Double Strength, Integer Bottle) {
        this.name = Name;
        this.strength = Strength;
        this.bottle = Bottle;
    }



    public String getSerializedName() {
        return this.name;
    }

    public Double getDefaultStrength() {
        return this.strength;
    }

    public Integer getDefaultBottle() {
        return this.bottle;
    }
}
