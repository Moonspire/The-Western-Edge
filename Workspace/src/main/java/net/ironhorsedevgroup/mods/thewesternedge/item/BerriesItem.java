package net.ironhorsedevgroup.mods.thewesternedge.item;

import net.ironhorsedevgroup.mods.thewesternedge.TWEUtils;
import net.ironhorsedevgroup.mods.thewesternedge.TheWesternEdgeMod;
import net.ironhorsedevgroup.mods.thewesternedge.block.berries.BerryType;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import java.util.Arrays;

public class BerriesItem extends ItemNameBlockItem {
    public BerriesItem (Block block, Item.Properties properties) {
        super(block, properties);
    }

    @Override
    public String getDescriptionId(ItemStack itemStack) {
        return I18n.get("berries." + TheWesternEdgeMod.MODID + "." + getBerryType(itemStack).getSerializedName());
    }

    public static BerryType getBerryType(ItemStack itemStack) {
        return getBerryType(TWEUtils.getIntTag(itemStack, "CustomModelData"));
    }

    public static BerryType getBerryType(Integer id) {
        return Arrays.stream(BerryType.values()).toList().get(id);
    }

    public static ItemStack setBerryType(ItemStack itemStack, BerryType berryType) {
        return setBerryType(itemStack, getBerryId(berryType));
    }

    public static ItemStack setBerryType(ItemStack itemStack, Integer id) {
        TWEUtils.putIntTag(itemStack, "CustomModelData", id);
        return itemStack;
    }

    public static Integer getBerryId(BerryType berryType) {
        return Arrays.stream(BerryType.values()).toList().indexOf(berryType);
    }

    @Override
    public void fillItemCategory(CreativeModeTab tab, NonNullList<ItemStack> itemStack) {
        if (this.allowdedIn(tab)) {
            for (BerryType berryType : BerryType.values()) {
                ItemStack newStack = new ItemStack(this);
                this.setBerryType(newStack, berryType);
                itemStack.add(newStack);
            }
        }
    }
}
