package net.ironhorsedevgroup.mods.thewesternedge;

import net.ironhorsedevgroup.mods.thewesternedge.events.ClientInitEvents;
import net.ironhorsedevgroup.mods.thewesternedge.events.GeneratedItemHooks;
import net.ironhorsedevgroup.mods.thewesternedge.init.*;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;

import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;

@Mod("thewesternedge")
public class TheWesternEdgeMod {

	public static final Logger LOGGER = LogManager.getLogger(TheWesternEdgeMod.class);
	public static final String MODID = "thewesternedge";
	//public static final Registrate REGISTRATE = Registrate.create(MODID);
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MODID, MODID), () -> PROTOCOL_VERSION,
			PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	private static int messageID = 0;

	public TheWesternEdgeMod() {
		TWETabs.load();
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

		forgeEventBus.register(ClientInitEvents.class);

		TWEBlocks.REGISTRY.register(bus);

		TWEItems.REGISTRY.register(bus);

		TWEBlockEntities.REGISTRY.register(bus);

		TWEMobEffects.REGISTRY.register(bus);

		TWEFeatures.REGISTRY.register(bus);

		forgeEventBus.addListener(EventPriority.NORMAL, GeneratedItemHooks::OnEntityInteract);
		forgeEventBus.addListener(ClientInitEvents::registerItemColors);
	}

	public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder,
			BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}
}
