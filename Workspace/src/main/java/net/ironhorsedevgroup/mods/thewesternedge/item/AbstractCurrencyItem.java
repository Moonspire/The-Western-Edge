package net.ironhorsedevgroup.mods.thewesternedge.item;

import net.ironhorsedevgroup.mods.thewesternedge.TWEUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import org.jetbrains.annotations.Nullable;

import javax.tools.Tool;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class AbstractCurrencyItem extends Item {
    private static double VALUE = 0;

    public AbstractCurrencyItem(Item.Properties properties) {
        super(properties);
    }

    public double getCurrencyValue() {
        return VALUE;
    }

    public String getCurrencyID(ItemStack itemstack) {
        if (itemstack.getItem() instanceof AbstractCurrencyItem) {
            return TWEUtils.getStringTag(itemstack, "CurrencyID");
        }
        return "";
    }

    public void setCurrencyID(ItemStack itemstack, Level level) {
        String currencyID = UUID.randomUUID().toString();
        List<Component> components = List.of(new TextComponent(currencyID));
        itemstack.getOrCreateTag().putString("CurrencyID", currencyID);

    }
}
