package net.ironhorsedevgroup.mods.thewesternedge.item.drinks;

import net.ironhorsedevgroup.mods.thewesternedge.TWEUtils;
import net.ironhorsedevgroup.mods.thewesternedge.TheWesternEdgeMod;
import net.ironhorsedevgroup.mods.thewesternedge.init.TWEItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BottleUtils {
    private static List<BottleVariants> bottleProperties = Arrays.stream(BottleVariants.values()).toList();
    
    // Modifying Ingredients -------------------------------------------------------------------------------------------
    public static ItemStack drainAmount(ItemStack itemStack, Double amount) {
        Double servings = getAmount(itemStack);
        Double newServings = servings - amount;
        if (newServings <= 0.0) {
            return createEmptyCopy(itemStack);
        }
        if (itemStack.getItem() == Items.POTION) {
            return TWEUtils.putDoubleTag(itemStack, "Servings", newServings);
        } else {
            NonNullList<BottleDrinks> drinks = getDrinks(itemStack);
            NonNullList<BottleAdditives> additives = getAdditives(itemStack);
            NonNullList<Potion> potions = getPotions(itemStack);
            ItemStack retStack = copyBottleProperties(itemStack, new ItemStack(itemStack.getItem()));
            for (BottleDrinks drink : drinks) {
                Double drinkStrength = getStrength(itemStack);
                Double drinkAmount = getDrinkAmount(itemStack, drink);
                Double newAmount = drinkAmount / (servings / newServings);
                addDrink(retStack, drink, newAmount, drinkStrength);
            }
            for (BottleAdditives additive : additives) {
                Double additiveAmount = getAdditiveAmount(itemStack, additive);
                Double newAmount = additiveAmount / (servings / newServings);
                addAdditive(retStack, additive, newAmount);
            }
            for (Potion potion : potions) {
                Double potionAmount = getPotionAmount(itemStack, potion);
                Double newAmount = potionAmount / (servings / newServings);
                addPotion(retStack, potion, newAmount);
            }
            return retStack;
        }
    }

    public static ItemStack addDrinks(ItemStack itemStack, List<BottleDrinks> drinks) {
        Double amount = 1.0 / drinks.size();
        for (int i = 0; i < drinks.size(); i++) {
            addDrink(itemStack, drinks.get(i), amount);
        }
        return itemStack;
    }

    public static ItemStack addDrinks(ItemStack itemStack, List<BottleDrinks> drinks, Double amounts) {
        for (int i = 0; i < drinks.size(); i++) {
            addDrink(itemStack, drinks.get(i), amounts);
        }
        return itemStack;
    }

    public static ItemStack addDrinks(ItemStack itemStack, List<BottleDrinks> drinks, List<Double> amounts) {
        for (int i = 0; i < drinks.size(); i++) {
            addDrink(itemStack, drinks.get(i), amounts.get(i));
        }
        return itemStack;
    }

    public static ItemStack addDrinks(ItemStack itemStack, List<BottleDrinks> drinks, List<Double> amounts, List<Double> strengths) {
        for (int i = 0; i < drinks.size(); i++) {
            addDrink(itemStack, drinks.get(i), amounts.get(i), strengths.get(i));
        }
        return itemStack;
    }

    public static ItemStack addDrink(ItemStack itemStack, BottleDrinks drink) {
        return addDrink(itemStack, drink, 1.0, drink.getDefaultStrength());
    }

    public static ItemStack addDrink(ItemStack itemStack, BottleDrinks drink, Double amount) {
        return addDrink(itemStack, drink, amount, drink.getDefaultStrength());
    }

    public static ItemStack addDrink(ItemStack itemStack, BottleDrinks drink, Double amount, Double strength) {
        if (drink != BottleDrinks.EMPTY) {
            Double bottleSize = getBottleSize(itemStack);
            Double existingAmount = getAmount(itemStack);
            if (amount + existingAmount > bottleSize) {
                amount = bottleSize - existingAmount;
            }
            Double drinkAmount = getDrinkAmount(itemStack, drink);
            TWEUtils.putDoubleTag(itemStack, "drink." + drink.getSerializedName(), amount + drinkAmount);
            addStrength(itemStack, amount, strength);
        }
        return itemStack;
    }

    public static ItemStack addAdditives(ItemStack itemStack, List<BottleAdditives> additives) {
        Double amount = 1.0 / additives.size();
        for (int i = 0; i < additives.size(); i++) {
            addAdditive(itemStack, additives.get(i), amount);
        }
        return itemStack;
    }

    public static ItemStack addAdditives(ItemStack itemStack, List<BottleAdditives> additives, Double amounts) {
        for (int i = 0; i < additives.size(); i++) {
            addAdditive(itemStack, additives.get(i), amounts);
        }
        return itemStack;
    }

    public static ItemStack addAdditives(ItemStack itemStack, List<BottleAdditives> additives, List<Double> amounts) {
        for (int i = 0; i < additives.size(); i++) {
            addAdditive(itemStack, additives.get(i), amounts.get(i));
        }
        return itemStack;
    }

    public static ItemStack addAdditive(ItemStack itemStack, BottleAdditives additive) {
        return addAdditive(itemStack, additive, 1.0);
    }

    public static ItemStack addAdditive(ItemStack itemStack, BottleAdditives additive, Double amount) {
        if (additive != BottleAdditives.EMPTY && getAmount(itemStack) != 0) {
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
            Double bottleSize = getBottleSize(itemStack);
            System.out.println("Bottle Size: " + bottleSize);
            Double existingAmount = getAmount(itemStack);
            System.out.println("Existing Amount: " + existingAmount);
            System.out.println("Attempted Amount: " + amount);
            if (amount + existingAmount > bottleSize) {
                amount = bottleSize - existingAmount;
            }
            System.out.println("Added Amount: " + amount);
            Double potionAmount = getPotionAmount(itemStack, potion);
            System.out.println("Existing Potion Amount: " + potionAmount);
            if (itemStack.getItem() == Items.POTION) {
                Potion existingPotion = PotionUtils.getPotion(itemStack);
                if (existingPotion == potion) {
                    TWEUtils.putDoubleTag(itemStack, "Servings", amount + potionAmount);
                } else {
                    itemStack = addPotion(copyBottleProperties(itemStack, new ItemStack(TWEItems.DRINK.get())), existingPotion, existingAmount);
                    addPotion(itemStack, potion, amount);
                }
            } else if (itemStack.getItem() == Items.GLASS_BOTTLE){
                itemStack = PotionUtils.setPotion(copyBottleProperties(itemStack, new ItemStack(Items.POTION)), potion);
                TWEUtils.putDoubleTag(itemStack, "Servings", amount);
            } else {
                TWEUtils.putDoubleTag(itemStack,"potion." + potion.getRegistryName(), amount + potionAmount);
            }
        }
        return itemStack;
    }

    // Get Ingredients -------------------------------------------------------------------------------------------------
    public static Boolean isDrinks(ItemStack itemStack, List<BottleDrinks> drinks) {
        for (BottleDrinks drink : drinks) {
            if (!isDrink(itemStack, drink)) {
                return false;
            }
        }
        return true;
    }

    public static Boolean isDrink(ItemStack itemStack, BottleDrinks drink) {
        if (TWEUtils.getDoubleTag(itemStack, "drink." + drink.getSerializedName()) != 0){
            return true;
        }
        return false;
    }

    public static NonNullList<BottleDrinks> getDrinks(ItemStack itemStack) {
        NonNullList<BottleDrinks> drinks = NonNullList.create();
        for (BottleDrinks drink : BottleDrinks.values()) {
            if (isDrink(itemStack, drink)) {
                drinks.add(drink);
            }
        }
        return drinks;
    }

    public static Boolean isAdditives(ItemStack itemStack, List<BottleAdditives> additives) {
        for (BottleAdditives additive : additives) {
            if (!isAdditive(itemStack, additive)) {
                return false;
            }
        }
        return true;
    }

    public static Boolean isAdditive(ItemStack itemStack, BottleAdditives additive) {
        if (TWEUtils.getDoubleTag(itemStack, "additive." + additive.getSerializedName()) != 0){
            return true;
        }
        return false;
    }

    public static NonNullList<BottleAdditives> getAdditives(ItemStack itemStack) {
        NonNullList<BottleAdditives> additives = NonNullList.create();
        for (BottleAdditives additive : BottleAdditives.values()) {
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
    public static Double getBottleSize(ItemStack itemStack) {
        return getBottle(itemStack).getServings();
    }

    public static Double getAmount(ItemStack itemStack) {
        return getDrinkAmount(itemStack, List.of(BottleDrinks.values()))
                + getPotionAmount(itemStack, Registry.POTION.stream().toList())
                + getAdditiveAmount(itemStack, List.of(BottleAdditives.values()));
    }

    public static Double getDrinkAmount(ItemStack itemStack, List<BottleDrinks> drinks) {
        Double total = 0.0;
        for (BottleDrinks drink : drinks) {
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

    public static Double getAdditiveAmount(ItemStack itemStack, List<BottleAdditives> additives) {
        Double total = 0.0;
        for (BottleAdditives additive : additives) {
            total = total + getAdditiveAmount(itemStack, additive);
        }
        return total;
    }

    public static Double getDrinkAmount(ItemStack itemStack, BottleDrinks drink) {
        if (itemStack.getItem() != Items.GLASS_BOTTLE && itemStack.getItem() != Items.POTION) {
            return TWEUtils.getDoubleTag(itemStack, "drink." + drink.getSerializedName());
        } else {
            return 0.0;
        }
    }
    
    public static Double getPotionAmount(ItemStack itemStack, Potion potion) {
        if (itemStack.getItem() == Items.POTION) {
            if (PotionUtils.getPotion(itemStack) == potion) {
                Double servings = TWEUtils.getDoubleTag(itemStack, "Servings");
                if (servings == 0.0) {
                    return 1.0;
                } else {
                    return servings;
                }
            } else {
                return 0.0;
            }
        } else if (itemStack.getItem() == Items.GLASS_BOTTLE) {
            return 0.0;
        } else {
            return TWEUtils.getDoubleTag(itemStack, "potion." + potion.getRegistryName());
        }
    }

    public static Double getAdditiveAmount(ItemStack itemStack, BottleAdditives additive) {
        if (itemStack.getItem() != Items.GLASS_BOTTLE && itemStack.getItem() != Items.POTION) {
            return TWEUtils.getDoubleTag(itemStack, "additive." + additive.getSerializedName());
        } else {
            return 0.0;
        }
    }

    public static Double getPotionAmountPerServing(ItemStack itemStack, Potion potion) {
        return getPotionAmount(itemStack, potion) / getAmount(itemStack);
    }

    // Get Ingredient Properties ---------------------------------------------------------------------------------------

    public static String getDrinkName(BottleDrinks drink) {
        return I18n.get("drink." + TheWesternEdgeMod.MODID + "." + drink.getSerializedName());
    }

    public static String getAdditiveName(BottleAdditives additive) {
        return I18n.get("additive." + TheWesternEdgeMod.MODID + "." + additive.getSerializedName());
    }

    // Bottle Properties -----------------------------------------------------------------------------------------------
    public static String getName(ItemStack itemStack) {
        String name = getCustomName(itemStack);
        if (name == "") {
            if (itemStack.getItem() == Items.GLASS_BOTTLE) {
                BottleVariants bottle = getBottle(itemStack);
                String bottleName = bottle.getSerializedName();
                if (bottleName != "default" && itemStack.getItem() == Items.GLASS_BOTTLE) {
                    return I18n.get("bottle." + TheWesternEdgeMod.MODID + "." + bottleName);
                }
            }
            return itemStack.getItem().getDescriptionId();
        }
        return name;
    }

    public static String getCustomName(ItemStack itemStack) {
        return TWEUtils.getStringTag(itemStack, "BottleName");
    }

    public static ItemStack setName(ItemStack itemStack, String name) {
        return TWEUtils.putStringTag(itemStack, "BottleName", name);
    }

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

    public static NonNullList<MobEffectInstance> getPotionEffects(ItemStack itemStack) {
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
        List<BottleDrinks> drinks = getDrinks(itemStack);
        List<BottleAdditives> additives = getAdditives(itemStack);
        List<MobEffectInstance> effects = getPotionEffects(itemStack, true);
        if (getContentsView(itemStack)) {
            for (BottleDrinks drink : drinks) {
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
        for (BottleAdditives additive : additives) {
            MutableComponent mutablecomponent = new TextComponent(additive.getSerializedName());
            components.add(mutablecomponent);
        }
        MutableComponent mutableComponent = new TextComponent(I18n.get("misc." + TheWesternEdgeMod.MODID + ".serving_name") + ": " + getAmount(itemStack));
        components.add(mutableComponent);
    }

    public static Boolean getContentsView(ItemStack itemStack) {
        return TWEUtils.getBoolTag(itemStack, "Contents");
    }

    public static ItemStack setContentsView(ItemStack itemStack, Boolean state) {
        TWEUtils.putBoolTag(itemStack,"Contents", state);
        return itemStack;
    }

    public static BottleVariants getBottle(ItemStack itemStack) {
        return bottleProperties.get(TWEUtils.getIntTag(itemStack, "CustomModelData"));
    }

    public static ItemStack setBottle(ItemStack itemStack, BottleVariants bottle) {
        TWEUtils.putIntTag(itemStack,"CustomModelData", bottleProperties.indexOf(bottle));
        return itemStack;
    }

    public static Integer getAllBottles() {
        return bottleProperties.size();
    }

    public static ItemStack createEmptyCopy(ItemStack itemStack) {
        return copyBottleProperties(itemStack, new ItemStack(Items.GLASS_BOTTLE));
    }

    public static ItemStack createBrokenCopy(ItemStack itemStack) {
        return createBrokenBottle(getBottle(itemStack));
    }

    public static ItemStack createBottle(BottleVariants bottle) {
        return setBottle(new ItemStack(Items.GLASS_BOTTLE), bottle);
    }

    public static ItemStack createBrokenBottle(BottleVariants bottle) {
        return setBottle(new ItemStack(TWEItems.BROKEN_BOTTLE.get()), bottle);
    }

    public static Boolean isBreakable(ItemStack itemStack) {
        return getBottle(itemStack).isBreakable();
    }

    public static Boolean isLabeled(ItemStack itemStack) {
        return getBottle(itemStack).isLabeled();
    }

    public static ItemStack copyBottleProperties(ItemStack oldBottle, ItemStack newBottle) {
        setBottle(newBottle, getBottle(oldBottle));
        setName(newBottle, getCustomName(oldBottle));
        setContentsView(newBottle, getContentsView(oldBottle));
        return newBottle;
    }

    //Drinking Bottles -------------------------------------------------------------------------------------------------
    public static ItemStack useBottleItem(ItemStack itemStack, Level level, LivingEntity entity) {
        Player player = entity instanceof Player ? (Player)entity : null;
        Double servings = getAmount(itemStack);
        if (player instanceof ServerPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, itemStack);
        }

        if (!level.isClientSide) {
            if (itemStack.getItem() == Items.POTION) {
                List<MobEffectInstance> effects = PotionUtils.getMobEffects(itemStack);
                for(MobEffectInstance mobeffectinstance : effects) {
                    if (mobeffectinstance.getEffect().isInstantenous()) {
                        mobeffectinstance.getEffect().applyInstantenousEffect(player, player, entity, mobeffectinstance.getAmplifier(), 1.0);
                    } else {
                        entity.addEffect(new MobEffectInstance(mobeffectinstance));
                    }
                }
            } else {
                applyBottleEffects(itemStack, entity);
            }
        }

        if (player != null) {
            player.awardStat(Stats.ITEM_USED.get(itemStack.getItem()));
            if (!player.getAbilities().instabuild) {
                itemStack = drainAmount(itemStack, 1.0);
                player.displayClientMessage(new TextComponent(I18n.get("misc." + TheWesternEdgeMod.MODID + ".serving_name") + ": " + BottleUtils.getAmount(itemStack)), (true));
                return itemStack;
            }
        }

        level.gameEvent(entity, GameEvent.DRINKING_FINISH, entity.eyeBlockPosition());
        return itemStack;
    }

    public static ItemStack use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        HitResult hitresult = TWEUtils.getPlayerPOVHitResult(level, player, ClipContext.Fluid.SOURCE_ONLY);
        if (hitresult.getType() == HitResult.Type.BLOCK) {
            BlockPos blockpos = ((BlockHitResult)hitresult).getBlockPos();
            BlockState blockState = level.getBlockState(blockpos);
            if ((level.mayInteract(player, blockpos) && blockState.is(Blocks.WATER_CAULDRON) && player.isCrouching()) || (level.mayInteract(player, blockpos) && level.getFluidState(blockpos).is(FluidTags.WATER))) {
                if (BottleUtils.getAmount(itemStack) < BottleUtils.getBottleSize(itemStack)) {
                    if (blockState.is(Blocks.WATER_CAULDRON)) {
                        LayeredCauldronBlock.lowerFillLevel(blockState, level, blockpos);
                    }
                    level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BOTTLE_FILL, SoundSource.NEUTRAL, 1.0F, 1.0F);
                    level.gameEvent(player, GameEvent.FLUID_PICKUP, blockpos);
                    itemStack = BottleUtils.addPotion(itemStack, Potions.WATER);
                    player.displayClientMessage(new TextComponent(I18n.get("misc." + TheWesternEdgeMod.MODID + ".serving_name") + ": " + BottleUtils.getAmount(itemStack)), (true));
                    return itemStack;
                }
            }
        }
        return null;
    }

    public static Integer getUseDuration(ItemStack itemStack) {
        Double amount = BottleUtils.getAmount(itemStack);
        if (amount >= 1.0) {
            return 32;
        } else {
            return (int)(32 * amount);
        }
    }

    public static ItemStack applyBottleEffects(ItemStack itemStack, LivingEntity entity) {
        Player player = entity instanceof Player ? (Player)entity : null;
        List<Potion> potions = getPotions(itemStack);
        HashMap<MobEffectInstance, Double> effects = new HashMap<>();
        for (Potion potion : potions) {
            List<MobEffectInstance> potionEffects = potion.getEffects();
            for (MobEffectInstance effect : potionEffects) {
                if (!effects.containsKey(effect)) {
                    effects.put(effect, getPotionAmountPerServing(itemStack, potion));
                } else {
                    effects.put(effect, effects.get(effect) + getPotionAmountPerServing(itemStack, potion));
                }
            }
        }
        for (Map.Entry<MobEffectInstance, Double> entry : effects.entrySet()) {
            MobEffectInstance context = entry.getKey();
            if (entry.getKey().getEffect().isInstantenous()) {
                context.getEffect().applyInstantenousEffect(player, player, entity, context.getAmplifier(), entry.getValue());
            } else {
                entity.addEffect(new MobEffectInstance(context.getEffect(), (int)(entry.getValue() * context.getDuration()), context.getAmplifier()));
            }
        }
        return itemStack;
    }
}
