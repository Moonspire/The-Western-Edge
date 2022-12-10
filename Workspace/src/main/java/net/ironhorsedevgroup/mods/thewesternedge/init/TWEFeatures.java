package net.ironhorsedevgroup.mods.thewesternedge.init;

import net.ironhorsedevgroup.mods.thewesternedge.TheWesternEdgeMod;
import net.ironhorsedevgroup.mods.thewesternedge.world.features.BushesGeneration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TWEFeatures {
    public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, TheWesternEdgeMod.MODID);
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> AMBER_BUSHES = REGISTRY.register("amber_bushes_feature",
            () -> new BushesGeneration(NoneFeatureConfiguration.CODEC));
}
