package net.mcreator.test.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;

public class SodiumGolemwaterattckProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double explode_level = 0;
		if (isInWaterRainOrBubble(entity) || entity.isUnderWater()) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, (float) 1.1, Level.ExplosionInteraction.TNT);
		}
	}

	private static boolean isInWaterRainOrBubble(Entity entity) {
		return entity.isInWaterOrRain() || entity.getInBlockState().is(Blocks.BUBBLE_COLUMN);
	}
}