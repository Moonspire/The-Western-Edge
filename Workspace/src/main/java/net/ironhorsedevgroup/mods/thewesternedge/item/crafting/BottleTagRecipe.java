package net.ironhorsedevgroup.mods.thewesternedge.item.crafting;

import net.ironhorsedevgroup.mods.thewesternedge.TWEUtils;
import net.ironhorsedevgroup.mods.thewesternedge.item.bottles.BottleUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

public class BottleTagRecipe extends CustomRecipe {
    public BottleTagRecipe(ResourceLocation location) {
        super(location);
    }

    public boolean matches(CraftingContainer container, Level level) {
        int i = 0;
        for(int j = 1; j < container.getContainerSize(); ++j) {
            ItemStack itemstack = container.getItem(j);
            if (!itemstack.isEmpty()) {
                if (itemstack.is(TWEUtils.getTag("bottle_items"))) {
                    i = i + 1;
                }
            }
        }
        if (i == 1) {
            return true;
        }
        return false;
    }

    public ItemStack assemble(CraftingContainer container) {
        ItemStack retStack = container.getItem(0);
        for(int i = 0; i < container.getContainerSize(); i++) {
            ItemStack itemStack = container.getItem(i);
            if (!itemStack.isEmpty()) {
                retStack = BottleUtils.copyBottleProperties(itemStack, retStack);
                break;
            }
        }
        return retStack;
    }

    public boolean canCraftInDimensions(int p_43844_, int p_43845_) {
        return p_43844_ * p_43845_ >= 2;
    }

    public ItemStack getResultItem() {
        return ItemStack.EMPTY;
    }

    public RecipeSerializer<?> getSerializer() {
        return RecipeSerializer.FIREWORK_ROCKET;
    }
}
