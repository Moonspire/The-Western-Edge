package net.ironhorsedevgroup.mods.thewesternedge.item.drinks;

import net.minecraft.util.StringRepresentable;
import net.minecraftforge.items.IItemHandler;

public enum BottleVariants implements StringRepresentable {
    POTION_BOTTLE("","default", 1.0, true, false),
    LABELED_POTION_BOTTLE("labeled_potion", "default", 1.0, true, true),
    DOOR_BOTTLE("door","door", 3.0, true, false),
    LABELED_DOOR_BOTTLE("labeled_door", "door", 3.0, true, true),
    CHONK_BOTTLE("chonk", "chonk", 5.0, true, false),
    LABELED_CHONK_BOTTLE("labeled_chonk", "chonk", 5.0, true, true),
    BLACKWATER_BOTTLE("blackwater", "blackwater", 4.0, true, false),
    LABELED_BLACKWATER_BOTTLE("labeled_blackwater", "blackwater", 4.0, true, true),
    TALL_BOTTLE("tall", "tall", 2.0, true, false),
    LABELED_TALL_BOTTLE("labeled_tall", "tall", 2.0, true, true),
    WATERSKIN("waterskin", "waterskin", 3.0, false, true);
    private final String name;
    private final String lang;
    private final Double servings;
    private final Boolean breakable;
    private final Boolean labeled;

    private BottleVariants(String Name, String Lang, Double Servings, Boolean Breakable, Boolean Labeled) {
        this.name = Name;
        this.lang = Lang;
        this.servings = Servings;
        this.breakable = Breakable;
        this.labeled = Labeled;
    }

    public String getSerializedName() {
        return this.lang;
    }

    public String getName() {
        return this.name;
    }

    public Double getServings() {
        return this.servings;
    }

    public Boolean isBreakable(){
        return this.breakable;
    }

    public Boolean isLabeled(){
        return this.labeled;
    }
}
