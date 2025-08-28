package net.mcreator.test.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class SodiumChlorideItem extends Item {
	public SodiumChlorideItem(Item.Properties properties) {
		super(properties.food((new FoodProperties.Builder()).nutrition(1).saturationModifier(0.1f).build()));
	}
}