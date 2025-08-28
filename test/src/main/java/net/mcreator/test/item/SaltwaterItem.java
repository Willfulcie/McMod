package net.mcreator.test.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.test.init.TestModFluids;

public class SaltwaterItem extends BucketItem {
	public SaltwaterItem(Item.Properties properties) {
		super(TestModFluids.SALT_WATER.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)

		);
	}
}