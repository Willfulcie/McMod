package net.mcreator.test.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.test.init.TestModItems;

public class SodiumWaterExplodeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double explode_level = 0;
		if (isInWaterRainOrBubble(entity) || entity.isUnderWater()) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, (float) 1.1, Level.ExplosionInteraction.TNT);
			explode_level = new ItemStack(TestModItems.SODIUM_INGOT.get()).getCount();
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(TestModItems.SODIUM_INGOT.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		}
	}

	private static boolean isInWaterRainOrBubble(Entity entity) {
		return entity.isInWaterOrRain() || entity.getInBlockState().is(Blocks.BUBBLE_COLUMN);
	}
}