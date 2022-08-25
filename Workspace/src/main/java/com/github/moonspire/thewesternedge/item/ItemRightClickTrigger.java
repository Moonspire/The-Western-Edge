package com.github.moonspire.thewesternedge.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public interface ItemRightClickTrigger {
    public int mobInteract(InteractionHand hand, Entity entity, Player player);
}
