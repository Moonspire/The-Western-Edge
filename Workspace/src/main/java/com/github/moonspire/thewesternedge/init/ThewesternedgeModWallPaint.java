package com.github.moonspire.thewesternedge.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import com.github.moonspire.thewesternedge.init.ThewesternedgeModBlocks.REGISTRY;

import net.minecraft.world.level.block.Block;

public class ThewesternedgeModWallPaint {
	public static final RegistryObject<Block> WOOD_MEDIC_MARK = REGISTRY.register("wood_medic_mark", () -> new WallMarkingBlock());
}
