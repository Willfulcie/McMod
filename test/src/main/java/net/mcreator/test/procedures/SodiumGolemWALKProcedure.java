package net.mcreator.test.procedures;

import net.minecraft.world.entity.Entity;

public class SodiumGolemWALKProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return Math.hypot(entity.getX(), entity.getY()) == 0;
	}
}