
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.ironhorsedevgroup.mods.thewesternedge.init;

import net.ironhorsedevgroup.mods.thewesternedge.TheWesternEdgeMod;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.ironhorsedevgroup.mods.thewesternedge.potion.MeadEffectMobEffect;
import net.ironhorsedevgroup.mods.thewesternedge.potion.BandagesEffectMobEffect;

public class TWEMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, TheWesternEdgeMod.MODID);
	public static final RegistryObject<MobEffect> BANDAGES_EFFECT = REGISTRY.register("bandages_effect", () -> new BandagesEffectMobEffect());
	public static final RegistryObject<MobEffect> MEAD_EFFECT = REGISTRY.register("mead_effect", () -> new MeadEffectMobEffect());
}
