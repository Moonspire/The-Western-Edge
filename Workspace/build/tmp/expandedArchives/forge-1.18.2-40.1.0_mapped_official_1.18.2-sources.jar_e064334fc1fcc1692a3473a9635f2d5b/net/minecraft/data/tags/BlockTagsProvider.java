package net.minecraft.data.tags;

import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class BlockTagsProvider extends TagsProvider<Block> {
   /** @deprecated Forge: Use the {@link #BlockTagsProvider(DataGenerator, String, net.minecraftforge.common.data.ExistingFileHelper) mod id variant} */
   @Deprecated
   public BlockTagsProvider(DataGenerator p_126511_) {
      super(p_126511_, Registry.BLOCK);
   }
   public BlockTagsProvider(DataGenerator p_126511_, String modId, @org.jetbrains.annotations.Nullable net.minecraftforge.common.data.ExistingFileHelper existingFileHelper) {
      super(p_126511_, Registry.BLOCK, modId, existingFileHelper);
   }

   protected void addTags() {
      this.tag(BlockTags.WOOL).add(Blocks.WHITE_WOOL, Blocks.ORANGE_WOOL, Blocks.MAGENTA_WOOL, Blocks.LIGHT_BLUE_WOOL, Blocks.YELLOW_WOOL, Blocks.LIME_WOOL, Blocks.PINK_WOOL, Blocks.GRAY_WOOL, Blocks.LIGHT_GRAY_WOOL, Blocks.CYAN_WOOL, Blocks.PURPLE_WOOL, Blocks.BLUE_WOOL, Blocks.BROWN_WOOL, Blocks.GREEN_WOOL, Blocks.RED_WOOL, Blocks.BLACK_WOOL);
      this.tag(BlockTags.PLANKS).add(Blocks.OAK_PLANKS, Blocks.SPRUCE_PLANKS, Blocks.BIRCH_PLANKS, Blocks.JUNGLE_PLANKS, Blocks.ACACIA_PLANKS, Blocks.DARK_OAK_PLANKS, Blocks.CRIMSON_PLANKS, Blocks.WARPED_PLANKS);
      this.tag(BlockTags.STONE_BRICKS).add(Blocks.STONE_BRICKS, Blocks.MOSSY_STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS, Blocks.CHISELED_STONE_BRICKS);
      this.tag(BlockTags.WOODEN_BUTTONS).add(Blocks.OAK_BUTTON, Blocks.SPRUCE_BUTTON, Blocks.BIRCH_BUTTON, Blocks.JUNGLE_BUTTON, Blocks.ACACIA_BUTTON, Blocks.DARK_OAK_BUTTON, Blocks.CRIMSON_BUTTON, Blocks.WARPED_BUTTON);
      this.tag(BlockTags.BUTTONS).addTag(BlockTags.WOODEN_BUTTONS).add(Blocks.STONE_BUTTON).add(Blocks.POLISHED_BLACKSTONE_BUTTON);
      this.tag(BlockTags.CARPETS).add(Blocks.WHITE_CARPET, Blocks.ORANGE_CARPET, Blocks.MAGENTA_CARPET, Blocks.LIGHT_BLUE_CARPET, Blocks.YELLOW_CARPET, Blocks.LIME_CARPET, Blocks.PINK_CARPET, Blocks.GRAY_CARPET, Blocks.LIGHT_GRAY_CARPET, Blocks.CYAN_CARPET, Blocks.PURPLE_CARPET, Blocks.BLUE_CARPET, Blocks.BROWN_CARPET, Blocks.GREEN_CARPET, Blocks.RED_CARPET, Blocks.BLACK_CARPET);
      this.tag(BlockTags.WOODEN_DOORS).add(Blocks.OAK_DOOR, Blocks.SPRUCE_DOOR, Blocks.BIRCH_DOOR, Blocks.JUNGLE_DOOR, Blocks.ACACIA_DOOR, Blocks.DARK_OAK_DOOR, Blocks.CRIMSON_DOOR, Blocks.WARPED_DOOR);
      this.tag(BlockTags.WOODEN_STAIRS).add(Blocks.OAK_STAIRS, Blocks.SPRUCE_STAIRS, Blocks.BIRCH_STAIRS, Blocks.JUNGLE_STAIRS, Blocks.ACACIA_STAIRS, Blocks.DARK_OAK_STAIRS, Blocks.CRIMSON_STAIRS, Blocks.WARPED_STAIRS);
      this.tag(BlockTags.WOODEN_SLABS).add(Blocks.OAK_SLAB, Blocks.SPRUCE_SLAB, Blocks.BIRCH_SLAB, Blocks.JUNGLE_SLAB, Blocks.ACACIA_SLAB, Blocks.DARK_OAK_SLAB, Blocks.CRIMSON_SLAB, Blocks.WARPED_SLAB);
      this.tag(BlockTags.WOODEN_FENCES).add(Blocks.OAK_FENCE, Blocks.ACACIA_FENCE, Blocks.DARK_OAK_FENCE, Blocks.SPRUCE_FENCE, Blocks.BIRCH_FENCE, Blocks.JUNGLE_FENCE, Blocks.CRIMSON_FENCE, Blocks.WARPED_FENCE);
      this.tag(BlockTags.DOORS).addTag(BlockTags.WOODEN_DOORS).add(Blocks.IRON_DOOR);
      this.tag(BlockTags.SAPLINGS).add(Blocks.OAK_SAPLING, Blocks.SPRUCE_SAPLING, Blocks.BIRCH_SAPLING, Blocks.JUNGLE_SAPLING, Blocks.ACACIA_SAPLING, Blocks.DARK_OAK_SAPLING, Blocks.AZALEA, Blocks.FLOWERING_AZALEA);
      this.tag(BlockTags.DARK_OAK_LOGS).add(Blocks.DARK_OAK_LOG, Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_WOOD);
      this.tag(BlockTags.OAK_LOGS).add(Blocks.OAK_LOG, Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_LOG, Blocks.STRIPPED_OAK_WOOD);
      this.tag(BlockTags.ACACIA_LOGS).add(Blocks.ACACIA_LOG, Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_LOG, Blocks.STRIPPED_ACACIA_WOOD);
      this.tag(BlockTags.BIRCH_LOGS).add(Blocks.BIRCH_LOG, Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_LOG, Blocks.STRIPPED_BIRCH_WOOD);
      this.tag(BlockTags.JUNGLE_LOGS).add(Blocks.JUNGLE_LOG, Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_WOOD);
      this.tag(BlockTags.SPRUCE_LOGS).add(Blocks.SPRUCE_LOG, Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_WOOD);
      this.tag(BlockTags.CRIMSON_STEMS).add(Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM, Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE);
      this.tag(BlockTags.WARPED_STEMS).add(Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM, Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE);
      this.tag(BlockTags.LOGS_THAT_BURN).addTag(BlockTags.DARK_OAK_LOGS).addTag(BlockTags.OAK_LOGS).addTag(BlockTags.ACACIA_LOGS).addTag(BlockTags.BIRCH_LOGS).addTag(BlockTags.JUNGLE_LOGS).addTag(BlockTags.SPRUCE_LOGS);
      this.tag(BlockTags.LOGS).addTag(BlockTags.LOGS_THAT_BURN).addTag(BlockTags.CRIMSON_STEMS).addTag(BlockTags.WARPED_STEMS);
      this.tag(BlockTags.ANVIL).add(Blocks.ANVIL, Blocks.CHIPPED_ANVIL, Blocks.DAMAGED_ANVIL);
      this.tag(BlockTags.SMALL_FLOWERS).add(Blocks.DANDELION, Blocks.POPPY, Blocks.BLUE_ORCHID, Blocks.ALLIUM, Blocks.AZURE_BLUET, Blocks.RED_TULIP, Blocks.ORANGE_TULIP, Blocks.WHITE_TULIP, Blocks.PINK_TULIP, Blocks.OXEYE_DAISY, Blocks.CORNFLOWER, Blocks.LILY_OF_THE_VALLEY, Blocks.WITHER_ROSE);
      this.tag(BlockTags.DIRT).add(Blocks.DIRT, Blocks.GRASS_BLOCK, Blocks.PODZOL, Blocks.COARSE_DIRT, Blocks.MYCELIUM, Blocks.ROOTED_DIRT, Blocks.MOSS_BLOCK);
      this.tag(BlockTags.ENDERMAN_HOLDABLE).addTag(BlockTags.SMALL_FLOWERS).addTag(BlockTags.DIRT).add(Blocks.SAND, Blocks.RED_SAND, Blocks.GRAVEL, Blocks.BROWN_MUSHROOM, Blocks.RED_MUSHROOM, Blocks.TNT, Blocks.CACTUS, Blocks.CLAY, Blocks.PUMPKIN, Blocks.CARVED_PUMPKIN, Blocks.MELON, Blocks.CRIMSON_FUNGUS, Blocks.CRIMSON_NYLIUM, Blocks.CRIMSON_ROOTS, Blocks.WARPED_FUNGUS, Blocks.WARPED_NYLIUM, Blocks.WARPED_ROOTS);
      this.tag(BlockTags.FLOWER_POTS).add(Blocks.FLOWER_POT, Blocks.POTTED_POPPY, Blocks.POTTED_BLUE_ORCHID, Blocks.POTTED_ALLIUM, Blocks.POTTED_AZURE_BLUET, Blocks.POTTED_RED_TULIP, Blocks.POTTED_ORANGE_TULIP, Blocks.POTTED_WHITE_TULIP, Blocks.POTTED_PINK_TULIP, Blocks.POTTED_OXEYE_DAISY, Blocks.POTTED_DANDELION, Blocks.POTTED_OAK_SAPLING, Blocks.POTTED_SPRUCE_SAPLING, Blocks.POTTED_BIRCH_SAPLING, Blocks.POTTED_JUNGLE_SAPLING, Blocks.POTTED_ACACIA_SAPLING, Blocks.POTTED_DARK_OAK_SAPLING, Blocks.POTTED_RED_MUSHROOM, Blocks.POTTED_BROWN_MUSHROOM, Blocks.POTTED_DEAD_BUSH, Blocks.POTTED_FERN, Blocks.POTTED_CACTUS, Blocks.POTTED_CORNFLOWER, Blocks.POTTED_LILY_OF_THE_VALLEY, Blocks.POTTED_WITHER_ROSE, Blocks.POTTED_BAMBOO, Blocks.POTTED_CRIMSON_FUNGUS, Blocks.POTTED_WARPED_FUNGUS, Blocks.POTTED_CRIMSON_ROOTS, Blocks.POTTED_WARPED_ROOTS, Blocks.POTTED_AZALEA, Blocks.POTTED_FLOWERING_AZALEA);
      this.tag(BlockTags.BANNERS).add(Blocks.WHITE_BANNER, Blocks.ORANGE_BANNER, Blocks.MAGENTA_BANNER, Blocks.LIGHT_BLUE_BANNER, Blocks.YELLOW_BANNER, Blocks.LIME_BANNER, Blocks.PINK_BANNER, Blocks.GRAY_BANNER, Blocks.LIGHT_GRAY_BANNER, Blocks.CYAN_BANNER, Blocks.PURPLE_BANNER, Blocks.BLUE_BANNER, Blocks.BROWN_BANNER, Blocks.GREEN_BANNER, Blocks.RED_BANNER, Blocks.BLACK_BANNER, Blocks.WHITE_WALL_BANNER, Blocks.ORANGE_WALL_BANNER, Blocks.MAGENTA_WALL_BANNER, Blocks.LIGHT_BLUE_WALL_BANNER, Blocks.YELLOW_WALL_BANNER, Blocks.LIME_WALL_BANNER, Blocks.PINK_WALL_BANNER, Blocks.GRAY_WALL_BANNER, Blocks.LIGHT_GRAY_WALL_BANNER, Blocks.CYAN_WALL_BANNER, Blocks.PURPLE_WALL_BANNER, Blocks.BLUE_WALL_BANNER, Blocks.BROWN_WALL_BANNER, Blocks.GREEN_WALL_BANNER, Blocks.RED_WALL_BANNER, Blocks.BLACK_WALL_BANNER);
      this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(Blocks.OAK_PRESSURE_PLATE, Blocks.SPRUCE_PRESSURE_PLATE, Blocks.BIRCH_PRESSURE_PLATE, Blocks.JUNGLE_PRESSURE_PLATE, Blocks.ACACIA_PRESSURE_PLATE, Blocks.DARK_OAK_PRESSURE_PLATE, Blocks.CRIMSON_PRESSURE_PLATE, Blocks.WARPED_PRESSURE_PLATE);
      this.tag(BlockTags.STONE_PRESSURE_PLATES).add(Blocks.STONE_PRESSURE_PLATE, Blocks.POLISHED_BLACKSTONE_PRESSURE_PLATE);
      this.tag(BlockTags.PRESSURE_PLATES).add(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE, Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE).addTag(BlockTags.WOODEN_PRESSURE_PLATES).addTag(BlockTags.STONE_PRESSURE_PLATES);
      this.tag(BlockTags.STAIRS).addTag(BlockTags.WOODEN_STAIRS).add(Blocks.COBBLESTONE_STAIRS, Blocks.SANDSTONE_STAIRS, Blocks.NETHER_BRICK_STAIRS, Blocks.STONE_BRICK_STAIRS, Blocks.BRICK_STAIRS, Blocks.PURPUR_STAIRS, Blocks.QUARTZ_STAIRS, Blocks.RED_SANDSTONE_STAIRS, Blocks.PRISMARINE_BRICK_STAIRS, Blocks.PRISMARINE_STAIRS, Blocks.DARK_PRISMARINE_STAIRS, Blocks.POLISHED_GRANITE_STAIRS, Blocks.SMOOTH_RED_SANDSTONE_STAIRS, Blocks.MOSSY_STONE_BRICK_STAIRS, Blocks.POLISHED_DIORITE_STAIRS, Blocks.MOSSY_COBBLESTONE_STAIRS, Blocks.END_STONE_BRICK_STAIRS, Blocks.STONE_STAIRS, Blocks.SMOOTH_SANDSTONE_STAIRS, Blocks.SMOOTH_QUARTZ_STAIRS, Blocks.GRANITE_STAIRS, Blocks.ANDESITE_STAIRS, Blocks.RED_NETHER_BRICK_STAIRS, Blocks.POLISHED_ANDESITE_STAIRS, Blocks.DIORITE_STAIRS, Blocks.BLACKSTONE_STAIRS, Blocks.POLISHED_BLACKSTONE_BRICK_STAIRS, Blocks.POLISHED_BLACKSTONE_STAIRS, Blocks.COBBLED_DEEPSLATE_STAIRS, Blocks.POLISHED_DEEPSLATE_STAIRS, Blocks.DEEPSLATE_TILE_STAIRS, Blocks.DEEPSLATE_BRICK_STAIRS, Blocks.OXIDIZED_CUT_COPPER_STAIRS, Blocks.WEATHERED_CUT_COPPER_STAIRS, Blocks.EXPOSED_CUT_COPPER_STAIRS, Blocks.CUT_COPPER_STAIRS, Blocks.WAXED_WEATHERED_CUT_COPPER_STAIRS, Blocks.WAXED_EXPOSED_CUT_COPPER_STAIRS, Blocks.WAXED_CUT_COPPER_STAIRS, Blocks.WAXED_OXIDIZED_CUT_COPPER_STAIRS);
      this.tag(BlockTags.SLABS).addTag(BlockTags.WOODEN_SLABS).add(Blocks.STONE_SLAB, Blocks.SMOOTH_STONE_SLAB, Blocks.STONE_BRICK_SLAB, Blocks.SANDSTONE_SLAB, Blocks.PURPUR_SLAB, Blocks.QUARTZ_SLAB, Blocks.RED_SANDSTONE_SLAB, Blocks.BRICK_SLAB, Blocks.COBBLESTONE_SLAB, Blocks.NETHER_BRICK_SLAB, Blocks.PETRIFIED_OAK_SLAB, Blocks.PRISMARINE_SLAB, Blocks.PRISMARINE_BRICK_SLAB, Blocks.DARK_PRISMARINE_SLAB, Blocks.POLISHED_GRANITE_SLAB, Blocks.SMOOTH_RED_SANDSTONE_SLAB, Blocks.MOSSY_STONE_BRICK_SLAB, Blocks.POLISHED_DIORITE_SLAB, Blocks.MOSSY_COBBLESTONE_SLAB, Blocks.END_STONE_BRICK_SLAB, Blocks.SMOOTH_SANDSTONE_SLAB, Blocks.SMOOTH_QUARTZ_SLAB, Blocks.GRANITE_SLAB, Blocks.ANDESITE_SLAB, Blocks.RED_NETHER_BRICK_SLAB, Blocks.POLISHED_ANDESITE_SLAB, Blocks.DIORITE_SLAB, Blocks.CUT_SANDSTONE_SLAB, Blocks.CUT_RED_SANDSTONE_SLAB, Blocks.BLACKSTONE_SLAB, Blocks.POLISHED_BLACKSTONE_BRICK_SLAB, Blocks.POLISHED_BLACKSTONE_SLAB, Blocks.COBBLED_DEEPSLATE_SLAB, Blocks.POLISHED_DEEPSLATE_SLAB, Blocks.DEEPSLATE_TILE_SLAB, Blocks.DEEPSLATE_BRICK_SLAB, Blocks.WAXED_WEATHERED_CUT_COPPER_SLAB, Blocks.WAXED_EXPOSED_CUT_COPPER_SLAB, Blocks.WAXED_CUT_COPPER_SLAB, Blocks.OXIDIZED_CUT_COPPER_SLAB, Blocks.WEATHERED_CUT_COPPER_SLAB, Blocks.EXPOSED_CUT_COPPER_SLAB, Blocks.CUT_COPPER_SLAB, Blocks.WAXED_OXIDIZED_CUT_COPPER_SLAB);
      this.tag(BlockTags.WALLS).add(Blocks.COBBLESTONE_WALL, Blocks.MOSSY_COBBLESTONE_WALL, Blocks.BRICK_WALL, Blocks.PRISMARINE_WALL, Blocks.RED_SANDSTONE_WALL, Blocks.MOSSY_STONE_BRICK_WALL, Blocks.GRANITE_WALL, Blocks.STONE_BRICK_WALL, Blocks.NETHER_BRICK_WALL, Blocks.ANDESITE_WALL, Blocks.RED_NETHER_BRICK_WALL, Blocks.SANDSTONE_WALL, Blocks.END_STONE_BRICK_WALL, Blocks.DIORITE_WALL, Blocks.BLACKSTONE_WALL, Blocks.POLISHED_BLACKSTONE_BRICK_WALL, Blocks.POLISHED_BLACKSTONE_WALL, Blocks.COBBLED_DEEPSLATE_WALL, Blocks.POLISHED_DEEPSLATE_WALL, Blocks.DEEPSLATE_TILE_WALL, Blocks.DEEPSLATE_BRICK_WALL);
      this.tag(BlockTags.CORAL_PLANTS).add(Blocks.TUBE_CORAL, Blocks.BRAIN_CORAL, Blocks.BUBBLE_CORAL, Blocks.FIRE_CORAL, Blocks.HORN_CORAL);
      this.tag(BlockTags.CORALS).addTag(BlockTags.CORAL_PLANTS).add(Blocks.TUBE_CORAL_FAN, Blocks.BRAIN_CORAL_FAN, Blocks.BUBBLE_CORAL_FAN, Blocks.FIRE_CORAL_FAN, Blocks.HORN_CORAL_FAN);
      this.tag(BlockTags.WALL_CORALS).add(Blocks.TUBE_CORAL_WALL_FAN, Blocks.BRAIN_CORAL_WALL_FAN, Blocks.BUBBLE_CORAL_WALL_FAN, Blocks.FIRE_CORAL_WALL_FAN, Blocks.HORN_CORAL_WALL_FAN);
      this.tag(BlockTags.SAND).add(Blocks.SAND, Blocks.RED_SAND);
      this.tag(BlockTags.RAILS).add(Blocks.RAIL, Blocks.POWERED_RAIL, Blocks.DETECTOR_RAIL, Blocks.ACTIVATOR_RAIL);
      this.tag(BlockTags.CORAL_BLOCKS).add(Blocks.TUBE_CORAL_BLOCK, Blocks.BRAIN_CORAL_BLOCK, Blocks.BUBBLE_CORAL_BLOCK, Blocks.FIRE_CORAL_BLOCK, Blocks.HORN_CORAL_BLOCK);
      this.tag(BlockTags.ICE).add(Blocks.ICE, Blocks.PACKED_ICE, Blocks.BLUE_ICE, Blocks.FROSTED_ICE);
      this.tag(BlockTags.VALID_SPAWN).add(Blocks.GRASS_BLOCK, Blocks.PODZOL);
      this.tag(BlockTags.LEAVES).add(Blocks.JUNGLE_LEAVES, Blocks.OAK_LEAVES, Blocks.SPRUCE_LEAVES, Blocks.DARK_OAK_LEAVES, Blocks.ACACIA_LEAVES, Blocks.BIRCH_LEAVES, Blocks.AZALEA_LEAVES, Blocks.FLOWERING_AZALEA_LEAVES);
      this.tag(BlockTags.IMPERMEABLE).add(Blocks.GLASS, Blocks.WHITE_STAINED_GLASS, Blocks.ORANGE_STAINED_GLASS, Blocks.MAGENTA_STAINED_GLASS, Blocks.LIGHT_BLUE_STAINED_GLASS, Blocks.YELLOW_STAINED_GLASS, Blocks.LIME_STAINED_GLASS, Blocks.PINK_STAINED_GLASS, Blocks.GRAY_STAINED_GLASS, Blocks.LIGHT_GRAY_STAINED_GLASS, Blocks.CYAN_STAINED_GLASS, Blocks.PURPLE_STAINED_GLASS, Blocks.BLUE_STAINED_GLASS, Blocks.BROWN_STAINED_GLASS, Blocks.GREEN_STAINED_GLASS, Blocks.RED_STAINED_GLASS, Blocks.BLACK_STAINED_GLASS, Blocks.TINTED_GLASS);
      this.tag(BlockTags.WOODEN_TRAPDOORS).add(Blocks.ACACIA_TRAPDOOR, Blocks.BIRCH_TRAPDOOR, Blocks.DARK_OAK_TRAPDOOR, Blocks.JUNGLE_TRAPDOOR, Blocks.OAK_TRAPDOOR, Blocks.SPRUCE_TRAPDOOR, Blocks.CRIMSON_TRAPDOOR, Blocks.WARPED_TRAPDOOR);
      this.tag(BlockTags.TRAPDOORS).addTag(BlockTags.WOODEN_TRAPDOORS).add(Blocks.IRON_TRAPDOOR);
      this.tag(BlockTags.UNDERWATER_BONEMEALS).add(Blocks.SEAGRASS).addTag(BlockTags.CORALS).addTag(BlockTags.WALL_CORALS);
      this.tag(BlockTags.BAMBOO_PLANTABLE_ON).addTag(BlockTags.SAND).addTag(BlockTags.DIRT).add(Blocks.BAMBOO, Blocks.BAMBOO_SAPLING, Blocks.GRAVEL);
      this.tag(BlockTags.STANDING_SIGNS).add(Blocks.OAK_SIGN, Blocks.SPRUCE_SIGN, Blocks.BIRCH_SIGN, Blocks.ACACIA_SIGN, Blocks.JUNGLE_SIGN, Blocks.DARK_OAK_SIGN, Blocks.CRIMSON_SIGN, Blocks.WARPED_SIGN);
      this.tag(BlockTags.WALL_SIGNS).add(Blocks.OAK_WALL_SIGN, Blocks.SPRUCE_WALL_SIGN, Blocks.BIRCH_WALL_SIGN, Blocks.ACACIA_WALL_SIGN, Blocks.JUNGLE_WALL_SIGN, Blocks.DARK_OAK_WALL_SIGN, Blocks.CRIMSON_WALL_SIGN, Blocks.WARPED_WALL_SIGN);
      this.tag(BlockTags.SIGNS).addTag(BlockTags.STANDING_SIGNS).addTag(BlockTags.WALL_SIGNS);
      this.tag(BlockTags.BEDS).add(Blocks.RED_BED, Blocks.BLACK_BED, Blocks.BLUE_BED, Blocks.BROWN_BED, Blocks.CYAN_BED, Blocks.GRAY_BED, Blocks.GREEN_BED, Blocks.LIGHT_BLUE_BED, Blocks.LIGHT_GRAY_BED, Blocks.LIME_BED, Blocks.MAGENTA_BED, Blocks.ORANGE_BED, Blocks.PINK_BED, Blocks.PURPLE_BED, Blocks.WHITE_BED, Blocks.YELLOW_BED);
      this.tag(BlockTags.FENCES).addTag(BlockTags.WOODEN_FENCES).add(Blocks.NETHER_BRICK_FENCE);
      this.tag(BlockTags.DRAGON_IMMUNE).add(Blocks.BARRIER, Blocks.BEDROCK, Blocks.END_PORTAL, Blocks.END_PORTAL_FRAME, Blocks.END_GATEWAY, Blocks.COMMAND_BLOCK, Blocks.REPEATING_COMMAND_BLOCK, Blocks.CHAIN_COMMAND_BLOCK, Blocks.STRUCTURE_BLOCK, Blocks.JIGSAW, Blocks.MOVING_PISTON, Blocks.OBSIDIAN, Blocks.CRYING_OBSIDIAN, Blocks.END_STONE, Blocks.IRON_BARS, Blocks.RESPAWN_ANCHOR);
      this.tag(BlockTags.WITHER_IMMUNE).add(Blocks.BARRIER, Blocks.BEDROCK, Blocks.END_PORTAL, Blocks.END_PORTAL_FRAME, Blocks.END_GATEWAY, Blocks.COMMAND_BLOCK, Blocks.REPEATING_COMMAND_BLOCK, Blocks.CHAIN_COMMAND_BLOCK, Blocks.STRUCTURE_BLOCK, Blocks.JIGSAW, Blocks.MOVING_PISTON);
      this.tag(BlockTags.WITHER_SUMMON_BASE_BLOCKS).add(Blocks.SOUL_SAND, Blocks.SOUL_SOIL);
      this.tag(BlockTags.TALL_FLOWERS).add(Blocks.SUNFLOWER, Blocks.LILAC, Blocks.PEONY, Blocks.ROSE_BUSH);
      this.tag(BlockTags.FLOWERS).addTag(BlockTags.SMALL_FLOWERS).addTag(BlockTags.TALL_FLOWERS).add(Blocks.FLOWERING_AZALEA_LEAVES, Blocks.FLOWERING_AZALEA);
      this.tag(BlockTags.BEEHIVES).add(Blocks.BEE_NEST, Blocks.BEEHIVE);
      this.tag(BlockTags.CROPS).add(Blocks.BEETROOTS, Blocks.CARROTS, Blocks.POTATOES, Blocks.WHEAT, Blocks.MELON_STEM, Blocks.PUMPKIN_STEM);
      this.tag(BlockTags.BEE_GROWABLES).addTag(BlockTags.CROPS).add(Blocks.SWEET_BERRY_BUSH).add(Blocks.CAVE_VINES).add(Blocks.CAVE_VINES_PLANT);
      this.tag(BlockTags.SHULKER_BOXES).add(Blocks.SHULKER_BOX, Blocks.BLACK_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.LIGHT_GRAY_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.WHITE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX);
      this.tag(BlockTags.PORTALS).add(Blocks.NETHER_PORTAL, Blocks.END_PORTAL, Blocks.END_GATEWAY);
      this.tag(BlockTags.FIRE).add(Blocks.FIRE, Blocks.SOUL_FIRE);
      this.tag(BlockTags.NYLIUM).add(Blocks.CRIMSON_NYLIUM, Blocks.WARPED_NYLIUM);
      this.tag(BlockTags.WART_BLOCKS).add(Blocks.NETHER_WART_BLOCK, Blocks.WARPED_WART_BLOCK);
      this.tag(BlockTags.BEACON_BASE_BLOCKS).add(Blocks.NETHERITE_BLOCK, Blocks.EMERALD_BLOCK, Blocks.DIAMOND_BLOCK, Blocks.GOLD_BLOCK, Blocks.IRON_BLOCK);
      this.tag(BlockTags.SOUL_SPEED_BLOCKS).add(Blocks.SOUL_SAND, Blocks.SOUL_SOIL);
      this.tag(BlockTags.WALL_POST_OVERRIDE).add(Blocks.TORCH, Blocks.SOUL_TORCH, Blocks.REDSTONE_TORCH, Blocks.TRIPWIRE).addTag(BlockTags.SIGNS).addTag(BlockTags.BANNERS).addTag(BlockTags.PRESSURE_PLATES);
      this.tag(BlockTags.CLIMBABLE).add(Blocks.LADDER, Blocks.VINE, Blocks.SCAFFOLDING, Blocks.WEEPING_VINES, Blocks.WEEPING_VINES_PLANT, Blocks.TWISTING_VINES, Blocks.TWISTING_VINES_PLANT, Blocks.CAVE_VINES, Blocks.CAVE_VINES_PLANT);
      this.tag(BlockTags.FALL_DAMAGE_RESETTING).addTag(BlockTags.CLIMBABLE).add(Blocks.SWEET_BERRY_BUSH, Blocks.COBWEB);
      this.tag(BlockTags.PIGLIN_REPELLENTS).add(Blocks.SOUL_FIRE).add(Blocks.SOUL_TORCH).add(Blocks.SOUL_LANTERN).add(Blocks.SOUL_WALL_TORCH).add(Blocks.SOUL_CAMPFIRE);
      this.tag(BlockTags.HOGLIN_REPELLENTS).add(Blocks.WARPED_FUNGUS).add(Blocks.POTTED_WARPED_FUNGUS).add(Blocks.NETHER_PORTAL).add(Blocks.RESPAWN_ANCHOR);
      this.tag(BlockTags.GOLD_ORES).add(Blocks.GOLD_ORE, Blocks.NETHER_GOLD_ORE, Blocks.DEEPSLATE_GOLD_ORE);
      this.tag(BlockTags.IRON_ORES).add(Blocks.IRON_ORE, Blocks.DEEPSLATE_IRON_ORE);
      this.tag(BlockTags.DIAMOND_ORES).add(Blocks.DIAMOND_ORE, Blocks.DEEPSLATE_DIAMOND_ORE);
      this.tag(BlockTags.REDSTONE_ORES).add(Blocks.REDSTONE_ORE, Blocks.DEEPSLATE_REDSTONE_ORE);
      this.tag(BlockTags.COAL_ORES).add(Blocks.COAL_ORE, Blocks.DEEPSLATE_COAL_ORE);
      this.tag(BlockTags.EMERALD_ORES).add(Blocks.EMERALD_ORE, Blocks.DEEPSLATE_EMERALD_ORE);
      this.tag(BlockTags.COPPER_ORES).add(Blocks.COPPER_ORE, Blocks.DEEPSLATE_COPPER_ORE);
      this.tag(BlockTags.LAPIS_ORES).add(Blocks.LAPIS_ORE, Blocks.DEEPSLATE_LAPIS_ORE);
      this.tag(BlockTags.SOUL_FIRE_BASE_BLOCKS).add(Blocks.SOUL_SAND, Blocks.SOUL_SOIL);
      this.tag(BlockTags.NON_FLAMMABLE_WOOD).add(Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM, Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE, Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM, Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE, Blocks.CRIMSON_PLANKS, Blocks.WARPED_PLANKS, Blocks.CRIMSON_SLAB, Blocks.WARPED_SLAB, Blocks.CRIMSON_PRESSURE_PLATE, Blocks.WARPED_PRESSURE_PLATE, Blocks.CRIMSON_FENCE, Blocks.WARPED_FENCE, Blocks.CRIMSON_TRAPDOOR, Blocks.WARPED_TRAPDOOR, Blocks.CRIMSON_FENCE_GATE, Blocks.WARPED_FENCE_GATE, Blocks.CRIMSON_STAIRS, Blocks.WARPED_STAIRS, Blocks.CRIMSON_BUTTON, Blocks.WARPED_BUTTON, Blocks.CRIMSON_DOOR, Blocks.WARPED_DOOR, Blocks.CRIMSON_SIGN, Blocks.WARPED_SIGN, Blocks.CRIMSON_WALL_SIGN, Blocks.WARPED_WALL_SIGN);
      this.tag(BlockTags.STRIDER_WARM_BLOCKS).add(Blocks.LAVA);
      this.tag(BlockTags.CAMPFIRES).add(Blocks.CAMPFIRE, Blocks.SOUL_CAMPFIRE);
      this.tag(BlockTags.GUARDED_BY_PIGLINS).add(Blocks.GOLD_BLOCK, Blocks.BARREL, Blocks.CHEST, Blocks.ENDER_CHEST, Blocks.GILDED_BLACKSTONE, Blocks.TRAPPED_CHEST, Blocks.RAW_GOLD_BLOCK).addTag(BlockTags.SHULKER_BOXES).addTag(BlockTags.GOLD_ORES);
      this.tag(BlockTags.PREVENT_MOB_SPAWNING_INSIDE).addTag(BlockTags.RAILS);
      this.tag(BlockTags.FENCE_GATES).add(Blocks.ACACIA_FENCE_GATE, Blocks.BIRCH_FENCE_GATE, Blocks.DARK_OAK_FENCE_GATE, Blocks.JUNGLE_FENCE_GATE, Blocks.OAK_FENCE_GATE, Blocks.SPRUCE_FENCE_GATE, Blocks.CRIMSON_FENCE_GATE, Blocks.WARPED_FENCE_GATE);
      this.tag(BlockTags.UNSTABLE_BOTTOM_CENTER).addTag(BlockTags.FENCE_GATES);
      this.tag(BlockTags.MUSHROOM_GROW_BLOCK).add(Blocks.MYCELIUM).add(Blocks.PODZOL).add(Blocks.CRIMSON_NYLIUM).add(Blocks.WARPED_NYLIUM);
      this.tag(BlockTags.INFINIBURN_OVERWORLD).add(Blocks.NETHERRACK, Blocks.MAGMA_BLOCK);
      this.tag(BlockTags.INFINIBURN_NETHER).addTag(BlockTags.INFINIBURN_OVERWORLD);
      this.tag(BlockTags.INFINIBURN_END).addTag(BlockTags.INFINIBURN_OVERWORLD).add(Blocks.BEDROCK);
      this.tag(BlockTags.STONE_ORE_REPLACEABLES).add(Blocks.STONE).add(Blocks.GRANITE).add(Blocks.DIORITE).add(Blocks.ANDESITE);
      this.tag(BlockTags.DEEPSLATE_ORE_REPLACEABLES).add(Blocks.DEEPSLATE).add(Blocks.TUFF);
      this.tag(BlockTags.BASE_STONE_OVERWORLD).add(Blocks.STONE).add(Blocks.GRANITE).add(Blocks.DIORITE).add(Blocks.ANDESITE).add(Blocks.TUFF).add(Blocks.DEEPSLATE);
      this.tag(BlockTags.BASE_STONE_NETHER).add(Blocks.NETHERRACK).add(Blocks.BASALT).add(Blocks.BLACKSTONE);
      this.tag(BlockTags.CANDLES).add(Blocks.CANDLE, Blocks.WHITE_CANDLE, Blocks.ORANGE_CANDLE, Blocks.MAGENTA_CANDLE, Blocks.LIGHT_BLUE_CANDLE, Blocks.YELLOW_CANDLE, Blocks.LIME_CANDLE, Blocks.PINK_CANDLE, Blocks.GRAY_CANDLE, Blocks.LIGHT_GRAY_CANDLE, Blocks.CYAN_CANDLE, Blocks.PURPLE_CANDLE, Blocks.BLUE_CANDLE, Blocks.BROWN_CANDLE, Blocks.GREEN_CANDLE, Blocks.RED_CANDLE, Blocks.BLACK_CANDLE);
      this.tag(BlockTags.CANDLE_CAKES).add(Blocks.CANDLE_CAKE, Blocks.WHITE_CANDLE_CAKE, Blocks.ORANGE_CANDLE_CAKE, Blocks.MAGENTA_CANDLE_CAKE, Blocks.LIGHT_BLUE_CANDLE_CAKE, Blocks.YELLOW_CANDLE_CAKE, Blocks.LIME_CANDLE_CAKE, Blocks.PINK_CANDLE_CAKE, Blocks.GRAY_CANDLE_CAKE, Blocks.LIGHT_GRAY_CANDLE_CAKE, Blocks.CYAN_CANDLE_CAKE, Blocks.PURPLE_CANDLE_CAKE, Blocks.BLUE_CANDLE_CAKE, Blocks.BROWN_CANDLE_CAKE, Blocks.GREEN_CANDLE_CAKE, Blocks.RED_CANDLE_CAKE, Blocks.BLACK_CANDLE_CAKE);
      this.tag(BlockTags.CRYSTAL_SOUND_BLOCKS).add(Blocks.AMETHYST_BLOCK, Blocks.BUDDING_AMETHYST);
      this.tag(BlockTags.CAULDRONS).add(Blocks.CAULDRON, Blocks.WATER_CAULDRON, Blocks.LAVA_CAULDRON, Blocks.POWDER_SNOW_CAULDRON);
      this.tag(BlockTags.INSIDE_STEP_SOUND_BLOCKS).add(Blocks.SNOW, Blocks.POWDER_SNOW);
      this.tag(BlockTags.DRIPSTONE_REPLACEABLE).addTag(BlockTags.BASE_STONE_OVERWORLD);
      this.tag(BlockTags.CAVE_VINES).add(Blocks.CAVE_VINES_PLANT).add(Blocks.CAVE_VINES);
      this.tag(BlockTags.MOSS_REPLACEABLE).addTag(BlockTags.BASE_STONE_OVERWORLD).addTag(BlockTags.CAVE_VINES).addTag(BlockTags.DIRT);
      this.tag(BlockTags.LUSH_GROUND_REPLACEABLE).addTag(BlockTags.MOSS_REPLACEABLE).add(Blocks.CLAY).add(Blocks.GRAVEL).add(Blocks.SAND);
      this.tag(BlockTags.AZALEA_ROOT_REPLACEABLE).addTag(BlockTags.BASE_STONE_OVERWORLD).addTag(BlockTags.DIRT).addTag(BlockTags.TERRACOTTA).add(Blocks.RED_SAND).add(Blocks.CLAY).add(Blocks.GRAVEL).add(Blocks.SAND).add(Blocks.SNOW_BLOCK).add(Blocks.POWDER_SNOW);
      this.tag(BlockTags.SMALL_DRIPLEAF_PLACEABLE).add(Blocks.CLAY).add(Blocks.MOSS_BLOCK);
      this.tag(BlockTags.BIG_DRIPLEAF_PLACEABLE).addTag(BlockTags.SMALL_DRIPLEAF_PLACEABLE).addTag(BlockTags.DIRT).add(Blocks.FARMLAND);
      this.tag(BlockTags.OCCLUDES_VIBRATION_SIGNALS).addTag(BlockTags.WOOL);
      this.tag(BlockTags.SNOW).add(Blocks.SNOW, Blocks.SNOW_BLOCK, Blocks.POWDER_SNOW);
      this.tag(BlockTags.MINEABLE_WITH_AXE).add(Blocks.NOTE_BLOCK, Blocks.ATTACHED_MELON_STEM, Blocks.ATTACHED_PUMPKIN_STEM, Blocks.AZALEA, Blocks.BAMBOO, Blocks.BARREL, Blocks.BEE_NEST, Blocks.BEEHIVE, Blocks.BEETROOTS, Blocks.BIG_DRIPLEAF_STEM, Blocks.BIG_DRIPLEAF, Blocks.BOOKSHELF, Blocks.BROWN_MUSHROOM_BLOCK, Blocks.BROWN_MUSHROOM, Blocks.CAMPFIRE, Blocks.CARROTS, Blocks.CARTOGRAPHY_TABLE, Blocks.CARVED_PUMPKIN, Blocks.CAVE_VINES_PLANT, Blocks.CAVE_VINES, Blocks.CHEST, Blocks.CHORUS_FLOWER, Blocks.CHORUS_PLANT, Blocks.COCOA, Blocks.COMPOSTER, Blocks.CRAFTING_TABLE, Blocks.CRIMSON_FUNGUS, Blocks.DAYLIGHT_DETECTOR, Blocks.DEAD_BUSH, Blocks.FERN, Blocks.FLETCHING_TABLE, Blocks.GLOW_LICHEN, Blocks.GRASS, Blocks.HANGING_ROOTS, Blocks.JACK_O_LANTERN, Blocks.JUKEBOX, Blocks.LADDER, Blocks.LARGE_FERN, Blocks.LECTERN, Blocks.LILY_PAD, Blocks.LOOM, Blocks.MELON_STEM, Blocks.MELON, Blocks.MUSHROOM_STEM, Blocks.NETHER_WART, Blocks.POTATOES, Blocks.PUMPKIN_STEM, Blocks.PUMPKIN, Blocks.RED_MUSHROOM_BLOCK, Blocks.RED_MUSHROOM, Blocks.SCAFFOLDING, Blocks.SMALL_DRIPLEAF, Blocks.SMITHING_TABLE, Blocks.SOUL_CAMPFIRE, Blocks.SPORE_BLOSSOM, Blocks.SUGAR_CANE, Blocks.SWEET_BERRY_BUSH, Blocks.TALL_GRASS, Blocks.TRAPPED_CHEST, Blocks.TWISTING_VINES_PLANT, Blocks.TWISTING_VINES, Blocks.VINE, Blocks.WARPED_FUNGUS, Blocks.WEEPING_VINES_PLANT, Blocks.WEEPING_VINES, Blocks.WHEAT).addTag(BlockTags.BANNERS).addTag(BlockTags.FENCE_GATES).addTag(BlockTags.LOGS).addTag(BlockTags.PLANKS).addTag(BlockTags.SAPLINGS).addTag(BlockTags.SIGNS).addTag(BlockTags.WOODEN_BUTTONS).addTag(BlockTags.WOODEN_DOORS).addTag(BlockTags.WOODEN_FENCES).addTag(BlockTags.WOODEN_PRESSURE_PLATES).addTag(BlockTags.WOODEN_SLABS).addTag(BlockTags.WOODEN_STAIRS).addTag(BlockTags.WOODEN_TRAPDOORS);
      this.tag(BlockTags.MINEABLE_WITH_HOE).add(Blocks.NETHER_WART_BLOCK, Blocks.WARPED_WART_BLOCK, Blocks.HAY_BLOCK, Blocks.DRIED_KELP_BLOCK, Blocks.TARGET, Blocks.SHROOMLIGHT, Blocks.SPONGE, Blocks.WET_SPONGE, Blocks.JUNGLE_LEAVES, Blocks.OAK_LEAVES, Blocks.SPRUCE_LEAVES, Blocks.DARK_OAK_LEAVES, Blocks.ACACIA_LEAVES, Blocks.BIRCH_LEAVES, Blocks.AZALEA_LEAVES, Blocks.FLOWERING_AZALEA_LEAVES, Blocks.SCULK_SENSOR, Blocks.MOSS_BLOCK, Blocks.MOSS_CARPET);
      this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(Blocks.STONE, Blocks.GRANITE, Blocks.POLISHED_GRANITE, Blocks.DIORITE, Blocks.POLISHED_DIORITE, Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, Blocks.COBBLESTONE, Blocks.GOLD_ORE, Blocks.DEEPSLATE_GOLD_ORE, Blocks.IRON_ORE, Blocks.DEEPSLATE_IRON_ORE, Blocks.COAL_ORE, Blocks.DEEPSLATE_COAL_ORE, Blocks.NETHER_GOLD_ORE, Blocks.LAPIS_ORE, Blocks.DEEPSLATE_LAPIS_ORE, Blocks.LAPIS_BLOCK, Blocks.DISPENSER, Blocks.SANDSTONE, Blocks.CHISELED_SANDSTONE, Blocks.CUT_SANDSTONE, Blocks.GOLD_BLOCK, Blocks.IRON_BLOCK, Blocks.BRICKS, Blocks.MOSSY_COBBLESTONE, Blocks.OBSIDIAN, Blocks.SPAWNER, Blocks.DIAMOND_ORE, Blocks.DEEPSLATE_DIAMOND_ORE, Blocks.DIAMOND_BLOCK, Blocks.FURNACE, Blocks.COBBLESTONE_STAIRS, Blocks.STONE_PRESSURE_PLATE, Blocks.IRON_DOOR, Blocks.REDSTONE_ORE, Blocks.DEEPSLATE_REDSTONE_ORE, Blocks.NETHERRACK, Blocks.BASALT, Blocks.POLISHED_BASALT, Blocks.STONE_BRICKS, Blocks.MOSSY_STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS, Blocks.CHISELED_STONE_BRICKS, Blocks.IRON_BARS, Blocks.CHAIN, Blocks.BRICK_STAIRS, Blocks.STONE_BRICK_STAIRS, Blocks.NETHER_BRICKS, Blocks.NETHER_BRICK_FENCE, Blocks.NETHER_BRICK_STAIRS, Blocks.ENCHANTING_TABLE, Blocks.BREWING_STAND, Blocks.END_STONE, Blocks.SANDSTONE_STAIRS, Blocks.EMERALD_ORE, Blocks.DEEPSLATE_EMERALD_ORE, Blocks.ENDER_CHEST, Blocks.EMERALD_BLOCK, Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE, Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, Blocks.REDSTONE_BLOCK, Blocks.NETHER_QUARTZ_ORE, Blocks.HOPPER, Blocks.QUARTZ_BLOCK, Blocks.CHISELED_QUARTZ_BLOCK, Blocks.QUARTZ_PILLAR, Blocks.QUARTZ_STAIRS, Blocks.DROPPER, Blocks.WHITE_TERRACOTTA, Blocks.ORANGE_TERRACOTTA, Blocks.MAGENTA_TERRACOTTA, Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.YELLOW_TERRACOTTA, Blocks.LIME_TERRACOTTA, Blocks.PINK_TERRACOTTA, Blocks.GRAY_TERRACOTTA, Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.CYAN_TERRACOTTA, Blocks.PURPLE_TERRACOTTA, Blocks.BLUE_TERRACOTTA, Blocks.BROWN_TERRACOTTA, Blocks.GREEN_TERRACOTTA, Blocks.RED_TERRACOTTA, Blocks.BLACK_TERRACOTTA, Blocks.IRON_TRAPDOOR, Blocks.PRISMARINE, Blocks.PRISMARINE_BRICKS, Blocks.DARK_PRISMARINE, Blocks.PRISMARINE_STAIRS, Blocks.PRISMARINE_BRICK_STAIRS, Blocks.DARK_PRISMARINE_STAIRS, Blocks.PRISMARINE_SLAB, Blocks.PRISMARINE_BRICK_SLAB, Blocks.DARK_PRISMARINE_SLAB, Blocks.TERRACOTTA, Blocks.COAL_BLOCK, Blocks.RED_SANDSTONE, Blocks.CHISELED_RED_SANDSTONE, Blocks.CUT_RED_SANDSTONE, Blocks.RED_SANDSTONE_STAIRS, Blocks.STONE_SLAB, Blocks.SMOOTH_STONE_SLAB, Blocks.SANDSTONE_SLAB, Blocks.CUT_SANDSTONE_SLAB, Blocks.PETRIFIED_OAK_SLAB, Blocks.COBBLESTONE_SLAB, Blocks.BRICK_SLAB, Blocks.STONE_BRICK_SLAB, Blocks.NETHER_BRICK_SLAB, Blocks.QUARTZ_SLAB, Blocks.RED_SANDSTONE_SLAB, Blocks.CUT_RED_SANDSTONE_SLAB, Blocks.PURPUR_SLAB, Blocks.SMOOTH_STONE, Blocks.SMOOTH_SANDSTONE, Blocks.SMOOTH_QUARTZ, Blocks.SMOOTH_RED_SANDSTONE, Blocks.PURPUR_BLOCK, Blocks.PURPUR_PILLAR, Blocks.PURPUR_STAIRS, Blocks.END_STONE_BRICKS, Blocks.MAGMA_BLOCK, Blocks.RED_NETHER_BRICKS, Blocks.BONE_BLOCK, Blocks.OBSERVER, Blocks.WHITE_GLAZED_TERRACOTTA, Blocks.ORANGE_GLAZED_TERRACOTTA, Blocks.MAGENTA_GLAZED_TERRACOTTA, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, Blocks.YELLOW_GLAZED_TERRACOTTA, Blocks.LIME_GLAZED_TERRACOTTA, Blocks.PINK_GLAZED_TERRACOTTA, Blocks.GRAY_GLAZED_TERRACOTTA, Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, Blocks.CYAN_GLAZED_TERRACOTTA, Blocks.PURPLE_GLAZED_TERRACOTTA, Blocks.BLUE_GLAZED_TERRACOTTA, Blocks.BROWN_GLAZED_TERRACOTTA, Blocks.GREEN_GLAZED_TERRACOTTA, Blocks.RED_GLAZED_TERRACOTTA, Blocks.BLACK_GLAZED_TERRACOTTA, Blocks.WHITE_CONCRETE, Blocks.ORANGE_CONCRETE, Blocks.MAGENTA_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE, Blocks.YELLOW_CONCRETE, Blocks.LIME_CONCRETE, Blocks.PINK_CONCRETE, Blocks.GRAY_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE, Blocks.CYAN_CONCRETE, Blocks.PURPLE_CONCRETE, Blocks.BLUE_CONCRETE, Blocks.BROWN_CONCRETE, Blocks.GREEN_CONCRETE, Blocks.RED_CONCRETE, Blocks.BLACK_CONCRETE, Blocks.DEAD_TUBE_CORAL_BLOCK, Blocks.DEAD_BRAIN_CORAL_BLOCK, Blocks.DEAD_BUBBLE_CORAL_BLOCK, Blocks.DEAD_FIRE_CORAL_BLOCK, Blocks.DEAD_HORN_CORAL_BLOCK, Blocks.TUBE_CORAL_BLOCK, Blocks.BRAIN_CORAL_BLOCK, Blocks.BUBBLE_CORAL_BLOCK, Blocks.FIRE_CORAL_BLOCK, Blocks.HORN_CORAL_BLOCK, Blocks.DEAD_TUBE_CORAL, Blocks.DEAD_BRAIN_CORAL, Blocks.DEAD_BUBBLE_CORAL, Blocks.DEAD_FIRE_CORAL, Blocks.DEAD_HORN_CORAL, Blocks.DEAD_TUBE_CORAL_FAN, Blocks.DEAD_BRAIN_CORAL_FAN, Blocks.DEAD_BUBBLE_CORAL_FAN, Blocks.DEAD_FIRE_CORAL_FAN, Blocks.DEAD_HORN_CORAL_FAN, Blocks.DEAD_TUBE_CORAL_WALL_FAN, Blocks.DEAD_BRAIN_CORAL_WALL_FAN, Blocks.DEAD_BUBBLE_CORAL_WALL_FAN, Blocks.DEAD_FIRE_CORAL_WALL_FAN, Blocks.DEAD_HORN_CORAL_WALL_FAN, Blocks.POLISHED_GRANITE_STAIRS, Blocks.SMOOTH_RED_SANDSTONE_STAIRS, Blocks.MOSSY_STONE_BRICK_STAIRS, Blocks.POLISHED_DIORITE_STAIRS, Blocks.MOSSY_COBBLESTONE_STAIRS, Blocks.END_STONE_BRICK_STAIRS, Blocks.STONE_STAIRS, Blocks.SMOOTH_SANDSTONE_STAIRS, Blocks.SMOOTH_QUARTZ_STAIRS, Blocks.GRANITE_STAIRS, Blocks.ANDESITE_STAIRS, Blocks.RED_NETHER_BRICK_STAIRS, Blocks.POLISHED_ANDESITE_STAIRS, Blocks.DIORITE_STAIRS, Blocks.POLISHED_GRANITE_SLAB, Blocks.SMOOTH_RED_SANDSTONE_SLAB, Blocks.MOSSY_STONE_BRICK_SLAB, Blocks.POLISHED_DIORITE_SLAB, Blocks.MOSSY_COBBLESTONE_SLAB, Blocks.END_STONE_BRICK_SLAB, Blocks.SMOOTH_SANDSTONE_SLAB, Blocks.SMOOTH_QUARTZ_SLAB, Blocks.GRANITE_SLAB, Blocks.ANDESITE_SLAB, Blocks.RED_NETHER_BRICK_SLAB, Blocks.POLISHED_ANDESITE_SLAB, Blocks.DIORITE_SLAB, Blocks.SMOKER, Blocks.BLAST_FURNACE, Blocks.GRINDSTONE, Blocks.STONECUTTER, Blocks.BELL, Blocks.LANTERN, Blocks.SOUL_LANTERN, Blocks.WARPED_NYLIUM, Blocks.CRIMSON_NYLIUM, Blocks.NETHERITE_BLOCK, Blocks.ANCIENT_DEBRIS, Blocks.CRYING_OBSIDIAN, Blocks.RESPAWN_ANCHOR, Blocks.LODESTONE, Blocks.BLACKSTONE, Blocks.BLACKSTONE_STAIRS, Blocks.BLACKSTONE_SLAB, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS, Blocks.CHISELED_POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICK_SLAB, Blocks.POLISHED_BLACKSTONE_BRICK_STAIRS, Blocks.GILDED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_STAIRS, Blocks.POLISHED_BLACKSTONE_SLAB, Blocks.POLISHED_BLACKSTONE_PRESSURE_PLATE, Blocks.CHISELED_NETHER_BRICKS, Blocks.CRACKED_NETHER_BRICKS, Blocks.QUARTZ_BRICKS, Blocks.TUFF, Blocks.CALCITE, Blocks.OXIDIZED_COPPER, Blocks.WEATHERED_COPPER, Blocks.EXPOSED_COPPER, Blocks.COPPER_BLOCK, Blocks.COPPER_ORE, Blocks.DEEPSLATE_COPPER_ORE, Blocks.OXIDIZED_CUT_COPPER, Blocks.WEATHERED_CUT_COPPER, Blocks.EXPOSED_CUT_COPPER, Blocks.CUT_COPPER, Blocks.OXIDIZED_CUT_COPPER_STAIRS, Blocks.WEATHERED_CUT_COPPER_STAIRS, Blocks.EXPOSED_CUT_COPPER_STAIRS, Blocks.CUT_COPPER_STAIRS, Blocks.OXIDIZED_CUT_COPPER_SLAB, Blocks.WEATHERED_CUT_COPPER_SLAB, Blocks.EXPOSED_CUT_COPPER_SLAB, Blocks.CUT_COPPER_SLAB, Blocks.WAXED_COPPER_BLOCK, Blocks.WAXED_WEATHERED_COPPER, Blocks.WAXED_EXPOSED_COPPER, Blocks.WAXED_OXIDIZED_COPPER, Blocks.WAXED_OXIDIZED_CUT_COPPER, Blocks.WAXED_WEATHERED_CUT_COPPER, Blocks.WAXED_EXPOSED_CUT_COPPER, Blocks.WAXED_CUT_COPPER, Blocks.WAXED_OXIDIZED_CUT_COPPER_STAIRS, Blocks.WAXED_WEATHERED_CUT_COPPER_STAIRS, Blocks.WAXED_EXPOSED_CUT_COPPER_STAIRS, Blocks.WAXED_CUT_COPPER_STAIRS, Blocks.WAXED_OXIDIZED_CUT_COPPER_SLAB, Blocks.WAXED_WEATHERED_CUT_COPPER_SLAB, Blocks.WAXED_EXPOSED_CUT_COPPER_SLAB, Blocks.WAXED_CUT_COPPER_SLAB, Blocks.LIGHTNING_ROD, Blocks.POINTED_DRIPSTONE, Blocks.DRIPSTONE_BLOCK, Blocks.DEEPSLATE, Blocks.COBBLED_DEEPSLATE, Blocks.COBBLED_DEEPSLATE_STAIRS, Blocks.COBBLED_DEEPSLATE_SLAB, Blocks.POLISHED_DEEPSLATE, Blocks.POLISHED_DEEPSLATE_STAIRS, Blocks.POLISHED_DEEPSLATE_SLAB, Blocks.DEEPSLATE_TILES, Blocks.DEEPSLATE_TILE_STAIRS, Blocks.DEEPSLATE_TILE_SLAB, Blocks.DEEPSLATE_BRICKS, Blocks.DEEPSLATE_BRICK_STAIRS, Blocks.DEEPSLATE_BRICK_SLAB, Blocks.CHISELED_DEEPSLATE, Blocks.CRACKED_DEEPSLATE_BRICKS, Blocks.CRACKED_DEEPSLATE_TILES, Blocks.SMOOTH_BASALT, Blocks.RAW_IRON_BLOCK, Blocks.RAW_COPPER_BLOCK, Blocks.RAW_GOLD_BLOCK, Blocks.ICE, Blocks.PACKED_ICE, Blocks.BLUE_ICE, Blocks.STONE_BUTTON, Blocks.PISTON, Blocks.STICKY_PISTON, Blocks.PISTON_HEAD, Blocks.AMETHYST_CLUSTER, Blocks.SMALL_AMETHYST_BUD, Blocks.MEDIUM_AMETHYST_BUD, Blocks.LARGE_AMETHYST_BUD, Blocks.AMETHYST_BLOCK, Blocks.BUDDING_AMETHYST, Blocks.INFESTED_COBBLESTONE, Blocks.INFESTED_CHISELED_STONE_BRICKS, Blocks.INFESTED_CRACKED_STONE_BRICKS, Blocks.INFESTED_DEEPSLATE, Blocks.INFESTED_STONE, Blocks.INFESTED_MOSSY_STONE_BRICKS, Blocks.INFESTED_STONE_BRICKS).addTag(BlockTags.WALLS).addTag(BlockTags.SHULKER_BOXES).addTag(BlockTags.ANVIL).addTag(BlockTags.CAULDRONS).addTag(BlockTags.RAILS).add(Blocks.CONDUIT);
      this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(Blocks.CLAY, Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.PODZOL, Blocks.FARMLAND, Blocks.GRASS_BLOCK, Blocks.GRAVEL, Blocks.MYCELIUM, Blocks.SAND, Blocks.RED_SAND, Blocks.SNOW_BLOCK, Blocks.SNOW, Blocks.SOUL_SAND, Blocks.DIRT_PATH, Blocks.WHITE_CONCRETE_POWDER, Blocks.ORANGE_CONCRETE_POWDER, Blocks.MAGENTA_CONCRETE_POWDER, Blocks.LIGHT_BLUE_CONCRETE_POWDER, Blocks.YELLOW_CONCRETE_POWDER, Blocks.LIME_CONCRETE_POWDER, Blocks.PINK_CONCRETE_POWDER, Blocks.GRAY_CONCRETE_POWDER, Blocks.LIGHT_GRAY_CONCRETE_POWDER, Blocks.CYAN_CONCRETE_POWDER, Blocks.PURPLE_CONCRETE_POWDER, Blocks.BLUE_CONCRETE_POWDER, Blocks.BROWN_CONCRETE_POWDER, Blocks.GREEN_CONCRETE_POWDER, Blocks.RED_CONCRETE_POWDER, Blocks.BLACK_CONCRETE_POWDER, Blocks.SOUL_SOIL, Blocks.ROOTED_DIRT);
      this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(Blocks.OBSIDIAN, Blocks.CRYING_OBSIDIAN, Blocks.NETHERITE_BLOCK, Blocks.RESPAWN_ANCHOR, Blocks.ANCIENT_DEBRIS);
      this.tag(BlockTags.NEEDS_IRON_TOOL).add(Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, Blocks.DEEPSLATE_DIAMOND_ORE, Blocks.EMERALD_ORE, Blocks.DEEPSLATE_EMERALD_ORE, Blocks.EMERALD_BLOCK, Blocks.GOLD_BLOCK, Blocks.RAW_GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.DEEPSLATE_GOLD_ORE, Blocks.REDSTONE_ORE, Blocks.DEEPSLATE_REDSTONE_ORE);
      this.tag(BlockTags.NEEDS_STONE_TOOL).add(Blocks.IRON_BLOCK, Blocks.RAW_IRON_BLOCK, Blocks.IRON_ORE, Blocks.DEEPSLATE_IRON_ORE, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.DEEPSLATE_LAPIS_ORE, Blocks.COPPER_BLOCK, Blocks.RAW_COPPER_BLOCK, Blocks.COPPER_ORE, Blocks.DEEPSLATE_COPPER_ORE, Blocks.CUT_COPPER_SLAB, Blocks.CUT_COPPER_STAIRS, Blocks.CUT_COPPER, Blocks.WEATHERED_COPPER, Blocks.WEATHERED_CUT_COPPER_SLAB, Blocks.WEATHERED_CUT_COPPER_STAIRS, Blocks.WEATHERED_CUT_COPPER, Blocks.OXIDIZED_COPPER, Blocks.OXIDIZED_CUT_COPPER_SLAB, Blocks.OXIDIZED_CUT_COPPER_STAIRS, Blocks.OXIDIZED_CUT_COPPER, Blocks.EXPOSED_COPPER, Blocks.EXPOSED_CUT_COPPER_SLAB, Blocks.EXPOSED_CUT_COPPER_STAIRS, Blocks.EXPOSED_CUT_COPPER, Blocks.WAXED_COPPER_BLOCK, Blocks.WAXED_CUT_COPPER_SLAB, Blocks.WAXED_CUT_COPPER_STAIRS, Blocks.WAXED_CUT_COPPER, Blocks.WAXED_WEATHERED_COPPER, Blocks.WAXED_WEATHERED_CUT_COPPER_SLAB, Blocks.WAXED_WEATHERED_CUT_COPPER_STAIRS, Blocks.WAXED_WEATHERED_CUT_COPPER, Blocks.WAXED_EXPOSED_COPPER, Blocks.WAXED_EXPOSED_CUT_COPPER_SLAB, Blocks.WAXED_EXPOSED_CUT_COPPER_STAIRS, Blocks.WAXED_EXPOSED_CUT_COPPER, Blocks.WAXED_OXIDIZED_COPPER, Blocks.WAXED_OXIDIZED_CUT_COPPER_SLAB, Blocks.WAXED_OXIDIZED_CUT_COPPER_STAIRS, Blocks.WAXED_OXIDIZED_CUT_COPPER, Blocks.LIGHTNING_ROD);
      this.tag(BlockTags.FEATURES_CANNOT_REPLACE).add(Blocks.BEDROCK, Blocks.SPAWNER, Blocks.CHEST, Blocks.END_PORTAL_FRAME);
      this.tag(BlockTags.LAVA_POOL_STONE_CANNOT_REPLACE).addTag(BlockTags.FEATURES_CANNOT_REPLACE).addTag(BlockTags.LEAVES).addTag(BlockTags.LOGS);
      this.tag(BlockTags.GEODE_INVALID_BLOCKS).add(Blocks.BEDROCK, Blocks.WATER, Blocks.LAVA, Blocks.ICE, Blocks.PACKED_ICE, Blocks.BLUE_ICE);
      this.tag(BlockTags.ANIMALS_SPAWNABLE_ON).add(Blocks.GRASS_BLOCK);
      this.tag(BlockTags.AXOLOTLS_SPAWNABLE_ON).add(Blocks.CLAY);
      this.tag(BlockTags.GOATS_SPAWNABLE_ON).add(Blocks.STONE, Blocks.SNOW, Blocks.SNOW_BLOCK, Blocks.PACKED_ICE, Blocks.GRAVEL);
      this.tag(BlockTags.MOOSHROOMS_SPAWNABLE_ON).add(Blocks.MYCELIUM);
      this.tag(BlockTags.PARROTS_SPAWNABLE_ON).add(Blocks.GRASS_BLOCK, Blocks.AIR).addTag(BlockTags.LEAVES).addTag(BlockTags.LOGS);
      this.tag(BlockTags.POLAR_BEARS_SPAWNABLE_ON_IN_FROZEN_OCEAN).add(Blocks.ICE);
      this.tag(BlockTags.RABBITS_SPAWNABLE_ON).add(Blocks.GRASS_BLOCK, Blocks.SNOW, Blocks.SNOW_BLOCK, Blocks.SAND);
      this.tag(BlockTags.FOXES_SPAWNABLE_ON).add(Blocks.GRASS_BLOCK, Blocks.SNOW, Blocks.SNOW_BLOCK, Blocks.PODZOL, Blocks.COARSE_DIRT);
      this.tag(BlockTags.WOLVES_SPAWNABLE_ON).add(Blocks.GRASS_BLOCK, Blocks.SNOW, Blocks.SNOW_BLOCK);
      this.tag(BlockTags.TERRACOTTA).add(Blocks.TERRACOTTA, Blocks.WHITE_TERRACOTTA, Blocks.ORANGE_TERRACOTTA, Blocks.MAGENTA_TERRACOTTA, Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.YELLOW_TERRACOTTA, Blocks.LIME_TERRACOTTA, Blocks.PINK_TERRACOTTA, Blocks.GRAY_TERRACOTTA, Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.CYAN_TERRACOTTA, Blocks.PURPLE_TERRACOTTA, Blocks.BLUE_TERRACOTTA, Blocks.BROWN_TERRACOTTA, Blocks.GREEN_TERRACOTTA, Blocks.RED_TERRACOTTA, Blocks.BLACK_TERRACOTTA);
      this.tag(BlockTags.AZALEA_GROWS_ON).addTag(BlockTags.DIRT).addTag(BlockTags.SAND).addTag(BlockTags.TERRACOTTA).add(Blocks.SNOW_BLOCK).add(Blocks.POWDER_SNOW);
      this.tag(BlockTags.REPLACEABLE_PLANTS).add(Blocks.GRASS, Blocks.FERN, Blocks.DEAD_BUSH, Blocks.VINE, Blocks.GLOW_LICHEN, Blocks.SUNFLOWER, Blocks.LILAC, Blocks.ROSE_BUSH, Blocks.PEONY, Blocks.TALL_GRASS, Blocks.LARGE_FERN, Blocks.HANGING_ROOTS);
   }

   public String getName() {
      return "Block Tags";
   }
}
