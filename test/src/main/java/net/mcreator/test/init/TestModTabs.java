/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.test.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.test.TestMod;

public class TestModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MODTAB = REGISTRY.register("modtab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.test.modtab")).icon(() -> new ItemStack(TestModBlocks.ROCK_SALT.get())).displayItems((parameters, tabData) -> {
				tabData.accept(TestModItems.SODIUM_SWORD.get());
				tabData.accept(TestModBlocks.ROCK_SALT.get().asItem());
				tabData.accept(TestModItems.SODIUM_INGOT.get());
				tabData.accept(TestModItems.DIAMOND_STICK.get());
				tabData.accept(TestModItems.WICKER_ARMOR_HELMET.get());
				tabData.accept(TestModItems.WICKER_ARMOR_CHESTPLATE.get());
				tabData.accept(TestModItems.WICKER_ARMOR_LEGGINGS.get());
				tabData.accept(TestModItems.WICKER_ARMOR_BOOTS.get());
				tabData.accept(TestModItems.SODIUM_GOLEM_SPAWN_EGG.get());
				tabData.accept(TestModBlocks.SODIUM_BLOCK.get().asItem());
				tabData.accept(TestModItems.CHIPS.get());
				tabData.accept(TestModItems.SALT.get());
				tabData.accept(TestModItems.SALT_WATER_BUCKET.get());
				tabData.accept(TestModItems.WICKER_WHIP.get());
				tabData.accept(TestModItems.VINE_STICK.get());
			}).build());
}