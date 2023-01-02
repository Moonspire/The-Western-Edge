package net.ironhorsedevgroup.mods.thewesternedge.item.cards;

import net.ironhorsedevgroup.mods.thewesternedge.TWEUtils;
import net.ironhorsedevgroup.mods.thewesternedge.TheWesternEdgeMod;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.util.StringRepresentable;

public enum Cards implements StringRepresentable {
    DEFAULT("default", 0, false),
    CROSSBOW_SQUID("crossbow_squid", 1, TWEUtils.getIntFromRGB(218, 48, 48)),
    CROSSBOW_2("crossbow_2", 2, TWEUtils.getIntFromRGB(218, 48, 48)),
    CROSSBOW_3("crossbow_3", 3, TWEUtils.getIntFromRGB(218, 48, 48)),
    CROSSBOW_4("crossbow_4", 4, TWEUtils.getIntFromRGB(218, 48, 48)),
    CROSSBOW_5("crossbow_5", 5, TWEUtils.getIntFromRGB(218, 48, 48)),
    CROSSBOW_6("crossbow_6", 6, TWEUtils.getIntFromRGB(218, 48, 48)),
    CROSSBOW_7("crossbow_7", 7, TWEUtils.getIntFromRGB(218, 48, 48)),
    CROSSBOW_8("crossbow_8", 8, TWEUtils.getIntFromRGB(218, 48, 48)),
    CROSSBOW_9("crossbow_9", 9, TWEUtils.getIntFromRGB(218, 48, 48)),
    CROSSBOW_10("crossbow_10", 10, TWEUtils.getIntFromRGB(218, 48, 48)),
    CROSSBOW_GUARDIAN("crossbow_guardian", 11, TWEUtils.getIntFromRGB(218, 48, 48)),
    CROSSBOW_WITHER("crossbow_wither", 12, TWEUtils.getIntFromRGB(218, 48, 48)),
    CROSSBOW_DRAGON("crossbow_dragon", 13, TWEUtils.getIntFromRGB(218, 48, 48)),
    BOW_SQUID("bow_squid", 14, TWEUtils.getIntFromRGB(39, 171, 37)),
    BOW_2("bow_2", 15, TWEUtils.getIntFromRGB(39, 171, 37)),
    BOW_3("bow_3", 16, TWEUtils.getIntFromRGB(39, 171, 37)),
    BOW_4("bow_4", 17, TWEUtils.getIntFromRGB(39, 171, 37)),
    BOW_5("bow_5", 18, TWEUtils.getIntFromRGB(39, 171, 37)),
    BOW_6("bow_6", 19, TWEUtils.getIntFromRGB(39, 171, 37)),
    BOW_7("bow_7", 20, TWEUtils.getIntFromRGB(39, 171, 37)),
    BOW_8("bow_8", 21, TWEUtils.getIntFromRGB(39, 171, 37)),
    BOW_9("bow_9", 22, TWEUtils.getIntFromRGB(39, 171, 37)),
    BOW_10("bow_10", 23, TWEUtils.getIntFromRGB(39, 171, 37)),
    BOW_GUARDIAN("bow_guardian", 24, TWEUtils.getIntFromRGB(39, 171, 37)),
    BOW_WITHER("bow_wither", 25, TWEUtils.getIntFromRGB(39, 171, 37)),
    BOW_DRAGON("bow_dragon", 26, TWEUtils.getIntFromRGB(39, 171, 37)),
    SWORD_SQUID("sword_squid", 27, TWEUtils.getIntFromRGB(48, 64, 218)),
    SWORD_2("sword_2", 28, TWEUtils.getIntFromRGB(48, 64, 218)),
    SWORD_3("sword_3", 29, TWEUtils.getIntFromRGB(48, 64, 218)),
    SWORD_4("sword_4", 30, TWEUtils.getIntFromRGB(48, 64, 218)),
    SWORD_5("sword_5", 31, TWEUtils.getIntFromRGB(48, 64, 218)),
    SWORD_6("sword_6", 32, TWEUtils.getIntFromRGB(48, 64, 218)),
    SWORD_7("sword_7", 33, TWEUtils.getIntFromRGB(48, 64, 218)),
    SWORD_8("sword_8", 34, TWEUtils.getIntFromRGB(48, 64, 218)),
    SWORD_9("sword_9", 35, TWEUtils.getIntFromRGB(48, 64, 218)),
    SWORD_10("sword_10", 36, TWEUtils.getIntFromRGB(48, 64, 218)),
    SWORD_GUARDIAN("sword_guardian", 37, TWEUtils.getIntFromRGB(48, 64, 218)),
    SWORD_WITHER("sword_wither", 38, TWEUtils.getIntFromRGB(48, 64, 218)),
    SWORD_DRAGON("sword_dragon", 39, TWEUtils.getIntFromRGB(48, 64, 218)),
    AXE_SQUID("axe_squid", 40, TWEUtils.getIntFromRGB(184, 162, 40)),
    AXE_2("axe_2", 41, TWEUtils.getIntFromRGB(184, 162, 40)),
    AXE_3("axe_3", 42, TWEUtils.getIntFromRGB(184, 162, 40)),
    AXE_4("axe_4", 43, TWEUtils.getIntFromRGB(184, 162, 40)),
    AXE_5("axe_5", 44, TWEUtils.getIntFromRGB(184, 162, 40)),
    AXE_6("axe_6", 45, TWEUtils.getIntFromRGB(184, 162, 40)),
    AXE_7("axe_7", 46, TWEUtils.getIntFromRGB(184, 162, 40)),
    AXE_8("axe_8", 47, TWEUtils.getIntFromRGB(184, 162, 40)),
    AXE_9("axe_9", 48, TWEUtils.getIntFromRGB(184, 162, 40)),
    AXE_10("axe_10", 49, TWEUtils.getIntFromRGB(184, 162, 40)),
    AXE_GUARDIAN("axe_guardian", 50, TWEUtils.getIntFromRGB(184, 162, 40)),
    AXE_WITHER("axe_wither", 51, TWEUtils.getIntFromRGB(184, 162, 40)),
    AXE_DRAGON("axe_dragon", 52, TWEUtils.getIntFromRGB(184, 162, 40));
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
            return I18n.get("item" + TheWesternEdgeMod.MODID + ".card");
        }
    }

    public Integer getColor() {
        return this.color;
    }

    public Integer getColor(Integer tintIndex) {
        return getColor();
    }
}
