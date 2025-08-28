package net.mcreator.test.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

public class SodiumSwordExplodeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double explode_level = 0;
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, 1, Level.ExplosionInteraction.TNT);
	}
}