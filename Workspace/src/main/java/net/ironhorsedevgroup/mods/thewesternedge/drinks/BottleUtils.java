package net.ironhorsedevgroup.mods.thewesternedge.drinks;

import com.mojang.datafixers.util.Pair;
import net.ironhorsedevgroup.mods.thewesternedge.TWEUtils;
import net.ironhorsedevgroup.mods.thewesternedge.TheWesternEdgeMod;
import net.ironhorsedevgroup.mods.thewesternedge.init.TWEAdditives;
import net.ironhorsedevgroup.mods.thewesternedge.init.TWEDrinks;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.gui.font.glyphs.BakedGlyph;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.List;
import java.util.Map;

public class BottleUtils {
    
    // Adding Ingredients ----------------------------------------------------------------------------------------------
    public static ItemStack addAll(ItemStack itemStack, List<TWEDrinks> drinks, List<TWEAdditives> additives, List<Potion> potions) {
        double amount = 1.0 / (drinks.size() + additives.size() + potions.size());
        addDrinks(itemStack, drinks, amount);
        addAdditives(itemStack, additives, amount);
        addPotions(itemStack, potions, amount);
        return itemStack;
    }

    public static ItemStack addDrinks(ItemStack itemStack, List<TWEDrinks> drinks) {
        Double amount = 1.0 / drinks.size();
        for (int i = 0; i < drinks.size(); i++) {
            addDrink(itemStack, drinks.get(i), amount);
        }
        return itemStack;
    }

    public static ItemStack addDrinks(ItemStack itemStack, List<TWEDrinks> drinks, Double amounts) {
        for (int i = 0; i < drinks.size(); i++) {
            addDrink(itemStack, drinks.get(i), amounts);
        }
        return itemStack;
    }

    public static ItemStack addDrinks(ItemStack itemStack, List<TWEDrinks> drinks, List<Double> amounts) {
        for (int i = 0; i < drinks.size(); i++) {
            addDrink(itemStack, drinks.get(i), amounts.get(i));
        }
        return itemStack;
    }

    public static ItemStack addDrinks(ItemStack itemStack, List<TWEDrinks> drinks, List<Double> amounts, List<Double> strengths) {
        for (int i = 0; i < drinks.size(); i++) {
            addDrink(itemStack, drinks.get(i), amounts.get(i), strengths.get(i));
        }
        return itemStack;
    }

    public static ItemStack addDrink(ItemStack itemStack, TWEDrinks drink) {
        return addDrink(itemStack, drink, 1.0, 1.0);
    }

    public static ItemStack addDrink(ItemStack itemStack, TWEDrinks drink, Double amount) {
        return addDrink(itemStack, drink, amount, 1.0);
    }

    public static ItemStack addDrink(ItemStack itemStack, TWEDrinks drink, Double amount, Double strength) {
        if (drink != TWEDrinks.EMPTY) {
            TWEUtils.putDoubleTag(itemStack, "drink." + drink.getSerializedName(), amount);
            addStrength(itemStack, amount, strength);
        }
        return itemStack;
    }

    public static ItemStack addAdditives(ItemStack itemStack, List<TWEAdditives> additives) {
        Double amount = 1.0 / additives.size();
        for (int i = 0; i < additives.size(); i++) {
            addAdditive(itemStack, additives.get(i), amount);
        }
        return itemStack;
    }

    public static ItemStack addAdditives(ItemStack itemStack, List<TWEAdditives> additives, Double amounts) {
        for (int i = 0; i < additives.size(); i++) {
            addAdditive(itemStack, additives.get(i), amounts);
        }
        return itemStack;
    }

    public static ItemStack addAdditives(ItemStack itemStack, List<TWEAdditives> additives, List<Double> amounts) {
        for (int i = 0; i < additives.size(); i++) {
            addAdditive(itemStack, additives.get(i), amounts.get(i));
        }
        return itemStack;
    }

    public static ItemStack addAdditive(ItemStack itemStack, Potion potion) {
        return addPotion(itemStack, potion, 1.0);
    }

    public static ItemStack addAdditive(ItemStack itemStack, TWEAdditives additive, Double amount) {
        if (additive != TWEAdditives.EMPTY && getAmount(itemStack) != 0) {
            TWEUtils.putDoubleTag(itemStack,"additive." + additive.getSerializedName(), amount);
        }
        return itemStack;
    }

    public static ItemStack addPotions(ItemStack itemStack, List<Potion> potion) {
        Double amount = 1.0 / potion.size();
        for (int i = 0; i < potion.size(); i++) {
            addPotion(itemStack, potion.get(i), amount);
        }
        return itemStack;
    }

    public static ItemStack addPotions(ItemStack itemStack, List<Potion> potion, Double amounts) {
        for (int i = 0; i < potion.size(); i++) {
            addPotion(itemStack, potion.get(i), amounts);
        }
        return itemStack;
    }

    public static ItemStack addPotions(ItemStack itemStack, List<Potion> potion, List<Double> amounts) {
        for (int i = 0; i < potion.size(); i++) {
            addPotion(itemStack, potion.get(i), amounts.get(i));
        }
        return itemStack;
    }

    public static ItemStack addPotion(ItemStack itemStack, Potion potion) {
        return addPotion(itemStack, potion, 1.0);
    }

    public static ItemStack addPotion(ItemStack itemStack, Potion potion, Double amount) {
        if (potion != Potions.EMPTY) {
            TWEUtils.putDoubleTag(itemStack,"potion." + potion.getRegistryName(), amount);
        }
        return itemStack;
    }

    // Get Ingredients -------------------------------------------------------------------------------------------------
    public static Boolean isDrinks(ItemStack itemStack, List<TWEDrinks> drinks) {
        for (TWEDrinks drink : drinks) {
            if (!isDrink(itemStack, drink)) {
                return false;
            }
        }
        return true;
    }

    public static Boolean isDrink(ItemStack itemStack, TWEDrinks drink) {
        if (TWEUtils.getDoubleTag(itemStack, "drink." + drink.getSerializedName()) != 0){
            return true;
        }
        return false;
    }

    public static NonNullList<TWEDrinks> getDrinks(ItemStack itemStack) {
        NonNullList<TWEDrinks> drinks = NonNullList.create();
        for (TWEDrinks drink : TWEDrinks.values()) {
            if (isDrink(itemStack, drink)) {
                drinks.add(drink);
            }
        }
        return drinks;
    }

    public static Boolean isAdditives(ItemStack itemStack, List<TWEAdditives> additives) {
        for (TWEAdditives additive : additives) {
            if (!isAdditive(itemStack, additive)) {
                return false;
            }
        }
        return true;
    }

    public static Boolean isAdditive(ItemStack itemStack, TWEAdditives additive) {
        if (TWEUtils.getDoubleTag(itemStack, "additive." + additive.getSerializedName()) != 0){
            return true;
        }
        return false;
    }

    public static NonNullList<TWEAdditives> getAdditives(ItemStack itemStack) {
        NonNullList<TWEAdditives> additives = NonNullList.create();
        for (TWEAdditives additive : TWEAdditives.values()) {
            if (isAdditive(itemStack, additive)) {
                additives.add(additive);
            }
        }
        return additives;
    }

    public static Boolean isPotions(ItemStack itemStack, List<Potion> potions) {
        for (Potion potion : potions) {
            if (!isPotion(itemStack, potion)) {
                return false;
            }
        }
        return true;
    }

    public static Boolean isPotion(ItemStack itemStack, Potion potion) {
        if (TWEUtils.getDoubleTag(itemStack, "potion." + potion.getRegistryName()) != 0){
            return true;
        }
        return false;
    }

    public static NonNullList<Potion> getPotions(ItemStack itemStack) {
        NonNullList<Potion> potions = NonNullList.create();
        for (Potion potion : Registry.POTION.stream().toList()) {
            if (isPotion(itemStack, potion)) {
                potions.add(potion);
            }
        }
        return potions;
    }

    // How Many Servings Exist -----------------------------------------------------------------------------------------
    public static Double getAmount(ItemStack itemStack) {
        return getDrinkAmount(itemStack, List.of(TWEDrinks.values())) + getPotionAmount(itemStack, Registry.POTION.stream().toList());
    }

    public static Double getDrinkAmount(ItemStack itemStack, List<TWEDrinks> drinks) {
        Double total = 0.0;
        for (TWEDrinks drink : drinks) {
            total = total + getDrinkAmount(itemStack, drink);
        }
        return total;
    }

    public static Double getPotionAmount(ItemStack itemStack, List<Potion> potions) {
        Double total = 0.0;
        for (Potion potion : potions) {
            total = total + getPotionAmount(itemStack, potion);
        }
        return total;
    }

    public static Double getDrinkAmount(ItemStack itemStack, TWEDrinks drink) {
        return TWEUtils.getDoubleTag(itemStack, "drink." + drink.getSerializedName());
    }
    
    public static Double getPotionAmount(ItemStack itemStack, Potion potion) {
        return TWEUtils.getDoubleTag(itemStack, "potion." + potion.getRegistryName());
    }

    // Get Ingredient Properties ---------------------------------------------------------------------------------------

    public static String getDrinkName(TWEDrinks drink) {
        return I18n.get("drink." + TheWesternEdgeMod.MODID + "." + drink.getSerializedName());
    }

    public static String getAdditiveName(TWEAdditives additive) {
        return I18n.get("additive." + TheWesternEdgeMod.MODID + "." + additive.getSerializedName());
    }

    // Bottle Properties -----------------------------------------------------------------------------------------------
    public static Double getStrength(ItemStack itemStack) {
        return TWEUtils.getDoubleTag(itemStack, "strength");
    }

    public static ItemStack addStrength(ItemStack itemStack, Double amount, Double strength) {
        Double existingAmount = getAmount(itemStack);
        Double existingStrength = getStrength(itemStack);
        Double newStrength = ((existingStrength * existingAmount) + (strength * amount)) / (existingAmount + amount);
        TWEUtils.putDoubleTag(itemStack,"strength", newStrength);
        return itemStack;
    }

    public static List<MobEffectInstance> getPotionEffects(ItemStack itemStack) {
        return getPotionEffects(itemStack, false);
    }

    public static NonNullList<MobEffectInstance> getPotionEffects(ItemStack itemStack, Boolean mergeDuplicates) {
        List<Potion> potions = getPotions(itemStack);
        NonNullList<MobEffectInstance> effects = NonNullList.create();
        for (Potion potion : potions) {
            List<MobEffectInstance> potionEffects = potion.getEffects();
            for (MobEffectInstance effect : potionEffects) {
                if (!effects.contains(effect) || !mergeDuplicates) {
                    effects.add(effect);
                }
            }
        }
        return effects;
    }

    public static void addDrinkTooltip(ItemStack itemStack, List<Component> components) {
        List<TWEDrinks> drinks = getDrinks(itemStack);
        List<TWEAdditives> additives = getAdditives(itemStack);
        List<MobEffectInstance> effects = getPotionEffects(itemStack, true);
        if (getContentsView(itemStack)) {
            for (TWEDrinks drink : drinks) {
                MutableComponent mutablecomponent = new TextComponent(getDrinkName(drink));
                components.add(mutablecomponent);
            }
            for (MobEffectInstance effect : effects) {
                MutableComponent mutablecomponent = new TranslatableComponent(effect.getDescriptionId());
                MobEffect mobeffect = effect.getEffect();

                if (effect.getAmplifier() > 0) {
                    mutablecomponent = new TranslatableComponent("potion.withAmplifier", mutablecomponent, new TranslatableComponent("potion.potency." + effect.getAmplifier()));
                }

                components.add(mutablecomponent.withStyle(mobeffect.getCategory().getTooltipFormatting()));
            }
        }
        for (TWEAdditives additive : additives) {
            MutableComponent mutablecomponent = new TextComponent(additive.getSerializedName());
            components.add(mutablecomponent);
        }
        Integer amount = getAmount(itemStack).intValue();
        String text = amount.toString() + " Serving";
        if (amount != 1) {
            text = text + "s";
        }
        MutableComponent mutableComponent = new TextComponent(text);
        components.add(mutableComponent);
    }

    public static Boolean getContentsView(ItemStack itemStack) {
        return TWEUtils.getBoolTag(itemStack, "Contents");
    }

    public static ItemStack setContentsView(ItemStack itemStack, Boolean state) {
        TWEUtils.putBoolTag(itemStack,"Contents", state);
        return itemStack;
    }

    public static ItemStack toggleContentsView(ItemStack itemStack) {
        return TWEUtils.toggleBoolTag(itemStack, "Contents");
    }

    public static Integer getBottle(ItemStack itemStack) {
        return TWEUtils.getIntTag(itemStack, "CustomModelData");
    }

    public static ItemStack setBottle(ItemStack itemStack, Integer integer) {
        TWEUtils.putIntTag(itemStack,"CustomModelData", integer);
        return itemStack;
    }

    //Drinking Bottles -------------------------------------------------------------------------------------------------
    public static ItemStack useBottleItem(ItemStack itemStack, Level level, LivingEntity entity) {
        Player player = entity instanceof Player ? (Player)entity : null;
        Integer bottle = BottleUtils.getBottle(itemStack);
        if (player instanceof ServerPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, itemStack);
        }

        if (!level.isClientSide) {
            List<MobEffectInstance> effects;
            if (itemStack.getItem() == Items.POTION) {
                effects = PotionUtils.getMobEffects(itemStack);
            } else {
                effects = getPotionEffects(itemStack);
            }
            for(MobEffectInstance mobeffectinstance : effects) {
                if (mobeffectinstance.getEffect().isInstantenous()) {
                    mobeffectinstance.getEffect().applyInstantenousEffect(player, player, entity, mobeffectinstance.getAmplifier(), 1.0D);
                } else {
                    entity.addEffect(new MobEffectInstance(mobeffectinstance));
                }
            }
        }

        if (player != null) {
            player.awardStat(Stats.ITEM_USED.get(itemStack.getItem()));
            if (!player.getAbilities().instabuild) {
                itemStack.shrink(1);
            }
        }

        if (player == null || !player.getAbilities().instabuild) {
            if (itemStack.isEmpty()) {
                return BottleUtils.setBottle(new ItemStack(Items.GLASS_BOTTLE), bottle);
            }

            if (player != null) {
                player.getInventory().add(BottleUtils.setBottle(new ItemStack(Items.GLASS_BOTTLE), bottle));
            }
        }

        level.gameEvent(entity, GameEvent.DRINKING_FINISH, entity.eyeBlockPosition());
        return itemStack;
    }

    public static Integer getUseDuration(ItemStack itemStack) {
        Double amount = BottleUtils.getAmount(itemStack);
        if (amount >= 1.0) {
            return 32;
        } else {
            return (int)(32 * amount);
        }
    }
}
