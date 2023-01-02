package net.ironhorsedevgroup.mods.thewesternedge.item.bottles;

import net.ironhorsedevgroup.mods.thewesternedge.TWEUtils;
import net.minecraft.util.StringRepresentable;

public enum BottleDrinks implements StringRepresentable {
    EMPTY("empty", 0.0, BottleVariants.POTION_BOTTLE, TWEUtils.getIntFromRGB(255, 255, 255), false),
    ROOTBEER("rootbeer", 0.0, BottleVariants.LABELED_SODA_BOTTLE, TWEUtils.getIntFromRGB(135, 67, 19), true),
    LEMONADE("lemonade", 0.1, BottleVariants.LABELED_CHONK_BOTTLE, TWEUtils.getIntFromRGB(253, 255, 115), true),
    BLACKWATER("blackwater", 0.0, BottleVariants.LABELED_BLACKWATER_BOTTLE, TWEUtils.getIntFromRGB(50, 50, 50), true),
    MEAD("mead", 1.0, BottleVariants.LABELED_DOOR_BOTTLE, TWEUtils.getIntFromRGB(255, 179, 15), true),
    BEER("beer", 0.6, BottleVariants.LABELED_SODA_BOTTLE, TWEUtils.getIntFromRGB(255, 230, 120), true),
    WINE("wine", 0.4, BottleVariants.LABELED_TALL_BOTTLE, TWEUtils.getIntFromRGB(148, 0, 76), true);

    private final String name;
    private final Double strength;
    private final BottleVariants bottle;
    private final Integer color;
    private final Boolean colorInfluence;

    private BottleDrinks(String Name, Double Strength, BottleVariants Bottle, Integer DrinkColor, Boolean ColorInfluence) {
        this.name = Name;
        this.strength = Strength;
        this.bottle = Bottle;
        this.color = DrinkColor;
        this.colorInfluence = ColorInfluence;
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

    public Integer getColor() {
        return this.color;
    }

    public Boolean getColorInfluence() {
        return this.colorInfluence;
    }
}
