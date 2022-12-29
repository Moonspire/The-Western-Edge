package net.ironhorsedevgroup.mods.thewesternedge.entity.projectiles;

import net.ironhorsedevgroup.mods.thewesternedge.TWEUtils;
import net.ironhorsedevgroup.mods.thewesternedge.init.TWEEntities;
import net.ironhorsedevgroup.mods.thewesternedge.init.TWEItems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class DynamiteProjectile extends ThrowableItemProjectile {
    private int fuse;
    public DynamiteProjectile(EntityType<? extends ThrowableItemProjectile> entity, Level level) {
        super(entity, level);
    }

    public DynamiteProjectile(Level p_37399_, LivingEntity p_37400_) {
        super(TWEEntities.DYNAMITE.get(), p_37400_, p_37399_);
    }

    public DynamiteProjectile(Level p_37394_, double p_37395_, double p_37396_, double p_37397_) {
        super(TWEEntities.DYNAMITE.get(), p_37395_, p_37396_, p_37397_, p_37394_);
    }

    public void setFuse(int fuse){
        this.fuse = fuse;
    }

    @Override
    protected Item getDefaultItem() {
        return TWEItems.DYNAMITE.get();
    }

    private ParticleOptions getParticle() {
        ItemStack itemstack = this.getItemRaw();
        return (ParticleOptions)(itemstack.isEmpty() ? new ItemParticleOption(ParticleTypes.ITEM, new ItemStack(TWEItems.DYNAMITE.get()))
                : new ItemParticleOption(ParticleTypes.ITEM, itemstack));
    }

    @Override
    public void handleEntityEvent(byte p_37402_) {
        if (p_37402_ == 3) {
            ParticleOptions particleoptions = this.getParticle();

            for(int i = 0; i < 8; ++i) {
                this.level.addParticle(particleoptions, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }

    }

    @Override
    protected void onHitEntity(EntityHitResult p_37404_) {
        super.onHitEntity(p_37404_);
        Entity entity = p_37404_.getEntity();
        int i = entity instanceof Blaze ? 3 : 0;
        entity.hurt(DamageSource.thrown(this, this.getOwner()), (float)i);
    }

    @Override
    protected void onHit(HitResult p_37406_) {
        this.setDeltaMovement(0.0, 0.0, 0.0);
        super.onHit(p_37406_);
    }

    @Override
    public void tick() {
        if (!this.onGround) {
            super.tick();
        }
        if (!level.isClientSide){
            int fuse = this.fuse;
            if (fuse > 0) {
                this.fuse = fuse - 1;
            } else {
                this.level.broadcastEntityEvent(this, (byte) 3);
                TWEUtils.explode(level, 1.5, this.position(), this);
                this.discard();
            }
        }
    }
}
