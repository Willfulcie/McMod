package net.mcreator.test.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class ChipsItem extends Item {
	public ChipsItem(Item.Properties properties) {
		super(properties.food((new FoodProperties.Builder()).nutrition(4).saturationModifier(0.3f).alwaysEdible().build()));
	}
}