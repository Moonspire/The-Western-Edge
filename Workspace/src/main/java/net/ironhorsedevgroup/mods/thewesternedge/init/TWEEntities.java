package net.ironhorsedevgroup.mods.thewesternedge.init;

import net.ironhorsedevgroup.mods.thewesternedge.TheWesternEdgeMod;
import net.ironhorsedevgroup.mods.thewesternedge.entity.projectiles.DynamiteProjectile;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TWEEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, TheWesternEdgeMod.MODID);
    public static final RegistryObject<EntityType<DynamiteProjectile>> DYNAMITE = REGISTRY.register("dynamite", () ->
            registerEntity(EntityType.Builder.<DynamiteProjectile>of(DynamiteProjectile::new, MobCategory.MISC).sized(0.25F, 0.25F), "dynamite"));

    private static final EntityType registerEntity(EntityType.Builder builder, String entityName) {
        return (EntityType) builder.build(entityName);
    }


}
