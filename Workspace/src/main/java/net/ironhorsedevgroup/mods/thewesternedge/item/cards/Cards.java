package net.ironhorsedevgroup.mods.thewesternedge.item.cards;

import net.ironhorsedevgroup.mods.thewesternedge.TWEUtils;
import net.ironhorsedevgroup.mods.thewesternedge.TheWesternEdgeMod;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.util.StringRepresentable;

public enum Cards implements StringRepresentable {
    DEFAULT("default", 0, false),
    CROSSBOW_SQUID("crossbow_squid", 1, CardUtils.getColor("crossbows")),
    CROSSBOW_2("crossbow_2", 2, CardUtils.getColor("crossbows")),
    CROSSBOW_3("crossbow_3", 3, CardUtils.getColor("crossbows")),
    CROSSBOW_4("crossbow_4", 4, CardUtils.getColor("crossbows")),
    CROSSBOW_5("crossbow_5", 5, CardUtils.getColor("crossbows")),
    CROSSBOW_6("crossbow_6", 6, CardUtils.getColor("crossbows")),
    CROSSBOW_7("crossbow_7", 7, CardUtils.getColor("crossbows")),
    CROSSBOW_8("crossbow_8", 8, CardUtils.getColor("crossbows")),
    CROSSBOW_9("crossbow_9", 9, CardUtils.getColor("crossbows")),
    CROSSBOW_10("crossbow_10", 10, CardUtils.getColor("crossbows")),
    CROSSBOW_GUARDIAN("crossbow_guardian", 11, CardUtils.getColor("crossbows")),
    CROSSBOW_WITHER("crossbow_wither", 12, CardUtils.getColor("crossbows")),
    CROSSBOW_DRAGON("crossbow_dragon", 13, CardUtils.getColor("crossbows")),
    BOW_SQUID("bow_squid", 14, CardUtils.getColor("bows")),
    BOW_2("bow_2", 15, CardUtils.getColor("bows")),
    BOW_3("bow_3", 16, CardUtils.getColor("bows")),
    BOW_4("bow_4", 17, CardUtils.getColor("bows")),
    BOW_5("bow_5", 18, CardUtils.getColor("bows")),
    BOW_6("bow_6", 19, CardUtils.getColor("bows")),
    BOW_7("bow_7", 20, CardUtils.getColor("bows")),
    BOW_8("bow_8", 21, CardUtils.getColor("bows")),
    BOW_9("bow_9", 22, CardUtils.getColor("bows")),
    BOW_10("bow_10", 23, CardUtils.getColor("bows")),
    BOW_GUARDIAN("bow_guardian", 24, CardUtils.getColor("bows")),
    BOW_WITHER("bow_wither", 25, CardUtils.getColor("bows")),
    BOW_DRAGON("bow_dragon", 26, CardUtils.getColor("bows")),
    SWORD_SQUID("sword_squid", 27, CardUtils.getColor("swords")),
    SWORD_2("sword_2", 28, CardUtils.getColor("swords")),
    SWORD_3("sword_3", 29, CardUtils.getColor("swords")),
    SWORD_4("sword_4", 30, CardUtils.getColor("swords")),
    SWORD_5("sword_5", 31, CardUtils.getColor("swords")),
    SWORD_6("sword_6", 32, CardUtils.getColor("swords")),
    SWORD_7("sword_7", 33, CardUtils.getColor("swords")),
    SWORD_8("sword_8", 34, CardUtils.getColor("swords")),
    SWORD_9("sword_9", 35, CardUtils.getColor("swords")),
    SWORD_10("sword_10", 36, CardUtils.getColor("swords")),
    SWORD_GUARDIAN("sword_guardian", 37, CardUtils.getColor("swords")),
    SWORD_WITHER("sword_wither", 38, CardUtils.getColor("swords")),
    SWORD_DRAGON("sword_dragon", 39, CardUtils.getColor("swords")),
    AXE_SQUID("axe_squid", 40, CardUtils.getColor("axes")),
    AXE_2("axe_2", 41, CardUtils.getColor("axes")),
    AXE_3("axe_3", 42, CardUtils.getColor("axes")),
    AXE_4("axe_4", 43, CardUtils.getColor("axes")),
    AXE_5("axe_5", 44, CardUtils.getColor("axes")),
    AXE_6("axe_6", 45, CardUtils.getColor("axes")),
    AXE_7("axe_7", 46, CardUtils.getColor("axes")),
    AXE_8("axe_8", 47, CardUtils.getColor("axes")),
    AXE_9("axe_9", 48, CardUtils.getColor("axes")),
    AXE_10("axe_10", 49, CardUtils.getColor("axes")),
    AXE_GUARDIAN("axe_guardian", 50, CardUtils.getColor("axes")),
    AXE_WITHER("axe_wither", 51, CardUtils.getColor("axes")),
    AXE_DRAGON("axe_dragon", 52, CardUtils.getColor("axes"));
    private final String name;
    private final int id;
    private final Boolean customName;
    private final int color;

    private Cards(String Name, int ID, int Color) {
        this(Name, ID, true, Color);
    }

    private Cards(String Name, int ID, boolean CustomName) {
        this(Name, ID, CustomName, TWEUtils.getIntFromRGB(255, 255, 255));
    }

    private Cards(String Name, int ID, boolean CustomName, int Color) {
        this.name = Name;
        this.id = ID;
        this.customName = CustomName;
        this.color = Color;
    }



    public String getSerializedName() {
        return this.name;
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        if (this.customName) {
            return I18n.get("item." + TheWesternEdgeMod.MODID + ".card." + this.name);
        } else {
            return I18n.get("item." + TheWesternEdgeMod.MODID + ".card");
        }
    }

    public Integer getColor() {
        return this.color;
    }

    public Integer getColor(Integer tintIndex) {
        return getColor();
    }
}
