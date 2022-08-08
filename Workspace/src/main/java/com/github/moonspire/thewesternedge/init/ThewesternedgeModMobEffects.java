
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.github.moonspire.thewesternedge.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import com.github.moonspire.thewesternedge.potion.MeadEffectMobEffect;
import com.github.moonspire.thewesternedge.potion.BandagesEffectMobEffect;
import com.github.moonspire.thewesternedge.ThewesternedgeMod;

public class ThewesternedgeModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ThewesternedgeMod.MODID);
	public static final RegistryObject<MobEffect> BANDAGES_EFFECT = REGISTRY.register("bandages_effect", () -> new BandagesEffectMobEffect());
	public static final RegistryObject<MobEffect> MEAD_EFFECT = REGISTRY.register("mead_effect", () -> new MeadEffectMobEffect());
}
