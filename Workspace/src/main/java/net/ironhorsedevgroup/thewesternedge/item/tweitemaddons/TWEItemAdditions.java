package net.ironhorsedevgroup.thewesternedge.item.tweitemaddons;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public interface TWEItemAdditions {
    int mobInteract(InteractionHand hand, Entity entity, Player player);
}
