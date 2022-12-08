package net.ironhorsedevgroup.mods.thewesternedge.entity.cryptid;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public abstract class PathingCryptid extends PathfinderMob {
    protected PathingCryptid(EntityType<? extends PathingCryptid> pathingCryptid, Level level) {
        super(pathingCryptid, level);
        this.xpReward = 5;
    }

    public SoundSource getSoundSource() {
        return SoundSource.NEUTRAL;
    }

    protected boolean shouldDespawnInPeaceful() {
        return true;
    }

    public static AttributeSupplier.Builder createCryptidAttributes() {
        return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE);
    }

    public boolean canBeLeashed(Player player) {
        return false;
    }
}
