/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.test.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.test.item.WickerWhipItem;
import net.mcreator.test.item.WickerArmorItem;
import net.mcreator.test.item.VineStickItem;
import net.mcreator.test.item.TESTItem;
import net.mcreator.test.item.SodiumSwordItem;
import net.mcreator.test.item.SodiumIngotItem;
import net.mcreator.test.item.SodiumChlorideItem;
import net.mcreator.test.item.SaltwaterItem;
import net.mcreator.test.item.SaltItem;
import net.mcreator.test.item.DiamondStickItem;
import net.mcreator.test.item.ChipsItem;
import net.mcreator.test.TestMod;

import java.util.function.Function;

public class TestModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(TestMod.MODID);
	public static final DeferredItem<Item> DIAMOND_STICK = register("diamond_stick", DiamondStickItem::new);
	public static final DeferredItem<Item> ROCK_SALT = block(TestModBlocks.ROCK_SALT);
	public static final DeferredItem<Item> SODIUM_INGOT = register("sodium_ingot", SodiumIngotItem::new);
	public static final DeferredItem<Item> SODIUM_SWORD = register("sodium_sword", SodiumSwordItem::new);
	public static final DeferredItem<Item> WICKER_ARMOR_HELMET = register("wicker_armor_helmet", WickerArmorItem.Helmet::new);
	public static final DeferredItem<Item> WICKER_ARMOR_CHESTPLATE = register("wicker_armor_chestplate", WickerArmorItem.Chestplate::new);
	public static final DeferredItem<Item> WICKER_ARMOR_LEGGINGS = register("wicker_armor_leggings", WickerArmorItem.Leggings::new);
	public static final DeferredItem<Item> WICKER_ARMOR_BOOTS = register("wicker_armor_boots", WickerArmorItem.Boots::new);
	public static final DeferredItem<Item> SODIUM_GOLEM_SPAWN_EGG = register("sodium_golem_spawn_egg", properties -> new SpawnEggItem(TestModEntities.SODIUM_GOLEM.get(), properties));
	public static final DeferredItem<Item> SODIUM_BLOCK = block(TestModBlocks.SODIUM_BLOCK);
	public static final DeferredItem<Item> SODIUM_CHLORIDE = register("sodium_chloride", SodiumChlorideItem::new);
	public static final DeferredItem<Item> CHIPS = register("chips", ChipsItem::new);
	public static final DeferredItem<Item> SALT = register("salt", SaltItem::new);
	public static final DeferredItem<Item> SALT_WATER_BUCKET = register("salt_water_bucket", SaltwaterItem::new);
	public static final DeferredItem<Item> WICKER_WHIP = register("wicker_whip", WickerWhipItem::new);
	public static final DeferredItem<Item> VINE_STICK = register("vine_stick", VineStickItem::new);
	public static final DeferredItem<Item> TEST = register("test", TESTItem::new);

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.registerItem(block.getId().getPath(), prop -> new BlockItem(block.get(), prop), properties);
	}
}