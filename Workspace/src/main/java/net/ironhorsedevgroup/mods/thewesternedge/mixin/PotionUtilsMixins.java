package net.ironhorsedevgroup.mods.thewesternedge.mixin;

import net.ironhorsedevgroup.mods.thewesternedge.item.drinks.BottleUtils;
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
        Integer amount = BottleUtils.getAmount(itemStack).intValue();
        String text = amount.toString() + " Serving";
        if (amount != 1) {
            text = text + "s";
        }
        MutableComponent mutableComponent = new TextComponent(text);
        components.add(mutableComponent);
    }
}
