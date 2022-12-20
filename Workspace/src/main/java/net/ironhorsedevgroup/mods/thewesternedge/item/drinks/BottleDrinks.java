package net.ironhorsedevgroup.mods.thewesternedge.item.drinks;

import net.ironhorsedevgroup.mods.thewesternedge.TWEUtils;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.util.StringRepresentable;
import net.minecraftforge.client.event.RenderTooltipEvent;
import org.jline.utils.Colors;

public enum BottleDrinks implements StringRepresentable {
    EMPTY("empty", 0.0, BottleVariants.POTION_BOTTLE, TWEUtils.getIntFromRGB(255, 255, 255), false),
    BLACKWATER("blackwater", 0.0, BottleVariants.BLACKWATER_BOTTLE, TWEUtils.getIntFromRGB(50, 50, 50), true),
    MEAD("mead", 1.0, BottleVariants.DOOR_BOTTLE, TWEUtils.getIntFromRGB(255, 179, 15), true),
    BEER("beer", 0.6, BottleVariants.TALL_BOTTLE, TWEUtils.getIntFromRGB(255, 230, 120), true),
    WINE("wine", 0.4, BottleVariants.TALL_BOTTLE, TWEUtils.getIntFromRGB(148, 0, 76), true);

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
