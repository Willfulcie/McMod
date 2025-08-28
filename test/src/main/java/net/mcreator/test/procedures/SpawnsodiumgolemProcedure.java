package net.mcreator.test.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.test.init.TestModEntities;
import net.mcreator.test.init.TestModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SpawnsodiumgolemProcedure {
	@SubscribeEvent
	public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x + 0, y + 0, z + 0))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x + 0, y - 1, z + 0))).getBlock() == TestModBlocks.SODIUM_BLOCK.get()
				&& (world.getBlockState(BlockPos.containing(x + 0, y - 2, z + 0))).getBlock() == TestModBlocks.SODIUM_BLOCK.get() && (world.getBlockState(BlockPos.containing(x + 1, y - 1, z + 0))).getBlock() == TestModBlocks.SODIUM_BLOCK.get()
				&& (world.getBlockState(BlockPos.containing(x - 1, y - 1, z + 0))).getBlock() == TestModBlocks.SODIUM_BLOCK.get()) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TestModEntities.SODIUM_GOLEM.get().spawn(_level, BlockPos.containing(x, y, z), EntitySpawnReason.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y - 2, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x + 1, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x - 1, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
		} else if ((world.getBlockState(BlockPos.containing(x + 0, y + 0, z + 0))).getBlock() == Blocks.OBSIDIAN && (world.getBlockState(BlockPos.containing(x + 0, y - 1, z + 0))).getBlock() == TestModBlocks.SODIUM_BLOCK.get()
				&& (world.getBlockState(BlockPos.containing(x + 0, y - 2, z + 0))).getBlock() == TestModBlocks.SODIUM_BLOCK.get() && (world.getBlockState(BlockPos.containing(x + 0, y - 1, z + 1))).getBlock() == TestModBlocks.SODIUM_BLOCK.get()
				&& (world.getBlockState(BlockPos.containing(x - 0, y - 1, z - 1))).getBlock() == TestModBlocks.SODIUM_BLOCK.get()) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TestModEntities.SODIUM_GOLEM.get().spawn(_level, BlockPos.containing(x, y, z), EntitySpawnReason.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y - 2, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y - 1, z + 1), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y - 1, z - 1), Blocks.AIR.defaultBlockState(), 3);
		}
	}
}