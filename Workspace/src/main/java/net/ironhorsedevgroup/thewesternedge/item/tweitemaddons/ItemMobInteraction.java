package net.ironhorsedevgroup.thewesternedge.item.tweitemaddons;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.gossip.GossipType;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;

public class ItemMobInteraction {
    public static int PoppyInteract(InteractionHand hand, Entity entity, Player player) {
        if (entity instanceof Villager villager) {
            villager.heal(1.0F);
            villager.getGossips().add(player.getUUID(), GossipType.MINOR_POSITIVE, 5);
            return 0;
        }
        return -1;
    }
}
