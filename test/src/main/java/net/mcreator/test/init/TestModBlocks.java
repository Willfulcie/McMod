/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.test.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import net.mcreator.test.block.SodiumBlockBlock;
import net.mcreator.test.block.SaltwaterBlock;
import net.mcreator.test.block.RockSaltBlock;
import net.mcreator.test.TestMod;

import java.util.function.Function;

public class TestModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(TestMod.MODID);
	public static final DeferredBlock<Block> ROCK_SALT = register("rock_salt", RockSaltBlock::new);
	public static final DeferredBlock<Block> SODIUM_BLOCK = register("sodium_block", SodiumBlockBlock::new);
	public static final DeferredBlock<Block> SALT_WATER = register("salt_water", SaltwaterBlock::new);

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier);
	}
}