package net.ironhorsedevgroup.mods.thewesternedge.item.drinks;

import net.minecraft.util.StringRepresentable;

public enum BottleDrinks implements StringRepresentable {
    EMPTY("empty", 0.0, BottleVariants.POTION_BOTTLE),
    BLACKWATER("blackwater", 0.0, BottleVariants.LABELED_BLACKWATER_BOTTLE),
    MEAD("mead", 1.0, BottleVariants.LABELED_DOOR_BOTTLE),
    BEER("beer", 0.6, BottleVariants.LABELED_TALL_BOTTLE),
    WINE("wine", 0.4, BottleVariants.LABELED_TALL_BOTTLE);

    private final String name;
    private final Double strength;
    private final BottleVariants bottle;

    private BottleDrinks(String Name, Double Strength, BottleVariants Bottle) {
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

    public BottleVariants getDefaultBottle() {
        return this.bottle;
    }
}
