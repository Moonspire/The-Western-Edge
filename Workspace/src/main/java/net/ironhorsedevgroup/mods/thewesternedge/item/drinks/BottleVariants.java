package net.ironhorsedevgroup.mods.thewesternedge.item.drinks;

import net.minecraft.util.StringRepresentable;

public enum BottleVariants implements StringRepresentable {
    POTION_BOTTLE("default", 1.0, true, false, 0),
    LABELED_POTION_BOTTLE("default", 1.0, true, true, 1),
    DOOR_BOTTLE("door", 3.0, true, false, 2),
    LABELED_DOOR_BOTTLE("door", 3.0, true, true, 3),
    CHONK_BOTTLE("chonk", 5.0, true, false, 4),
    LABELED_CHONK_BOTTLE("chonk", 5.0, true, true, 5),
    BLACKWATER_BOTTLE("blackwater", 4.0, true, false, 6),
    LABELED_BLACKWATER_BOTTLE("blackwater", 4.0, true, true, 7),
    TALL_BOTTLE("tall", 2.0, true, false, 8),
    LABELED_TALL_BOTTLE("tall", 2.0, true, true, 9),
    SODA_BOTTLE("soda", 1.5, true, false, 11),
    LABELED_SODA_BOTTLE("soda", 1.5, true, true, 12),
    //GLASS_CUP("glass_cup", 1.0, true, false, 13),
    WATERSKIN("waterskin", 3.0, false, true, 10);
    private final String name;
    private final Double servings;
    private final Boolean breakable;
    private final Boolean labeled;
    private final Integer bottleID;

    private BottleVariants(String Name, Double Servings, Boolean Breakable, Boolean Labeled, Integer BottleID) {
        this.name = Name;
        this.servings = Servings;
        this.breakable = Breakable;
        this.labeled = Labeled;
        this.bottleID = BottleID;
    }

    public String getSerializedName() {
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

    public Integer getID() {
        return this.bottleID;
    }
}
