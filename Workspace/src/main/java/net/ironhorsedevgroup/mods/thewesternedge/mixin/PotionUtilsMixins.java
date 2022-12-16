package net.ironhorsedevgroup.mods.thewesternedge.mixin;

import net.ironhorsedevgroup.mods.thewesternedge.TheWesternEdgeMod;
import net.ironhorsedevgroup.mods.thewesternedge.item.drinks.BottleUtils;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(PotionUtils.class)
public class PotionUtilsMixins {
    @Inject(at = @At("TAIL"), method = "addPotionTooltip(Lnet/minecraft/world/item/ItemStack;Ljava/util/List;FLorg/spongepowered/asm/mixin/injection/callback/CallbackInfo;)V", cancellable = true, remap = false)
    private static void addPotionTooltip(ItemStack itemStack, List<Component> components, float number, CallbackInfo info) {
        MutableComponent mutableComponent = new TextComponent(I18n.get("misc." + TheWesternEdgeMod.MODID + ".serving_name") + ": " + BottleUtils.getAmount(itemStack));
        components.add(mutableComponent);
    }
}
