
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.github.moonspire.thewesternedge.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;

import com.github.moonspire.thewesternedge.ThewesternedgeMod;

public class ThewesternedgeModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, ThewesternedgeMod.MODID);
	public static final RegistryObject<Potion> MEAD = REGISTRY.register("mead",
			() -> new Potion(new MobEffectInstance(ThewesternedgeModMobEffects.MEAD_EFFECT.get(), 3600, 0, false, true)));
}
