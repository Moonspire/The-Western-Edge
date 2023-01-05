package net.ironhorsedevgroup.mods.thewesternedge.init;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Arrays;
import java.util.List;

public class TWEConfig {
    public static final ForgeConfigSpec GENERAL_SPEC;

    static {
        ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();
        setupConfig(configBuilder);
        GENERAL_SPEC = configBuilder.build();
    }

    public static ForgeConfigSpec.ConfigValue<List<? extends Integer>> cardCrossbowsColor;
    public static ForgeConfigSpec.ConfigValue<List<? extends Integer>> cardBowsColor;
    public static ForgeConfigSpec.ConfigValue<List<? extends Integer>> cardSwordsColor;
    public static ForgeConfigSpec.ConfigValue<List<? extends Integer>> cardAxesColor;

    private static void setupConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Colors for playing cards!");
        builder.push("Card Colors");
            cardCrossbowsColor = builder.defineList("card_crossbows_color", Arrays.asList(163, 65, 80), entry -> true);
            cardBowsColor = builder.defineList("card_bows_color", Arrays.asList(70, 158, 76), entry -> true);
            cardSwordsColor = builder.defineList("card_swords_color", Arrays.asList(77, 86, 160), entry -> true);
            cardAxesColor = builder.defineList("card_axes_color", Arrays.asList(178, 179, 56), entry -> true);
        builder.pop();
    }
}
