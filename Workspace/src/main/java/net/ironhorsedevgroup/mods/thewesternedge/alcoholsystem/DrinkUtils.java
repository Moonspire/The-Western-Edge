package net.ironhorsedevgroup.mods.thewesternedge.alcoholsystem;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import net.ironhorsedevgroup.mods.thewesternedge.TWEUtils;
import net.ironhorsedevgroup.mods.thewesternedge.TheWesternEdgeMod;
import net.ironhorsedevgroup.mods.thewesternedge.init.TWEAdditives;
import net.ironhorsedevgroup.mods.thewesternedge.init.TWEDrinks;
import net.ironhorsedevgroup.mods.thewesternedge.init.TWEItems;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import org.lwjgl.system.CallbackI;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public class DrinkUtils {
    public static ItemStack addDrink(ItemStack itemStack, TWEDrinks drink, Double amount) {
        if (drink == TWEDrinks.EMPTY) {
            return new ItemStack(Items.GLASS_BOTTLE.asItem());
        } else {
            itemStack.getOrCreateTag().putDouble(drink.getSerializedName(), amount);
            itemStack.getOrCreateTag().putBoolean("Contents", true);
        }
        return itemStack;
    }

    public static ItemStack setContentsView(ItemStack itemStack, Boolean state) {
        itemStack.getOrCreateTag().putBoolean("Contents", state);
        return itemStack;
    }

    public static ItemStack toggleContentsView(ItemStack itemStack) {
        return TWEUtils.toggleBoolTag(itemStack, "Contents");
    }

    public static ItemStack addAdditive(ItemStack itemStack, TWEAdditives additive, Double amount) {
        if (additive == TWEAdditives.EMPTY) {
            return itemStack;
        } else {
            itemStack.getOrCreateTag().putDouble(additive.getSerializedName(), amount);
        }
        return itemStack;
    }

    public static ItemStack setBottle(ItemStack itemStack, Integer integer) {
        if (integer != 0) {
            itemStack.getOrCreateTag().putDouble("CustomModelData", integer);
        } else {
            itemStack.removeTagKey("CustomModelData");
        }
        return itemStack;
    }

    public static String getDrinkName(TWEDrinks drink) {
        return I18n.get("drink." + TheWesternEdgeMod.MODID + "." + drink.getSerializedName(), null);
    }

    public static NonNullList<TWEDrinks> getAllDrinks(ItemStack itemStack) {
        NonNullList<TWEDrinks> presentDrinks = NonNullList.create();
        for (TWEDrinks drink : TWEDrinks.values()) {
            if (TWEUtils.getDoubleTag(itemStack, drink.getSerializedName()) != 0) {
                presentDrinks.add(drink);
            }
        }
        return presentDrinks;
    }

    public static NonNullList<TWEAdditives> getAllAdditives(ItemStack itemStack) {
        NonNullList<TWEAdditives> presentAdditives = NonNullList.create();
        for (TWEAdditives additive : TWEAdditives.values()) {
            if (TWEUtils.getDoubleTag(itemStack, additive.getSerializedName()) != 0) {
                presentAdditives.add(additive);
            }
        }
        return presentAdditives;
    }

    public static void addDrinkTooltip(ItemStack itemStack, List<Component> components) {
        addDrinkTooltip(itemStack, components, false);
    }

    public static void addDrinkTooltip(ItemStack itemStack, List<Component> components, Boolean forceView) {
        NonNullList<TWEDrinks> drinks = getAllDrinks(itemStack);
        NonNullList<TWEAdditives> additives = getAllAdditives(itemStack);
        for (TWEAdditives additive : additives) {
            MutableComponent mutablecomponent = new TextComponent(additive.getSerializedName());
            components.add(mutablecomponent);
        }
        if (TWEUtils.getBoolTag(itemStack, "Contents") || forceView) {
            for (TWEDrinks drink : drinks) {
                MutableComponent mutablecomponent = new TextComponent(getDrinkName(drink));
                components.add(mutablecomponent);
            }
        }
    }
}
