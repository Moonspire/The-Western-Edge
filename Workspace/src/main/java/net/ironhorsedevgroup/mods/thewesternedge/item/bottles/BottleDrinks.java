package net.ironhorsedevgroup.mods.thewesternedge.item.bottles;

import net.ironhorsedevgroup.mods.thewesternedge.TWEUtils;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;

public enum BottleDrinks implements StringRepresentable {
    EMPTY("empty", 0.0, BottleVariants.POTION_BOTTLE, TWEUtils.getIntFromRGB(255, 255, 255), 0),
    ROOTBEER("rootbeer", 0.0, BottleVariants.LABELED_SODA_BOTTLE, TWEUtils.getIntFromRGB(135, 67, 19), 150),
    LEMONADE("lemonade", 0.1, BottleVariants.LABELED_CHONK_BOTTLE, TWEUtils.getIntFromRGB(253, 255, 115), 255),
    BLACKWATER("blackwater", 0.0, BottleVariants.LABELED_BLACKWATER_BOTTLE, TWEUtils.getIntFromRGB(50, 50, 50), 255),
    MEAD("mead", 1.0, BottleVariants.LABELED_DOOR_BOTTLE, TWEUtils.getIntFromRGB(255, 179, 15), 140),
    BEER("beer", 0.6, BottleVariants.LABELED_SODA_BOTTLE, TWEUtils.getIntFromRGB(255, 230, 120), 100),
    WINE("wine", 0.4, BottleVariants.LABELED_TALL_BOTTLE, TWEUtils.getIntFromRGB(148, 0, 76), 230),
    WHISKEY("whiskey", 4.0, BottleVariants.LABELED_CHONK_BOTTLE, TWEUtils.getIntFromRGB(176, 111, 21), 200),
    VODKA("vodka", 5.0, BottleVariants.LABELED_TALL_BOTTLE, PotionUtils.getColor(Potions.WATER), 5),
    MOONSHINE("moonshine", 8.0, BottleVariants.DOOR_BOTTLE, PotionUtils.getColor(Potions.WATER), 5);

    private final String name;
    private final Double strength;
    private final BottleVariants bottle;
    private final Integer color;
    private final Integer colorInfluence;

    private BottleDrinks(String Name, Double Strength, BottleVariants Bottle, Integer DrinkColor, Integer ColorInfluence) {
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

    public Integer getColorInfluence() {
        return this.colorInfluence;
    }
}
